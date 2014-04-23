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
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
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
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
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
  `name` VARCHAR(150) NOT NULL ,
  `original_name` VARCHAR(150) NULL ,
  `latitude` DECIMAL(10,7) NULL ,
  `longitude` DECIMAL(10,7) NULL ,
  `status` VARCHAR(45) NULL ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
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
  `name` VARCHAR(200) NOT NULL ,
  `address` VARCHAR(500) NULL ,
  `postcode` VARCHAR(200) NULL ,
  `equipment` INT NULL ,
  `service` INT NULL ,
  `weekPrice` DECIMAL(5,2) NULL ,
  `salePrice` DECIMAL(5,2) NULL ,
  `currency` VARCHAR(3) NULL ,
  `latitude` DECIMAL(10,7) NULL ,
  `longitude` DECIMAL(10,7) NULL ,
  `description` VARCHAR(500) NULL ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP NULL ,
  `status` VARCHAR(45) NULL DEFAULT 'INVISIBILITY' ,
  PRIMARY KEY (`id`) ,
  INDEX `index_dormitory` (`city_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`dormitory_rating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`dormitory_rating` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`dormitory_rating` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `dormitory_id` INT NOT NULL ,
  `user_id` INT NOT NULL ,
  `alias` VARCHAR(45) NOT NULL ,
  `score` INT NOT NULL ,
  `comment` VARCHAR(1000) NULL ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP NULL ,
  `status` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `index_dormitory_rating` (`dormitory_id` ASC, `user_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`room_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`room_type` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`room_type` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
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
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `index_dormitory_media` (`dormitory_id` ASC, `media_type` ASC) )
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
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
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
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
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
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
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
  `name` INT NOT NULL ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`order` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `user_id` INT NULL ,
  `belongs_to` INT NULL ,
  `type` VARCHAR(20) NOT NULL ,
  `status` VARCHAR(20) NOT NULL ,
  `amount` DECIMAL(5,2) NOT NULL ,
  `currency` VARCHAR(3) NOT NULL ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`order_history`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`order_history` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`order_history` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `order_id` INT NOT NULL ,
  `operator_id` INT NOT NULL ,
  `operation` VARCHAR(20) NOT NULL ,
  `operate_time` TIMESTAMP NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`order_contact_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`order_contact_info` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`order_contact_info` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `order_id` INT NOT NULL ,
  `belong_to_user_info_id` INT NULL ,
  `guarantee_info_id` INT NULL ,
  `contact_person_info_id` INT NULL ,
  `prefer_id` INT NULL ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`line_item_pickup`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`line_item_pickup` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`line_item_pickup` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `order_id` INT NOT NULL ,
  `flight_number` VARCHAR(45) NULL ,
  `city_id` VARCHAR(45) NULL ,
  `pickup_date` DATETIME NULL ,
  `pickup_type` VARCHAR(20) NULL ,
  `amount` DECIMAL(5,2) NULL ,
  `currency` VARCHAR(3) NULL ,
  `luggage_amount` INT NULL ,
  `luggage_size` DECIMAL(3,1) NULL ,
  `takeoff_date` DATETIME NULL ,
  `takeoff_city` VARCHAR(100) NULL ,
  `arrival_city` VARCHAR(100) NULL ,
  `arrival_country` VARCHAR(100) NULL ,
  `arrival_airport` VARCHAR(100) NULL ,
  `flight_company` VARCHAR(200) NULL ,
  `pickup_to_city` VARCHAR(100) NULL ,
  `pickup_to_address` VARCHAR(500) NULL ,
  `pickup_to_dormitory` VARCHAR(200) NULL ,
  `pickup_to_postalcode` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`line_item_dormitory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`line_item_dormitory` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`line_item_dormitory` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `order_id` INT NOT NULL ,
  `dormitory_id` INT NULL ,
  `room_info_id` INT NULL ,
  `contract_type_id` INT NULL ,
  `listPrice` DECIMAL(5,2) NULL ,
  `amount` DECIMAL(5,2) NULL ,
  `currency` VARCHAR(3) NULL ,
  `dormitory_info_date` TIMESTAMP NULL ,
  `create_time` TIMESTAMP NULL ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`users` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `login` VARCHAR(200) NOT NULL ,
  `password` VARCHAR(200) NOT NULL ,
  `email` VARCHAR(100) NOT NULL ,
  `alias` VARCHAR(200) NULL ,
  `reset_password_sign` VARCHAR(200) NULL ,
  `user_info_id` INT NULL ,
  `guarantee_info_id` INT NULL ,
  `contact_person_info_id` INT NULL ,
  `user_prefer_id` INT NULL ,
  `create_date` TIMESTAMP NULL ,
  `update_date` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`groups`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`groups` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`groups` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(200) NOT NULL ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`roles` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(200) NOT NULL ,
  `create_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_date` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`functions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`functions` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`functions` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(200) NOT NULL ,
  `servlet_path_info` VARCHAR(200) NOT NULL ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`user_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`user_group` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`user_group` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `user_id` INT NOT NULL ,
  `group_id` INT NOT NULL ,
  `create_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_date` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`role_fuction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`role_fuction` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`role_fuction` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `role_id` INT NOT NULL ,
  `function_id` INT NOT NULL ,
  `create_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_date` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`group_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`group_role` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`group_role` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `group_id` INT NOT NULL ,
  `role_id` INT NOT NULL ,
  `create_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_date` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`payment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`payment` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`payment` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `order_id` INT NOT NULL ,
  `amount` DECIMAL NOT NULL ,
  `currency` VARCHAR(3) NOT NULL ,
  `status` VARCHAR(20) NOT NULL ,
  `third_part_order_id` VARCHAR(200) NULL ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`payment_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`payment_details` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`payment_details` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `payment_id` INT NOT NULL ,
  `type` VARCHAR(20) NOT NULL ,
  `nvp` VARCHAR(1000) NOT NULL ,
  `status` VARCHAR(45) NOT NULL ,
  `notify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `notify_id` VARCHAR(200) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`slide`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`slide` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`slide` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `desc` VARCHAR(400) NULL ,
  `path` VARCHAR(200) NOT NULL ,
  `index` INT NOT NULL ,
  `status` VARCHAR(45) NOT NULL DEFAULT '1' ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`room_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`room_info` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`room_info` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `dormitory_id` VARCHAR(45) NOT NULL ,
  `room_type_id` VARCHAR(45) NOT NULL ,
  `equipment` INT NOT NULL ,
  `service` INT NOT NULL ,
  `description` VARCHAR(1000) NULL ,
  `checkin_date` TIMESTAMP NOT NULL ,
  `orientations` VARCHAR(200) NULL ,
  `floors` VARCHAR(200) NULL ,
  `bed_type` VARCHAR(200) NULL ,
  `house_area` VARCHAR(200) NULL ,
  `ensuite_bathroom` VARCHAR(45) NULL ,
  `kitchen_people_number` INT NULL ,
  `floor_arrangement` VARCHAR(45) NULL ,
  `orientation_arrangement` VARCHAR(45) NULL ,
  `room_language_arrangement` VARCHAR(45) NULL ,
  `kitchen_equipment` VARCHAR(400) NULL ,
  `bathroom_equipment` VARCHAR(400) NULL ,
  `status` VARCHAR(45) NULL DEFAULT 'INVISIBILITY' ,
  `create_time` TIMESTAMP NULL ,
  `update_time` TIMESTAMP NULL ,
  `name` VARCHAR(200) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`room_price`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`room_price` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`room_price` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `room_info_id` INT NOT NULL ,
  `contract_type_id` VARCHAR(45) NOT NULL ,
  `currency` VARCHAR(3) NOT NULL ,
  `weekPrice` DECIMAL NOT NULL ,
  `salePrice` DECIMAL NOT NULL ,
  `status` VARCHAR(45) NULL DEFAULT '1' ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`user_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`user_info` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`user_info` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `last_name` VARCHAR(100) NOT NULL ,
  `nationality` VARCHAR(45) NULL ,
  `gender` INT NULL ,
  `birthday` DATETIME NULL ,
  `email` VARCHAR(200) NULL ,
  `qq` VARCHAR(45) NULL ,
  `wechat` VARCHAR(45) NULL ,
  `phone` VARCHAR(45) NULL ,
  `country` VARCHAR(200) NULL ,
  `province` VARCHAR(200) NULL ,
  `city` VARCHAR(200) NULL ,
  `county` VARCHAR(200) NULL ,
  `address` VARCHAR(500) NULL ,
  `postalcode` VARCHAR(100) NULL ,
  `relationship` VARCHAR(100) NULL ,
  `create_date` TIMESTAMP NULL ,
  `update_date` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`user_prefer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`user_prefer` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`user_prefer` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `smoke` INT NULL ,
  `vegetarianism` INT NULL ,
  `your_grade` INT NULL ,
  `room_member_grade` INT NULL ,
  `room_member_gender` VARCHAR(45) NULL ,
  `major` VARCHAR(200) NULL ,
  `college` VARCHAR(200) NULL ,
  `floor` VARCHAR(500) NULL ,
  `orientation` INT NULL ,
  `graduate_school` VARCHAR(200) NULL ,
  `need_push` INT NULL ,
  `read_clause` INT NULL ,
  `create_date` TIMESTAMP NULL ,
  `update_date` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`browsing_history`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`browsing_history` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`browsing_history` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `user_id` INT NOT NULL ,
  `dormitory_id` INT NOT NULL ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`dormitory_contract`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`dormitory_contract` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`dormitory_contract` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `room_number` VARCHAR(100) NULL ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`service` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`service` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `service` VARCHAR(100) NOT NULL ,
  `status` VARCHAR(45) NOT NULL DEFAULT '1' ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`equipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`equipment` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`equipment` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `equipment` VARCHAR(100) NOT NULL ,
  `status` VARCHAR(45) NOT NULL DEFAULT '1' ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`article`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dormitory`.`article` ;

CREATE  TABLE IF NOT EXISTS `dormitory`.`article` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `user_id` INT NOT NULL ,
  `title` VARCHAR(150) NOT NULL ,
  `cover_path` VARCHAR(45) NULL ,
  `text` LONGBLOB NOT NULL ,
  `type` VARCHAR(45) NULL ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP NULL ,
  `status` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
PACK_KEYS = DEFAULT;


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
