/*
 Navicat Premium Data Transfer

 Source Server         : mysql_db
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : bank

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 10/03/2019 21:03:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `accountid` int(4) NOT NULL AUTO_INCREMENT COMMENT '编号、主键、非空、自增',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `balance` decimal(18, 2) NULL DEFAULT NULL COMMENT '余额',
  `status` int(4) NULL DEFAULT NULL COMMENT '账户状态id',
  PRIMARY KEY (`accountid`) USING BTREE,
  INDEX `status`(`status`) USING BTREE,
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`status`) REFERENCES `status` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'zs', '123', 200.00, 1);
INSERT INTO `account` VALUES (2, 'lisi', '111', 100.00, 1);
INSERT INTO `account` VALUES (4, 'zf', '123', 100.00, 1);
INSERT INTO `account` VALUES (5, 'lb', '123', 100.00, 1);

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '编号，主键，非空，自增',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for personinfo
-- ----------------------------
DROP TABLE IF EXISTS `personinfo`;
CREATE TABLE `personinfo`  (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '编号，主键，非空，自增',
  `accountid` int(4) NULL DEFAULT NULL COMMENT '账户id',
  `realname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `age` int(4) NULL DEFAULT NULL COMMENT '年龄(18~99)',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `cardid` decimal(18, 0) NULL DEFAULT NULL COMMENT '身份证(18位)',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `accountid`(`accountid`) USING BTREE,
  CONSTRAINT `personinfo_ibfk_1` FOREIGN KEY (`accountid`) REFERENCES `account` (`accountid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of personinfo
-- ----------------------------
INSERT INTO `personinfo` VALUES (1, 1, '张三', 25, '男', 362428196606061112, '吉林省长春市南关区', '0794-56224212');
INSERT INTO `personinfo` VALUES (2, 2, '李四', 28, '女', NULL, NULL, NULL);
INSERT INTO `personinfo` VALUES (3, 4, '张飞', 26, '男', 123456789123450, '四川省', '0796-57462155');
INSERT INTO `personinfo` VALUES (4, 5, '刘备', 35, '男', 789456123012345, '四川省成都市', '0576-123456789');

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status`  (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '编号，主键，非空，自增',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户状态名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES (1, '正常');
INSERT INTO `status` VALUES (2, '冻结');

-- ----------------------------
-- Table structure for transaction_log
-- ----------------------------
DROP TABLE IF EXISTS `transaction_log`;
CREATE TABLE `transaction_log`  (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '编号，主键，非空，自增',
  `accountid` int(4) NULL DEFAULT NULL COMMENT '己方账户id',
  `otherid` int(4) NULL DEFAULT NULL COMMENT '对方账户id',
  `tr_money` decimal(18, 2) NULL DEFAULT NULL COMMENT '交易金额',
  `datetime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易时间',
  `ta_type` int(4) NULL DEFAULT NULL COMMENT '交易类型id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `accountid`(`accountid`) USING BTREE,
  INDEX `ta_type`(`ta_type`) USING BTREE,
  CONSTRAINT `transaction_log_ibfk_1` FOREIGN KEY (`accountid`) REFERENCES `account` (`accountid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `transaction_log_ibfk_2` FOREIGN KEY (`ta_type`) REFERENCES `transaction_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of transaction_log
-- ----------------------------
INSERT INTO `transaction_log` VALUES (1, 1, 1, 1000.00, '2019-03-08', 1);
INSERT INTO `transaction_log` VALUES (2, 1, 1, 200.00, '2019-03-10 12:12:12', 1);
INSERT INTO `transaction_log` VALUES (3, 1, 1, 1000.00, '2019-03-10 14:21:25', 2);
INSERT INTO `transaction_log` VALUES (4, 1, 1, 100.00, '2019-03-10 12:15:16', 2);
INSERT INTO `transaction_log` VALUES (5, 1, 1, 100.00, '2019-03-11 11:25:23', 1);
INSERT INTO `transaction_log` VALUES (6, 1, 2, 100.00, '2019-03-20 15:30:12', 3);

-- ----------------------------
-- Table structure for transaction_type
-- ----------------------------
DROP TABLE IF EXISTS `transaction_type`;
CREATE TABLE `transaction_type`  (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '编号，主键，非空，自增',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of transaction_type
-- ----------------------------
INSERT INTO `transaction_type` VALUES (1, '存款');
INSERT INTO `transaction_type` VALUES (2, '取款');
INSERT INTO `transaction_type` VALUES (3, '转账');

SET FOREIGN_KEY_CHECKS = 1;
