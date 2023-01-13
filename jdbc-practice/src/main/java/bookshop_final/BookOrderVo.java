package bookshop_final;

public class BookOrderVo {
	private Long book_no;
	private String title;
	private Long count;
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "BookOrderVo [book_no=" + book_no + ", title=" + title + ", count=" + count + "]";
	}
	
	
}
