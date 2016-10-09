/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : phone

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2016-10-08 15:05:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hpzc_customer`
-- ----------------------------
DROP TABLE IF EXISTS `hpzc_customer`;
CREATE TABLE `hpzc_customer` (
  `c_id` varchar(32) NOT NULL COMMENT '客户表ID',
  `c_code` varchar(16) DEFAULT NULL COMMENT '客户编码',
  `c_name` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `c_address` varchar(200) DEFAULT NULL COMMENT '客户地址',
  `c_link` varchar(16) DEFAULT NULL,
  `c_tel` varchar(16) DEFAULT NULL COMMENT '客户电话',
  `c_mail` varchar(100) DEFAULT NULL COMMENT '客户邮箱',
  `c_qq` varchar(16) DEFAULT NULL COMMENT '客户QQ',
  `c_weixin` varchar(50) DEFAULT NULL COMMENT '客户微信',
  `c_memo` varchar(100) DEFAULT NULL COMMENT '客户描述',
  `c_bank1` varchar(100) DEFAULT NULL COMMENT '开户行1',
  `c_account1` varchar(100) DEFAULT NULL COMMENT '银行账号1',
  `c_bank2` varchar(100) DEFAULT NULL COMMENT '开户行2',
  `c_account2` varchar(100) DEFAULT NULL COMMENT '银行账号2',
  `c_create` date DEFAULT NULL COMMENT '创建日期',
  `remark1` varchar(100) DEFAULT NULL COMMENT '备用1',
  `remark2` varchar(100) DEFAULT NULL COMMENT '备用2',
  `remark3` varchar(100) DEFAULT NULL COMMENT '备用3',
  `remark4` varchar(100) DEFAULT NULL COMMENT '备用4',
  `remark6` varchar(100) DEFAULT NULL COMMENT '备用5',
  `is_delete` char(1) DEFAULT '0' COMMENT '是否删除标识！0：false 1:true',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of hpzc_customer
-- ----------------------------
