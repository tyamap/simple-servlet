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

INSERT INTO `test_table`
    (`name`)
VALUES
    ('test'),
    ('hoge'),
    ('fuga'),
    ('foo'),
    ('bar');