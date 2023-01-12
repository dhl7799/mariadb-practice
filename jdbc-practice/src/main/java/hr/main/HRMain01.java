package hr.main;

import java.util.List;
import java.util.Scanner;

import hr.dao.EmployeeDao;
import hr.vo.EmployeeVo;

public class HRMain01 {

	private static void FindByName(String keyword) {
		List<EmployeeVo> list = new EmployeeDao().findByName(keyword);
		for(EmployeeVo vo : list) {
			System.out.println(vo.getNo() + ":" + vo.getFirstName() + ":"
					+ vo.getLastName() + ":" + vo.getHireDate());
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("이름> ");
			String keyword = scanner.nextLine();
			if("quit".equals(keyword)) {
				break;
			}
			FindByName(keyword);
		}
		
		
		scanner.close();
	}

}
