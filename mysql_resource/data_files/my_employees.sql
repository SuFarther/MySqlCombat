/*
 Navicat Premium Data Transfer

 Source Server         : www.onecbuying.com
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : myemployees

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 11/09/2021 09:28:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for my_employees
-- ----------------------------
DROP TABLE IF EXISTS `my_employees`;
CREATE TABLE `my_employees` (
  `Id` int DEFAULT NULL,
  `First_name` varchar(10) DEFAULT NULL,
  `Last_name` varchar(10) DEFAULT NULL,
  `Userid` varchar(10) DEFAULT NULL,
  `Salary` double(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of my_employees
-- ----------------------------
BEGIN;
INSERT INTO `my_employees` VALUES (1, 'patel', 'Ralph', 'Rpatel', 1000.00);
INSERT INTO `my_employees` VALUES (2, 'Dancs', 'Betty', 'Bdancs', 1000.00);
INSERT INTO `my_employees` VALUES (4, 'Newman', 'Chad', 'Cnewman', 1000.00);
INSERT INTO `my_employees` VALUES (5, 'Ropeburn', 'Audrey', 'Aropebur', 1550.00);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
