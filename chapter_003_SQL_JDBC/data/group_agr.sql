create table students(
    id serial primary key,
    name varchar(255)
);

create table subjects(
    id serial primary key,
    name varchar(255)
);

create table students_subjects(
    id serial primary key,
    student_id int references students(id),
    subject_id int references subjects(id),
    mark int
);

insert into students(name) values ('Аня');
insert into students(name) values ('Ваня');
insert into students(name) values ('Боря');

insert into subjects(name) values ('Математика');
insert into subjects(name) values ('Русский');
insert into subjects(name) values ('Информатика');

insert into students_subjects(student_id, subject_id, mark) values (1, 1, 5);
insert into students_subjects(student_id, subject_id, mark) values (1, 2, 5);
insert into students_subjects(student_id, subject_id, mark) values (1, 3, 5);

insert into students_subjects(student_id, subject_id, mark) values (2, 1, 5);
insert into students_subjects(student_id, subject_id, mark) values (2, 2, 4);
insert into students_subjects(student_id, subject_id, mark) values (2, 3, 4);

insert into students_subjects(student_id, subject_id, mark) values (3, 1, 3);
insert into students_subjects(student_id, subject_id, mark) values (3, 2, 5);
insert into students_subjects(student_id, subject_id, mark) values (3, 3, 3);

select avg(mark) from students_subjects;
select min(mark) from students_subjects;
select max(mark) from students_subjects;

select s.name, avg(ss.mark) from students_subjects ss join subjects s on ss.subject_id = s.id
group by s.name;

select s.name, avg(ss.mark) from students_subjects ss join students s on ss.student_id = s.id
group by s.name;

select s.name, avg(ss.mark) from students_subjects ss join subjects s on ss.subject_id = s.id
group by s.name
having avg(ss.mark) > 4.5;