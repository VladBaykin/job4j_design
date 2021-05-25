create table cities(
    id serial primary key,
    name text,
    population int
);

insert into cities(name, population) values('city', 1000);