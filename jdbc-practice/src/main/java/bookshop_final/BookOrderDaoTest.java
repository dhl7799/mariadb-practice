package bookshop_final;

import java.util.List;

import bookshop.example.Book;

public class BookOrderDaoTest {

	public static void main(String[] args) {
		BookOrderDao bod = new BookOrderDao();
		/*
		bod.insertBookOrder((long)1,"트와일라잇",(long)0);
		bod.insertBookOrder((long)2,"뉴문",(long)0);
		bod.insertBookOrder((long)3,"이클립스",(long)0);
		bod.insertBookOrder((long)4,"브레이킹던",(long)0);
		bod.insertBookOrder((long)5,"아리랑",(long)0);
		bod.insertBookOrder((long)6,"젊은그들",(long)0);
		bod.insertBookOrder((long)7,"아프니깐 청춘이다",(long)0);
		bod.insertBookOrder((long)8,"귀천",(long)0);
		bod.insertBookOrder((long)9,"태백산맥",(long)0);
		bod.insertBookOrder((long)10,"풀하우스",(long)0);*/
		List<BookOrderVo> list = bod.showAll();
		for(BookOrderVo vo : list) {
			System.out.println(vo.getBook_no() +", " + vo.getTitle() + "," + vo.getCount());
		}
	}

}
