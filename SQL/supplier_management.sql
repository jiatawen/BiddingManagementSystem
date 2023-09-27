/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : localhost:3306
 Source Schema         : supplier_management

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 27/09/2023 08:54:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `Id` int NOT NULL AUTO_INCREMENT COMMENT '主键\r\n',
  `Name` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `Address` varchar(1023) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位地址\r\n',
  `Tel` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `Type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '供方类型',
  `Money` decimal(10, 2) NULL DEFAULT NULL COMMENT '注册资金',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `p_k_type`(`Type` ASC) USING BTREE,
  CONSTRAINT `p_k_type` FOREIGN KEY (`Type`) REFERENCES `suppliertype` (`Text`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 89 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (25, '速驰汽车', '北京市朝阳区建国路123号 ', '13812345678 ', '二级供应商', 2345678.00);
INSERT INTO `supplier` VALUES (26, '骏途汽车', '上海市浦东新区张杨路456弄 ', '13987654321 ', '二级供应商', 5432109.00);
INSERT INTO `supplier` VALUES (27, '瑞宝汽车', '广东省深圳市福田区华强北789号 ', '13654321987 ', '二级供应商', 24567890.00);
INSERT INTO `supplier` VALUES (28, '威尼克斯汽车', '湖北省武汉市江汉区江汉路321号 ', '13567891234 ', '三级供应商', 18765432.00);
INSERT INTO `supplier` VALUES (29, '德赛特汽车', '四川省成都市锦江区天府广场654号 ', '13798765432 ', '二级供应商', 29876543.00);
INSERT INTO `supplier` VALUES (30, '云峰汽车', '浙江省杭州市西湖区西湖景区987号 ', '15012345678 ', '三级供应商', 10987654.00);
INSERT INTO `supplier` VALUES (31, '华瀚汽车', '山东省青岛市市南区香港中路741号 ', '15123456789 ', '二级供应商', 27654321.00);
INSERT INTO `supplier` VALUES (32, '金驹汽车', '河南省郑州市金水区农业路852号 ', '15876543210 ', '二级供应商', 15432109.00);
INSERT INTO `supplier` VALUES (33, '宝捷汽车', ' 湖南省长沙市岳麓区麓山路369号 ', '15987654321 ', '三级供应商', 21098765.00);
INSERT INTO `supplier` VALUES (34, '卓越汽车', '江苏省南京市玄武区中山东路258号 ', '18765432109 ', '二级供应商', 7654321.00);
INSERT INTO `supplier` VALUES (35, '星际汽车', ' 辽宁省大连市中山区人民广场603号 ', '18809876543 ', '三级供应商', 16543210.00);
INSERT INTO `supplier` VALUES (87, '速驰汽车', '1131', '13143', '一级供应商', 1313.00);

-- ----------------------------
-- Table structure for suppliertype
-- ----------------------------
DROP TABLE IF EXISTS `suppliertype`;
CREATE TABLE `suppliertype`  (
  `Id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `Text` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  `Memo` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `Text`(`Text` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of suppliertype
-- ----------------------------
INSERT INTO `suppliertype` VALUES (1, '一级供应商', '一级供应商主要负责生产汽车的主要组成部分。例如：发动机、变速器、悬挂系统、底盘、车身结构等。一级供应商通常与汽车厂商长期合作关系，是整个企业链条中最重要的部分。汽车厂商通常会与一级供应商进行技术合作，共享研发成果，保证汽车零部件的质量和可靠性。在整个汽车产业链中，一级供应商通常具有技术含量最高、利润最高、供应关系最稳定的特点。');
INSERT INTO `suppliertype` VALUES (2, '二级供应商', '二级供应商是供应商体系的中间部分。它们通常生产汽车中的附属零件和电子元件。例如：车灯、音响、空调、电子控制单元等。二级供应商通常与一级供应商和汽车厂商有密切的合作关系。虽然二级供应商的利润相对较低，但是它们的市场规模相对较大，因为汽车中的各个附属零部件数量很多。二级供应商是整个汽车生产供应链的重要组成部分。');
INSERT INTO `suppliertype` VALUES (3, '三级供应商', '三级供应商提供汽车行业中生产所需的非常规制品和服务。例如：汽车胎、空气滤清器、喇叭、等。尽管这些部件不属于车辆的核心部件，但它们对汽车的性能和安全性同样起着至关重要的作用。三级供应商通常与二级和一级供应商合作，承担低利润的订单。然而，作为汽车生产供应链的组成部分，三级供应商是不可或缺的。');

SET FOREIGN_KEY_CHECKS = 1;
