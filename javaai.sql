/*
 Navicat Premium Dump SQL

 Source Server         : localConnection
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : javaai

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 12/09/2025 19:47:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL COMMENT '用户名id',
  `sender` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '聊天记录的发送者',
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '聊天的内容',
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '聊天类型 0.对话 1.图片内容 2.音频内容',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 1, 'user', '你好', '0', '2025-09-09 11:15:51');
INSERT INTO `message` VALUES (2, 1, 'ai', '你好，我是ai', '0', '2025-09-09 11:16:46');
INSERT INTO `message` VALUES (3, 100, 'user', 'hello', '0', '2025-09-09 11:17:12');
INSERT INTO `message` VALUES (4, 1, 'user', '你是谁？', '0', '2025-09-10 09:46:14');
INSERT INTO `message` VALUES (5, 1, 'ai', '<think>\n\n</think>\n\n您好！我是由中国的深度求索（DeepSeek）公司开发的智能助手DeepSeek-R1。如您有任何任何问题，我会尽我所能为您提供帮助。', '0', '2025-09-10 09:46:17');
INSERT INTO `message` VALUES (6, 1, 'user', '你是谁', '0', '2025-09-10 11:08:32');
INSERT INTO `message` VALUES (7, 1, 'ai', '<think>\n\n</think>\n\n您好！我是由中国的深度求索（DeepSeek）公司开发的智能助手DeepSeek-R1。如您有任何任何问题，我会尽我所能为您提供帮助。', '0', '2025-09-10 11:08:34');
INSERT INTO `message` VALUES (8, 1, 'user', '中医和西医的区别', '0', '2025-09-10 14:30:44');
INSERT INTO `message` VALUES (9, 1, 'ai', '<think>\n嗯，我现在要理解中医和西医的区别。我觉得这两种医疗体系都是用来治疗疾病的，但它们可能有不同的方法、理念和目标。首先，我应该分别了解一下两种系统的核心概念。\n\n中医，我记得它主要围绕“五脏”来展开，包括肺、胃、肝、脾等。这些脏腑在中医中被看作是生命之根，也是人体功能的基本部分。所以，中医可能更注重整体的身体协调和恢复。比如，如果一个人经常熬夜，那么中医可能会从心脏、肺开始进行调理。\n\n西医呢，它的主要理论我记得是“以健康为中心”，强调从生源到病源的分析。它通常使用科学方法，比如实验、观察和测量，来诊断和治疗疾病。西医可能更关注具体症状和患者的个人情况，可能还会涉及激素水平、基因研究等技术。\n\n然后，我应该考虑两者在实施上的差异。中医可能需要更多的实践和经验，因为它更多地依靠经验丰富的医生和护理人员进行治疗。而西医通常由专业的医生和技术团队来操作，可能需要更系统的培训才能胜任。\n\n另外，我听说中医有“内”和“外”的方面。“内”就是指整体的调节，比如通过饮食调整、情绪管理等方式达到整体健康。而“外”则是通过手术或其他外治手段来治疗疾病。这两者结合起来，可能在某些情况下更为有效，尤其是在无法进行内治的情况下。\n\n西医的诊断方法也挺多的，比如X光、超声波、电子检查等等，这些都是用来观察人体结构和功能的状态。这些技术可以帮助医生更准确地判断患者的问题所在，并制定相应的治疗方案。\n\n但我觉得中医可能也有其局限性。比如，它可能对某些疾病的解释不够科学或全面，特别是那些在西医看来还没有完全理清的疾病。另外，中医在不同文化背景下的应用可能也存在差异，有的地方可能不太普及或者不通用。\n\n还有，中医和西医在治疗效果上可能会有所偏差。比如，中医强调整体健康，可能能够有效预防某些疾病的复发或加重，而西医则更注重药物治疗的效果，可能在短期内效果更好。\n\n总的来说，中医和西医都是现代医学的重要组成部分，各有优缺点。它们都致力于帮助人们更好地健康生活，但具体的方法和技术上还是有很大的不同。\n</think>\n\n中医和西医是两种不同的医疗体系，各自有不同的核心概念、实施方法和目标。以下是对两者的主要区别及特点的总结：\n\n### 中医：\n1. **整体观念**：中医强调“内”与“外”的协调，认为人体的整体健康至关重要。\n2. **脏腑调节**：主要围绕五脏（肺、胃、肝、脾、肾）进行调理，重视脏腑之间的关系和功能。\n3. **传统方法**：依赖经验丰富的医生和护理人员，采用理论指导实践，强调因人而异的治疗方案。\n4. **内治与外治结合**：在某些情况下可能同时使用内治（通过饮食、情绪管理）和外治（如手术）来达到更好的效果。\n\n### 西医：\n1. **科学方法**：以“健康为中心”，采用实验、观察和测量等科学手段诊断和治疗疾病。\n2. **从生源分析**：注重病机的科学分析，使用激素水平、基因研究等技术来判断疾病原因。\n3. **个体化诊断**：注重患者的具体情况，制定个性化治疗方案，可能涉及手术或药物治疗。\n4. **具体治疗**：以症状为导向，采用各种医疗手段如手术、化疗等方式进行治疗。\n\n### 实用区别：\n- **治疗方法**：中医更注重整体和内治，西医则通过科学诊断和专业治疗。\n- **实施方法**：中医依靠经验与实践，西医需系统培训和设备支持。\n- **应用范围**：中医在特定文化背景和地域有推广潜力，而西医则广泛应用于现代医疗体系。\n\n### 总结：\n中医和西医各有优缺点，但都致力于改善人类健康。选择哪种体系取决于具体需求、文化背景及个人偏好。', '0', '2025-09-10 14:30:55');
INSERT INTO `message` VALUES (10, 1, 'user', '你是谁', '0', '2025-09-10 15:58:58');
INSERT INTO `message` VALUES (11, 1, 'ai', '<think>\n\n</think>\n\n您好！我是由中国的深度求索（DeepSeek）公司开发的智能助手DeepSeek-R1。如您有任何任何问题，我会尽我所能为您提供帮助。', '0', '2025-09-10 15:59:00');
INSERT INTO `message` VALUES (12, 1, 'user', '小马', '0', '2025-09-11 15:43:30');
INSERT INTO `message` VALUES (13, 1, 'user', '小马', '0', '2025-09-11 16:32:31');
INSERT INTO `message` VALUES (14, 1, 'user', '小猪', '0', '2025-09-11 16:34:50');
INSERT INTO `message` VALUES (15, 1, 'user', '你是谁', '0', '2025-09-11 19:07:22');
INSERT INTO `message` VALUES (16, 1, 'user', '你是谁', '0', '2025-09-11 19:19:31');
INSERT INTO `message` VALUES (24, 1, 'user', '老虎', '1', '2025-09-12 14:11:24');
INSERT INTO `message` VALUES (25, 1, 'ai', '/img/output_1757657515112.png', '1', '2025-09-12 14:11:55');
INSERT INTO `message` VALUES (26, 1, 'user', '猪猪侠', '1', '2025-09-12 14:38:23');
INSERT INTO `message` VALUES (27, 1, 'ai', '/img/output_1757659134087.png', '1', '2025-09-12 14:38:54');
INSERT INTO `message` VALUES (28, 1, 'user', '大家好，我系渣渣辉', '2', '2025-09-12 14:57:56');
INSERT INTO `message` VALUES (29, 1, 'ai', '/audio/output_1757660277063.mp3', '2', '2025-09-12 14:57:57');
INSERT INTO `message` VALUES (30, 1, 'user', '你是谁', '0', '2025-09-12 17:03:20');
INSERT INTO `message` VALUES (31, 1, 'ai', '<think>\n\n</think>\n\n您好！我是由中国的深度求索（DeepSeek）公司开发的智能助手DeepSeek-R1。如您有任何任何问题，我会尽我所能为您提供帮助。', '0', '2025-09-12 17:03:23');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', '铁蛋', '男', '1234567890', '2025-09-06 10:11:51');
INSERT INTO `user` VALUES (3, 'test', '123456', '翠花', '女', '1234567891', '2025-09-06 14:09:00');
INSERT INTO `user` VALUES (4, '11', '123456', '陈', '男', '17353802029', '2025-09-09 09:01:33');
INSERT INTO `user` VALUES (5, 'zhangsan', '123123', '张三', '男', '17353802028', '2025-09-09 09:28:40');

SET FOREIGN_KEY_CHECKS = 1;
