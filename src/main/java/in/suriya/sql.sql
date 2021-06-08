create table staff(
name varchar(50) not null,
mob_no bigint not null unique,
password varchar(50) not null unique
);

insert into staff (name,mob_no,password) values('Harish',9003750359,'Harish1#');
insert into staff (name,mob_no,password) values('Suriya',9500500452,'Suriya1@');


select *from staff;
delete from staff;
drop table staff;


create table student(
roll_no bigint not null unique,
mob_no bigint not null,
fee_structure int not null default 1,
fee int not null,
payment_status varchar(20) default 'NOTPAID'
);

insert into student(roll_no,mob_no,fee) values('1712114',9500500451,75000);
insert into student(roll_no,mob_no,fee) values('1712113',9003750351,60000);

select *from student;
delete from student;
drop table student;



create table librarian(
user_name varchar(50) not null unique,
password varchar(50) not null unique
);


insert into librarian (user_name,password)values('admin','Librarian1@');


select *from librarian;



create table library(
book_id int not null,
book_name varchar(50) not null unique,
quantity int not null,
);

insert into library (book_id,book_name,quantity)values('10243','physics',4);
insert into library (book_id,book_name,quantity)values('10244','geometry',3);
insert into library (book_id,book_name,quantity)values('10245','chemistry',5);
insert into library (book_id,book_name,quantity)values('10246','cryptocurrency',2);
insert into library (book_id,book_name,quantity)values('10247','trignometry',1);
insert into library (book_id,book_name,quantity)values('10248','zoology',1);
insert into library (book_id,book_name,quantity)values('10249','biology',2);


create table enrolled_book(
book_id int not null,
book_name varchar(100) not null,
roll_no bigint not null,
mob_no bigint not null,
enrolled_date date default current_date	
);

select *from enrolled_book;
drop table enrolled_book;
insert into enrolled_book(book_id,book_name,roll_no,mob_no)  select l.book_id,l.book_name,s.rollno,s.mobno from student s,library l where s.rollno=1712115 and l.book_id=10243 and 1712115 not in(select (roll_no) from enrolled_book where roll_no=1712115 and book_id=10243);


