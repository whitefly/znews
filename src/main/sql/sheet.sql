create table comment
(
	id int auto_increment
		primary key,
	content varchar(255) not null comment '评论的内容',
	user_id int not null comment '评论的用户id',
	created_date datetime not null,
	entity_type int not null comment '问题评论还是答案评论',
	entity_id int not null comment '问题或答案的id',
	status int null
)
comment '问题的答案/答案的评论';

create index comment_user_id_index
	on comment (user_id);

create table feed
(
	id int auto_increment
		primary key,
	created_date datetime null comment '新鲜事创建时间',
	user_id int not null comment '产生者id',
	data text collate utf8mb4_general_ci null,
	type int null comment '新鲜事的类型'
)
charset=utf8;

create index user_id_index
	on feed (user_id);

create table message
(
	id int auto_increment
		primary key,
	from_id int not null comment '发送者id',
	to_id int not null comment '接受者id',
	content varchar(255) not null comment '信息内容',
	created_date datetime not null comment '发送时间',
	has_read int not null comment '接收者是否读取',
	conversation_id varchar(255) not null comment '2个人的有来有回的信息,应该属于同一个对话'
)
comment '用户之间的站内信';

create table news
(
	id int auto_increment
		primary key,
	title varchar(255) not null,
	link varchar(255) null,
	image varchar(255) null,
	like_count int not null comment '点赞数',
	comment_count int null comment '评论数',
	user_id int not null comment '发布资讯的用户id',
	created_date datetime not null
)
comment '资讯';

create table question
(
	id int auto_increment
		primary key,
	title varchar(255) not null comment '用户标题',
	content varchar(255) not null comment '问题具体内容',
	user_id int not null comment '提出该问题的用户',
	created_date datetime not null comment '提出时间',
	comment_count int not null comment '问题的评论数'
)
comment '问题';

create table user
(
	id int auto_increment
		primary key,
	name varchar(30) not null comment '用户名',
	password varchar(255) not null comment '密码',
	salt varchar(30) not null comment '对每个账户的密码进行加盐hash',
	head_url varchar(255) null comment '用户头像地址',
	constraint user_name_uindex
		unique (name)
)
comment '用户表';
insert into user(name,password,salt,head_url) values('系统','123','123','12a8e1ce5ad8060fddb93ae2df98028b_m.jpg');

create table user_ticket
(
	id int auto_increment
		primary key,
	user_id int not null comment 'session对应的用户id',
	ticket varchar(45) not null comment 'session值',
	expired datetime not null comment '过期时间点',
	status int default 0 not null comment 'session登录的状态(0表示应该失效)'
)
comment '用户session表';

create index ticket_index
	on user_ticket (ticket);

