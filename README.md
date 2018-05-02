# Telephone

--
-- Host: localhost    Database: contact
-- ------------------------------------------------------
-- Server version	5.7.11-log


DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `login` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ;




DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `surname` varchar(512) CHARACTER SET utf8 NOT NULL,
  `name` varchar(512) CHARACTER SET utf8 NOT NULL,
  `patronymic` varchar(512) CHARACTER SET utf8 NOT NULL,
  `mobile` varchar(512) CHARACTER SET utf8 NOT NULL,
  `homephone` varchar(512) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(512) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(512) CHARACTER SET utf8 DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  
  PRIMARY KEY (`id`),
  
);

-- Dump completed on 2018-04-27 13:21:44
