package bookshop.example;

public class Book {
	private int bookNo;
	private String title;
	private String author;
	private int stateCode;

	public Book(int n, String title, String author) {
		this.bookNo = n;
		this.title = title;
		this.author = author;
		stateCode = 1;
	}
	
	public void displayBookInfo() {
		String bishere = "재고있음";
		if(this.stateCode == 0)
			bishere = "대여중";
		System.out.println("책 제목:" + this.title +", 작가:" + this.author + ", 대여 유무:" + bishere);
	}
	
	public void rent() {
		this.stateCode = 0;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
