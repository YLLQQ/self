CREATE TABLE `second_kill_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `kill_product_id` int(11) NOT NULL COMMENT '秒杀产品编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `second_kill_record_pk` (`kill_product_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='秒杀记录表'



