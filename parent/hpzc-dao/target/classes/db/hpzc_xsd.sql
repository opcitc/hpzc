/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : phone

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2016-10-08 15:05:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hpzc_xsd`
-- ----------------------------
DROP TABLE IF EXISTS `hpzc_xsd`;
CREATE TABLE `hpzc_xsd` (
  `x_id` varchar(32) NOT NULL COMMENT 'Id',
  `x_khbh` varchar(16) DEFAULT NULL COMMENT '客户编号',
  `x_xsrq` varchar(16) DEFAULT NULL COMMENT '销售日期',
  `x_ywygh` varchar(16) DEFAULT NULL COMMENT '业务员工号',
  `x_ywyxm` varchar(16) DEFAULT NULL COMMENT '业务员姓名',
  `x_zdrgh` varchar(16) DEFAULT NULL COMMENT '制单人工号',
  `x_zdrxm` varchar(16) DEFAULT NULL COMMENT '制单人姓名',
  `x_bgygh` varchar(16) DEFAULT NULL COMMENT '保管员工号',
  `x_bgyxm` varchar(16) DEFAULT NULL COMMENT '保管员姓名',
  `x_xsdh` varchar(16) DEFAULT NULL COMMENT '销售单号',
  `x_ddh` varchar(16) DEFAULT NULL COMMENT '订单号',
  `x_xsje` varchar(16) DEFAULT NULL COMMENT '销售金额',
  `remark1` varchar(200) DEFAULT NULL COMMENT '备用1',
  `remark2` varchar(200) DEFAULT NULL COMMENT '备用2',
  `remark3` varchar(200) DEFAULT NULL COMMENT '备用3',
  `remark4` varchar(200) DEFAULT NULL COMMENT '备用4',
  `remark5` varchar(200) DEFAULT NULL COMMENT '备用5',
  `x_create` date DEFAULT NULL COMMENT '创建日期',
  `x_modefier` date DEFAULT NULL COMMENT '修改日期',
  `is_delete` char(1) DEFAULT '0' COMMENT '是否删除标识！0：false 1:true',
  `h_zdrq` varchar(10) DEFAULT NULL COMMENT '制单日期',
  `h_seqno` varchar(10) DEFAULT NULL COMMENT '序列号',
  `status` varchar(1) DEFAULT '0' COMMENT '单据状态！',
  `h_type` varchar(1) DEFAULT '0' COMMENT '单据类型',
  PRIMARY KEY (`x_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售单';

-- ----------------------------
-- Records of hpzc_xsd
-- ----------------------------
INSERT INTO `hpzc_xsd` VALUES ('1', '001001', '2016-09-29', '业务员1', '业务员1', '', '业务员', '', '', '201608001', '201608002', '1000', '', '2016-08-10', '', '', '', '2016-08-10', '2016-08-22', '0', '2016-08-10', '201609', '0', '0');
INSERT INTO `hpzc_xsd` VALUES ('10', '001010', '2016-08-20', '业务员2', '业务员1', '', '业务员', '', '', '201608010', '201608011', '1009', '', '2016-08-21', '', '', '', '2016-08-21', '2016-09-14', '0', '2016-08-21', '201609', '0', '0');
INSERT INTO `hpzc_xsd` VALUES ('11', '001011', '2016-08-20', '业务员3', '业务员2', '', '业务员', '', '', '201608011', '201608012', '1010', '', '2016-08-15', '', '', '', '2016-08-15', '2016-09-14', '0', '2016-08-15', '201609', '0', '0');
INSERT INTO `hpzc_xsd` VALUES ('12', '001012', '2016-08-20', '业务员4', '业务员2', '', '业务员', '', '', '201608012', '201608013', '1011', '', '2016-09-22', '', '', '', '2016-09-22', '2016-09-14', '0', '2016-09-22', '201609', '0', '0');
INSERT INTO `hpzc_xsd` VALUES ('13', '001013', '2016-09-20', '业务员5', '业务员3', '', '业务员', '', '', '201608013', '201608014', '1012', '', '2016-07-22', '', '', '', '2016-07-22', '2016-09-14', '0', '2016-07-22', '201609', '0', '0');
INSERT INTO `hpzc_xsd` VALUES ('14', '001014', '2016-09-27', '业务员6', '业务员3', '', '业务员', '', '', '201608014', '201608015', '1013', '', '2016-06-22', '', '', '', '2016-06-22', '2016-09-14', '0', '2016-06-22', '201609', '0', '0');
INSERT INTO `hpzc_xsd` VALUES ('15', '001015', '2016-08-20', '业务员7', '业务员5', '', '业务员', '', '', '201608015', '201608016', '1014', '', '2016-05-12', '', '', '', '2016-05-12', '2016-09-14', '0', '2016-05-12', '201609', '0', '0');
INSERT INTO `hpzc_xsd` VALUES ('2', '001002', '2016-08-20', '业务员8', '业务员5', '', '业务员', '', '', '201608002', '201608003', '1001', '', '2016-06-12', '', '', '', '2016-06-12', '2016-08-22', '0', '2016-06-12', '201609', '0', '0');
INSERT INTO `hpzc_xsd` VALUES ('3', '001003', '2016-09-14', '业务员9', '业务员6', '', '业务员', '', '', '201608003', '201608004', '1002', '', '2016-08-18', '', '', '', '2016-08-18', '2016-08-22', '0', '2016-08-18', '201609', '0', '0');
INSERT INTO `hpzc_xsd` VALUES ('4', '001004', '2016-09-08', '业务员1', '业务员7', '', '业务员', '', '', '201608004', '201608005', '1003', '', '2016-08-26', '', '', '', '2016-08-26', '2016-08-22', '0', '2016-08-26', '201609', '0', '0');
INSERT INTO `hpzc_xsd` VALUES ('5', '001005', '2016-08-20', '业务员2', '业务员6', '', '业务员', '', '', '201608005', '201608006', '1004', '', '2016-09-02', '', '', '', '2016-09-02', '2016-08-22', '0', '2016-09-02', '201609', '0', '0');
INSERT INTO `hpzc_xsd` VALUES ('6', '001006', '2016-08-20', '业务员3', '业务员7', '', '业务员', '', '', '201608006', '201608007', '1005', '', '2016-09-12', '', '', '', '2016-09-12', '2016-08-22', '0', '2016-09-12', '201609', '0', '0');
INSERT INTO `hpzc_xsd` VALUES ('7', '001007', '2016-08-20', '业务员4', '业务员8', '', '业务员', '', '', '201608007', '201608008', '1006', '', '2016-09-10', '', '', '', '2016-09-10', '2016-08-22', '0', '2016-09-10', '201609', '0', '0');
INSERT INTO `hpzc_xsd` VALUES ('8', '001008', '2016-08-20', '业务员5', '业务员8', '', '业务员', '', '', '201608008', '201608009', '1007', '', '2016-09-10', '', '', '', '2016-09-10', '2016-09-14', '0', '2016-09-10', '201609', '0', '0');
INSERT INTO `hpzc_xsd` VALUES ('9', '001009', '2016-08-20', '业务员6', '业务员9', '', '业务员', '', '', '201608009', '201608010', '1008', '', '2016-08-22', '', '', '', '2016-08-22', '2016-08-22', '0', '2016-08-22', '201609', '0', '0');
INSERT INTO `hpzc_xsd` VALUES ('EE61E15440494C45B500B9866632B4A4', null, '2016-08-20', null, '126', null, '125', null, null, 'XS-20160900001', null, null, '201609', '2016-09-14', null, null, null, '2016-09-14', '2016-09-14', '0', '2016-09-14', '201609', '0', '0');
