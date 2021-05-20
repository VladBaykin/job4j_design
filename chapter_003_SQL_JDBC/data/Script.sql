create table smartphone(
	id serial primary key,
	name varchar(255),
	price integer,
	in_stock boolean,
);

insert into smartphone(name, integer, in_stock) values('Pixel', 500, false);
select * from product;
update smartphone set in_stock = true;
delete from smartphone;