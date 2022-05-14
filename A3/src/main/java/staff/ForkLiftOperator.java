package staff;

import service.Information;

public class ForkLiftOperator extends Employee {
	
	public ForkLiftOperator() {
		super();
		unitTime = 20;
	}

	@Override
	public void performWork(Information deliveryInfo) {
		int count = deliveryInfo.getCount();
		String item = deliveryInfo.getItem();

		logTime(count);
		System.out.println("Stored " + count + " " + item);
	}
}
