/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : phone

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2016-10-08 15:05:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hpzc_user`
-- ----------------------------
DROP TABLE IF EXISTS `hpzc_user`;
CREATE TABLE `hpzc_user` (
  `u_id` varchar(32) NOT NULL COMMENT '用户表ID',
  `username` varchar(16) DEFAULT NULL COMMENT '账号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `name` varchar(16) DEFAULT NULL COMMENT '姓名',
  `tel` varchar(16) DEFAULT NULL COMMENT '联系方式',
  `u_no` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `khh` varchar(100) DEFAULT NULL COMMENT '开户行',
  `yhzh` varchar(100) DEFAULT NULL COMMENT '银行账号',
  `qq` varchar(16) DEFAULT NULL COMMENT 'QQ',
  `weixin` varchar(16) DEFAULT NULL COMMENT '微信',
  `mail` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `jjlxr` varchar(16) DEFAULT NULL COMMENT '紧急联系人',
  `jjlxrtel` varchar(16) DEFAULT NULL COMMENT '紧急联系人电话',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `other` varchar(100) DEFAULT NULL COMMENT '其他',
  `org_code` varchar(100) DEFAULT NULL COMMENT '部门编码',
  `org_name` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `org_codesj` varchar(100) DEFAULT NULL COMMENT '上级部门编码',
  `org_namesj` varchar(100) DEFAULT NULL COMMENT '上级部门名称',
  `memo` varchar(100) DEFAULT NULL COMMENT '描述',
  `is_delete` char(1) DEFAULT '0' COMMENT '是否删除标识！0:false 1 true',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of hpzc_user
-- ----------------------------
INSERT INTO `hpzc_user` VALUES ('1', 'zhaoyun', '7edfe5410bf8d4c2374cd01c5133fea8', '赵云', '1525555555', null, null, null, '', null, 'zhaoyun@126.com', null, null, null, null, null, null, null, null, '', '0');
INSERT INTO `hpzc_user` VALUES ('123', 'machao', '20e3948d91548b70924203a9f17ef7e4', '马超', '', null, null, null, '', null, '141@123.com', null, null, null, null, null, null, null, null, '', '0');
INSERT INTO `hpzc_user` VALUES ('19A9F7CE2A594A1E92B4499214FA019C', 'huangzhong', '5d437c51635ce2b204b6c7813669a1e8', '黄忠', null, null, null, null, null, null, 'qwerwre@123.com', null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `hpzc_user` VALUES ('2', 'zhangliao', 'def4a49760354c10214d8e73c5085100', '张辽', '1525555555', null, null, null, '', null, 'zhangliao', null, null, null, null, null, null, null, null, '', '0');
INSERT INTO `hpzc_user` VALUES ('3', 'zhanghe', '1f677a8c05e6a44766ae7085f0738455', '张郃', '1525555555', null, null, null, '', null, 'zhanghe', null, null, null, null, null, null, null, null, '', '0');
INSERT INTO `hpzc_user` VALUES ('4', 'guanyu', '9af5340d36ba95ed9c1f249dbd7f008f', '关羽', '1539999999', null, null, null, '', null, 'guanyu@126.com', null, null, null, null, null, null, null, null, '', '0');
INSERT INTO `hpzc_user` VALUES ('4E69650DC40C4203B440CF406DC0AE93', 'xuhuang', 'a05ac00d639d5c1b0d2b6484d7f8cb7b', '徐晃', '', '', '', '', '', '', 'wert@126.com', '', '', '', '', '', '', '', '', '', '0');
INSERT INTO `hpzc_user` VALUES ('5', 'zhangfei', 'd58f2170fedb27250f52b7b0409a5f96', '张飞', '163828292', null, null, null, '', null, 'zhangfei@126.com', null, null, null, null, null, null, null, null, '', '0');
INSERT INTO `hpzc_user` VALUES ('94811682D36F47658EA918785213A537', 'ganning', '7b191c853be79ac559babf7a2fbf4de6', '甘宁', '', null, null, null, '', null, '141@123.com', null, null, null, null, null, null, null, null, '', '0');
INSERT INTO `hpzc_user` VALUES ('D0F88BE822F0413C82A2C8BAE3E0E39D', 'dianwei', '6c85b67ab96c1844d483a3348e087174', '典韦', '', null, null, null, '', null, '1ewqrwrwr@123.com', null, null, null, null, null, null, null, null, '', '0');
INSERT INTO `hpzc_user` VALUES ('E234CDD0B9D84C51AD3197F1924CD0DE', 'xuchu', 'c0ad94ab77d97627c9b13aee853c08e1', '许褚', '', null, null, null, '', null, '1ewqrwrwr@123.com', null, null, null, null, null, null, null, null, '', '0');
