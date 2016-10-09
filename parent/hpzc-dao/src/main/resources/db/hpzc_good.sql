/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : phone

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2016-10-08 15:05:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hpzc_good`
-- ----------------------------
DROP TABLE IF EXISTS `hpzc_good`;
CREATE TABLE `hpzc_good` (
  `g_id` varchar(32) NOT NULL COMMENT '唯一ID',
  `g_code` varchar(16) DEFAULT NULL COMMENT '商品编号',
  `g_name` varchar(16) DEFAULT NULL COMMENT '商品名称',
  `g_memo` varchar(200) DEFAULT NULL COMMENT '商品描述',
  `g_tm` varchar(100) DEFAULT NULL COMMENT '条码',
  `g_cs` varchar(100) DEFAULT NULL COMMENT '参数',
  `g_cgj` double DEFAULT NULL COMMENT '进货价',
  `g_xsj` double DEFAULT NULL COMMENT '销售价',
  `g_sjsj` double DEFAULT NULL COMMENT '实际售价',
  `g_spsl` int(11) DEFAULT NULL COMMENT '商品数量',
  `g_spjhzj` double DEFAULT NULL COMMENT '商品进货总价',
  `g_spxszj` double DEFAULT NULL COMMENT '商品销售总价',
  `g_spsjzje` double DEFAULT NULL COMMENT '商品实际总金额',
  `g_splr` double DEFAULT NULL COMMENT '商品利润',
  `g_creator` varchar(16) DEFAULT NULL COMMENT '创建人',
  `g_creator_name` varchar(100) DEFAULT NULL COMMENT '创建日期',
  `g_modifier` varchar(16) DEFAULT NULL COMMENT '修改人',
  `g_modifier_name` varchar(100) DEFAULT NULL COMMENT '修改日期',
  `memo` varchar(100) DEFAULT NULL COMMENT '备注',
  `remark1` varchar(100) DEFAULT NULL COMMENT '备用1',
  `remark2` varchar(100) DEFAULT NULL COMMENT '备用2',
  `remark3` varchar(100) DEFAULT NULL COMMENT '备用3',
  `remark4` varchar(100) DEFAULT NULL COMMENT '备用4',
  `remark5` varchar(100) DEFAULT NULL COMMENT '备用5',
  `is_delete` char(1) DEFAULT '0' COMMENT '是否删除标识！0：false 1:true',
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品清单';

-- ----------------------------
-- Records of hpzc_good
-- ----------------------------
INSERT INTO `hpzc_good` VALUES ('1', 'SP-001001', '充电器', '小型', '110', '', '10', '20', '18', null, '0', '0', '0', '0', '201608001', '业务员', '', '', '', '', '', '', '', '', '0');
INSERT INTO `hpzc_good` VALUES ('10', 'SP-001002', '手机壳', '小型', '111', '', '10', '20', '18', null, '0', '0', '0', '0', '201608001', '业务员', '', '', '', '', '', '', '', '', '0');
INSERT INTO `hpzc_good` VALUES ('11', 'SP-001003', '手机链', '小型', '112', '', '10', '20', '18', null, '0', '0', '0', '0', '201608001', '业务员', '', '', '', '', '', '', '', '', '0');
INSERT INTO `hpzc_good` VALUES ('12', 'SP-001003', '手机链', '小型', '112', '', '10', '20', '18', null, '0', '0', '0', '0', '201608001', '业务员', '', '', '', '', '', '', '', '', '0');
INSERT INTO `hpzc_good` VALUES ('13', 'SP-001003', '手机链', '小型', '112', '', '10', '20', '18', null, '0', '0', '0', '0', '201608001', '业务员', '', '', '', '', '', '', '', '', '0');
INSERT INTO `hpzc_good` VALUES ('14', 'SP-001003', '手机链', '小型', '112', '', '10', '20', '18', null, '0', '0', '0', '0', '201608001', '业务员', '', '', '', '', '', '', '', '', '0');
INSERT INTO `hpzc_good` VALUES ('15', 'SP-001003', '手机链', '小型', '112', '', '10', '20', '18', null, '0', '0', '0', '0', '201608001', '业务员', '', '', '', '', '', '', '', '', '0');
INSERT INTO `hpzc_good` VALUES ('2', 'SP-001001', '充电器', '小型', '110', '', '10', '20', '18', null, '0', '0', '0', '0', '201608001', '业务员', '', '', '', '', '', '', '', '', '0');
INSERT INTO `hpzc_good` VALUES ('3', 'SP-001001', '充电器', '小型', '110', '', '10', '20', '18', null, '0', '0', '0', '0', '201608001', '业务员', '', '', '', '', '', '', '', '', '0');
INSERT INTO `hpzc_good` VALUES ('4', 'SP-001001', '充电器', '小型', '110', '', '10', '20', '18', null, '0', '0', '0', '0', '201608001', '业务员', '', '', '', '', '', '', '', '', '0');
INSERT INTO `hpzc_good` VALUES ('5', 'SP-001001', '充电器', '小型', '110', '', '10', '20', '18', null, '0', '0', '0', '0', '201608001', '业务员', '', '', '', '', '', '', '', '', '0');
INSERT INTO `hpzc_good` VALUES ('6', 'SP-001002', '手机壳', '小型', '111', '', '10', '20', '18', null, '0', '0', '0', '0', '201608001', '业务员', '', '', '', '', '', '', '', '', '0');
INSERT INTO `hpzc_good` VALUES ('7', 'SP-001002', '手机壳', '小型', '111', '', '10', '20', '18', null, '0', '0', '0', '0', '201608001', '业务员', '', '', '', '', '', '', '', '', '0');
INSERT INTO `hpzc_good` VALUES ('8', 'SP-001002', '手机壳', '小型', '111', '', '10', '20', '18', null, '0', '0', '0', '0', '201608001', '业务员', '', '', '', '', '', '', '', '', '0');
INSERT INTO `hpzc_good` VALUES ('9', 'SP-001002', '手机壳', '小型', '111', '', '10', '20', '18', null, '0', '0', '0', '0', '201608001', '业务员', '', '', '', '', '', '', '', '', '0');
