package management;

import java.util.List;
import io.InstructionReader;
import io.Reader;
import service.DeliveryInstructionProcessor;
import service.InstructionProcessor;
import service.Service;
import staff.EmployeeManager;
import staff.HumanResources;

public class Main {

	private final static int EMPLOYEENUMBER = 5;
	private static EmployeeManager manager;
	List<Service> services;

	public static void main(String[] args) {

		System.out.println("Welcome to the warehouse!");
		manager = new HumanResources(EMPLOYEENUMBER);

		// read instructions from file
		Reader reader = new InstructionReader();
		List<String> instructions = reader.read("input.txt");

		// wrap instructions into services
		InstructionProcessor processor = new DeliveryInstructionProcessor();
		List<Service> services = processor.processInstruction(instructions, manager);

		// executor services
		Executor executor = new Executor();
		executor.executeAllServices(services);

		System.out.println("Human resources reports " + manager.getTotalMinutesWorked() + " minutes worked.");
	}
}
