/*创建合同双方用户信息表*/
use tender;
drop table if exists t_user;
create table T_USER
(
    people_id       int primary key,
    u_type         char(1) default 'A',
    legal_name      varchar(50),
    agent_name      varchar(50),
    place          varchar(50),
    zipcode        int,
    phone          int,
    bank_id         int,
    bank_place      varchar(50)
);