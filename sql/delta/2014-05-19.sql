alter table dormitory add display_order int default 0;
update dormitory set display_order = 0;
update city set name = 'Kingston-upon-Thames' where name = 'Kinston';