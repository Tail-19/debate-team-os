USE `test`;
DROP TABLE IF EXISTS `files`;
CREATE TABLE `files`
(
    `id`            BIGINT(20) UNSIGNED AUTO_INCREMENT,
    `name`          varchar(32) DEFAULT NULL,
    `path`          varchar(64) DEFAULT NULL,
    `fileType`      varchar(32),
    `uploader`      varchar(32),
    `uploaderTitle` varchar(32),
    `tag`           varchar(32),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable`
(
    `id`         BIGINT(20) UNSIGNED AUTO_INCREMENT,
    `username`   varchar(32) DEFAULT NULL,
    `student_id` varchar(32) DEFAULT NULL,
    `password`   varchar(64),
    `phone`      varchar(32),
    `email`      varchar(32),
    `token`      varchar(128),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages`
(
    `id`      BIGINT(20) UNSIGNED AUTO_INCREMENT,
    `from`    varchar(32) DEFAULT NULL,
    `to`      varchar(32) DEFAULT NULL,
    `message` varchar(128) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;