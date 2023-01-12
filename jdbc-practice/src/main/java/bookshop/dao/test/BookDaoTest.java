package bookshop.dao.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


import bookshop.dao.BookDao;
import bookshop.example.Book;
import bookshop.vo.AuthorVo;
import bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		testInsert();
		testFindAll();
	}
	private static void testFindAll() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo a: list) {
			System.out.println(a);
		}
	}

	private static void testInsert() {
		
		BookVo vo = null;
		BookDao dao = new BookDao();
		
		vo = new BookVo();
		vo.setTitle("트와일라잇");
		vo.setAuthor_no((long)19);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("뉴문");
		vo.setAuthor_no((long)19);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("이클립스");
		vo.setAuthor_no((long)19);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("브레이킹던");
		vo.setAuthor_no((long)19);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("아리랑");
		vo.setAuthor_no((long)20);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("젊은그들");
		vo.setAuthor_no((long)21);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("아프니깐 청춘이다");
		vo.setAuthor_no((long)22);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("귀천");
		vo.setAuthor_no((long)23);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("태백산맥");
		vo.setAuthor_no((long)20);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("풀하우스");
		vo.setAuthor_no((long)24);
		dao.insert(vo);


	}
	
	

}
