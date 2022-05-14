package staff;

import service.Information;

public class Picker extends Employee {
	
	public Picker() {
		super();
		unitTime = 5;
	}

	@Override
	public void performWork(Information deliveryInfo) {
		int count = deliveryInfo.getCount();
		String item = deliveryInfo.getItem();

		logTime(count);
		System.out.println("Picked " + count + " " + item);
	}
}
