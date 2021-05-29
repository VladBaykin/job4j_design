CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer,
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values (1, 'company1');
insert into company(id, name) values (2, 'company2');
insert into company(id, name) values (3, 'company3');
insert into company(id, name) values (4, 'company4');
insert into company(id, name) values (5, 'company5');

insert into person(id, name, company_id) values (1, 'name1', 1);
insert into person(id, name, company_id) values (2, 'name2', 2);
insert into person(id, name, company_id) values (3, 'name3', 3);
insert into person(id, name, company_id) values (4, 'name4', 4);
insert into person(id, name, company_id) values (5, 'name5', 5);
insert into person(id, name, company_id) values (6, 'name6', 1);
insert into person(id, name, company_id) values (7, 'name7', 1);

select * from company;
select * from person;

-- 1. В одном запросе получить
-- - имена всех person, которые не состоят в компании с id = 5;
-- - название компании для каждого человека.
select p.name person, c.name company
from person p join company c on p.company_id = c.id
where p.company_id <> 5;

-- 2. Необходимо выбрать название компании с максимальным количеством человек + количество человек в этой компании.
select c.name company, count(c.name) person_count
from person p join company c on p.company_id = c.id
group by c.name
order by person_count desc
limit 1;
