/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : db_chess

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-11-10 18:08:50
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_player
-- ----------------------------
INSERT INTO `tbl_player` VALUES ('1', 'jing', '321', 'asdf', '0', '2015-11-03 16:29:28', '0', '2015-11-03 16:29:32');
INSERT INTO `tbl_player` VALUES ('2', 'test', '321', 'test', '0', '2015-11-10 18:07:03', '0', '2015-11-10 18:07:09');
