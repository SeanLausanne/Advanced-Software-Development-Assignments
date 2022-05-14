package service;

public class DeliveryInfo implements Information {

	private int count;
	private String item;
	private String account;

	// 2 constructors for shipping and receiving
	public DeliveryInfo(String item, int count) {
		this.count = count;
		this.item = item;
		this.account = null;
	}

	public DeliveryInfo(String item, String account, int count) {
		this.count = count;
		this.item = item;
		this.account = account;
	}

	public String getItem() {
		return this.item;
	}

	public int getCount() {
		return this.count;
	}

	public String getAccount() {
		return this.account;
	}
}
