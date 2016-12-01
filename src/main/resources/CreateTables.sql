/**
 * MySQL 5.7.16.0
 * 
 * Schema : beyond
 * 
 * 
 */

/*
 * B_USER
 */
DROP TABLE IF EXISTS `beyond`.`b_user`;
CREATE TABLE  `beyond`.`b_user` (
  `user_id` varchar(20) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;