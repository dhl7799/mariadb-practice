package bookshop_final;

import java.util.List;
import java.util.Scanner;

public class BookMall {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		UserVo user = null;
		boolean notDone = true;
		while(notDone) {
			System.out.print("1. 로그인 2. 회원가입(간단테스트는 BookMallTest에서)>");
			int select = Integer.parseInt(scanner.nextLine());
			if(select == 1) {
				user = signIn();
				System.out.println("로그인 되었습니다.");
				notDone = false;
			}
			else if(select == 2) {
				signUp();
				System.out.println("가입하신 이메일로 로그인 해주세요.");
			}
			else {
				System.out.println("다시 입력해주세요.");
			}
		}
		
		while(true) {
			System.out.println("1. 카테고리 확인 2. 장바구니 담기 3. 내 장바구니 확인 4. 장바구니에서 빼기 5. 결제하기 6. 나가기");
			System.out.print("무엇을 하시겠습니까?>");
			int choose = Integer.parseInt(scanner.nextLine());
			switch(choose){
				case 1: showCategory();
					break;
				case 2: selectBook(user);
					break;
				case 3: showCart(user);
					break;
				case 4: removeFromCart(user);
					break;
				case 5: order(user);
					break;
				case 6: quit();
				    break;
			}

		}
	}
	



	private static void signUp() {
		UserVo vo = new UserVo();
		System.out.print("Email>");
		vo.setEmail(scanner.nextLine());
		System.out.print("Name>");
		vo.setName(scanner.nextLine());
		System.out.print("PhoneNumber>");
		vo.setPhoneNumber(scanner.nextLine());
		
		boolean done = false;
		while(!done) {
			String password1 = null;
			String password2 = null;
			System.out.print("Password>");
			password1 = scanner.nextLine();
			System.out.print("한번더 Password>");
			password2 = scanner.nextLine();
			if(password1.equals(password2)) {
				System.out.println("회원가입 완료");
				vo.setPassword(password1);
				done = true;
			}
			else {
				System.out.println("입력하신 비밀번호가 서로 다릅니다. 다시 입력해주세요");
			}
		}
		
		new UserDao().SignUp(vo);
	}



	private static UserVo signIn() {
		UserVo user = new UserVo();
		System.out.print("Email>");
		user.setEmail(scanner.nextLine());
		UserDao ud = new UserDao();
		String password = ud.getPassword(user.getEmail());
		boolean done = false;
		int count = 5;
		while(!done) {
			System.out.print("Password>");
			user.setPassword(scanner.nextLine());
			if(user.getPassword().equals(password)) {
				done = true;
			}
			else {
				count--;
				if(count >0) {
					System.out.println("비밀번호를 다시 입력해주세요");
					System.out.println("5회 잘못입력시 종료, 남은횟수 " + count +"회");
				}
				else {
					System.out.println("비밀번호 오류 횟수 5회 초과");
					System.exit(0);
				}
			}
		}
		ud.getUserInfo(user,user.getEmail(),user.getPassword());
		return user;
	}



	private static void quit() {
		System.exit(0);
	}
	private static void order(UserVo user) {
		Long price = getTotalPrice(user);
		System.out.print("수령하실 주소를 입력하여주세요>");
		String address = scanner.nextLine();
		new OrderDao().insertOrder(user.getName(), price, address);
		putBooksInBookOrder(user);
		System.out.println(price + "원이 결제되었습니다");
		new CartDao().deleteAllFromCart(user.getEmail());
	}
	
	private static Long getBookNumByTitle(String title) {
		BookVo vo = new BookDao().findBookByTitle(title);
		return vo.getNo();
	}

	private static void putBooksInBookOrder(UserVo user) {
		List<CartVo> list = new CartDao().printMyCart(user.getEmail());
		BookOrderDao bod = new BookOrderDao();
		for(CartVo vo : list) {
			bod.addBookOrder(getBookNumByTitle(vo.getTitle()), vo.getTitle(), vo.getCount());
		}
		
	}
	
	private static Long getTotalPrice(UserVo user) {
		Long sum = (long)0;
		List<CartVo> list = new CartDao().printMyCart(user.getEmail());
		for(CartVo vo: list) {
			sum += vo.getPrice();
		}
		return sum;
	}
	
	private static void showCart(UserVo user) {
		List<CartVo> list = new CartDao().printMyCart(user.getEmail());
		for(CartVo vo: list) {
			System.out.println("제목:" + vo.getTitle() +" "+ vo.getCount()+"권 " + "금액:" + vo.getPrice());
		}
	}
	
	
	private static void showCategory() {
		
		List<CategoryVo> list = new CategoryDao().getCategory();
		for(CategoryVo cv : list) {
			System.out.println(cv.getNo()+". " + cv.getCategoryName());
		}
		System.out.print("원하는 카테고리 번호를 고르세요(나가려면 -1)>>");
		int cat = Integer.parseInt(scanner.nextLine());
		List<BookVo> blist = null;
		blist = new BookDao().findBookByCategory((long)cat);
		printBooks(blist);
	}
	
	private static void printBooks(List<BookVo> books) {
		for(BookVo bv : books) {
			System.out.println("책 번호: " + bv.getNo());
			System.out.println("책 제목: " + bv.getTitle());
			System.out.println("가격: " + bv.getPrice());
		}
	}
	
	private static void selectBook(UserVo user) {
		BookDao bd = new BookDao();
		System.out.println("원하시는 상품 번호를 선택해 장바구니에 담아주세요");
		int obNum = Integer.parseInt(scanner.nextLine());
		BookVo book = bd.findBookByNo((long)obNum);
		System.out.println("몇개를 담으시겠습니까");
		int obCount = Integer.parseInt(scanner.nextLine());
		//상품 obNum 카트에 obCount만큼 담기 기능
		CartDao cd = new CartDao();
		cd.putInCart(user.getEmail(), book, obCount);
		System.out.println("상품을 장바구니에 담았습니다.");
	}
	
	private static void removeFromCart(UserVo user) {
		BookDao bd = new BookDao();
		System.out.println("제거하실 상품 번호를 선택해주세요");
		int obNum = Integer.parseInt(scanner.nextLine());
		BookVo book = bd.findBookByNo((long)obNum);
		System.out.println("몇개를 제거하시겠습니까");
		int obCount = Integer.parseInt(scanner.nextLine());
		//상품 obNum 카트에 obCount만큼 담기 기능
		CartDao cd = new CartDao();
		cd.deleteFromCart(user.getEmail(), book, obCount);
		System.out.println("상품을 장바구니에서 제외하였습니다.");
		
	}
}



