CREATE TABLE `second_kill_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `kill_product_id` int(11) NOT NULL COMMENT '秒杀商品编号',
  `kill_product_stock` int(11) NOT NULL DEFAULT '0' COMMENT '秒杀商品库存',
  `kill_start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀活动开始时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='秒杀配置表'


