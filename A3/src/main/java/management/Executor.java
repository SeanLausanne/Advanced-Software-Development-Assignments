package management;

import java.util.List;
import service.Service;

public class Executor {

	public void executeAllServices(List<Service> services) {
		for (Service service : services) {
			service.execute();
		}
	}
}
