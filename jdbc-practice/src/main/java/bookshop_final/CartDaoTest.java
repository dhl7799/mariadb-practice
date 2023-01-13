package bookshop_final;

import java.util.List;
import java.util.Scanner;

public class CartDaoTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		CartDao cd = new CartDao();
		BookDao bd = new BookDao();
		System.out.println("원하시는 상품 번호를 선택해 장바구니에 담아주세요");
		int obNum = Integer.parseInt(scanner.nextLine());
		BookVo book = bd.findBookByNo((long)obNum);
		System.out.println("몇개를 담으시겠습니까");
		int obCount = Integer.parseInt(scanner.nextLine());
		//상품 obNum 카트에 obCount만큼 담기 기능
		cd.putInCart("donghyundhl@naver.com", book, obCount);
		/*Long sum = (long)0;
		List<CartVo> list = new CartDao().printMyCart("donghyundhl@naver.com");
		for(CartVo vo: list) {
			sum += vo.getPrice();
		}
		System.out.println(sum +"원이 결제되었습니다.");
		*/
	}

}
