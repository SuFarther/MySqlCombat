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

 Date: 21/09/2021 08:55:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for act
-- ----------------------------
DROP TABLE IF EXISTS `act`;
CREATE TABLE `act` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `money` decimal(7,2) DEFAULT NULL COMMENT '钱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of act
-- ----------------------------
BEGIN;
INSERT INTO `act` VALUES (1, 1000.00);
INSERT INTO `act` VALUES (2, 1000.00);
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `age` int DEFAULT NULL COMMENT '年龄',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES (1, '张三', 18, '110@qq.com');
INSERT INTO `student` VALUES (2, '里斯', 20, '120@qq.com');
INSERT INTO `student` VALUES (3, '王五', 30, '199@qq.com');
INSERT INTO `student` VALUES (4, '李鬼', 30, '117@qq.com');
INSERT INTO `student` VALUES (5, '猫咪', 31, '112@qq.com');
INSERT INTO `student` VALUES (7, '赵日天', 31, '112@qq.com');
INSERT INTO `student` VALUES (8, '雪花女神龙', 31, '112@qq.com');
INSERT INTO `student` VALUES (9, '鬼见愁', 49, '123@qq.com');
INSERT INTO `student` VALUES (10, '雪花女神龙2', 31, '112@qq.com');
INSERT INTO `student` VALUES (11, '雪花女神龙3', 32, '112@qq.com');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) DEFAULT NULL COMMENT '账号',
  `password` varchar(16) DEFAULT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'zhangsan', '123456', '110@qq.com');
INSERT INTO `user` VALUES (2, 'lisi', '123', '119@qq.com');
INSERT INTO `user` VALUES (3, 'wangwu', '789', '112@qq.com');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
