/*创建合同表*/
use tender;
drop table if exists T_CONTRACT;
create table tender.t_contract
(
    contract_id    int auto_increment,
    contract_uid   char(12)      not null,
    party_a_id     int           null,
    party_b_id     int           null,
    create_date    date          null,
    modify_date    date          null,
    end_date       date          null,
    title          varchar(50)   null,
    name           varchar(50)   null,
    place          varchar(50)   null,
    scale          varchar(2000) null,
    clause         varchar(2000) null,
    breach         varchar(2000) null,
    supplement     varchar(2000) null,
    u_a_money      double        null,
    u_a_time       date          null,
    u_b_power      varchar(2000) null,
    u_b_obligation varchar(2000) null,
    primary key (contract_id, contract_uid),
    constraint contract_id
        unique (contract_id),
    constraint contract_uid
        unique (contract_uid),
    constraint t_contract_ibfk_1
        foreign key (party_a_id) references tender.t_user (people_id),
    constraint t_contract_ibfk_2
        foreign key (party_b_id) references tender.t_user (people_id)
);

create index party_a_id
    on tender.t_contract (party_a_id);

create index party_b_id
    on tender.t_contract (party_b_id);

/**
  插入测试数据
 */

insert into t_contract(contract_uid, party_a_id, party_b_id, create_date, modify_date, end_date, title, name, place,
                       scale, clause, breach, supplement, u_a_money, u_a_time, u_b_power, u_b_obligation)
VALUES (202310100001, 1, 4, '2023-10-10', '2023-10-10', '2025-10-10', '借贷款合同', 'xxx项目开发', '四川省成都市aaaaaa',
        '规模:xxxxxxxxxxxxxxxxxxxx', '此条款:xxxxxxxxxxxxx', '违约:xxxxxxxxxxxxxxxxx', '补充条款:xxxxxxxxxxxxxxxx',
        '510234.51', '2025-10-10', '权力:xxxxxxxxxxxxxxx', '义务:xxxxxxxxxxxxxxxxxxxxxx'),
    (202310100002, 1, 5, '2023-10-10', '2023-10-10', '2025-10-10', '借贷款合同', 'xxx项目开发', '四川省成都市aaaaaa',
        '规模:xxxxxxxxxxxxxxxxxxxx', '此条款:xxxxxxxxxxxxx', '违约:xxxxxxxxxxxxxxxxx', '补充条款:xxxxxxxxxxxxxxxx',
        '510234.51', '2025-10-10', '权力:xxxxxxxxxxxxxxx', '义务:xxxxxxxxxxxxxxxxxxxxxx'),
    (202310100003, 3, 5, '2023-10-10', '2023-10-10', '2025-10-10', '借贷款合同', 'xxx项目开发', '四川省成都市aaaaaa',
        '规模:xxxxxxxxxxxxxxxxxxxx', '此条款:xxxxxxxxxxxxx', '违约:xxxxxxxxxxxxxxxxx', '补充条款:xxxxxxxxxxxxxxxx',
        '510234.51', '2025-10-10', '权力:xxxxxxxxxxxxxxx', '义务:xxxxxxxxxxxxxxxxxxxxxx');