package bookshop_final;

import java.util.List;



public class UserDaoTest {

	public static void main(String[] args) {
		UserVo vo = new UserVo();
		vo.setEmail("aaaa@google.com");
		vo.setName("둘리");
		vo.setPhoneNumber("010-1111-2222");
		vo.setPassword("8828");
		//testInsert(vo);
		String gotPass = trySignIn(vo.getEmail());
		if(gotPass.equals(vo.getPassword())) {
			System.out.println(vo.getName() +"님이 로그인 하셨습니다,");
		}
		else
		{
			System.out.println("비밀번호 오류");
		}

	}
	
	
	public static String trySignIn(String email) {
		String password = new UserDao().getPassword(email);
		return password;
	}

	public static void testInsert(UserVo vo) {
	    new UserDao().SignUp(vo);;
		
	}

}
