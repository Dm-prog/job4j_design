--Создать структур данных в базе. Таблицы. Кузов. Двигатель, Коробка передач.
create table body (
   id serial primary key,
   name varchar(100)
);
create table engine (
   id serial primary key,
   name varchar(100)
);
create table transmission (
   id serial primary key,
   name varchar(100)
);

-- Создать структуру Машина. Машина не может существовать без данных из п.1.
create table cars (
   id serial primary key,
   name varchar(100),
   body_id int references body(id),
   engine_id int references body(id),
   transmission_id int references body(id)
);

-- Заполнить таблицы через insert.
insert into body (name) values
('body_1'), ('body_2'), ('body_3');

insert into engine (name) values
('engine_1'), ('engine_2'), ('engine_3');

insert into transmission (name) values
('transmission_1'), ('transmission_2'), ('transmission_3');

insert into cars (name, body_id, engine_id, transmission_id) values
('car_1', 1, 1, 1), ('car_2', 2, 2, 2);

-- 1. Вывести список всех машин и все привязанные к ним детали.
select c.name as car, b.name as body, e.name as engine, t.name as transmission
from cars c
left join body b on c.body_id = b.id
left join engine e on c.engine_id = e.id
left join transmission t on c.transmission_id = t.id;

-- 2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
select b.name from body b left join cars c
on c.body_id = b.id where c.id is null
union
select e.name from engine e left join cars c
on c.engine_id = e.id where c.id is null
union
select t.name from transmission t left join cars c
on c.transmission_id = t.id where c.id is null;