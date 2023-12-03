-- mainスキーマ作成
create schema main;

-- テーブル作成
create table main.t_department(
  id serial,
  name varchar(128) not null,
  location varchar(128) not null,
  primary key (id)
);

create table main.t_employee(
  id serial,
  name varchar(128) not null,
  job varchar(128) not null,
  manager_id int null,
  hire_date date not null,
  salary bigint not null,
  department_id int not null,
  primary key (id)
);