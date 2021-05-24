create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
    type_id int references type(id),
    expired_date timestamp,
    price int
);

insert into type(name) values ('Сыр');
insert into type(name) values ('Мороженое');
insert into type(name) values ('Молоко');

insert into product(name,type_id,expired_date,price) values('Сыр1', 1, '2021-05-30', 100);
insert into product(name,type_id,expired_date,price) values('Сыр2', 1, '2088-06-30', 120);
insert into product(name,type_id,expired_date,price) values('Сыр3', 1, '2021-05-25', 15);

insert into product(name,type_id,expired_date,price) values('Мороженое1', 2, '2021-06-10', 90);
insert into product(name,type_id,expired_date,price) values('Мороженое2', 2, '2021-12-3', 45);
insert into product(name,type_id,expired_date,price) values('Мороженое3', 2, '2021-10-3', 50);

insert into product(name,type_id,expired_date,price) values('Молоко1', 3, '2021-05-29', 51);
insert into product(name,type_id,expired_date,price) values('Молоко2', 3, '2021-05-28', 48);
insert into product(name,type_id,expired_date,price) values('Молоко3', 3, '2021-05-27', 38);

-- запрос на получение всех продуктов с типом "СЫР"
 select p.id, p.name, expired_date, price
 from product p join type t on p.type_id = t.id
 where t.name = 'Сыр';

-- запрос на получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product p where p.name like '%Мороженое%';

-- запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select p.name, p.expired_date
from product p
where date_part('month', p.expired_date) = date_part('month', now() + interval '1 month');

-- запрос, который выводит самый дорогой продукт.
select * from product order by price desc limit 1;

-- запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество
select t.name, count(t.id)
from product p join type t on t.id = p.type_id
group by t.name;

-- запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.id, p.name, type_id, expired_date, price
from product p join type t on p.type_id = t.id
where t.name = 'Сыр' or t.name = 'Молоко';

-- запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select t.name, count(type_id)
from product p join type t on p.type_id = t.id
group by t.name having count(type_id) < 10;

-- вывести все продукты и их тип.
select p.id, p.name, p.type_id, p.expired_date, p.price, t.name
from product p join type t on p.type_id = t.id;