create table dic
(
	dic_id varchar(64) not null
		primary key,
	dic_code varchar(64) null comment '字典编码',
	dic_name varchar(255) null comment '字典名称',
	fg_delete int default 0 null comment '删除标识'
)
comment '字典';

