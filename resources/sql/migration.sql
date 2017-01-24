CREATE DATABASE IF NOT EXISTS tables_example;

USE tables_example;

CREATE TABLE `employees` (
  `id`              INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`            VARCHAR(300)     NOT NULL,
  `address`         VARCHAR(300)              DEFAULT NULL,
  `age`             INT(11)                   DEFAULT '18',
  `job_description` TEXT,
  `birthday`        DATE             NOT NULL,
  `salary_in_cents` INT(10) UNSIGNED NOT NULL,
  `ssn`             CHAR(9)          NOT NULL,
  `created_at`      DATETIME         NOT NULL,
  `is_full_time`    TINYINT(1)                DEFAULT '1',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8