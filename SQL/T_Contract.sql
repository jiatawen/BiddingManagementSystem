/*创建合同表*/
use tender;
drop table if exists T_CONTRACT;
create table T_CONTRACT
(
    contract_id    int primary key,
    party_a        int,
    party_b        int,
    create_date    date,
    modify_date    date,
    end_date       date,
    title          varchar(50),
    name           varchar(50),
    place          varchar(50),
    scale          varchar(200),
    clause         varchar(200),
    breach         varchar(200),
    supplement     varchar(200),
    u_a_money      double,
    u_a_time       date,
    u_b_power      varchar(200),
    u_b_obligation varchar(200),
    foreign key (party_a) references t_user(people_id),
    foreign key (party_b) references t_user(people_id)
);