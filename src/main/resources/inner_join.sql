create table drivers(
    id serial primary key,
    name varchar(50),
    age int
);
create table cars(
    id serial primary key,
    name varchar(50),
    drivers_id int references drivers(id)
);
insert into drivers(name, age)values('ivan', 32);
insert into drivers(name, age)values('oleg', 40);
insert into drivers(name, age)values('petr', 18);

insert into cars values(1, 'volkswagen', 1);
insert into cars values(2, 'mercedes', 2);
insert into cars values(3, 'toyota', 3);

select d.name, d.age, c.name from drivers as d join cars as c on c.drivers_id = d.id;
select d.name, d.age, c.name from drivers as d join cars as c on c.drivers_id = d.id and d.age > 18;
select d.name, d.age, c.name from drivers as d join cars as c on c.drivers_id = d.id and c.name like 'v%';