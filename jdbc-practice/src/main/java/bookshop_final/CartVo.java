package bookshop_final;

public class CartVo {
	private Long no;
	private String user_email;
	private String title;
	private Long count;
	private Long price;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getUser_Email() {
		return user_email;
	}
	public void setUser_Email(String user_email) {
		this.user_email = user_email;
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
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Cart [no="+ no + ", user_email=" + user_email + ", title=" + title + ", count=" + count + ", price=" + price + "]";
	}
	
}
