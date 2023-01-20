package bookshop_final;

import java.util.List;

public class BookMallTest {

	public static void main(String[] args) {
		UserDao ud = new UserDao();
		UserVo user1 = new UserVo();
		user1.setEmail("dooly@gmail.com");
		user1.setName("둘리");
		user1.setPassword("1234");
		user1.setPhoneNumber("010-1111-2222");
		UserVo user2 = new UserVo();
		user2.setEmail("ddochi@gmail.com");
		user2.setName("또치");
		user2.setPassword("1234");
		user2.setPhoneNumber("010-2222-3232");
		UserVo user3 = new UserVo();
		user3.setEmail("michael@gmail.com");
		user3.setName("마이콜");
		user3.setPassword("1234");
		user3.setPhoneNumber("010-5353-8888");
		ud.SignUp(user1);
		ud.SignUp(user2);
		ud.SignUp(user3);

		CategoryDao cg = new CategoryDao();
		cg.addCategory("소설");
		cg.addCategory("수필");
		cg.addCategory("컴퓨터/IT");
		cg.addCategory("인문");
		cg.addCategory("경제");
		cg.addCategory("예술");

		BookDao db = new BookDao();
		BookVo book1 = new BookVo();
		book1.setTitle("트와일라잇");
		book1.setPrice((long) 20000);
		book1.setCategoryNo((long) 1);
		db.insertBook(book1);

		BookVo book2 = new BookVo();
		book2.setTitle("뉴문");
		book2.setPrice((long) 22000);
		book2.setCategoryNo((long) 1);
		db.insertBook(book2);

		BookVo book3 = new BookVo();
		book3.setTitle("이클립스");
		book3.setPrice((long) 30000);
		book3.setCategoryNo((long) 2);
		db.insertBook(book3);

		BookVo book4 = new BookVo();
		book4.setTitle("브레이킹던");
		book4.setPrice((long) 15000);
		book4.setCategoryNo((long) 2);
		db.insertBook(book4);

		BookVo book5 = new BookVo();
		book5.setTitle("아리랑");
		book5.setPrice((long) 18000);
		book5.setCategoryNo((long) 3);
		db.insertBook(book5);

		BookVo book6 = new BookVo();
		book6.setTitle("젊은그들");
		book6.setPrice((long) 12000);
		book6.setCategoryNo((long) 4);
		db.insertBook(book6);

		BookVo book7 = new BookVo();
		book7.setTitle("아프니깐 청춘이다");
		book7.setPrice((long) 50000);
		book7.setCategoryNo((long) 5);
		db.insertBook(book7);

		BookVo book8 = new BookVo();
		book8.setTitle("귀천");
		book8.setPrice((long) 23000);
		book8.setCategoryNo((long) 6);
		db.insertBook(book8);

		BookVo book9 = new BookVo();
		book9.setTitle("태백산맥");
		book9.setPrice((long) 13500);
		book9.setCategoryNo((long) 6);
		db.insertBook(book9);

		BookVo book10 = new BookVo();
		book10.setTitle("풀하우스");
		book10.setPrice((long) 9000);
		book10.setCategoryNo((long) 5);
		db.insertBook(book10);
		
		CartDao cd = new CartDao();
		cd.putInCart(user1.getEmail(), book1, 10);
		cd.putInCart(user2.getEmail(), book3, 20);
		cd.putInCart(user3.getEmail(), book7, 99);
		
		OrderDao od = new OrderDao();
		od.insertOrder(user1.getName(), 1000000L, "우리집");
		od.insertOrder(user2.getName(), 2131242353L, "자취방");
		od.insertOrder(user3.getName(), 4324241L, "시골집");
		
		BookOrderDao bod = new BookOrderDao();
		bod.insertBookOrder((long) 1, "트와일라잇", (long) 0);
		bod.insertBookOrder((long) 2, "뉴문", (long) 0);
		bod.insertBookOrder((long) 3, "이클립스", (long) 0);
		bod.insertBookOrder((long) 4, "브레이킹던", (long) 0);
		bod.insertBookOrder((long) 5, "아리랑", (long) 0);
		bod.insertBookOrder((long) 6, "젊은그들", (long) 0);
		bod.insertBookOrder((long) 7, "아프니깐 청춘이다", (long) 0);
		bod.insertBookOrder((long) 8, "귀천", (long) 0);
		bod.insertBookOrder((long) 9, "태백산맥", (long) 0);
		bod.insertBookOrder((long) 10, "풀하우스", (long) 0);

		// 회원리스트 - 2명이상

		List<UserVo> ulist = ud.getAllUserInfo();
		System.out.println("User Info");
		for (UserVo vo : ulist) {
			System.out.println(
					vo.getEmail() + ", " + vo.getName() + ", " + vo.getPassword() + ", " + vo.getPhoneNumber());
		}

		// 카테고리 리스트 - 3개이상

		System.out.println("Category Info");
		List<CategoryVo> clist = cg.getCategory();
		for (CategoryVo vo : clist) {
			System.out.println(vo.getNo() + ", " + vo.getCategoryName());
		}

		// 상품 리스트 - 3개이상

		System.out.println("Book Info");
		List<BookVo> list = db.findAllBooks();
		for (BookVo bv : list) {
			System.out.println(bv.getNo() + ", " + bv.getTitle() + ", " + bv.getPrice() + ", " + bv.getCategoryNo());
		}

		// 카트 리스트 - 2개
		List<CartVo> clist1 = cd.printMyCart(user1.getEmail());
		List<CartVo> clist2 = cd.printMyCart(user2.getEmail());
		List<CartVo> clist3 = cd.printMyCart(user3.getEmail());
		
		System.out.println("Cart Info");
		for (CartVo vo : clist1) {
			System.out.println(vo.getNo() + ", " + vo.getTitle() + ", " + vo.getCount() + ", " +vo.getPrice());
		}
		for (CartVo vo : clist2) {
			System.out.println(vo.getNo() + ", " + vo.getTitle() + ", " + vo.getCount() + ", " +vo.getPrice());
		}
		for (CartVo vo : clist3) {
			System.out.println(vo.getNo() + ", " + vo.getTitle() + ", " + vo.getCount() + ", " +vo.getPrice());
		}
		
		// 주문 리스트 - 1개
		System.out.println("Order Info");
		List<OrderVo> olist = od.showAll();
		for(OrderVo ov : olist) {
			System.out.println(ov.getAddress()+", " +ov.getUsrName() + ", " +ov.getTotalPrice());
		}
		
		// 주문 도서 리스트 - 2개
		List<BookOrderVo> blist = bod.showAll();
		System.out.println("BookOrder Info");
		for (BookOrderVo vo : blist) {
			System.out.println(vo.getBook_no() + ", " + vo.getTitle() + ", " + vo.getCount());
		}
	}

}
