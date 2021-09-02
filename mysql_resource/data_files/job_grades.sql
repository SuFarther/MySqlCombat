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

 Date: 02/09/2021 21:41:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for job_grades
-- ----------------------------
DROP TABLE IF EXISTS `job_grades`;
CREATE TABLE `job_grades` (
  `grade_level` varchar(3) DEFAULT NULL,
  `lowest_sal` int DEFAULT NULL,
  `highest_sal` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of job_grades
-- ----------------------------
BEGIN;
INSERT INTO `job_grades` VALUES ('A', 1000, 2999);
INSERT INTO `job_grades` VALUES ('B', 3000, 5999);
INSERT INTO `job_grades` VALUES ('C', 6000, 9999);
INSERT INTO `job_grades` VALUES ('D', 10000, 14999);
INSERT INTO `job_grades` VALUES ('E', 15000, 24999);
INSERT INTO `job_grades` VALUES ('F', 25000, 40000);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
