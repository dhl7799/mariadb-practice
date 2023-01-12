package emaillist.main;

import java.util.List;
import java.util.Scanner;

import emaillist.dao.EmaillistDao;
import emaillist.vo.EmaillistVo;

public class EmaillistApp {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		while(true) {
			System.out.print("(l)ist (d)elete (i)nsert (q)uit >");
			String command = scanner.nextLine();
			if("l".equals(command)) {
				doFindAll();
			}
			else if("d".equals(command)) {
				doDelete();
			}
			else if("i".equals(command)) {
				doInsert();
			}
			else if("q".equals(command)) {
				break;
			}
			else {
				System.out.println("Try again, wrong Command");
			}
		}
		scanner.close();
	}

	private static void doDelete() {
		System.out.print("이메일:");
		String email = scanner.nextLine();
		
		new EmaillistDao().deleteByEmail(email);
		
	}

	public static void doFindAll() {
		List<EmaillistVo> list = new EmaillistDao().findAll();
		for(EmaillistVo vo : list) {
			System.out.println("이름:" + vo.getFirstName() + " " + vo.getLastName() + ", 이메일:" + vo.getEmail());
		}
	}
	private static void doInsert() {
		System.out.print("번호:");
		Long no = scanner.nextLong();
		System.out.print("이름:");
		String firstName = scanner.nextLine();
		System.out.print("성:");
		String lastName = scanner.nextLine();
		System.out.print("이메일:");
		String email = scanner.nextLine();
		
		EmaillistVo vo2 = new EmaillistVo();
		vo2.setNo(no);
		vo2.setFirstName(firstName);
		vo2.setLastName(lastName);
		vo2.setEmail(email);
		new EmaillistDao().insert(vo2);
	}
	
}
