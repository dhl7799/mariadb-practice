-- explore datas....

show tables;

select count(*) from employees;

select * from departments;

select dept_no, dept_name from departments;

-- as(alias, 생략가능)
select first_name as '이름', gender as '성별', hire_date as '입사 일' from employees;

select concat(first_name, ' ', last_name) as '이름', 
gender as '성별', 
hire_date as '입사 일' 
from employees;

select count(*) from titles;

select count(*) from salaries;

select distinct title from titles;