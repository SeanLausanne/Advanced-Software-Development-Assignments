package staff;

import service.Information;

public abstract class Employee {

	private int MinutesWorkedSinceLastPay;
	protected int unitTime;

	public Employee() {
		MinutesWorkedSinceLastPay = 0;
	}

	protected void logTime(int count) {
		MinutesWorkedSinceLastPay += unitTime * count;
	}

	public int getMinutesWorkedSinceLastPay() {
		return MinutesWorkedSinceLastPay;
	}

	public abstract void performWork(Information info);
}
