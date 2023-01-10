drop table member;
create table member(
	no int not null auto_incremenmt,
    email varchar(100) not null,
    password varchar(64) not null,
    name varchar(100) not null,
    department varchar(100),
    primary key(no)
);

desc member;

alter table member add column juminbunho char(13) not null;