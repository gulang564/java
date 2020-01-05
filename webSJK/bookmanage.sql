/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : bookmanage

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 05/01/2020 11:51:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bkID` int(11) NOT NULL,
  `bkCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bkName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bkAuthor` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bkPress` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bkDatePress` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bkLanguage` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bkPages` int(40) DEFAULT NULL,
  `bkNum` int(5) DEFAULT NULL,
  `bkDateIn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bkBrief` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `bkCover` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bkStatus` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bkLeibie` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`bkID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (0, '111', '不良人', 'xiaotong', '长大', '2019-12-11', '中文', 234, 5, '2019-12-15', '袁天罡（不良帅），中国3D动画《画江湖之不良人》系列中的角色。原型为历史人物袁天罡。大唐国师，不良人最高首领，只有历代皇帝才知晓他的真实身份是太宗年间的道士袁天罡。他凭借丹药获得长生不老，暗中组成不良人专供大唐君王驱使。', './UserImg/5ab074cf6ef24f6384231228740d0793.jpg', '在馆', '人文');
INSERT INTO `book` VALUES (1, '222', '中国科技', '小王', '黑马程序员', '2018-12-11', '中文', 452, 6, '2019-11-11', '程序员的自我修养', './UserImg/04c5efb93ff34783badba0bd9e7294e4.jpg', '借出', '科技');
INSERT INTO `book` VALUES (11, '1111', '12', '121', '1232', '12323', '英文', 123, 232, '232', '发的广泛地个梵蒂冈儿童从VB功能就刚刚好', './UserImg/5ab074cf6ef24f6384231228740d0793.jpg', '123', '历史');
INSERT INTO `book` VALUES (12, '1111', '12', '121', '1232', '12323', '中文', 123, 232, '232', 'ytfhghghj', './UserImg/4f34afb202af480f9cd4f4fcc27f29f2.jpg', '123', '科学');
INSERT INTO `book` VALUES (82, '11', '12', '121', '12', '12', '中文', 123, 232, '232', 'kkk', './UserImg/f3b43c6e56094281a799f6ef013f5f51.jpg', '123', '历史');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `rdID` int(20) DEFAULT NULL,
  `bkID` int(20) DEFAULT NULL,
  `ldContinueTimes` int(20) DEFAULT NULL,
  `ldDateOut` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `IdDateRetPan` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  INDEX `rdId`(`rdID`) USING BTREE,
  INDEX `bkId`(`bkID`) USING BTREE,
  CONSTRAINT `bkId` FOREIGN KEY (`bkID`) REFERENCES `book` (`bkID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `rdId` FOREIGN KEY (`rdID`) REFERENCES `reader` (`rdID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES (12, 0, 0, '2018-12-12', '2020-1-12');

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader`  (
  `rdID` int(5) NOT NULL,
  `rdName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `rdSex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `rdDept` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `rdPhone` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `rdEmail` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `rdDateReg` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `rdPhoto` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `rdStatus` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `rdBorrowQty` int(11) DEFAULT NULL,
  `rdPwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `rdLeibie` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`rdID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES (12, '332', '女', '计算机科学学院', '12323', '2323', '2019-12-15 9:49:10', './utils/images/2e229b958adb416fac78194d8850467c.jpg', '激活', 3, '232', '博士');
INSERT INTO `reader` VALUES (123, 'xiaotong', '男', '计算机科学学院', '12323', '2323', '2019-12-15 10:25:43', './UserImg/d2d406e4cdf942488990c5d961830d49.jpg', '激活', 3, '232', '本科生');
INSERT INTO `reader` VALUES (888, '888', '男', '计算机科学学院', '12323', '2323', '2019-12-15 12:49:32', './UserImg/26bb3bb7b2e34438ad399f40c49a10f6.jpg', '激活', 3, '232', '教师');
INSERT INTO `reader` VALUES (999, '999', '女', '化工学院', '1232322', '2323', '2019-12-30 11:1:9', './UserImg/892a6369669c4822a0694d55435099be.jpg', '挂失', 3, '232', '博士');

-- ----------------------------
-- Table structure for readertype
-- ----------------------------
DROP TABLE IF EXISTS `readertype`;
CREATE TABLE `readertype`  (
  `rdTypeName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者类别名称【唯一、非空】',
  `CanLendQty` int(3) DEFAULT NULL COMMENT '可借书数量',
  `CanLendDay` int(2) DEFAULT NULL COMMENT '可借书天数',
  `CanContinueTimes` int(1) DEFAULT NULL COMMENT '可续借的次数',
  `PunishRate` double(1, 1) DEFAULT NULL COMMENT '罚款率（元/天）',
  `DateValid` smallint(6) NOT NULL COMMENT '证书有效期（年）【非空，0表示永久有效】'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of readertype
-- ----------------------------
INSERT INTO `readertype` VALUES ('教师', 12, 60, 2, 0.5, 0);
INSERT INTO `readertype` VALUES ('博士', 8, 30, 1, 0.3, 3);
INSERT INTO `readertype` VALUES ('本科生', 8, 30, 1, 0.2, 4);
INSERT INTO `readertype` VALUES ('研究生', 8, 30, 1, 0.4, 3);

SET FOREIGN_KEY_CHECKS = 1;
