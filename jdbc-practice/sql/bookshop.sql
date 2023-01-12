-- bookshop
desc book;
desc author;
desc emaillist;
set sql_safe_updates=0;

insert into book values(null, '제목', 5, 'Y');

delete from author;
select * from book;

select * from author
order by no;