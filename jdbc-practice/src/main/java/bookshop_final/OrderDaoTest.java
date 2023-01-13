package bookshop_final;

import java.util.List;

public class OrderDaoTest {

	public static void main(String[] args) {
		OrderDao od = new OrderDao();
		List<OrderVo> list = od.showAll();
		for(OrderVo ov : list) {
			System.out.println(ov.getAddress()+", " +ov.getUsrName() + ", " +ov.getTotalPrice());
		}
	}

}
