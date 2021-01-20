1)
create table user (
    id serial primary key,
    name varchar(200)
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
    name varchar(200)
);

create table user (
    id serial primary key,
    name varchar(200),
    item_id int references item(id)
);

4)
create table item (
    id serial primary key,
    name varchar(200)
    comments_id int references comments(id)
);

create table comments (
    id serial primary key,
    name varchar(200)
);

5)
create table item (
    id serial primary key,
    name varchar(200)
    attachs_id int references attachs(id)
);

create table attachs (
    id serial primary key,
    name varchar(200)
);

6)
create table item (
    id serial primary key,
    name varchar(200)
);

create table category (
    id serial primary key,
    name varchar(200),
    item_id int references item(id)
);

7)
create table item (
    id serial primary key,
    name varchar(200)
);

create table state (
    id serial primary key,
    name varchar(200),
    item_id int references item(id)
);