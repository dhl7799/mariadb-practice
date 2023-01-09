select lpad('1234',10,'-'), rpad('1234', 10, '-');

-- 에제) 직원들의 월급을 오른쪽 정렬(빈공간 *)

select
concat('---', ltrim('     hello     '),'---'),
concat('---', rtrim('     hello     '),'---'),
concat('---', trim(leading 'x' from 'xxxxxxhelloxxxxxx'),'---'),
concat('---', trim(trailing 'x' from 'xxxxxxhelloxxxxxx'),'---'),
concat('---', trim(both 'x' from 'xxxxxxhelloxxxxxx'),'---');

select length('Hello World') from dual;