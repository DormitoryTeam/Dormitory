INSERT INTO `dormitory`.`order` (`id`,`user_id`,`belongs_to`,`type`,`status`,`amount`,`currency`,`create_time`,`update_time`) VALUES (1,1,1,0,1,300.00,'USD','2014-02-07 14:47:14',NULL);
INSERT INTO `dormitory`.`order` (`id`,`user_id`,`belongs_to`,`type`,`status`,`amount`,`currency`,`create_time`,`update_time`) VALUES (2,1,2,0,1,500.00,'USD','2014-02-07 14:47:45',NULL);
INSERT INTO `dormitory`.`order` (`id`,`user_id`,`belongs_to`,`type`,`status`,`amount`,`currency`,`create_time`,`update_time`) VALUES (3,2,2,'PICKUP','COMMIT',400.00,'USD','2014-02-07 15:00:05',NULL);
COMMIT;