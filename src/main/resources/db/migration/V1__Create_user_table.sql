# Executive Command:
#  mvn flyway:clean   -- 清空flyway缓存
#  mvn flyway:repair  -- 修复,再次生成表之前要先执行这个
#  mvn flyway:migrate -- 合成表
CREATE TABLE `user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID标识',
  `ACCOUNT_ID` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '账户ID',
  `NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '登录账户名',
  `TOKEN` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'token令牌',
  `GMT_CREATE` bigint(20) DEFAULT NULL COMMENT '以格林威治时间为标准 - 创建时间(时间戳)',
  `GMT_MODIFIED` bigint(20) DEFAULT NULL COMMENT '以格林威治时间为标准 - 修改时间(时间戳)',
  `BIO` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '个人说明',
  `AVATAR_URL` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'URL',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';