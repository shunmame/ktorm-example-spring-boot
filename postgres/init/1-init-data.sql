-- t_departmentテーブルへのデータ挿入
insert into main.t_department(name, location) values ('tech', 'Guangzhou');
insert into main.t_department(name, location) values ('finance', 'Beijing');

-- t_employeeテーブルへのデータ挿入
insert into main.t_employee(name, job, manager_id, hire_date, salary, department_id) values ('vince', 'engineer', null, '2018-01-01', 100, 1);
insert into main.t_employee(name, job, manager_id, hire_date, salary, department_id) values ('marry', 'trainee', 1, '2019-01-01', 50, 1);
insert into main.t_employee(name, job, manager_id, hire_date, salary, department_id) values ('tom', 'director', null, '2018-01-01', 200, 2);
insert into main.t_employee(name, job, manager_id, hire_date, salary, department_id) values ('penny', 'assistant', 3, '2019-01-01', 100, 2);