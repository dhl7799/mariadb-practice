-- 문제1.
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
select count(*)
from salaries
where to_date = '9999-01-01' 
and salary>=(select avg(salary) from salaries where to_date = '9999-01-01');

-- 문제2. 
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다. 
select ett.사번 as '사번', ett.이름 as '이름', ett.부서 as '부서', ett.연봉 as '연봉'
from (select e.emp_no as '사번', concat(e.first_name, ' ', e.last_name) as '이름', d.dept_name as '부서', d.dept_no as '부서번호', s.salary as '연봉'
from employees e, departments d, salaries s, dept_emp de
where e.emp_no = s.emp_no and e.emp_no = de.emp_no and s.to_date = '9999-01-01' and de.to_date = '9999-01-01'
and de.dept_no = d.dept_no) as ett, (select nt.dn as '부서번호', Max(nt.sl) as '연봉'
from (select de.dept_no as dn, s.emp_no as en, s.salary as sl
from salaries s, dept_emp de
where s.to_date = '9999-01-01' and de.to_date = '9999-01-01' and s.emp_no = de.emp_no) as nt
group by 부서번호) ntt
where ett.연봉 = ntt.연봉 and ett.부서번호 = ntt.부서번호
order by 연봉 desc;


-- 문제3.
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요 

select nt2.사번 as '사번', nt2.이름 as '이름', nt2.연봉 as '연봉'
from (select nt.dn as '부서번호', nt.dtn as '부서', avg(nt.sl) as '평균연봉'
from (select de.dept_no as dn, s.emp_no as en, s.salary as sl, d.dept_name as dtn
from salaries s, dept_emp de, departments d
where d.dept_no = de.dept_no and s.to_date = '9999-01-01' and de.to_date = '9999-01-01' and s.emp_no = de.emp_no) as nt
group by 부서번호) nt1, (select e.emp_no as '사번', concat(e.first_name, ' ', e.last_name) as '이름', de.dept_no as '부서번호', s.salary as '연봉'
from employees e, dept_emp de, salaries s
where e.emp_no = de.emp_no and e.emp_no = s.emp_no and s.to_date = '9999-01-01') nt2
where nt1.부서번호 = nt2.부서번호 and nt2.연봉 >= nt1.평균연봉;

-- 문제4.
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.

select nt2.사번 as '사번', nt2.이름 as '이름', nt1.이름 as '매니저', nt2.부서 as '부서'
from (select concat(e.first_name, ' ', e.last_name) as '이름', dm.dept_no as '부서번호'
from employees e, dept_manager dm
where e.emp_no = dm.emp_no and dm.to_date = '9999-01-01') nt1, (select e.emp_no as '사번', concat(e.first_name, ' ', e.last_name) as '이름', de.dept_no as '부서번호', d.dept_name as '부서'
from employees e, dept_emp de, departments d
where e.emp_no = de.emp_no and de.dept_no = d.dept_no and de.to_date = '9999-01-01') nt2
where nt1.부서번호 = nt2.부서번호;

-- 문제5.
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.

select nt2.사번 as '사번', nt2.이름 as '이름', nt2.직책 as '직책', nt2.연봉 as '연봉', nt1.부서번호 as '부서번호'
from (select nt.dn as '부서번호', avg(nt.sl) as '연봉'
from (select de.dept_no as dn, s.emp_no as en, s.salary as sl
from salaries s, dept_emp de
where s.to_date = '9999-01-01' and de.to_date = '9999-01-01' and s.emp_no = de.emp_no) as nt
group by 부서번호
order by 연봉 desc limit 1) nt1, (select e.emp_no as '사번', concat(e.first_name, ' ', e.last_name) as '이름', t.title as '직책', s.salary as '연봉', de.dept_no as '부서번호'
from employees e, titles t, salaries s, dept_emp de
where e.emp_no = t.emp_no and t.to_date = '9999-01-01' and e.emp_no = s.emp_no and s.to_date = '9999-01-01' and e.emp_no = de.emp_no) nt2
where nt1.부서번호 = nt2.부서번호;

-- 문제6.
-- 평균 연봉이 가장 높은 부서는? 

select d.dept_name as '부서' from departments d, (select nt.dn as '부서번호', avg(nt.sl) as '연봉'
from (select de.dept_no as dn, s.emp_no as en, s.salary as sl
from salaries s, dept_emp de
where s.to_date = '9999-01-01' and de.to_date = '9999-01-01' and s.emp_no = de.emp_no) as nt
group by 부서번호
order by 연봉 desc limit 1) as nt1
where d.dept_no = nt1.부서번호;


-- 문제7.
-- 평균 연봉이 가장 높은 직책?

select ntt.직책 from (select nt1.직책 as '직책', avg(nt1.연봉) as '평균연봉'
from (select t.title as '직책', s.salary as '연봉'
from titles t, salaries s
where t.emp_no = s.emp_no and t.to_date = '9999-01-01' and s.to_date = '9999-01-01') nt1
group by 직책) ntt
order by ntt.평균연봉 desc
limit 1;

-- 문제8.
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.

-- 현재 직원의 사번, 이름, 연봉, 부서, 부서번호 테이블 nt1

select nt1.부서 as '부서', nt1.이름 as '이름', nt1.연봉 as '연봉', nt2.매니저_이름 as "매니저 이름", nt2.매니저_연봉 as "매니저_연봉"
from (select e.emp_no as '사번', concat(e.first_name, ' ', e.last_name) as '이름', s.salary as '연봉', d.dept_name as '부서', de.dept_no as '부서번호'
from employees e, salaries s, departments d, dept_emp de
where e.emp_no = s.emp_no and e.emp_no = de.emp_no and s.to_date = '9999-01-01' and de.to_date = '9999-01-01'
and d.dept_no = de.dept_no) nt1, (select dm.dept_no as '부서번호', concat(e.first_name, ' ', e.last_name) as '매니저_이름', s.salary as '매니저_연봉'
from dept_manager dm, employees e, salaries s
where dm.to_date = '9999-01-01' and dm.emp_no = e.emp_no and e.emp_no = s.emp_no and s.to_date = '9999-01-01') nt2
where nt1.부서번호 = nt2.부서번호 and nt1.연봉 >= nt2.매니저_연봉;

