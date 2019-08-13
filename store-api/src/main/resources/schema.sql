CREATE DATABASE  IF NOT EXISTS `assignment`;


DROP TABLE IF EXISTS `credits`;

CREATE TABLE `credits` (
  `credit_id` int(11) NOT NULL AUTO_INCREMENT,
  `points` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`credit_id`),
  KEY `FK648alyyrjw295vwi553b3u71m` (`order_id`)
) ;


DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
);


DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK624gtjin3po807j3vix093tlf` (`customer_id`)
) ;


