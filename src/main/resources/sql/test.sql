/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 06/12/2019 14:44:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '请求类型',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '日志标题',
  `remote_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '操作IP地址',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '操作用户昵称',
  `request_uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '请求URI',
  `http_method` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '操作方式',
  `class_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '请求类型.方法',
  `params` text CHARACTER SET utf8 COLLATE utf8_bin COMMENT '操作提交的数据',
  `session_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'sessionId',
  `response` longtext CHARACTER SET utf8 COLLATE utf8_bin COMMENT '返回内容',
  `use_time` bigint(11) DEFAULT NULL COMMENT '方法执行时间',
  `browser` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '浏览器信息',
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '地区',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '省',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '市',
  `isp` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '网络服务提供商',
  `exception` text CHARACTER SET utf8 COLLATE utf8_bin COMMENT '异常信息',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sys_log_create_by` (`create_by`) USING BTREE,
  KEY `sys_log_request_uri` (`request_uri`) USING BTREE,
  KEY `sys_log_type` (`type`) USING BTREE,
  KEY `sys_log_create_date` (`create_date`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
BEGIN;
INSERT INTO `sys_log` VALUES (5, '普通请求', '登录', '127.0.0.1', NULL, 'http://localhost:8702/test/userinfo/login', 'POST', 'com.july.controller.UserinfoController.login', '[{\"mobile\":\"19913146112\",\"password\":\"146112\"}]', '13DC26A3B2ED11EB4DF4EFB2C2693ACA', '{\"msg\":\"处理成功\",\"code\":0,\"content\":{\"id\":1,\"mobile\":\"19913146112\",\"token\":\"D4D5C12837D94A4EACFE3E50EBA6E3C3\",\"username\":\"zengxueqi\"}}', 9, 'UnKnown, More-Info: PostmanRuntime/7.20.1-UnKnown, More-Info: PostmanRuntime/7.20.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_log` VALUES (6, '普通请求', '登录', '127.0.0.1', NULL, 'http://localhost:8702/test/userinfo/login', 'POST', 'com.july.controller.UserinfoController.login', '[{\"mobile\":\"19913146112\",\"password\":\"146112\"}]', 'E6C20E00513DBB25E58C57A1B90087DF', '{\"msg\":\"处理成功\",\"code\":0,\"content\":{\"id\":1,\"mobile\":\"19913146112\",\"token\":\"7099D61E85AE49C8BC2259BFD580803D\",\"username\":\"zengxueqi\"}}', 24, 'UnKnown, More-Info: PostmanRuntime/7.20.1-UnKnown, More-Info: PostmanRuntime/7.20.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_log` VALUES (7, '普通请求', '登录', '127.0.0.1', NULL, 'http://localhost:8702/test/userinfo/login', 'POST', 'com.july.controller.UserinfoController.login', '[{\"mobile\":\"19913146112\",\"password\":\"146112\"}]', 'E6C20E00513DBB25E58C57A1B90087DF', '{\"msg\":\"处理成功\",\"code\":0,\"content\":{\"id\":1,\"mobile\":\"19913146112\",\"token\":\"F4C2B3B36E1B4AC0A38B60F085AFC18D\",\"username\":\"zengxueqi\"}}', 7, 'UnKnown, More-Info: PostmanRuntime/7.20.1-UnKnown, More-Info: PostmanRuntime/7.20.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_log` VALUES (8, '普通请求', '登录', '127.0.0.1', NULL, 'http://localhost:8702/test/userinfo/login', 'POST', 'com.july.controller.UserinfoController.login', '[{\"mobile\":\"19913146112\",\"password\":\"146112\"}]', 'E6C20E00513DBB25E58C57A1B90087DF', '{\"msg\":\"处理成功\",\"code\":0,\"content\":{\"id\":1,\"mobile\":\"19913146112\",\"token\":\"E6F0C0ABE57D469BAA79CCD8E9D03A61\",\"username\":\"zengxueqi\"}}', 6, 'UnKnown, More-Info: PostmanRuntime/7.20.1-UnKnown, More-Info: PostmanRuntime/7.20.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_log` VALUES (9, '普通请求', '登录', '127.0.0.1', NULL, 'http://localhost:8702/test/userinfo/login', 'POST', 'com.july.controller.UserinfoController.login', '[{\"mobile\":\"19913146112\",\"password\":\"146112\"}]', 'E6C20E00513DBB25E58C57A1B90087DF', '{\"msg\":\"处理成功\",\"code\":0,\"content\":{\"id\":1,\"mobile\":\"19913146112\",\"token\":\"C6CAE8C713F2479390D247AC59ACD49E\",\"username\":\"zengxueqi\"}}', 6, 'UnKnown, More-Info: PostmanRuntime/7.20.1-UnKnown, More-Info: PostmanRuntime/7.20.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_log` VALUES (10, '普通请求', '登录', '127.0.0.1', NULL, 'http://localhost:8702/test/userinfo/login', 'POST', 'com.july.controller.UserinfoController.login', '[{\"mobile\":\"19913146112\",\"password\":\"146112\"}]', 'E6C20E00513DBB25E58C57A1B90087DF', '{\"msg\":\"处理成功\",\"code\":0,\"content\":{\"id\":1,\"mobile\":\"19913146112\",\"token\":\"B1F42E295EBA413D82BD911102DBBA0F\",\"username\":\"zengxueqi\"}}', 5, 'UnKnown, More-Info: PostmanRuntime/7.20.1-UnKnown, More-Info: PostmanRuntime/7.20.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_log` VALUES (11, '普通请求', '登录', '127.0.0.1', NULL, 'http://localhost:8702/test/userinfo/login', 'POST', 'com.july.controller.UserinfoController.login', '[{\"mobile\":\"19913146112\",\"password\":\"146112\"}]', 'E6C20E00513DBB25E58C57A1B90087DF', '{\"msg\":\"处理成功\",\"code\":0,\"content\":{\"id\":1,\"mobile\":\"19913146112\",\"token\":\"8F057D0B7432475E95A52C985DC5B646\",\"username\":\"zengxueqi\"}}', 8, 'UnKnown, More-Info: PostmanRuntime/7.20.1-UnKnown, More-Info: PostmanRuntime/7.20.1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `pwdsalt` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
