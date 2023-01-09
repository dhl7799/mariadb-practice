-- 집계 avg,max, min count cum stddev varrance

select avg(salary), sum(salary)
from salaries;


-- select 절에 그룹함수가 있는 경우 어떤 컬럼도 select절에 올수 없다
select emp_no, avg(salary)
from salaries;


-- query 순서
-- 1) from: 접근 테이블 확인
-- 2) where: 조건에 맞는 row를 선택 (임시 테이블)
-- 3) 집계 (결과 테이블)
-- 4) projection을 함
-- 에제: 사번이 10060인 사원이 받은 평균 월급은? 

select avg(salary)
from salaries
where emp_no = '10060';


-- 예제: 모든 사원이 받은 평균 월급은?
select emp_no, avg(salary)
from salaries
group by emp_no; 


-- group by에 참여하고 있는 컬럼은 프로젝션이 가능하다

-- 예제: 평균 월급이 6만달러 이상인 사원의 사번과 평균 월급 출력
-- where절 끝난곳에
-- group by 끝난 결과 테이블에서 끄집어 내오는게 having
select emp_no, avg(salary)
from salaries
group by emp_no
having avg(salary)>= 60000;