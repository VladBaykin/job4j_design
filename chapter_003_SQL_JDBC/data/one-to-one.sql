-- получать паспорт по человеку
create table passport(
    id serial primary key,
    seria int,
    number int
);

create table people(
    id serial primary key,
    name varchar(255),
    passport_id int references passport(id) unique
);

-- получить данные человека по паспорту и паспорт по человеку
create table passport(
    id serial primary key,
    seria int,
    number int
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table passport_people(
    id serial primary key,
    passport_id int references passport(id) unique,
    people_id int references people(id) unique
);