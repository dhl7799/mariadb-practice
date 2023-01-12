package bookshop.vo;

public class BookVo {
	private Long no;
	private String title;
	private Long author_no;
	private String rent;
	
	
	@Override
	public String toString() {
		return "Book [no=" + no + ", title=" + title + ", auothor_no=" + author_no + ", rent=" + rent + "]";
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getAuthor_no() {
		return author_no;
	}
	public void setAuthor_no(Long author_no) {
		this.author_no = author_no;
	}
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
}
