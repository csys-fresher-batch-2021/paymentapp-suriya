create table staff(
name varchar(50) not null,
mobno bigint not null unique,
password varchar(50) not null unique
);

insert into staff (name,mobno,password) values('Harish',9003750359,'Harish1#');
insert into staff (name,mobno,password) values('Suriya',9500500452,'Suriya1@');


select *from staff;
delete from staff;
drop table staff;


create table student(
rollno bigint not null unique,
mobno bigint not null,
fee int not null,
payment_status varchar(20) default 'Not_paid'
);

insert into student(rollno,mobno,fee) values('1712114',9500500451,75000);
insert into student(rollno,mobno,fee) values('1712113',9003750351,60000);


select *from student;
delete from student;
drop table student;
