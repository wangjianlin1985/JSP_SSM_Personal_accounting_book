/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50505
Source Host           : 127.0.0.1:3306
Source Database       : ssm_jizhang

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-01-20 17:06:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `balance`
-- ----------------------------
DROP TABLE IF EXISTS `balance`;
CREATE TABLE `balance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `month` date NOT NULL,
  `actual_balance` float(255,2) NOT NULL COMMENT '本月末结余，即下月初结余',
  PRIMARY KEY (`id`),
  KEY `reference_to_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of balance
-- ----------------------------
INSERT INTO `balance` VALUES ('22', '50', '2019-12-14', '1.00');
INSERT INTO `balance` VALUES ('23', '50', '2020-01-14', '12.00');
INSERT INTO `balance` VALUES ('24', '51', '2019-12-14', '80000.00');

-- ----------------------------
-- Table structure for `expenditure`
-- ----------------------------
DROP TABLE IF EXISTS `expenditure`;
CREATE TABLE `expenditure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `money` float(255,2) NOT NULL,
  `type_of_money` varchar(255) DEFAULT NULL,
  `date` date NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `dele` int(1) DEFAULT NULL COMMENT '-1：删除；1未删除',
  PRIMARY KEY (`id`),
  KEY `foreignkey_to_item2` (`item_id`),
  KEY `foreignkey_to_user2` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expenditure
-- ----------------------------
INSERT INTO `expenditure` VALUES ('107', '324', '50', '1.00', '327', '2020-01-14', '买了一个鸡蛋', '1');
INSERT INTO `expenditure` VALUES ('108', '333', '51', '100.00', '337', '2020-01-14', '吃饭', '1');
INSERT INTO `expenditure` VALUES ('109', '334', '51', '100.00', '338', '2020-01-14', '', '1');
INSERT INTO `expenditure` VALUES ('110', '335', '51', '10.00', '341', '2020-01-14', '', '1');

-- ----------------------------
-- Table structure for `income`
-- ----------------------------
DROP TABLE IF EXISTS `income`;
CREATE TABLE `income` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `money` float(255,2) NOT NULL,
  `type_of_money` varchar(255) DEFAULT NULL,
  `date` date NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `dele` int(1) DEFAULT NULL COMMENT '-1：删除；1未删除',
  PRIMARY KEY (`id`),
  KEY `foreignkey_to_user1` (`user_id`),
  KEY `foreignkey_to_item1` (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of income
-- ----------------------------
INSERT INTO `income` VALUES ('63', '321', '50', '12.00', '323', '2020-01-14', '', '1');
INSERT INTO `income` VALUES ('64', '330', '51', '18000.00', '333', '2020-01-14', '发工资', '1');
INSERT INTO `income` VALUES ('65', '331', '51', '200.00', '334', '2020-01-14', '转账', '1');

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '表示此项对应哪个user，如果是1表示是公有项',
  `name` char(50) DEFAULT NULL,
  `in_or_ex` varchar(3) NOT NULL COMMENT 'in表示收入，ex表示支出',
  `remark` char(200) DEFAULT NULL,
  `dele` int(1) NOT NULL COMMENT '-1：删除；1未删除',
  `sort` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foreignkey_to_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=337 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('320', '50', '', 'in', '空项目', '1', '320');
INSERT INTO `item` VALUES ('321', '50', '工资', 'in', '', '1', '321');
INSERT INTO `item` VALUES ('322', '50', '其他', 'in', '', '1', '322');
INSERT INTO `item` VALUES ('323', '50', '', 'ex', '空项目', '1', '323');
INSERT INTO `item` VALUES ('324', '50', '餐饮', 'ex', '', '1', '324');
INSERT INTO `item` VALUES ('325', '50', '服饰', 'ex', '', '1', '325');
INSERT INTO `item` VALUES ('326', '50', '医疗', 'ex', '', '1', '326');
INSERT INTO `item` VALUES ('327', '50', '其他', 'ex', '', '1', '327');
INSERT INTO `item` VALUES ('328', '50', '红包', 'in', '', '1', '328');
INSERT INTO `item` VALUES ('329', '51', '', 'in', '空项目', '1', '329');
INSERT INTO `item` VALUES ('330', '51', '工资', 'in', '', '1', '330');
INSERT INTO `item` VALUES ('331', '51', '其他', 'in', '', '1', '331');
INSERT INTO `item` VALUES ('332', '51', '', 'ex', '空项目', '1', '332');
INSERT INTO `item` VALUES ('333', '51', '餐饮', 'ex', '', '1', '333');
INSERT INTO `item` VALUES ('334', '51', '服饰', 'ex', '', '1', '334');
INSERT INTO `item` VALUES ('335', '51', '医疗', 'ex', '', '1', '335');
INSERT INTO `item` VALUES ('336', '51', '其他', 'ex', '', '1', '336');

-- ----------------------------
-- Table structure for `pay_method`
-- ----------------------------
DROP TABLE IF EXISTS `pay_method`;
CREATE TABLE `pay_method` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `is_count_in_this_month_ex` int(1) DEFAULT NULL COMMENT '是否计入本月支出，1：是；0：否；（-1为收入，收入不考虑此字段）',
  `in_or_ex` varchar(255) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `dele` int(1) NOT NULL COMMENT '-1：删除；1未删除',
  `sort` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=343 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pay_method
-- ----------------------------
INSERT INTO `pay_method` VALUES ('323', '50', '余额宝', null, 'in', '', '1', '323');
INSERT INTO `pay_method` VALUES ('324', '50', '现金', null, 'in', '', '1', '324');
INSERT INTO `pay_method` VALUES ('325', '50', '微信', null, 'in', '', '1', '325');
INSERT INTO `pay_method` VALUES ('326', '50', '银行卡', null, 'in', '', '1', '326');
INSERT INTO `pay_method` VALUES ('327', '50', '余额宝', '1', 'ex', '', '1', '327');
INSERT INTO `pay_method` VALUES ('328', '50', '现金', '1', 'ex', '', '1', '328');
INSERT INTO `pay_method` VALUES ('329', '50', '微信', '1', 'ex', '', '1', '329');
INSERT INTO `pay_method` VALUES ('330', '50', '银行卡', '1', 'ex', '', '1', '330');
INSERT INTO `pay_method` VALUES ('331', '50', '花呗', '0', 'ex', '', '1', '331');
INSERT INTO `pay_method` VALUES ('332', '50', '信用卡', '0', 'ex', '', '1', '332');
INSERT INTO `pay_method` VALUES ('333', '51', '余额宝', null, 'in', '', '1', '333');
INSERT INTO `pay_method` VALUES ('334', '51', '现金', null, 'in', '', '1', '334');
INSERT INTO `pay_method` VALUES ('335', '51', '微信', null, 'in', '', '1', '335');
INSERT INTO `pay_method` VALUES ('336', '51', '银行卡', null, 'in', '', '1', '336');
INSERT INTO `pay_method` VALUES ('337', '51', '余额宝', '1', 'ex', '', '1', '337');
INSERT INTO `pay_method` VALUES ('338', '51', '现金', '1', 'ex', '', '1', '338');
INSERT INTO `pay_method` VALUES ('339', '51', '微信', '1', 'ex', '', '1', '339');
INSERT INTO `pay_method` VALUES ('340', '51', '银行卡', '1', 'ex', '', '1', '340');
INSERT INTO `pay_method` VALUES ('341', '51', '花呗', '0', 'ex', '', '1', '341');
INSERT INTO `pay_method` VALUES ('342', '51', '信用卡', '0', 'ex', '', '1', '342');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `is_active` int(1) DEFAULT NULL COMMENT '1表示活跃用户，0表示非活跃用户（未激活或者注销）',
  `activation_code` varchar(255) DEFAULT NULL COMMENT '验证码',
  `activation_code_time` varchar(255) DEFAULT NULL COMMENT '验证码发送时间 格式yyyy-mm-dd hh:mm:ss',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('50', 'admin', '1357845688@qq.com', 'f25e9490e23d41af6559473e040c3bf4018073bf38482f60', null, null, null, '2020-01-14 12:01:21', '2020-01-14 12:27:13', '1', '239587', '2020-01-14 12:01:21');
INSERT INTO `user` VALUES ('51', 'user', '1347845688@qq.com', 'f25e9490e23d41af6559473e040c3bf4018073bf38482f60', null, null, null, '2020-01-14 12:28:01', '2002-01-06 01:45:07', '1', '132943', '2020-01-14 12:28:01');

-- ----------------------------
-- Procedure structure for `insertItem`
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertItem`;
DELIMITER ;;
CREATE DEFINER=`ssm_jizhang`@`%` PROCEDURE `insertItem`(
	IN userId INT,
	IN itemName VARCHAR(50),
	IN remark VARCHAR(200),
	IN inOrEx VARCHAR(3),
	IN dele INT,
	OUT result INT
)
BEGIN

START TRANSACTION; 

INSERT INTO item ( user_id, name, in_or_ex, remark, dele, sort )
    VALUES (userId, itemName, inOrEx, remark, dele, 0);

SET result=LAST_INSERT_ID();

UPDATE item set item.sort = result WHERE item.id = result;

COMMIT; 

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `insertPayMethod`
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertPayMethod`;
DELIMITER ;;
CREATE DEFINER=`ssm_jizhang`@`%` PROCEDURE `insertPayMethod`(
	IN userId INT,
	IN name VARCHAR(50),
	IN is_count_in_this_month_ex INT,
	IN remark VARCHAR(200),
	IN inOrEx VARCHAR(3),
	IN dele INT,
	OUT result INT
)
BEGIN

START TRANSACTION; 

INSERT INTO pay_method ( user_id, name, is_count_in_this_month_ex, in_or_ex, remark, dele, sort )
    VALUES (userId, name, is_count_in_this_month_ex, inOrEx, remark, dele, 0);

SET result=LAST_INSERT_ID();

UPDATE pay_method set pay_method.sort = result WHERE pay_method.id = result;

COMMIT; 

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `selectIncome`
-- ----------------------------
DROP PROCEDURE IF EXISTS `selectIncome`;
DELIMITER ;;
CREATE DEFINER=`ssm_jizhang`@`%` PROCEDURE `selectIncome`(
	IN userId INT,
	IN inOrEx VARCHAR(3),
	OUT id INT,
	OUT sortId INT,
	OUT item_id INT,
	OUT user_id  INT,
	OUT date DATE,
	OUT money FLOAT,
	OUT type_of_money VARCHAR(255),
	OUT remark VARCHAR(255)
)
BEGIN

SELECT DISTINCT
		income.id,
		income.id as sortId,
		income.item_id,
		income.user_id,
		income.date as date,
		income.money as money,
		income.type_of_money,
		income.remark

	FROM
		income,
		item,
		pay_method
	WHERE
		income.item_id = item.id
	AND income.user_id = userId
	AND income.dele = 1
	AND income.type_of_money = pay_method.id
;
END
;;
DELIMITER ;
