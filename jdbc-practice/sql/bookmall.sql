desc cart;
desc category;
desc book;
delete from cart;
insert into category
value (null, '예술');
select * from book;
set sql_safe_updates=0;
ALTER TABLE book AUTO_INCREMENT=1;
delete from book;
select * from cart;
insert into cart values('donghyundhl@naver.com','트와일라잇',1,20000);
select * from cart where user_email = 'donghyundhl@naver.com';
select no, title, count, price from cart where user_email = 'donghyundhl@naver.com';
desc cart;
desc user;
delete from user;
insert into user
value ('donghyundhl@naver.com', '이동현', '010-5221-9705', '9558828');
select * from book where no = 1;
select * from book where category_no = 1;
select password from user
where email = 'aaaa@google.com';
delete from cart;
select * from book;

desc orders;