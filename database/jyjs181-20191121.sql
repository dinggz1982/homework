/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : jyjs181

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-11-21 01:14:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `class_info`
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `major_id` int(11) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_info
-- ----------------------------
INSERT INTO `class_info` VALUES ('1', '教育技术181', '2', '2018');

-- ----------------------------
-- Table structure for `college`
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `school_id` int(11) NOT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `school_id` (`school_id`),
  CONSTRAINT `college_ibfk_1` FOREIGN KEY (`school_id`) REFERENCES `school` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES ('1', '??????', '??', '17', '13');
INSERT INTO `college` VALUES ('2', '????', '???310', '2', '123');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `classinfo_id` int(11) DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `meta_course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'java程序设计', '107', '2', null, '1');

-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL,
  `description` text,
  `college_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '软件工程', '123', null);
INSERT INTO `major` VALUES ('2', '教育技术', '骞垮?澶у???叉????							\r\n								', null);
INSERT INTO `major` VALUES ('3', '???叉????', '骞垮ぇ???叉????				', null);
INSERT INTO `major` VALUES ('4', '123123', '123123', null);
INSERT INTO `major` VALUES ('5', '21312', '21312', null);
INSERT INTO `major` VALUES ('6', '???叉????', '骞垮ぇ???叉????', null);
INSERT INTO `major` VALUES ('7', '???叉????', '骞垮ぇ', null);
INSERT INTO `major` VALUES ('8', '???叉????', '???叉????', null);
INSERT INTO `major` VALUES ('9', '???叉????', '???叉????', null);
INSERT INTO `major` VALUES ('10', '???叉????23', '???叉????23', null);
INSERT INTO `major` VALUES ('11', '杞欢宸ョ?', '鍗?鍗?鐞?宸ヨ蒋浠跺伐绋?', null);

-- ----------------------------
-- Table structure for `meta_course`
-- ----------------------------
DROP TABLE IF EXISTS `meta_course`;
CREATE TABLE `meta_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  `course_time` int(11) DEFAULT NULL COMMENT '课时',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meta_course
-- ----------------------------
INSERT INTO `meta_course` VALUES ('1', 'java程序设计', null, '32');

-- ----------------------------
-- Table structure for `outline`
-- ----------------------------
DROP TABLE IF EXISTS `outline`;
CREATE TABLE `outline` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  `parent_id` bigint(20) DEFAULT NULL,
  `textbook_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outline
-- ----------------------------
INSERT INTO `outline` VALUES ('1', '第一章', null, null, '1');
INSERT INTO `outline` VALUES ('2', '第二章', null, null, '1');
INSERT INTO `outline` VALUES ('3', '1.1:java基本数据类型', null, '1', '1');
INSERT INTO `outline` VALUES ('4', '1.2:java程序结构', null, '1', '1');
INSERT INTO `outline` VALUES ('5', '2.1:面向对象程序设计1', null, '2', '1');
INSERT INTO `outline` VALUES ('6', '2.2:面向对象程序设计2', null, '2', '1');

-- ----------------------------
-- Table structure for `school`
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学校名称',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学校地址',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮政编码',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '学校简介',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('2', '????', '??????????', '123456', '510000', '????');
INSERT INTO `school` VALUES ('9', '????', '??????', '123456', null, null);
INSERT INTO `school` VALUES ('11', '????????', '????????', '????????', null, null);
INSERT INTO `school` VALUES ('17', '??????', '??????', '??????', null, null);

-- ----------------------------
-- Table structure for `textbook`
-- ----------------------------
DROP TABLE IF EXISTS `textbook`;
CREATE TABLE `textbook` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `press` varchar(255) DEFAULT NULL COMMENT '出版社',
  `isbn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of textbook
-- ----------------------------
INSERT INTO `textbook` VALUES ('1', '电子工业出版社', '123', 'JAVA程序设计', '1');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `description` text,
  `type` int(11) DEFAULT NULL COMMENT '用户类型：1管理员，2教师，3学生',
  `realname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('107', 'abc', '123', null, null, null, '张三');
INSERT INTO `users` VALUES ('115', 'def', '123', null, null, null, '李四');
INSERT INTO `users` VALUES ('116', '??', '123', null, null, null, '王五');
INSERT INTO `users` VALUES ('117', 'abc123', '123', null, null, null, '赵六');

-- ----------------------------
-- Table structure for `user_major`
-- ----------------------------
DROP TABLE IF EXISTS `user_major`;
CREATE TABLE `user_major` (
  `user_id` int(11) DEFAULT NULL,
  `major_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_major
-- ----------------------------
