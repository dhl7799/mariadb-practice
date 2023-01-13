package bookshop_final;

import java.util.List;

public class CategoryDaoTest {

	public static void main(String[] args) {
		CategoryDao cg = new CategoryDao();
		cg.addCategory("소설");
		cg.addCategory("수필");
		cg.addCategory("컴퓨터/IT");
		cg.addCategory("인문");
		cg.addCategory("경제");
		cg.addCategory("예술");
		
		List<CategoryVo> list = cg.getCategory();
		for(CategoryVo vo : list) {
			System.out.println(vo.getNo() +", " + vo.getCategoryName());
		}
	}

}
