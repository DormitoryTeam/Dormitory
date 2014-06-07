ALTER TABLE `dormitory`.`slide` 
ADD COLUMN `redirecturl` VARCHAR(500) NULL AFTER `create_time`;

ALTER TABLE `dormitory`.`order` 
ADD COLUMN `condition` VARCHAR(10) NOT NULL DEFAULT 'active';
