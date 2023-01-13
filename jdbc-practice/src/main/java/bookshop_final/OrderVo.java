package bookshop_final;

public class OrderVo {
	private Long no;
	private String usrName;
	private Long totalPrice;
	private String address;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Order [no=" + no + ", usrName=" + usrName + ", totalPrice=" + totalPrice + ", address=" + address + "]";
	}
	
}
