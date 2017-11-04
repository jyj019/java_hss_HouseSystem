/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : house

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-04 14:50:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_city
-- ----------------------------
DROP TABLE IF EXISTS `tb_city`;
CREATE TABLE `tb_city` (
  `cityid` int(11) NOT NULL AUTO_INCREMENT,
  `cityname` varchar(255) COLLATE utf8_bin NOT NULL,
  `prov_id` int(11) NOT NULL,
  PRIMARY KEY (`cityid`),
  KEY `fk_city_prov` (`prov_id`),
  CONSTRAINT `fk_city_prov` FOREIGN KEY (`prov_id`) REFERENCES `tb_province` (`provid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_city
-- ----------------------------
INSERT INTO `tb_city` VALUES ('1', '北京', '1');
INSERT INTO `tb_city` VALUES ('2', '重庆', '2');
INSERT INTO `tb_city` VALUES ('3', '成都', '3');
INSERT INTO `tb_city` VALUES ('4', '绵阳', '3');
INSERT INTO `tb_city` VALUES ('5', '德阳', '3');

-- ----------------------------
-- Table structure for tb_district
-- ----------------------------
DROP TABLE IF EXISTS `tb_district`;
CREATE TABLE `tb_district` (
  `distid` int(11) NOT NULL AUTO_INCREMENT,
  `distname` varchar(255) COLLATE utf8_bin NOT NULL,
  `city_id` int(11) NOT NULL,
  PRIMARY KEY (`distid`),
  KEY `fk_district_city` (`city_id`),
  CONSTRAINT `fk_district_city` FOREIGN KEY (`city_id`) REFERENCES `tb_city` (`cityid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_district
-- ----------------------------
INSERT INTO `tb_district` VALUES ('1', '东城区', '1');
INSERT INTO `tb_district` VALUES ('2', '海淀区', '1');
INSERT INTO `tb_district` VALUES ('3', '大兴区', '1');
INSERT INTO `tb_district` VALUES ('4', '其他', '1');
INSERT INTO `tb_district` VALUES ('5', '渝北区', '2');
INSERT INTO `tb_district` VALUES ('6', '江北区', '2');
INSERT INTO `tb_district` VALUES ('7', '沙坪坝区', '2');
INSERT INTO `tb_district` VALUES ('8', '万州区', '2');
INSERT INTO `tb_district` VALUES ('9', '其他', '2');
INSERT INTO `tb_district` VALUES ('10', '成华区', '3');
INSERT INTO `tb_district` VALUES ('11', '武侯区', '3');
INSERT INTO `tb_district` VALUES ('12', '金牛区', '3');
INSERT INTO `tb_district` VALUES ('13', '锦江区', '3');
INSERT INTO `tb_district` VALUES ('14', '青羊区', '3');
INSERT INTO `tb_district` VALUES ('15', '其他', '3');
INSERT INTO `tb_district` VALUES ('16', '涪城区', '4');
INSERT INTO `tb_district` VALUES ('17', '游仙区', '4');
INSERT INTO `tb_district` VALUES ('18', '三台县', '4');
INSERT INTO `tb_district` VALUES ('19', '其他', '5');
INSERT INTO `tb_district` VALUES ('20', '旌阳区', '5');
INSERT INTO `tb_district` VALUES ('21', '绵竹市', '5');
INSERT INTO `tb_district` VALUES ('22', '其他', '5');

-- ----------------------------
-- Table structure for tb_house
-- ----------------------------
DROP TABLE IF EXISTS `tb_house`;
CREATE TABLE `tb_house` (
  `houseid` int(11) NOT NULL AUTO_INCREMENT,
  `area` int(11) NOT NULL,
  `contacterEmail` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `contacterName` varchar(10) COLLATE utf8_bin NOT NULL,
  `contacterQQ` varchar(12) COLLATE utf8_bin DEFAULT NULL,
  `contacterTel` varchar(20) COLLATE utf8_bin NOT NULL,
  `detail` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `floor` int(11) NOT NULL,
  `mainPhoto` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price` float NOT NULL,
  `pubDate` datetime DEFAULT NULL,
  `street` varchar(255) COLLATE utf8_bin NOT NULL,
  `title` varchar(50) COLLATE utf8_bin NOT NULL,
  `totalFloor` int(11) DEFAULT NULL,
  `district_id` int(11) DEFAULT NULL,
  `house_type_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`houseid`),
  KEY `fk_house_district` (`district_id`),
  KEY `fk_house_type` (`house_type_id`),
  KEY `fk_house_user` (`user_id`),
  CONSTRAINT `fk_house_district` FOREIGN KEY (`district_id`) REFERENCES `tb_district` (`distid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_house_type` FOREIGN KEY (`house_type_id`) REFERENCES `tb_house_type` (`typeid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_house_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_house
-- ----------------------------
INSERT INTO `tb_house` VALUES ('4', '300', 'eeee@eeeeeee', 'hh', '3333', '333333', '', '15', 'e8fcf4a7-3193-47bf-bb08-2289364838cb.jpg', '3000', '2017-10-24 14:32:34', '五门街道', '江景房', '23', '6', '1', '5');

-- ----------------------------
-- Table structure for tb_house_photo
-- ----------------------------
DROP TABLE IF EXISTS `tb_house_photo`;
CREATE TABLE `tb_house_photo` (
  `photoid` int(11) NOT NULL AUTO_INCREMENT,
  `photoname` varchar(255) COLLATE utf8_bin NOT NULL,
  `house_id` int(11) NOT NULL,
  PRIMARY KEY (`photoid`),
  KEY `fk_photo_house` (`house_id`),
  CONSTRAINT `fk_photo_house` FOREIGN KEY (`house_id`) REFERENCES `tb_house` (`houseid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_house_photo
-- ----------------------------

-- ----------------------------
-- Table structure for tb_house_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_house_type`;
CREATE TABLE `tb_house_type` (
  `typeid` int(11) NOT NULL,
  `typename` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_house_type
-- ----------------------------
INSERT INTO `tb_house_type` VALUES ('1', '单间');
INSERT INTO `tb_house_type` VALUES ('2', '一室一厅');
INSERT INTO `tb_house_type` VALUES ('3', '二室一厅');
INSERT INTO `tb_house_type` VALUES ('4', '三室一厅');
INSERT INTO `tb_house_type` VALUES ('5', '三室两厅');
INSERT INTO `tb_house_type` VALUES ('6', '四室两厅');
INSERT INTO `tb_house_type` VALUES ('7', '别墅');
INSERT INTO `tb_house_type` VALUES ('8', '其他');

-- ----------------------------
-- Table structure for tb_login_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_login_log`;
CREATE TABLE `tb_login_log` (
  `loginid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `ipaddr` varchar(255) COLLATE utf8_bin NOT NULL,
  `logdate` datetime NOT NULL,
  PRIMARY KEY (`loginid`),
  KEY `fk_log_user` (`user_id`),
  CONSTRAINT `fk_log_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_login_log
-- ----------------------------
INSERT INTO `tb_login_log` VALUES ('1', '2', '211.135.62.90', '2017-10-18 17:02:23');
INSERT INTO `tb_login_log` VALUES ('2', '4', '211.135.62.90', '2017-10-18 20:02:40');
INSERT INTO `tb_login_log` VALUES ('3', '4', '211.135.62.90', '2017-10-19 09:17:44');
INSERT INTO `tb_login_log` VALUES ('4', '4', '211.135.62.90', '2017-10-19 09:28:03');
INSERT INTO `tb_login_log` VALUES ('5', '4', '211.135.62.90', '2017-10-19 10:40:02');
INSERT INTO `tb_login_log` VALUES ('6', '4', '211.135.62.90', '2017-10-19 10:45:33');
INSERT INTO `tb_login_log` VALUES ('7', '5', '0:0:0:0:0:0:0:1', '2017-10-19 14:04:41');
INSERT INTO `tb_login_log` VALUES ('8', '5', '0:0:0:0:0:0:0:1', '2017-10-19 14:07:25');
INSERT INTO `tb_login_log` VALUES ('9', '4', '0:0:0:0:0:0:0:1', '2017-10-19 14:10:29');
INSERT INTO `tb_login_log` VALUES ('10', '5', '0:0:0:0:0:0:0:1', '2017-10-19 14:34:57');
INSERT INTO `tb_login_log` VALUES ('11', '5', '0:0:0:0:0:0:0:1', '2017-10-19 14:37:43');
INSERT INTO `tb_login_log` VALUES ('12', '4', '0:0:0:0:0:0:0:1', '2017-10-19 14:37:55');
INSERT INTO `tb_login_log` VALUES ('13', '5', '0:0:0:0:0:0:0:1', '2017-10-19 20:40:54');
INSERT INTO `tb_login_log` VALUES ('14', '5', '0:0:0:0:0:0:0:1', '2017-10-19 20:40:54');
INSERT INTO `tb_login_log` VALUES ('15', '5', '0:0:0:0:0:0:0:1', '2017-10-19 20:49:59');
INSERT INTO `tb_login_log` VALUES ('16', '5', '0:0:0:0:0:0:0:1', '2017-10-19 20:50:57');
INSERT INTO `tb_login_log` VALUES ('17', '5', '0:0:0:0:0:0:0:1', '2017-10-23 18:54:53');
INSERT INTO `tb_login_log` VALUES ('18', '5', '0:0:0:0:0:0:0:1', '2017-10-23 20:11:22');
INSERT INTO `tb_login_log` VALUES ('19', '5', '0:0:0:0:0:0:0:1', '2017-10-24 08:31:33');
INSERT INTO `tb_login_log` VALUES ('20', '5', '0:0:0:0:0:0:0:1', '2017-10-24 10:40:58');
INSERT INTO `tb_login_log` VALUES ('21', '5', '0:0:0:0:0:0:0:1', '2017-10-24 14:31:03');
INSERT INTO `tb_login_log` VALUES ('22', '5', '0:0:0:0:0:0:0:1', '2017-10-24 17:37:12');
INSERT INTO `tb_login_log` VALUES ('23', '7', '0:0:0:0:0:0:0:1', '2017-10-25 19:25:59');
INSERT INTO `tb_login_log` VALUES ('24', '5', '0:0:0:0:0:0:0:1', '2017-11-03 19:53:14');

-- ----------------------------
-- Table structure for tb_province
-- ----------------------------
DROP TABLE IF EXISTS `tb_province`;
CREATE TABLE `tb_province` (
  `provid` int(11) NOT NULL AUTO_INCREMENT,
  `provname` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`provid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_province
-- ----------------------------
INSERT INTO `tb_province` VALUES ('1', '北京');
INSERT INTO `tb_province` VALUES ('2', '重庆');
INSERT INTO `tb_province` VALUES ('3', '四川省');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` char(32) COLLATE utf8_bin NOT NULL,
  `realname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `tel` char(11) COLLATE utf8_bin DEFAULT NULL,
  `isadmin` bit(1) DEFAULT b'0',
  PRIMARY KEY (`userid`),
  UNIQUE KEY `uni_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '王大锤', '13800112233', '');
INSERT INTO `tb_user` VALUES ('2', 'qing', 'e10adc3949ba59abbe56e057f20f883e', 'qingxing', '123456', '\0');
INSERT INTO `tb_user` VALUES ('3', 'twoshits', '1c63129ae9db9c60c3e8aa94d3e00495', '�������', '13500998765', '\0');
INSERT INTO `tb_user` VALUES ('4', '22', 'b6d767d2f8ed5d21a44b0e5886680cb9', 'luna', '44444', '\0');
INSERT INTO `tb_user` VALUES ('5', 'lucy', '202cb962ac59075b964b07152d234b70', 'lucy.j', 'd888d', null);
INSERT INTO `tb_user` VALUES ('6', 'hhhh', '81dc9bdb52d04dc20036dbd8313ed055', 'hello', '66666', null);
INSERT INTO `tb_user` VALUES ('7', 'hhh', '934b535800b1cba8f96a5d72f72f1611', 'helloyo', '567890', null);
INSERT INTO `tb_user` VALUES ('8', 'oneshit', 'e0f7a4d0ef9b84b83b693bbf3feb8e6e', '2', '13500998765', '\0');
SET FOREIGN_KEY_CHECKS=1;
