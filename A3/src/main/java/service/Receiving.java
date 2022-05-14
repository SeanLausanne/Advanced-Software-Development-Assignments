package service;

import staff.Employee;
import staff.EmployeeManager;

public class Receiving implements Service {

	private EmployeeManager manager;
	private Information receivingInfo;

	public Receiving(EmployeeManager manager, Information receivingInfo) {
		this.manager = manager;
		this.receivingInfo = receivingInfo;
	}

	@Override
	public void execute() {
		Employee forkliftOperator = manager.getForkLiftOperator();
		forkliftOperator.performWork(receivingInfo);

		String item = this.receivingInfo.getItem();
		int count = this.receivingInfo.getCount();
		System.out.println("Received " + count + " " + item);
	}
}
