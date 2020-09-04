CREATE DATABASE IF NOT EXISTS `test_db`;
USE `test_db`;

DROP TABLE IF EXISTS `test_table`;

CREATE TABLE `test_table`
(
    `id`               INT(20) AUTO_INCREMENT,
    `name`             VARCHAR(20) NOT NULL,
    `created_at`       Datetime DEFAULT NULL,
    `updated_at`       Datetime DEFAULT NULL,
    PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `test_employees`;

CREATE TABLE `test_employees`
(
    `id`               INT(20) AUTO_INCREMENT,
    `name`             VARCHAR(20) NOT NULL,
    `department`      VARCHAR(20) NOT NULL,
    `salary`           BIGINT,
    PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `test_events`;

CREATE TABLE `test_events`
(
    `id`               INT(20) AUTO_INCREMENT,
    `title`            VARCHAR(20) NOT NULL,
    `event_date`       TIMESTAMP DEFAULT NULL,
    `employee_id`      BIGINT,
    PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
