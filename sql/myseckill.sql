/*
 Navicat Premium Data Transfer

 Source Server         : lighthouse
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 82.157.147.8:3306
 Source Schema         : myseckill

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 22/03/2022 12:43:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` bigint(20) NOT NULL,
  `user_id` int(20) NOT NULL COMMENT '用户id',
  `reminder` float(20, 2) NOT NULL COMMENT '账户余额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(20) NOT NULL,
  `goodsname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `price` decimal(10, 2) NOT NULL COMMENT '价格',
  `isseckill` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否秒杀商品',
  `describ` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `store` int(6) NOT NULL COMMENT '商品库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, 'AMD R5/R7 3600', 2349.00, '1', '搭微星B450B550主板CPU套装 微星B450 GAMING PLUS MAX R7 5700G(盒装)套装(带核显)', 10);
INSERT INTO `goods` VALUES (2, '航嘉（Huntkey） 暗夜猎手5', 349.00, '1', '电脑机箱台式DIY全侧透游戏水冷ATX大板背线机箱240水冷散热 暗夜猎手5黑色+安钛克AP500W（额定500W）', 10);
INSERT INTO `goods` VALUES (3, '三星（SAMSUNG）970 EVO Plus', 737.00, '1', 'SSD固态硬盘 M.2接口(NVMe协议)', 10);
INSERT INTO `goods` VALUES (4, '枭鲸(SEIWHALE) 32G', 759.00, NULL, '(16GX2)DDR4 3200台式内存', 10);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `userid` int(20) NOT NULL COMMENT '用户id',
  `goodsid` int(20) NOT NULL COMMENT '商品id',
  `num` int(11) NOT NULL COMMENT '商品个数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1944 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '453882101@qq.com', '123456');

SET FOREIGN_KEY_CHECKS = 1;
