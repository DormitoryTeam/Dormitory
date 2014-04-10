module.exports = function(grunt) {
	grunt.initConfig({
		pkg: grunt.file.readJSON('package.json'),
		project: {
			name: 'hostel',
			version: '0.0.1'
		},
		cssmin: {
			options: {
				banner: '/*Compressed css at' + Date() + '*/\n',
			},
			combine: {
			 	files: {
			 		'css/all.min.css': [
				 		'css/all.css'
				 	]
			 	}
			}
		},
		watch: {
			css: {
				files: [
					'css/doc/*.css',
					'css/site.css',
					'css/global.css'
				],
				tasks: ['concat'],
				options: {
					livereload: true
				}
			}
		},
		concat: {
			options: {
				banner: '/*Merged css at' + Date() + '*/\n',
			},
			dist: {
				src: [
					'css/global.css',
					'css/doc/*.css', 
					'css/site.css', 
				],
				dest: 'css/all.css'
			}
		},
		yuidoc: {
			compile: {
				name: '<%= pkg.name %>',
				description: '<%= pkg.description %>',
                options: {
                        paths: 'javascript',
                        outdir: 'docs/'
                }
			}
		},
		to_single_quotes: {
			// files: {
			// 	'dest/default_options': ['src/testing', 'src/123']
			// }
		},
		mocha: {
			test: {
				src: ['test/**/*.html'],
				options: {
			        reporter: 'Nyan', // Duh!
			        run: true
	      		}
			}
		}
	});	

	require('load-grunt-tasks')(grunt);

	grunt.registerTask('css', ['concat' ,'cssmin']);
	grunt.registerTask('doc', 'yuidoc');
	grunt.registerTask('test', 'mocha');
}