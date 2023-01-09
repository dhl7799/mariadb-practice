select date_format(now(),'%Y년 %m월%d일 %h시 %i분 %s초') from dual;
select date_format(now(),'%d %b \ %y %h:%i:%s') from dual;

select first_name, hire_date,
period_diff(date_format(curdate(), '%y%m'), date_format(hire_date, '%y%m')) as month
from employees;

-- date_aff(==adddate), date_sub(subdate)
-- 날짜를 date 타입의 컬럼이나 값에 type의 표현식으로 더하거나 뺄수있음
-- 예) 각 사원의 근속 년수가 5년이 되는 날에 휴가를 보내준다면 각 사원의 근속 휴가 날짜는?

select first_name,
hire_date,
date_add(hire_date, interval 5 month) as '근속휴가날' 
from employees;

-- cast

select '12345' + 10, cast('12345' as int) from dual;

select date_format(cast('2023-01-09' as date), '%Y년 %m월 %d일') as '날짜' from dual;

select cast(cast(1-2 as unsigned) as integer) from dual;