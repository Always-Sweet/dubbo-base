-- auto-generated definition
create table dic
(
    dic_id    varchar(64)      not null
        primary key,
    dic_code  varchar(64)      null comment '字典编码',
    dic_name  varchar(255)     null comment '字典名称',
    fg_active int(1) default 0 not null comment '注销状态',
    fg_delete int(1) default 0 not null comment '删除标识'
)
    comment '字典';