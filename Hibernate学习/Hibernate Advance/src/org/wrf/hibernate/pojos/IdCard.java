package org.wrf.hibernate.pojos;
	
public class IdCard {
	/*主键ID*/
	private String id;
	/*身份证编号*/
	private String cardNo;

	/*关联Customer*/
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
