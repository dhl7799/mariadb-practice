-- inner join


select *
from employees a
join titles b
on a.emp_no = b.emp_no
and b.to_date = '9999-01-01';

select *
from employees a,
titles b
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01';