/*
Navicat MySQL Data Transfer

Source Server         : 140.143.238.212
Source Server Version : 50722
Source Host           : 140.143.238.212:3306
Source Database       : point_system

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-05-03 19:44:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `app`
-- ----------------------------
DROP TABLE IF EXISTS `app`;
CREATE TABLE `app` (
  `id` bigint(20) NOT NULL,
  `app_key` varchar(64) NOT NULL,
  `app_secret` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `dev_id` bigint(20) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valid` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of app
-- ----------------------------
INSERT INTO `app` VALUES ('991981467603042304', 'fvyqFfOTRlpLVrGJ', 'fWknd0DC7JPp2pN7UIDA42zqbXyAgob2', '?24v', '991915684390764544', '1', '2018-05-03 10:03:07', '2018-05-03 10:03:07', '1');
INSERT INTO `app` VALUES ('991982501415092224', 'ElNolDYTibjFHLpf', 'AdAvJVujKts1M4gcIeJnUS3iIx7ofgLC', '??', '991915684390764544', '1', '2018-05-03 10:07:13', '2018-05-03 10:07:13', '1');

-- ----------------------------
-- Table structure for `app_dev`
-- ----------------------------
DROP TABLE IF EXISTS `app_dev`;
CREATE TABLE `app_dev` (
  `id` bigint(20) NOT NULL,
  `dev_id` bigint(20) NOT NULL,
  `app_id` bigint(20) NOT NULL,
  `role` varchar(16) NOT NULL,
  `is_default` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `valid` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of app_dev
-- ----------------------------
INSERT INTO `app_dev` VALUES ('991981467913420800', '991915684390764544', '991981467603042304', 'owner', '1', '2018-05-03 10:07:46', '2018-05-03 10:07:46', '1');
INSERT INTO `app_dev` VALUES ('991982501759025152', '991915684390764544', '991982501415092224', 'owner', '0', null, null, '1');
INSERT INTO `app_dev` VALUES ('991986569374072832', '991985597314760704', '991981467603042304', 'developer', '0', null, null, '1');

-- ----------------------------
-- Table structure for `app_developer`
-- ----------------------------
DROP TABLE IF EXISTS `app_developer`;
CREATE TABLE `app_developer` (
  `id` bigint(20) NOT NULL,
  `country_code` varchar(16) DEFAULT '86',
  `mobile` varchar(20) NOT NULL,
  `nick_name` varchar(64) NOT NULL,
  `avatar` varchar(128) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `password` varchar(64) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `valid` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of app_developer
-- ----------------------------
INSERT INTO `app_developer` VALUES ('991915684390764544', '86', '18661219025', 'Ogfhq9', null, null, '$2a$10$cVUkLBklSqakE9GH9yk.E.MHN6f28conu5IRo8KGqo2O/ywsdYv1S', '2018-05-03 05:41:42', null, '1');
INSERT INTO `app_developer` VALUES ('991985597314760704', '86', '18661219026', 'svtwCr', null, null, '$2a$10$epaYj3Zy5X6s7fY1Lg9VAe.vp8OoHJZU7NvIyeFOsgzxdLaQXa0WO', '2018-05-03 10:19:31', null, '1');

-- ----------------------------
-- Table structure for `event`
-- ----------------------------
DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `id` bigint(20) NOT NULL,
  `app_id` bigint(20) NOT NULL,
  `created_by` bigint(20) NOT NULL,
  `name` varchar(64) NOT NULL,
  `score` int(11) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valid` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of event
-- ----------------------------

-- ----------------------------
-- Table structure for `level`
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level` (
  `id` bigint(20) NOT NULL,
  `app_id` bigint(20) NOT NULL,
  `created_by` bigint(20) NOT NULL,
  `level` int(11) NOT NULL DEFAULT '0',
  `name` varchar(64) NOT NULL,
  `icon` varchar(128) DEFAULT NULL,
  `min_score` int(11) NOT NULL DEFAULT '0',
  `level_words` text,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valid` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of level
-- ----------------------------
INSERT INTO `level` VALUES ('992006370360295424', '991981467603042304', '991915684390764544', '1', '1111', null, '1', '111', null, null, '1');

-- ----------------------------
-- Table structure for `modal`
-- ----------------------------
DROP TABLE IF EXISTS `modal`;
CREATE TABLE `modal` (
  `id` bigint(20) NOT NULL,
  `app_id` bigint(20) NOT NULL,
  `created_by` bigint(20) NOT NULL,
  `event_id` bigint(20) NOT NULL,
  `serial_id` bigint(20) NOT NULL,
  `name` varchar(64) NOT NULL,
  `icon` varchar(128) DEFAULT NULL,
  `unget_icon` varchar(128) DEFAULT NULL,
  `get_condition` int(11) NOT NULL DEFAULT '0',
  `get_condition_words` text,
  `stimulate_words` text,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valid` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of modal
-- ----------------------------

-- ----------------------------
-- Table structure for `modal_serial`
-- ----------------------------
DROP TABLE IF EXISTS `modal_serial`;
CREATE TABLE `modal_serial` (
  `id` bigint(20) NOT NULL,
  `app_id` bigint(20) NOT NULL,
  `created_by` bigint(20) NOT NULL,
  `name` varchar(64) NOT NULL,
  `type` tinyint(2) NOT NULL DEFAULT '1',
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valid` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of modal_serial
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL,
  `app_id` bigint(20) NOT NULL,
  `created_by` bigint(20) NOT NULL,
  `user_account` varchar(64) NOT NULL,
  `nick_name` varchar(64) NOT NULL,
  `modal_num` int(11) NOT NULL DEFAULT '0',
  `score` int(11) NOT NULL DEFAULT '0',
  `intergral` int(11) NOT NULL DEFAULT '0',
  `current_level` int(11) NOT NULL DEFAULT '0',
  `virtual_icons` bigint(20) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valid` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_info
-- ----------------------------
