/*
 Navicat Premium Data Transfer

 Source Server         : www.onecbuying.com
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 08/09/2021 06:46:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_ca
-- ----------------------------
DROP TABLE IF EXISTS `t_ca`;
CREATE TABLE `t_ca` (
  `id` int NOT NULL,
  `cname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `csex` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_ca
-- ----------------------------
BEGIN;
INSERT INTO `t_ca` VALUES (1, '韩梅梅', '女');
INSERT INTO `t_ca` VALUES (2, '李雷', '男');
INSERT INTO `t_ca` VALUES (3, '李明', '男');
COMMIT;

-- ----------------------------
-- Table structure for t_ua
-- ----------------------------
DROP TABLE IF EXISTS `t_ua`;
CREATE TABLE `t_ua` (
  `t_id` int NOT NULL,
  `t_Name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tGender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_ua
-- ----------------------------
BEGIN;
INSERT INTO `t_ua` VALUES (1, 'john', 'male');
INSERT INTO `t_ua` VALUES (2, 'lucy', 'female');
INSERT INTO `t_ua` VALUES (3, 'lily', 'female');
INSERT INTO `t_ua` VALUES (4, 'jack', 'male');
INSERT INTO `t_ua` VALUES (5, 'rose', 'female');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
