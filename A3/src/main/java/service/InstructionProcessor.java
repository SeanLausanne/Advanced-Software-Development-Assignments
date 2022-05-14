package service;

import java.util.List;
import staff.EmployeeManager;

public interface InstructionProcessor {

	public List<Service> processInstruction(List<String> instructions, EmployeeManager manager);

}
