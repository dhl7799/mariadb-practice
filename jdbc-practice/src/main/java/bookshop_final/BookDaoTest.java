package bookshop_final;

import java.util.List;
import java.util.Scanner;

public class BookDaoTest {
		
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		BookDao db = new BookDao();
		
		/*
		System.out.println("원하시는 상품 번호를 선택해 장바구니에 담아주세요");
		int obNum = Integer.parseInt(scanner.nextLine());
		BookVo book = bd.findBookByNo((long)obNum);
		System.out.println("몇개를 담으시겠습니까");
		int obCount = Integer.parseInt(scanner.nextLine());
		//상품 obNum 카트에 obCount만큼 담기 기능
		CartDao cd = new CartDao();
		cd.putInCart("donghyundhl@naver.com", book, obCount);
		System.out.println("상품을 장바구니에 담았습니다.");*/
		/*
		BookDao db = new BookDao();
		
		List<CategoryVo> list = new CategoryDao().getCategory();
		for(CategoryVo cv : list) {
			System.out.println(cv.getNo()+". " + cv.getCategoryName());
		}
		System.out.print("원하는 카테고리 번호를 고르세요(나가려면 -1)>>");
		int cat = Integer.parseInt(scanner.nextLine());
		List<BookVo> blist = null;
		blist = new BookDao().findBookByCategory((long)cat);
		for(BookVo bv : blist) {
			System.out.println("책 번호: " + bv.getNo());
			System.out.println("책 제목: " + bv.getTitle());
			System.out.println("가격: " + bv.getPrice());
		}
		*/
		BookVo book1 = new BookVo();
		book1.setTitle("트와일라잇");
		book1.setPrice((long)20000);
		book1.setCategoryNo((long)1);
		db.insertBook(book1);
		
		BookVo book2 = new BookVo();
		book2.setTitle("뉴문");
		book2.setPrice((long)22000);
		book2.setCategoryNo((long)1);
		db.insertBook(book2);
		
		BookVo book3 = new BookVo();
		book3.setTitle("이클립스");
		book3.setPrice((long)30000);
		book3.setCategoryNo((long)2);
		db.insertBook(book3);
		
		BookVo book4 = new BookVo();
		book4.setTitle("브레이킹던");
		book4.setPrice((long)15000);
		book4.setCategoryNo((long)2);
		db.insertBook(book4);
		
		BookVo book5 = new BookVo();
		book5.setTitle("아리랑");
		book5.setPrice((long)18000);
		book5.setCategoryNo((long)3);
		db.insertBook(book5);
		
		BookVo book6 = new BookVo();
		book6.setTitle("젊은그들");
		book6.setPrice((long)12000);
		book6.setCategoryNo((long)4);
		db.insertBook(book6);
		
		BookVo book7 = new BookVo();
		book7.setTitle("아프니깐 청춘이다");
		book7.setPrice((long)50000);
		book7.setCategoryNo((long)5);
		db.insertBook(book7);
		
		BookVo book8 = new BookVo();
		book8.setTitle("귀천");
		book8.setPrice((long)23000);
		book8.setCategoryNo((long)6);
		db.insertBook(book8);
		
		BookVo book9 = new BookVo();
		book9.setTitle("태백산맥");
		book9.setPrice((long)13500);
		book9.setCategoryNo((long)6);
		db.insertBook(book9);
		
		BookVo book10 = new BookVo();
		book10.setTitle("풀하우스");
		book10.setPrice((long)9000);
		book10.setCategoryNo((long)5);
		db.insertBook(book10);
		
		List<BookVo> list = db.findAllBooks();
		for(BookVo bv : list) {
			System.out.println(bv.getNo() + ", " + bv.getTitle() + ", " + bv.getPrice() + ", " + bv.getCategoryNo());
		}
	}

}
