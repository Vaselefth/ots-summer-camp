CREATE DATABASE IF NOT EXISTS `ots_summer_camp`;
USE `ots_summer_camp`;



CREATE TABLE `user` (
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	`username` varchar(40) NOT NULL,
	`password` varchar(40) NOT NULL,
	`role` varchar(40) NOT NULL,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE `invoice_type` (
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	`description` text(250) NOT NULL,
	`type` varchar(40) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE `transactor` (
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	`first_name` varchar(40) NOT NULL,
	`last_name` varchar(40) NOT NULL,
	`company_name` varchar(40) NOT NULL,
	`email` varchar(40) NOT NULL,
	`tin` bigint(10) NOT NULL,
	`doy` varchar(20) NOT NULL,
	`address` varchar(50) NOT NULL,
	`city` varchar(30) NOT NULL,
	`phone_number` varchar(10) NOT NULL,
	`postal_code` varchar(10) NOT NULL,
	`transactor_type` tinyint(1) NOT NULL,
	`is_abroad` tinyint(1) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE `invoice` (
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	`date_created` datetime NOT NULL,
	`description` text(250) NOT NULL,
	`total_amount` double(10,2) NOT NULL,
	`invoice_type_id` bigint(20) NOT NULL,
	`user_id` bigint(20) NOT NULL,
	`transactor_id` bigint(20) NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_invoice_type_id` FOREIGN KEY (`invoice_type_id`) REFERENCES `invoice_type`(`id`),
	CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
	CONSTRAINT `fk_transactor_id` FOREIGN KEY (`transactor_id`) REFERENCES `transactor`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE `vat` (
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	`vat_value` double(3,2) NOT NULL,
	`valid_date` datetime NOT NULL,
	`description` varchar(30) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE `product_service` (
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	`description` text(200) NOT NULL,
	`price_per_item` double(10,2) NOT NULL,
	`discount` double(4,2) NOT NULL,
	`is_product` tinyint(1) NOT NULL,
	`vat_id` bigint(20) NOT NULL,
	PRIMARY KEY(`id`),
	CONSTRAINT `fk_vat_id` FOREIGN KEY(`vat_id`) REFERENCES `vat`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE `invoice_detail` (
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	`price_per_item` double(10,2) NOT NULL,
	`discount` double(4,2) NOT NULL,
	`quantity` int(8) NOT NULL,
	`price_prior_vat` double(10,2) NOT NULL,
	`total_price` double(10,2) NOT NULL,
	`invoice_id` bigint(20) NOT NULL,
	`product_id` bigint(20) NOT NULL,
	`vat_id` bigint(20) NOT NULL,
	PRIMARY KEY(`id`),
	CONSTRAINT `fk_invoice_id` FOREIGN KEY(`invoice_id`) REFERENCES `invoice`(`id`),
	CONSTRAINT `fk_product_id` FOREIGN KEY(`product_id`) REFERENCES `product_service`(`id`),
	CONSTRAINT `fk_vat_id` FOREIGN KEY(`vat_id`) REFERENCES `vat`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
