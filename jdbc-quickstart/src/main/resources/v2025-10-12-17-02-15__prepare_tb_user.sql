DROP DATABASE IF EXISTS db_java_web;

CREATE DATABASE IF NOT EXISTS db_java_web;

USE db_java_web;

-- 删除 tb_user
DROP TABLE IF EXISTS tb_user;

-- 创建 tb_user
CREATE TABLE tb_user
(
    id       INT,
    username VARCHAR(20),
    password VARCHAR(32)
);

-- 添加数据
INSERT INTO tb_user VALUES(1, 'zhangsan', '123'), (2, 'lisi', '234')