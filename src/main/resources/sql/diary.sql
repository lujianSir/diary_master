/*
Navicat MySQL Data Transfer

Source Server         : 本地链接
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : diary

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-03-09 17:33:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(50) DEFAULT NULL,
  `cabbreviation` varchar(50) DEFAULT NULL,
  `weixin` varchar(255) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `creattime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '八位时空', '八位', null, '4', '2020-03-01 17:26:27');
INSERT INTO `company` VALUES ('2', '测试数据', '测试', 'ewqewqeq', '4', '2020-03-03 10:26:27');
INSERT INTO `company` VALUES ('5', '咸宁数据', '咸宁', null, '3', '2020-03-04 12:25:49');

-- ----------------------------
-- Table structure for daily
-- ----------------------------
DROP TABLE IF EXISTS `daily`;
CREATE TABLE `daily` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `uposition` varchar(50) DEFAULT NULL,
  `utelphone` varchar(50) DEFAULT NULL,
  `weather` int(11) DEFAULT NULL,
  `attendancetody` int(11) DEFAULT NULL,
  `attendanceoneself` int(11) DEFAULT NULL,
  `effectivework` int(11) DEFAULT NULL,
  `satisfactiondegree` int(11) DEFAULT NULL,
  `equipments` text,
  `workcomment` text,
  `abnorname` text,
  `dunning` text,
  `dunningpic` varchar(255) DEFAULT NULL,
  `amountody` decimal(10,0) DEFAULT NULL,
  `invoicetody` decimal(10,0) DEFAULT NULL,
  `dpic` text,
  `dvoideo` text,
  `dtime` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `creattime` varchar(50) DEFAULT NULL,
  `creatMouth` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of daily
-- ----------------------------
INSERT INTO `daily` VALUES ('5', '4', 'zhaoliu', '测试222', '222', '1', '4', '1', '2', '3', '挖掘机-2;吊车-8', '挖土方666', '挖掘机有问题666', '催款钱666', null, '60', '60', '/image/picture/1583740915288.jpg', '/image/video/1583740928803.mp4', '2020年03月09日', '10', '2020-03-09 16:29:45', '2020年03月');
INSERT INTO `daily` VALUES ('6', '4', 'zhaoliu', '测试1111', '111', '1', '4', '1', '2', '3', '挖掘机-3;吊车-5;钻图集-1', '挖土方666', '挖掘机有问题666', '催款钱666', null, '60', '60', '/image/picture/1583740915288.jpg', '/image/video/1583740928803.mp4', '2020年03月08日', '10', '2020-03-09 16:33:48', '2020年03月');
INSERT INTO `daily` VALUES ('7', '4', 'zhaoliu', '测试222', '2222', '1', '4', '1', '2', '3', '挖掘机-3;吊车-5;钻图集-1', '挖土方666', '挖掘机有问题666', '催款钱666', null, '60', '60', '/image/picture/1583740915288.jpg', '/image/video/1583740928803.mp4', '2020年03月08日', '11', '2020-03-09 16:40:16', '2020年03月');
INSERT INTO `daily` VALUES ('8', '3', 'dsadsadagse', '测试222111', '2222111', '1', '4', '1', '2', '3', '挖掘机-3;吊车-5;钻图集-1', '挖土方666', '挖掘机有问题666', '催款钱666', null, '60', '60', '/image/picture/1583740915288.jpg', '/image/video/1583740928803.mp4', '2020年03月08日', '11', '2020-03-09 16:40:59', '2020年03月');

-- ----------------------------
-- Table structure for everyday
-- ----------------------------
DROP TABLE IF EXISTS `everyday`;
CREATE TABLE `everyday` (
  `dtime` varchar(255) NOT NULL,
  `creatMouth` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dtime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of everyday
-- ----------------------------
INSERT INTO `everyday` VALUES ('2020年03月03日', '2020年03月');
INSERT INTO `everyday` VALUES ('2020年03月04日', '2020年03月');
INSERT INTO `everyday` VALUES ('2020年03月05日', '2020年03月');
INSERT INTO `everyday` VALUES ('2020年03月06日', '2020年03月');
INSERT INTO `everyday` VALUES ('2020年03月07日', '2020年03月');
INSERT INTO `everyday` VALUES ('2020年03月08日', '2020年03月');
INSERT INTO `everyday` VALUES ('2020年03月09日', '2020年03月');

-- ----------------------------
-- Table structure for fileinfo
-- ----------------------------
DROP TABLE IF EXISTS `fileinfo`;
CREATE TABLE `fileinfo` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(50) DEFAULT NULL,
  `frealurl` varchar(255) DEFAULT NULL,
  `fvirtualurl` varchar(255) DEFAULT NULL,
  `fuploadtime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fileinfo
-- ----------------------------
INSERT INTO `fileinfo` VALUES ('1', '1583740915288.jpg', 'D:\\sts-workspace\\diary\\upload\\picture\\1583740915288.jpg', '/image/picture/1583740915288.jpg', '2020-03-09 16:01:55');
INSERT INTO `fileinfo` VALUES ('2', '1583740928803.mp4', 'D:\\sts-workspace\\diary\\upload\\video\\1583740928803.mp4', '/image/video/1583740928803.mp4', '2020-03-09 16:02:08');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) DEFAULT NULL,
  `pabbreviation` varchar(50) DEFAULT NULL,
  `pnumber` varchar(255) DEFAULT NULL,
  `paddress` text,
  `pstatus` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `ptype` int(11) DEFAULT NULL,
  `contractamount` decimal(10,0) DEFAULT NULL,
  `acceptedamount` decimal(10,0) DEFAULT NULL,
  `acceptedinvoice` decimal(10,0) DEFAULT NULL,
  `totalartificial` int(11) DEFAULT NULL,
  `approachDay` varchar(50) DEFAULT NULL,
  `completeDay` varchar(50) DEFAULT NULL,
  `paycondition` text,
  `fineremarks` text,
  `creattime` varchar(50) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `weixin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('10', '崇阳项目1', '崇阳宁1', 'czcxzvz', '湖北崇阳1', '1', '5', '1', '320', '240', '130', '10', '2010-3-3', '2019-8-3', '非要全部成功', '晚一天扣1000', '2020-03-04 17:02:06', '3', null);
INSERT INTO `project` VALUES ('11', '赤壁项目', '赤壁', '2132141', '湖北崇赤壁', '2', '5', '3', '920', '740', '430', '10', '2010-3-3', '2019-18-3', '非dsda要全部成功', '晚3211扣1000', '2020-03-04 17:03:29', '3', null);
INSERT INTO `project` VALUES ('12', '赤壁项目', '赤壁', '21321', '湖北崇赤壁', '2', '5', '3', '920', '740', '430', '10', '2010-3-3', '2019-18-3', '非dsda要全部成功', '晚3211扣1000', '2020-03-06 10:44:11', '3', null);

-- ----------------------------
-- Table structure for projectuser
-- ----------------------------
DROP TABLE IF EXISTS `projectuser`;
CREATE TABLE `projectuser` (
  `pid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of projectuser
-- ----------------------------
INSERT INTO `projectuser` VALUES ('10', '3');
INSERT INTO `projectuser` VALUES ('11', '3');
INSERT INTO `projectuser` VALUES ('10', '4');
INSERT INTO `projectuser` VALUES ('12', '3');
INSERT INTO `projectuser` VALUES ('11', '4');
INSERT INTO `projectuser` VALUES ('11', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(32) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `utelphone` varchar(50) DEFAULT NULL,
  `uposition` varchar(32) DEFAULT NULL,
  `upic` varchar(255) DEFAULT NULL,
  `wxid` varchar(255) DEFAULT NULL,
  `creattime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'dsadsadagse', '13412', '312312', null, null, '2020-03-03 17:26:27\r\n2020-03-01 17:26:27\r\n');
INSERT INTO `user` VALUES ('2', 'zhangse', '13412', null, null, null, '2020-03-03 10:26:27\r\n');
INSERT INTO `user` VALUES ('3', 'dsadsadagse', '13412', null, null, null, '2020-03-01 17:26:27\r\n');
INSERT INTO `user` VALUES ('4', 'zhaoliu', '13142314871', '主要是为了测试', null, 'dsadsafadwadwa', '2020-03-03 17:26:17\r\n');
