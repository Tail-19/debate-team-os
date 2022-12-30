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