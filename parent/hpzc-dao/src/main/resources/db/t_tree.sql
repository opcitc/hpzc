/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : phone

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2016-10-08 15:06:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_tree`
-- ----------------------------
DROP TABLE IF EXISTS `t_tree`;
CREATE TABLE `t_tree` (
  `id` varchar(32) NOT NULL COMMENT '唯一ID',
  `text` varchar(100) DEFAULT NULL COMMENT '目录名称',
  `state` varchar(10) DEFAULT NULL COMMENT '打开和关闭状态',
  `iconCls` varchar(32) DEFAULT NULL COMMENT '引用图表',
  `url` varchar(300) DEFAULT NULL COMMENT 'url跳转地址',
  `nid` varchar(32) DEFAULT NULL COMMENT '所属层的ID值',
  `is_delete` varchar(1) DEFAULT '0' COMMENT '是否作废!',
  `status` varchar(1) DEFAULT '0' COMMENT '数据状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tree
-- ----------------------------
INSERT INTO `t_tree` VALUES ('1', '首页', 'closed', null, '', '0', '0', '0');
INSERT INTO `t_tree` VALUES ('2', '采购单管理', 'open', null, 'hpzcCgd', '1', '0', '0');
INSERT INTO `t_tree` VALUES ('3', '销售单管理', 'open', null, 'hpzcXsd', '1', '0', '0');
INSERT INTO `t_tree` VALUES ('4', '用户管理', 'open', null, 'hpzcUser', '1', '0', '0');
