CREATE  TABLE IF NOT EXISTS `dormitory`.`system_email` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `email` VARCHAR(200) NOT NULL ,
  `email_type` VARCHAR(5) NOT NULL ,
  `status` VARCHAR(45) NULL ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `index_system_email` (`id` ASC) )
ENGINE = InnoDB;