SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `dormitory` ;
CREATE SCHEMA IF NOT EXISTS `dormitory` DEFAULT CHARACTER SET utf8 ;
USE `dormitory` ;

-- -----------------------------------------------------
-- Table `dormitory`.`country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`country` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`country` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NOT NULL ,
  `countrycode` VARCHAR(5) NOT NULL ,
  `status` VARCHAR(45) NULL ,
  `create_time` TIMESTAMP NULL ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `countrycode_UNIQUE` (`countrycode` ASC) ,
  INDEX `index_country` (`id` ASC, `countrycode` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`city` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `country_id` INT NOT NULL ,
  `name` VARCHAR(200) NOT NULL ,
  `status` VARCHAR(45) NULL ,
  `create_time` TIMESTAMP NULL ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `index_city` (`country_id` ASC, `name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`college`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`college` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`college` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `city_id` INT NOT NULL ,
  `name` VARCHAR(500) NOT NULL ,
  `latitude` DECIMAL(10,7) NULL ,
  `longitude` DECIMAL(10,7) NULL ,
  `status` VARCHAR(45) NULL ,
  `create_time` TIMESTAMP NULL ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `index_college` (`city_id` ASC, `name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`dormitory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`dormitory` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`dormitory` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `city_id` INT NOT NULL ,
  `type_id` INT NOT NULL ,
  `contact_type_id` INT NOT NULL ,
  `name` VARCHAR(200) NOT NULL ,
  `address` VARCHAR(500) NULL ,
  `postcode` VARCHAR(200) NULL ,
  `listPrice` DECIMAL(5,2) NULL ,
  `salePrice` DECIMAL(5,2) NULL ,
  `currency` VARCHAR(3) NULL ,
  `latitude` DECIMAL(10,7) NULL ,
  `longitude` DECIMAL(10,7) NULL ,
  `equipment` INT NULL ,
  `service` INT NULL ,
  `description` VARCHAR(500) NULL ,
  `create_time` TIMESTAMP NULL ,
  `update_time` TIMESTAMP NULL ,
  `status` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `index_dormitory` (`city_id` ASC, `type_id` ASC, `contact_type_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`dormitory_rating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`dormitory_rating` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`dormitory_rating` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `dormitory_id` INT NOT NULL ,
  `user_id` INT NOT NULL ,
  `score` INT NOT NULL ,
  `create_time` TIMESTAMP NULL ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `index_dormitory_rating` (`dormitory_id` ASC, `user_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`dormitory_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`dormitory_type` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`dormitory_type` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `create_time` TIMESTAMP NULL ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`dormitory_media`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`dormitory_media` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`dormitory_media` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `dormitory_id` INT NOT NULL ,
  `media_type` INT NOT NULL ,
  `media_path` VARCHAR(300) NULL ,
  `index` INT NULL ,
  `create_time` TIMESTAMP NULL ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `index_dormitory_media` (`dormitory_id` ASC, `media_type` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`pickup_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`pickup_order` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`pickup_order` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`dormitory_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`dormitory_order` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`dormitory_order` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`airport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`airport` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`airport` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `country_id` INT NOT NULL ,
  `city_id` INT NULL ,
  `name` VARCHAR(100) NOT NULL ,
  `airportCode` VARCHAR(45) NULL ,
  `status` INT NULL ,
  `create_time` TIMESTAMP NULL ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `index_airport` (`country_id` ASC, `airportCode` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`desitination`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`desitination` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`desitination` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `country_id` INT NOT NULL ,
  `airport_id` INT NOT NULL ,
  `name` INT NOT NULL ,
  `status` VARCHAR(45) NULL ,
  `create_time` TIMESTAMP NULL ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `index_desitination` (`country_id` ASC, `airport_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`distance_result`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`distance_result` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`distance_result` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `city_id` INT NOT NULL ,
  `college_id` INT NOT NULL ,
  `dormitory_id` INT NOT NULL ,
  `distance` DECIMAL(20,10) NOT NULL ,
  `create_time` TIMESTAMP NULL ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `index_distance_result` (`city_id` ASC, `college_id` ASC, `dormitory_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`contract_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`contract_type` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`contract_type` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `create_time` TIMESTAMP NULL ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Placeholder table for view `dormitory`.`view_college_rad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dormitory`.`view_college_rad` (`college_id` INT, `city_id` INT, `college_name` INT, `lon` INT, `lat` INT, `R` INT);

-- -----------------------------------------------------
-- Placeholder table for view `dormitory`.`view_dormitory_rad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dormitory`.`view_dormitory_rad` (`dormitory_id` INT, `city_id` INT, `dormitory_name` INT, `lon` INT, `lat` INT, `R` INT);

-- -----------------------------------------------------
-- Placeholder table for view `dormitory`.`view_college_trig`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dormitory`.`view_college_trig` (`college_id` INT, `city_id` INT, `college_name` INT, `R` INT, `cos_lat` INT, `sin_lat` INT, `cos_lon` INT, `sin_lon` INT);

-- -----------------------------------------------------
-- Placeholder table for view `dormitory`.`view_dormitory_trig`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dormitory`.`view_dormitory_trig` (`dormitory_id` INT, `city_id` INT, `dormitory_name` INT, `R` INT, `cos_lat` INT, `sin_lat` INT, `cos_lon` INT, `sin_lon` INT);

-- -----------------------------------------------------
-- Placeholder table for view `dormitory`.`view_college_glb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dormitory`.`view_college_glb` (`college_id` INT, `city_id` INT, `college_name` INT, `x` INT, `y` INT, `z` INT);

-- -----------------------------------------------------
-- Placeholder table for view `dormitory`.`view_dormitory_glb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dormitory`.`view_dormitory_glb` (`dormitory_id` INT, `city_id` INT, `dormitory_name` INT, `x` INT, `y` INT, `z` INT);

-- -----------------------------------------------------
-- View `dormitory`.`view_college_rad`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `dormitory`.`view_college_rad` ;
DROP TABLE IF EXISTS `dormitory`.`view_college_rad`;
USE `dormitory`;
CREATE  OR REPLACE VIEW `dormitory`.`view_college_rad` AS
  SELECT id AS college_id, city_id, name AS college_name, 3.14159265359*longitude/180 AS lon
             , 3.14159265359*latitude/180 AS lat
             , 6378                AS R
  FROM college;

-- -----------------------------------------------------
-- View `dormitory`.`view_dormitory_rad`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `dormitory`.`view_dormitory_rad` ;
DROP TABLE IF EXISTS `dormitory`.`view_dormitory_rad`;
USE `dormitory`;
CREATE  OR REPLACE VIEW `dormitory`.`view_dormitory_rad` AS
  SELECT id AS dormitory_id, city_id, name AS dormitory_name, 3.14159265359*longitude/180 AS lon
             , 3.14159265359*latitude/180 AS lat
             , 6378                AS R
  FROM dormitory;

-- -----------------------------------------------------
-- View `dormitory`.`view_college_trig`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `dormitory`.`view_college_trig` ;
DROP TABLE IF EXISTS `dormitory`.`view_college_trig`;
USE `dormitory`;
CREATE  OR REPLACE VIEW `dormitory`.`view_college_trig` AS
  SELECT college_id, city_id, college_name, R, COS(lat) AS cos_lat, SIN(lat) AS sin_lat,
                  COS(lon) AS cos_lon, SIN(lon) AS sin_lon
    FROM `dormitory`.`view_college_rad`;

-- -----------------------------------------------------
-- View `dormitory`.`view_dormitory_trig`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `dormitory`.`view_dormitory_trig` ;
DROP TABLE IF EXISTS `dormitory`.`view_dormitory_trig`;
USE `dormitory`;
CREATE  OR REPLACE VIEW `dormitory`.`view_dormitory_trig` AS
  SELECT dormitory_id, city_id, dormitory_name, R, COS(lat) AS cos_lat, SIN(lat) AS sin_lat,
                  COS(lon) AS cos_lon, SIN(lon) AS sin_lon
    FROM `dormitory`.`view_dormitory_rad`;

-- -----------------------------------------------------
-- View `dormitory`.`view_college_glb`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `dormitory`.`view_college_glb` ;
DROP TABLE IF EXISTS `dormitory`.`view_college_glb`;
USE `dormitory`;
CREATE  OR REPLACE VIEW `dormitory`.`view_college_glb` AS
  SELECT college_id, city_id, college_name, R*cos_lat*cos_lon AS x,
               R*cos_lat*sin_lon AS y,
               R*sin_lat         AS z
    FROM `dormitory`.`view_college_trig`;

-- -----------------------------------------------------
-- View `dormitory`.`view_dormitory_glb`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `dormitory`.`view_dormitory_glb` ;
DROP TABLE IF EXISTS `dormitory`.`view_dormitory_glb`;
USE `dormitory`;
CREATE  OR REPLACE VIEW `dormitory`.`view_dormitory_glb` AS
  SELECT dormitory_id, city_id, dormitory_name, R*cos_lat*cos_lon AS x,
               R*cos_lat*sin_lon AS y,
               R*sin_lat         AS z
    FROM `dormitory`.`view_dormitory_trig`;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
