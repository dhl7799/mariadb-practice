SELECT MAX(salary) as "최고임금", 
MIN(salary) as "최저임금", 
MAX(salary) - MIN(salary) as "최고임금 -최저임금"
from salaries;

SELECT date_format(MAX(from_date), '%Y년 %c월 %d일' ) as '입사일' from salaries;

-- period_diff(date_format(curdate(), '%y%m'), date_format(hire_date, '%y%m'))
SELECT date_format(from_date, '%Y년 %c월 %d일' ) as '입사일', to_date - from_date as '일수'
from salaries
order by from_date asc, to_date desc
limit 1;


select avg(salary) as '평균연봉' from salaries; 

select MAX(salary) as '최고연봉', MIN(salary) as '최저연봉' from salaries;

select DATEDIFF(CURDATE(),MIN(birth_date))/365 as '최연장자', 
DATEDIFF(CURDATE(),MAX(birth_date))/365 as '최고 어린 사원' from employees;

select concat(first_name, ' ', last_name) as '이름',
birth_date as '생일' ,
DATEDIFF(CURDATE(),birth_date)/365 as 나이 from employees
order by birth_date desc
limit 1;

-- select concat(first_name, ' ', last_name) as '이름',
-- DATEDIFF(CURDATE(),birth_date)/365 as 나이 from employees
-- having MAX(나이); 이거 안되는듯....

-- select concat(first_name, ' ', last_name) as '이름',
-- (DATEDIFF(CURDATE(),birth_date)/365) as 나이 from employees
-- having MIN(나이);

-- select concat(first_name, ' ', last_name) as '이름', DATEDIFF(CURDATE(),MAX(birth_date))/365 as '나이'
-- from employees 
-- order by birth_date asc
-- limit 1;



