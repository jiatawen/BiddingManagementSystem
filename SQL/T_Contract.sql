/*创建合同表*/
use tender;
drop table if exists T_CONTRACT;
create table T_CONTRACT
(
    contract_id    int auto_increment,
    contract_uid   char(12),
    party_a_id     int,
    party_b_id     int,
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
    primary key (contract_id, contract_uid),
    foreign key (party_a_id) references t_user (people_id),
    foreign key (party_b_id) references t_user (people_id)
);

/**
  插入测试数据
 */

insert into t_contract(contract_uid, party_a_id, party_b_id, create_date, modify_date, end_date, title, name, place,
                       scale, clause, breach, supplement, u_a_money, u_a_time, u_b_power, u_b_obligation)
VALUES (202310100001, 1, 4, '2023-10-10', '2023-10-10', '2025-10-10', '借贷款合同', 'xxx项目开发', '四川省成都市aaaaaa',
        '规模:xxxxxxxxxxxxxxxxxxxx', '此条款:xxxxxxxxxxxxx', '违约:xxxxxxxxxxxxxxxxx', '补充条款:xxxxxxxxxxxxxxxx',
        '510234.51', '2025-10-10', '权力:xxxxxxxxxxxxxxx', '义务:xxxxxxxxxxxxxxxxxxxxxx'),
    (202310100001, 1, 5, '2023-10-10', '2023-10-10', '2025-10-10', '借贷款合同', 'xxx项目开发', '四川省成都市aaaaaa',
        '规模:xxxxxxxxxxxxxxxxxxxx', '此条款:xxxxxxxxxxxxx', '违约:xxxxxxxxxxxxxxxxx', '补充条款:xxxxxxxxxxxxxxxx',
        '510234.51', '2025-10-10', '权力:xxxxxxxxxxxxxxx', '义务:xxxxxxxxxxxxxxxxxxxxxx'),
    (202310100001, 3, 5, '2023-10-10', '2023-10-10', '2025-10-10', '借贷款合同', 'xxx项目开发', '四川省成都市aaaaaa',
        '规模:xxxxxxxxxxxxxxxxxxxx', '此条款:xxxxxxxxxxxxx', '违约:xxxxxxxxxxxxxxxxx', '补充条款:xxxxxxxxxxxxxxxx',
        '510234.51', '2025-10-10', '权力:xxxxxxxxxxxxxxx', '义务:xxxxxxxxxxxxxxxxxxxxxx');