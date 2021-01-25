-- 1. Создать таблицы и заполнить их начальными данными
create table departments (
    id serial primary key,
    name varchar(100)
);

create table employees (
    id serial primary key,
    name varchar(100),
    employees_departments int references departments(id)
);

insert into departments (name) values
('dep1'), ('dep2'), ('dep3');

insert into employees (name, employees_departments) values
('ivan', 1), ('boris', 2), ('sergei', 3), ('olga', 1), ('roman', null);

-- 2. Выполнить запросы с left, rigth, full, cross соединениями
select * from employees e left join departments d on e.employees_departments = d.id;
select * from employees e right join departments d on e.employees_departments = d.id;
select * from employees e full join departments d on e.employees_departments = d.id;
select * from employees e cross join departments d;

-- 3. Используя left join найти работников, которые не относятся ни к одну из департаментов
select e.* from employees e left join departments d
on e.employees_departments = d.id where e.employees_departments is null;

-- 4. Используя left и right join написать запросы, которые давали бы одинаковый результат.
select e.* from employees e left join departments d on e.employees_departments = d.id;
select e.* from departments d right join employees e on e.employees_departments = d.id;

-- 5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
--Используя cross join составить все возможные разнополые пары

create table teens (
    name varchar(100),
    gender varchar(5)
);

insert into teens (name, gender) values
('roman', 'м'), ('olga', 'ж'), ('ivan', 'м'), ('marina', 'ж'), ('sveta', 'ж'), ('boris', 'м');
select * from (select name from teens where gender = 'м') as boys
cross join (select name from teens where gender = 'ж') as girls;