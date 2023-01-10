select version(), current_date, now() from dual;

-- 수학함수, 사칙 연산도 된다.
select sin(pi() / 4), 1 + 2 * 3 - 4 / 5 from dual;

-- 대소문자 구분 안한다.
sElect VERSION(), current_DATE, NOW() froM dual;

drop table pet;
-- table 생성: DDL
create table pet (
	name varchar(100),
	owner varchar(20),
	species varchar(20),
	gender char(1),
	birth date,
	death date
);

-- schema 확인
describe pet;
desc pet;

-- table 삭제: DDLdrop table pet;
show tables;

-- insert: DML(C)
insert
  into pet
values ('성탄이', '안대혁', 'dog', 'm', '2007-12-25', null);
insert
  into pet
values ('성탄이2', '안대혁', 'dog', 'm', '2007-12-25', null);
insert
  into pet
values ('성탄이3', '안대혁', 'dog', 'm', '2007-12-25', '2020-12-25');

-- select: DML(R)
select * from pet;
set sql_safe_updates=0;


-- update: DML(U)
update pet
   set name='성탄이4'
 where death = '2020-12-25'; 

-- delete: DML(D)
delete from pet where name = '성타니';

-- load data
-- load data local infile 'd:\pet.txt' into table pet;

-- select
select name, species from pet where name = '성타니';


select name, species, gender
	from pet
	where species = 'dog'
    and gender = 'f';


select name, species
	from pet
    where species = 'snake'
    or species = 'bird';
    
select name, species, birth
	from pet
order by name desc;

select name, birth, death
	from pet
    where death is not null;
    
select name
	from pet
	where name like '%____%';
    
select count(*)
	from pet
    where death is not null;