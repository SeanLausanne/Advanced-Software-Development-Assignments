package staff;

import service.Information;

public class Driver extends Employee {

	public Driver() {
		super();
		unitTime = 15;
	}

	@Override
	public void performWork(Information deliveryInfo) {
		int count = deliveryInfo.getCount();
		String item = deliveryInfo.getItem();
		String account = deliveryInfo.getAccount();

		logTime(count);
		System.out.println("Delivered " + item + " to " + account);
	}
}
