/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50725
Source Host           : 127.0.0.1:3306
Source Database       : homework

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-11-07 19:19:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `college`
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `school_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `school_id` (`school_id`) USING BTREE,
  CONSTRAINT `college_ibfk_1` FOREIGN KEY (`school_id`) REFERENCES `school` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES ('1', '文逸楼', '教育学院', '123', '1');
INSERT INTO `college` VALUES ('2', '文逸楼', '美术学院 ', '123', '1');
INSERT INTO `college` VALUES ('3', '理科南', '计算机学院', '456', '1');

-- ----------------------------
-- Table structure for `school`
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('1', '广州大学城', '广州大学', '123456');
INSERT INTO `school` VALUES ('2', '广州大学城', '中山大学', '123456');
INSERT INTO `school` VALUES ('3', '测试地址1', '测试学校1', '测试电话1');
INSERT INTO `school` VALUES ('4', '测试地址2', '测试学校2', '测试电话2');
INSERT INTO `school` VALUES ('5', '测试地址3', '测试学校3', '测试电话3');
INSERT INTO `school` VALUES ('6', '测试地址4', '测试学校4', '测试电话4');
INSERT INTO `school` VALUES ('7', '测试地址5', '测试学校5', '测试电话5');
INSERT INTO `school` VALUES ('8', '测试地址6', '测试学校6', '测试电话6');
INSERT INTO `school` VALUES ('9', '测试地址7', '测试学校7', '测试电话7');
INSERT INTO `school` VALUES ('10', '测试地址8', '测试学校8', '测试电话8');
INSERT INTO `school` VALUES ('11', '测试地址9', '测试学校9', '测试电话9');
INSERT INTO `school` VALUES ('12', '测试地址10', '测试学校10', '测试电话10');
INSERT INTO `school` VALUES ('13', '测试地址11', '测试学校11', '测试电话11');
INSERT INTO `school` VALUES ('14', '测试地址12', '测试学校12', '测试电话12');
INSERT INTO `school` VALUES ('15', '测试地址13', '测试学校13', '测试电话13');
INSERT INTO `school` VALUES ('16', '测试地址14', '测试学校14', '测试电话14');
INSERT INTO `school` VALUES ('17', '测试地址15', '测试学校15', '测试电话15');
INSERT INTO `school` VALUES ('18', '测试地址16', '测试学校16', '测试电话16');
INSERT INTO `school` VALUES ('19', '测试地址17', '测试学校17', '测试电话17');
INSERT INTO `school` VALUES ('20', '测试地址18', '测试学校18', '测试电话18');
INSERT INTO `school` VALUES ('21', '测试地址19', '测试学校19', '测试电话19');
INSERT INTO `school` VALUES ('22', '测试地址20', '测试学校20', '测试电话20');
INSERT INTO `school` VALUES ('23', '测试地址21', '测试学校21', '测试电话21');
INSERT INTO `school` VALUES ('24', '测试地址22', '测试学校22', '测试电话22');
INSERT INTO `school` VALUES ('25', '测试地址23', '测试学校23', '测试电话23');
INSERT INTO `school` VALUES ('26', '测试地址24', '测试学校24', '测试电话24');
INSERT INTO `school` VALUES ('27', '测试地址25', '测试学校25', '测试电话25');
INSERT INTO `school` VALUES ('28', '测试地址26', '测试学校26', '测试电话26');
INSERT INTO `school` VALUES ('29', '测试地址27', '测试学校27', '测试电话27');
INSERT INTO `school` VALUES ('30', '测试地址28', '测试学校28', '测试电话28');
INSERT INTO `school` VALUES ('31', '测试地址29', '测试学校29', '测试电话29');
INSERT INTO `school` VALUES ('32', '测试地址30', '测试学校30', '测试电话30');
INSERT INTO `school` VALUES ('33', '测试地址31', '测试学校31', '测试电话31');
INSERT INTO `school` VALUES ('34', '测试地址32', '测试学校32', '测试电话32');
INSERT INTO `school` VALUES ('35', '测试地址33', '测试学校33', '测试电话33');
INSERT INTO `school` VALUES ('36', '测试地址34', '测试学校34', '测试电话34');
INSERT INTO `school` VALUES ('37', '测试地址35', '测试学校35', '测试电话35');
INSERT INTO `school` VALUES ('38', '测试地址36', '测试学校36', '测试电话36');
INSERT INTO `school` VALUES ('39', '测试地址37', '测试学校37', '测试电话37');
INSERT INTO `school` VALUES ('40', '测试地址38', '测试学校38', '测试电话38');
INSERT INTO `school` VALUES ('41', '测试地址39', '测试学校39', '测试电话39');
INSERT INTO `school` VALUES ('42', '测试地址40', '测试学校40', '测试电话40');
INSERT INTO `school` VALUES ('43', '测试地址41', '测试学校41', '测试电话41');
INSERT INTO `school` VALUES ('44', '测试地址42', '测试学校42', '测试电话42');
INSERT INTO `school` VALUES ('45', '测试地址43', '测试学校43', '测试电话43');
INSERT INTO `school` VALUES ('46', '测试地址44', '测试学校44', '测试电话44');
INSERT INTO `school` VALUES ('47', '测试地址45', '测试学校45', '测试电话45');
INSERT INTO `school` VALUES ('48', '测试地址46', '测试学校46', '测试电话46');
INSERT INTO `school` VALUES ('49', '测试地址47', '测试学校47', '测试电话47');
INSERT INTO `school` VALUES ('50', '测试地址48', '测试学校48', '测试电话48');
INSERT INTO `school` VALUES ('51', '测试地址49', '测试学校49', '测试电话49');
INSERT INTO `school` VALUES ('52', '测试地址50', '测试学校50', '测试电话50');
INSERT INTO `school` VALUES ('53', '测试地址51', '测试学校51', '测试电话51');
INSERT INTO `school` VALUES ('54', '测试地址52', '测试学校52', '测试电话52');
INSERT INTO `school` VALUES ('55', '测试地址53', '测试学校53', '测试电话53');
INSERT INTO `school` VALUES ('56', '测试地址54', '测试学校54', '测试电话54');
INSERT INTO `school` VALUES ('57', '测试地址55', '测试学校55', '测试电话55');
INSERT INTO `school` VALUES ('58', '测试地址56', '测试学校56', '测试电话56');
INSERT INTO `school` VALUES ('59', '测试地址57', '测试学校57', '测试电话57');
INSERT INTO `school` VALUES ('60', '测试地址58', '测试学校58', '测试电话58');
INSERT INTO `school` VALUES ('61', '测试地址59', '测试学校59', '测试电话59');
INSERT INTO `school` VALUES ('62', '测试地址60', '测试学校60', '测试电话60');
INSERT INTO `school` VALUES ('63', '测试地址61', '测试学校61', '测试电话61');
INSERT INTO `school` VALUES ('64', '测试地址62', '测试学校62', '测试电话62');
INSERT INTO `school` VALUES ('65', '测试地址63', '测试学校63', '测试电话63');
INSERT INTO `school` VALUES ('66', '测试地址64', '测试学校64', '测试电话64');
INSERT INTO `school` VALUES ('67', '测试地址65', '测试学校65', '测试电话65');
INSERT INTO `school` VALUES ('68', '测试地址66', '测试学校66', '测试电话66');
INSERT INTO `school` VALUES ('69', '测试地址67', '测试学校67', '测试电话67');
INSERT INTO `school` VALUES ('70', '测试地址68', '测试学校68', '测试电话68');
INSERT INTO `school` VALUES ('71', '测试地址69', '测试学校69', '测试电话69');
INSERT INTO `school` VALUES ('72', '测试地址70', '测试学校70', '测试电话70');
INSERT INTO `school` VALUES ('73', '测试地址71', '测试学校71', '测试电话71');
INSERT INTO `school` VALUES ('74', '测试地址72', '测试学校72', '测试电话72');
INSERT INTO `school` VALUES ('75', '测试地址73', '测试学校73', '测试电话73');
INSERT INTO `school` VALUES ('76', '测试地址74', '测试学校74', '测试电话74');
INSERT INTO `school` VALUES ('77', '测试地址75', '测试学校75', '测试电话75');
INSERT INTO `school` VALUES ('78', '测试地址76', '测试学校76', '测试电话76');
INSERT INTO `school` VALUES ('79', '测试地址77', '测试学校77', '测试电话77');
INSERT INTO `school` VALUES ('80', '测试地址78', '测试学校78', '测试电话78');
INSERT INTO `school` VALUES ('81', '测试地址79', '测试学校79', '测试电话79');
INSERT INTO `school` VALUES ('82', '测试地址80', '测试学校80', '测试电话80');
INSERT INTO `school` VALUES ('83', '测试地址81', '测试学校81', '测试电话81');
INSERT INTO `school` VALUES ('84', '测试地址82', '测试学校82', '测试电话82');
INSERT INTO `school` VALUES ('85', '测试地址83', '测试学校83', '测试电话83');
INSERT INTO `school` VALUES ('86', '测试地址84', '测试学校84', '测试电话84');
INSERT INTO `school` VALUES ('87', '测试地址85', '测试学校85', '测试电话85');
INSERT INTO `school` VALUES ('88', '测试地址86', '测试学校86', '测试电话86');
INSERT INTO `school` VALUES ('89', '测试地址87', '测试学校87', '测试电话87');
INSERT INTO `school` VALUES ('90', '测试地址88', '测试学校88', '测试电话88');
INSERT INTO `school` VALUES ('91', '测试地址89', '测试学校89', '测试电话89');
INSERT INTO `school` VALUES ('92', '测试地址90', '测试学校90', '测试电话90');
INSERT INTO `school` VALUES ('93', '测试地址91', '测试学校91', '测试电话91');
INSERT INTO `school` VALUES ('94', '测试地址92', '测试学校92', '测试电话92');
INSERT INTO `school` VALUES ('95', '测试地址93', '测试学校93', '测试电话93');
INSERT INTO `school` VALUES ('96', '测试地址94', '测试学校94', '测试电话94');
INSERT INTO `school` VALUES ('97', '测试地址95', '测试学校95', '测试电话95');
INSERT INTO `school` VALUES ('98', '测试地址96', '测试学校96', '测试电话96');
INSERT INTO `school` VALUES ('99', '测试地址97', '测试学校97', '测试电话97');
INSERT INTO `school` VALUES ('100', '测试地址98', '测试学校98', '测试电话98');
INSERT INTO `school` VALUES ('101', '测试地址99', '测试学校99', '测试电话99');
INSERT INTO `school` VALUES ('102', '测试地址100', '测试学校100', '测试电话100');
