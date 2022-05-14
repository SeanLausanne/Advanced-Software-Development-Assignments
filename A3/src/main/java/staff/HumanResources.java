package staff;

import java.util.ArrayList;
import java.util.List;

public class HumanResources extends EmployeeManager {

	private int nextDriver;
	private int nextForkLiftOperator;
	private int nextPicker;

	private List<Employee> drivers;
	private List<Employee> forkLiftOperators;
	private List<Employee> pickers;

	public HumanResources(int employeeNumber) {
		super(employeeNumber);

		this.nextDriver = 0;
		this.nextForkLiftOperator = 0;
		this.nextPicker = 0;
		this.drivers = new ArrayList<>();
		this.forkLiftOperators = new ArrayList<>();
		this.pickers = new ArrayList<>();

		for (int i = 0; i < employeeNumber; i++) {
			drivers.add(new Driver());
			forkLiftOperators.add(new ForkLiftOperator());
			pickers.add(new Picker());
		}
	}

	@Override
	public Employee getDriver() {
		Employee driver = drivers.get(nextDriver);
		nextDriver = (nextDriver + 1) % employeeNumber;
		return driver;
	}

	@Override
	public Employee getPicker() {
		Employee picker = pickers.get(nextPicker);
		nextPicker = (nextPicker + 1) % employeeNumber;
		return picker;
	}

	@Override
	public Employee getForkLiftOperator() {
		Employee forkliftOperator = forkLiftOperators.get(nextForkLiftOperator);
		nextForkLiftOperator = (nextForkLiftOperator + 1) % employeeNumber;
		return forkliftOperator;
	}

	@Override
	public int getTotalMinutesWorked() {
		int count = 0;
		for (int i = 0; i < employeeNumber; i++) {
			count += drivers.get(i).getMinutesWorkedSinceLastPay();
			count += pickers.get(i).getMinutesWorkedSinceLastPay();
			count += forkLiftOperators.get(i).getMinutesWorkedSinceLastPay();
		}
		return count;
	}
}
