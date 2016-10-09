/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : phone

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2016-10-08 15:04:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hpzc_logs`
-- ----------------------------
DROP TABLE IF EXISTS `hpzc_logs`;
CREATE TABLE `hpzc_logs` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `class` varchar(200) DEFAULT NULL COMMENT '日志发生的java类，全路径',
  `method` varchar(50) DEFAULT NULL COMMENT '方法名',
  `log_level` varchar(50) DEFAULT NULL COMMENT '日志级别',
  `msg` text COMMENT '日志详细信息',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `module` varchar(20) DEFAULT NULL COMMENT '所属模块',
  `operator_id` varchar(32) DEFAULT NULL COMMENT '操作人id',
  `operator` varchar(32) DEFAULT NULL COMMENT '操作人名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hpzc_logs
-- ----------------------------
