/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : phone

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2016-10-08 15:05:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hpzc_xsd_detail`
-- ----------------------------
DROP TABLE IF EXISTS `hpzc_xsd_detail`;
CREATE TABLE `hpzc_xsd_detail` (
  `x_xsspbh` varchar(16) DEFAULT '' COMMENT '销售商品ID',
  `x_id` varchar(32) NOT NULL COMMENT '唯一id',
  `x_xsspmc` varchar(16) DEFAULT NULL COMMENT '销售商品名称',
  `x_xsdh` varchar(16) DEFAULT NULL COMMENT '销售单号',
  `x_xssl` int(11) DEFAULT NULL COMMENT '销售数量',
  `x_xsj` double DEFAULT NULL COMMENT '销售价',
  `x_ywygh` varchar(16) DEFAULT NULL COMMENT '业务员工号',
  `x_ywyxm` varchar(16) DEFAULT NULL COMMENT '业务员姓名',
  `x_xszje` double DEFAULT NULL COMMENT '销售总金额',
  `x_xsrq` date DEFAULT NULL COMMENT '销售日期',
  `x_xgrq` date DEFAULT NULL COMMENT '修改日期',
  `x_cjrq` date DEFAULT NULL COMMENT '创建日期',
  `remark1` varchar(100) DEFAULT NULL COMMENT '备用1',
  `remark2` varchar(100) DEFAULT NULL COMMENT '备用2',
  `remark3` varchar(100) DEFAULT NULL COMMENT '备用3',
  `remark4` varchar(100) DEFAULT NULL COMMENT '备用4',
  `remark5` varchar(100) DEFAULT NULL COMMENT '备用5',
  `is_delete` char(1) DEFAULT '0' COMMENT '是否删除标识！0：false 1:true',
  PRIMARY KEY (`x_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售明细表';

-- ----------------------------
-- Records of hpzc_xsd_detail
-- ----------------------------
INSERT INTO `hpzc_xsd_detail` VALUES ('1', '1', '1', '201608001', '1', '2', null, '1', null, '2016-10-05', '2016-10-08', null, '1', null, null, null, null, '0');
INSERT INTO `hpzc_xsd_detail` VALUES ('2', '2', '', '201608001', '1', '1', null, '', null, '2016-10-08', '2016-10-08', null, '', null, null, null, null, '0');
INSERT INTO `hpzc_xsd_detail` VALUES ('3', '3', '', '201608001', '1', '2', null, '', null, '2016-10-08', '2016-10-08', null, '', null, null, null, null, '0');
INSERT INTO `hpzc_xsd_detail` VALUES ('4', '4', '', '201608002', '0', '0', null, '2', null, '2016-10-08', '2016-10-08', null, '', null, null, null, null, '0');
INSERT INTO `hpzc_xsd_detail` VALUES ('5', '5', '', '201608002', '0', '0', null, '11', null, '2016-10-10', '2016-10-08', null, '', null, null, null, null, '0');
