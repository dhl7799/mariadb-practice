package bookshop_final;

public class CategoryVo {
	private Long no;
	private String categoryName;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [no=" + no + ", categoryName=" + categoryName + "]";
	}
	
}
