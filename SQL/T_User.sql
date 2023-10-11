/*创建合同双方用户信息表*/
use tender;
drop table if exists t_user;
create table t_user
(
    people_id  int              not null
        primary key auto_increment,
    u_type     char default 'A' null,
    legal_name varchar(50)      null,
    agent_name varchar(50)      null,
    place      varchar(50)      null,
    zipcode    char(6)          null,
    phone      char(11)         null,
    bank_id    char(19)         null,
    bank_place varchar(50)      null
);

/**
  插入测试数据
 */

insert into t_user(u_type, legal_name, agent_name, place, zipcode, phone, bank_id, bank_place)
VALUES ('A', 'AAAAAA责任有限公司', '陈建文', '四川省成都市青白江区xxxxx', '610300', '17380000000',
        '6100000000000000001', '建设银行xx支行'),
       ('B', 'AAAAAA责任有限公司', '陈建文', '四川省成都市青白江区xxxxx', '610300', '17380000000',
        '6100000000000000001', '建设银行xx支行'),
       ('A', 'CCCCCC责任有限公司', '刘欢', '四川省成都市青白江区xxxxx', '610311', '12340000000',
        '6100000000000000002', '中国银行xx支行'),
       ('B', 'CCCCCC责任有限公司', '刘欢', '四川省成都市青白江区xxxxx', '610311', '12340000000',
        '6100000000000000002', '中国银行xx支行'),
    ('B', 'BBBBBB责任有限公司', '乙方神秘人', '四川省成都市青白江区xxxxx', '510311', '12340000123',
        '3330000000000000002', '瑞士银行xx支行');

insert into t_user(u_type, legal_name, agent_name, place, zipcode, phone, bank_id, bank_place)
values ('B', 'AAAAAA责任有限公司', '陈建文', '四川省成都市青白江区xxxxx', '610300', '17380000000',
        '6100000000000000001', '建设银行xx支行'),
       ('A', 'BBBBBB责任有限公司', '甲方神秘人', '四川省成都市青白江区xxxxx', '510311', '12340000123',
        '3330000000000000002', '瑞士银行xx支行');