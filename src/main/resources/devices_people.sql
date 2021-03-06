create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values
('iPhone X', 35.500),
('Galaxy S8 Plus', 23.000),
('iPhone 8', 28.300);

insert into people(name) values
('ivan'),('boris'),('evgeniy'),('roman');

insert into devices_people(device_id, people_id) values
(1, 1), (1, 3), (1, 4), (2, 2),
(2, 3), (2, 4), (3, 1), (3, 2), (3, 3);

-- у Ивана - iPhone X, iPhone 8;
-- у Бориса - Galaxy S8 Plus, iPhone 8;
-- у Евгения - iPhone X, Galaxy S8 Plus, iPhone 8;
-- у Романа - Galaxy S8 Plus;

--Используя группировку вывести для каждого человека среднюю цену его устройств
select p.name, avg(d.price) from people p join devices_people dp on p.id = dp.people_id
join devices d on dp.device_id = d.id group by p.name;

--Дополнить запрос условием, что цена устройства должны быть больше 29.0
select p.name, avg(d.price) from people p join devices_people dp on p.id = dp.people_id
join devices d on dp.device_id = d.id group by p.name having avg(d.price) < 29.0;


