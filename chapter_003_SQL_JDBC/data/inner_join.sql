create table smartphone (
	id serial primary key,
	name varchar(255)
);
create table people (
	id serial primary key,
	name varchar(255),
	smartphone_id int references smartphone(id)
);
insert into smartphone(name) values('Apple');
insert into smartphone(name) values('POCO');
insert into smartphone(name) values('Sams');
insert into smartphone(name) values('Nokia');

insert into people(name, smartphone_id) values('name1', 1);
insert into people(name, smartphone_id) values('name2', 2);
insert into people(name, smartphone_id) values('name3', 3);
insert into people(name, smartphone_id) values('name4', 4);

select p.name Имя, s.name Смарт
from people p join smartphone s on p.smartphone_id = s.id;

select p.name Имя, s.name Смарт
from people p join smartphone s on p.smartphone_id = s.id and p.smartphone_id = 2;

select p.name Имя, s.name Смарт
from people p join smartphone s on p.smartphone_id = s.id and s.name like '%le';
