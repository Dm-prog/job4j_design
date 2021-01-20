1)
create table user (
    id serial primary key,
    name varchar(200),
    role_id int references role(id)
);

create table role (
    id serial primary key,
    name varchar(200),
    user_id int references user(id)
);

2)
create table role (
    id serial primary key,
    name varchar(200)
);

create table rules (
    id serial primary key,
    name varchar(200)
);

create table rules_role(
    id serial primary key,
    rules_id int references rules(id),
    role_id int references role(id)
);

3)
create table item (
    id serial primary key,
    name varchar(200),
    user_id int references user(id)
);

create table user (
    id serial primary key,
    name varchar(200)
);

4)
create table item (
    id serial primary key,
    name varchar(200)
);

create table comments (
    id serial primary key,
    name varchar(200),
    item_id int references item(id)
);

5)
create table item (
    id serial primary key,
    name varchar(200)
);

create table attachs (
    id serial primary key,
    name varchar(200),
    item_id int references item(id)
);

6)
create table item (
    id serial primary key,
    name varchar(200),
    category_id int references category(id)
);

create table category (
    id serial primary key,
    name varchar(200)
);

7)
create table item (
    id serial primary key,
    name varchar(200),
    state_id int references state(id)
);

create table state (
    id serial primary key,
    name varchar(200)
);