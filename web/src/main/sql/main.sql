create table second_kill_config
(
	id int auto_increment comment '主键编号'
		primary key,
	kill_product_id int not null comment '秒杀商品编号',
	kill_product_stock int default '0' not null comment '秒杀商品库存',
	kill_start_time timestamp default CURRENT_TIMESTAMP not null comment '秒杀活动开始时间',
	kill_update_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '配置更新时间',
)
comment '秒杀配置表'
;

create table second_kill_record
(
	id int auto_increment comment '主键编号'
		primary key,
	kill_product_id int not null comment '秒杀产品编号',
	create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
	update_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
	user_id int not null comment '用户编号',
	constraint second_kill_record_pk
		unique (kill_product_id, user_id)
)
comment '秒杀记录表'
;

