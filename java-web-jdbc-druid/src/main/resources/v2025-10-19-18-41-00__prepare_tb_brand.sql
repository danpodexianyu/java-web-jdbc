create database if not exists db_java_web;

use db_java_web;

-- 删除 tb_brand
drop table if exists tb_brand;

-- 创建 tb_user
create table tb_brand
(
    id           int primary key auto_increment, -- ID主键
    brand_name   varchar(20),                    -- 品牌名称
    company_name varchar(20),                    -- 公司名称
    ordered      int,                            -- 排序字段
    description  varchar(100),                   -- 描述信息
    status       int                             -- 状态：0-禁用, 1-启用
);

-- 添加数据
insert into tb_brand (brand_name, company_name, ordered, description, status)
values('三只松鼠', '三只松鼠股份有限公司', 5, '好吃不上火', 0),
      ('华为', '华为技术有限公司', 100, '华为致力于把数字世界带入每个人、每个家庭、每个组织，构建万物互联的智能世界', 1),
      ('小米', '小米科技有限公司', 50, 'are you ok', 1)