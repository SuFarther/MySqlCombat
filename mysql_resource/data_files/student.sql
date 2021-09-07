/*
 Navicat Premium Data Transfer

 Source Server         : www.onecbuying.com
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : student

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 08/09/2021 06:46:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `majorid` int NOT NULL AUTO_INCREMENT,
  `majorname` varchar(20) NOT NULL,
  PRIMARY KEY (`majorid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of major
-- ----------------------------
BEGIN;
INSERT INTO `major` VALUES (1, 'javaee');
INSERT INTO `major` VALUES (2, 'html5');
INSERT INTO `major` VALUES (3, 'android');
COMMIT;

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id` int NOT NULL AUTO_INCREMENT,
  `studentno` varchar(10) NOT NULL,
  `score` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of result
-- ----------------------------
BEGIN;
INSERT INTO `result` VALUES (1, 's001', 100);
INSERT INTO `result` VALUES (2, 's002', 90);
INSERT INTO `result` VALUES (3, 's003', 80);
INSERT INTO `result` VALUES (4, 's004', 70);
INSERT INTO `result` VALUES (5, 's005', 60);
INSERT INTO `result` VALUES (6, 's006', 50);
INSERT INTO `result` VALUES (7, 's006', 40);
INSERT INTO `result` VALUES (8, 's005', 95);
INSERT INTO `result` VALUES (9, 's006', 88);
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentno` varchar(10) NOT NULL,
  `studentname` varchar(20) NOT NULL,
  `loginpwd` varchar(8) NOT NULL,
  `sex` char(1) DEFAULT NULL,
  `majorid` int NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `borndate` datetime DEFAULT NULL,
  PRIMARY KEY (`studentno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('S001', '张三封', '8888', '男', 1, '13288886666', 'zhangsanfeng@126.com', '1966-09-01 00:00:00');
INSERT INTO `student` VALUES ('S002', '殷天正', '8888', '男', 1, '13888881234', 'yintianzheng@qq.com', '1976-09-02 00:00:00');
INSERT INTO `student` VALUES ('S003', '周伯通', '8888', '男', 2, '13288886666', 'zhoubotong@126.com', '1986-09-03 00:00:00');
INSERT INTO `student` VALUES ('S004', '张翠山', '8888', '男', 1, '13288886666', NULL, '1995-09-04 00:00:00');
INSERT INTO `student` VALUES ('S005', '小小张', '8888', '女', 3, '13288885678', 'xiaozhang@126.com', '1990-09-05 00:00:00');
INSERT INTO `student` VALUES ('S006', '张无忌', '8888', '男', 2, '13288886666', 'zhangwuji@126.com', '1998-08-09 00:00:00');
INSERT INTO `student` VALUES ('S007', '赵敏', '0000', '女', 1, '13288880987', 'zhaomin@126.com', '1998-06-09 00:00:00');
INSERT INTO `student` VALUES ('S008', '周芷若', '6666', '女', 1, '13288883456', 'zhouzhiruo@126.com', '1996-07-09 00:00:00');
INSERT INTO `student` VALUES ('S009', '殷素素', '8888', '女', 1, '13288886666', 'yinsusu@163.com', '1986-01-09 00:00:00');
INSERT INTO `student` VALUES ('S010', '宋远桥', '6666', '男', 3, '1328888890', 'songyuanqiao@qq.com', '1996-02-09 00:00:00');
INSERT INTO `student` VALUES ('S011', '杨不悔', '6666', '女', 2, '13288882345', NULL, '1995-09-09 00:00:00');
INSERT INTO `student` VALUES ('S012', '杨逍', '9999', '男', 1, '13288885432', NULL, '1976-09-09 00:00:00');
INSERT INTO `student` VALUES ('S013', '纪晓芙', '9999', '女', 3, '13288888765', NULL, '1976-09-09 00:00:00');
INSERT INTO `student` VALUES ('S014', '谢逊', '9999', '男', 1, '13288882211', NULL, '1946-09-09 00:00:00');
INSERT INTO `student` VALUES ('S015', '宋青书', '9999', '男', 3, '13288889900', NULL, '1976-06-08 00:00:00');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
