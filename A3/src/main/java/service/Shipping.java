package service;

import staff.Employee;
import staff.EmployeeManager;

public class Shipping implements Service {
	
	private EmployeeManager manager;
	private Information shippingInfo;

	public Shipping(EmployeeManager manager, Information shippingInfo) {
		this.manager = manager;
		this.shippingInfo = shippingInfo;
	}

	@Override
	public void execute() {
		Employee picker = manager.getPicker();
		picker.performWork(this.shippingInfo);
		Employee driver = manager.getDriver();
		driver.performWork(this.shippingInfo);

		String item = this.shippingInfo.getItem();
		String account = this.shippingInfo.getAccount();
		int count = this.shippingInfo.getCount();
		System.out.println("Shipped " + count + " " + item + " to " + account);
	}
}
