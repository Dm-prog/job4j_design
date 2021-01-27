create table type (
    id serial primary key,
    name varchar(100)
);
create table product (
    id serial primary key,
    name varchar(100),
    type_id int references type(id),
    expired_date date,
    price decimal
);

insert into type (name) values
('СЫР'), ('МОЛОКО'), ('МОРОЖЕННОЕ');

insert into product (name, type_id, expired_date, price) values
('плавленный', 1, '2021-02-15', 15.2),
('дружба', 1, '2021-02-12', 20.5),
('мороженное сливочное', 3, '2021-07-01', 56.8),
('топленое', 2, '2021-01-30', 30.1),
('клубничное', 3, '2021-06-10', 45.5);

-- 1. Написать запрос получение всех продуктов с типом "СЫР"
select p.* from product p join type t on p.type_id = t.id where t.name = 'СЫР';

-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select p.* from product p join type t on p.type_id = t.id where p.name like '%мороженное%';

-- 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from product where expired_date >= date_trunc('month', CURRENT_DATE) + INTERVAL '1 month'
    and expired_date < date_trunc('month', CURRENT_DATE) + INTERVAL '2 month';

-- 4. Написать запрос, который выводит самый дорогой продукт.
select name, price from product where price = (select max(price) from product);

-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.
select t.*, count(p) from type t join product p on t.id = p.type_id group by t.id;

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.* from product p join type t on t.id = p.type_id where t.name = 'СЫР' or t.name = 'МОЛОКО';

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select t.name, count(p) from type t join product p on p.type_id = t.id group by t.name having count(p) < 2;

-- 8. Вывести все продукты и их тип.
select p.name, t.name from product p join type t on p.type_id = t.id;