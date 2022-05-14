package staff;

public abstract class EmployeeManager {
	
	protected int employeeNumber;
	
	public EmployeeManager(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	public abstract Employee getDriver();

	public abstract Employee getPicker();

	public abstract Employee getForkLiftOperator();

	public abstract int getTotalMinutesWorked();
}
