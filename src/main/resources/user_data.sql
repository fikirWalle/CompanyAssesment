
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `name` varchar(50) DEFAULT NULL,
                          PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `payer`;
CREATE TABLE `payer` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `name` varchar(50) DEFAULT NULL,'point' INT(20) DEFAULT NULL,
                        PRIMARY KEY (`id`)
);

