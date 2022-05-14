package service;

import java.util.ArrayList;
import java.util.List;
import staff.EmployeeManager;

public class DeliveryInstructionProcessor implements InstructionProcessor {
	
	// in case of input format change, implement a new InstructionProcessor
	private final int SERVICE_IDX = 0;
	private final int ITEM_IDX = 1;
	private final int COUNT_IDX = -1;
	private final int ACCOUNT_IDX = -2;
	
	// covert instructions into services
	@Override
	public List<Service> processInstruction(List<String> instructions, EmployeeManager manager) {
		List<Service> services = new ArrayList<>();

		for (String instruction : instructions) {
			String[] words = instruction.split(" ");
			String service = words[SERVICE_IDX];
			String item = words[ITEM_IDX];
			int count = Integer.parseInt(words[words.length + COUNT_IDX]);
			
			if (service.equals("RECEIVE")) {
				Information receivingInfo = new DeliveryInfo(item, count);
				Service receiving = new Receiving(manager, receivingInfo);
				services.add(receiving);
			}
			
			else if (service.equals("SHIP")) {
				String account = words[words.length + ACCOUNT_IDX];
				Information shippingInfo = new DeliveryInfo(item, account, count);
				Service shipping = new Shipping(manager, shippingInfo);
				services.add(shipping);
			}
		}
		return services;
	}
}
