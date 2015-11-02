/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : db_chess

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2015-11-02 23:56:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_demo`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_demo`;
CREATE TABLE `tbl_demo` (
  `game_id` int(11) NOT NULL,
  `score` int(11) NOT NULL DEFAULT '0',
  `total_count` int(11) NOT NULL DEFAULT '0',
  `win_count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_demo
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_player`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_player`;
CREATE TABLE `tbl_player` (
  `game_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` char(64) NOT NULL,
  `pwd` char(64) NOT NULL,
  `name` char(64) NOT NULL,
  `regist_utc` int(11) NOT NULL,
  `regist_date` datetime NOT NULL,
  `last_login_utc` int(11) NOT NULL,
  `last_login_date` datetime NOT NULL,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_player
-- ----------------------------
