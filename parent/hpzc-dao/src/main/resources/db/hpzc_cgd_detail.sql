/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : phone

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2016-10-08 15:04:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hpzc_cgd_detail`
-- ----------------------------
DROP TABLE IF EXISTS `hpzc_cgd_detail`;
CREATE TABLE `hpzc_cgd_detail` (
  `g_id` varchar(32) NOT NULL COMMENT '进货单ID',
  `g_code` varchar(32) DEFAULT NULL COMMENT '进货单编号',
  `g_cgsm` text COMMENT '采购说明',
  `g_cgsm1` text COMMENT '采购说明1',
  `g_spbh` varchar(16) DEFAULT NULL COMMENT '商品编号',
  `g_spmc` varchar(16) DEFAULT NULL COMMENT '商品名称',
  `g_gysbh` varchar(16) DEFAULT NULL COMMENT '供应商编号',
  `g_gysmc` varchar(16) DEFAULT NULL COMMENT '供应商名称',
  `g_spdj` double DEFAULT NULL COMMENT '商品单价',
  `g_ckbh` varchar(16) DEFAULT NULL COMMENT '仓库编号',
  `g_ckmc` varchar(16) DEFAULT NULL COMMENT '仓库名称',
  `g_create` varchar(32) DEFAULT '' COMMENT '创建日期',
  `remark1` varchar(100) DEFAULT NULL COMMENT '备用1',
  `remark2` varchar(100) DEFAULT NULL COMMENT '备用2',
  `remark3` varchar(100) DEFAULT NULL COMMENT '备用3',
  `remark4` varchar(100) DEFAULT NULL COMMENT '备用4',
  `remark5` varchar(100) DEFAULT NULL COMMENT '备用5',
  `is_delete` char(1) DEFAULT '0' COMMENT '是否删除标识！0：false 1:true',
  `g_xh` varchar(32) DEFAULT NULL COMMENT '单据序列号',
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='进货明细表';

-- ----------------------------
-- Records of hpzc_cgd_detail
-- ----------------------------
INSERT INTO `hpzc_cgd_detail` VALUES ('0', 'GH-20160820001', 'test', null, '001', '泰和', '001', '泰和', '12', '12', '12', '2016-09-30', null, null, null, null, null, '0', null);
INSERT INTO `hpzc_cgd_detail` VALUES ('1', 'GH-20160820001', 'twst', null, '001', '泰和', '001', '泰和', '200', '12', '', '2016-09-30', null, null, null, null, null, '0', null);
INSERT INTO `hpzc_cgd_detail` VALUES ('186F5FE058FB4EE1A8E61EA57438CD37', null, '', null, '213', '321', '1', '2', '321', '', '', '2016-09-30', null, null, null, null, null, '0', null);
INSERT INTO `hpzc_cgd_detail` VALUES ('2', '20160820002', 'x', 'zx', 'zx', 'zx', 'zx', 'zx', null, null, null, '2016-09-30', null, null, null, null, null, '0', null);
INSERT INTO `hpzc_cgd_detail` VALUES ('3', '20160820002', 's', null, 'as', 'sd', 'sd', 's', null, 'sd', null, '2016-09-30', null, null, null, null, null, '0', null);
INSERT INTO `hpzc_cgd_detail` VALUES ('4B3EC98F50274006B96CA4CAB4A09D09', 'GH-20160820001', '', null, '001', '泰和', '001', '泰和', '200', '', '', '2016-10-10', null, null, null, null, null, '0', null);
INSERT INTO `hpzc_cgd_detail` VALUES ('AB284A668BA642759E8B8B57857A61DC', 'GH-20160820001', '3', null, '001', '泰和', '323', '2123', '2', '23', '23', '2016-09-30', null, null, null, null, null, '0', null);
