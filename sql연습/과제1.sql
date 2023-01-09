show tables;

select * from employees where emp_no = '10944';

select concat(first_name, ' ', last_name) as '이름', 
gender as '성별', 
hire_date as '입사일' 
from employees;

select gender, count(*) from employees group by gender;

select count(*) from salaries where to_date > '2023-01-01';

select count(*) from departments;

select distinct count(*) from dept_manager;

select dept_name from departments order by CHAR_LENGTH(dept_name) desc;

select count(*) from salaries where salary >= 120000;

select distinct title from titles order by CHAR_LENGTH(title) desc;

select count(*) from titles where title = 'Engineer';

select title, from_date, to_date from titles where emp_no = 13250 order by from_date;


