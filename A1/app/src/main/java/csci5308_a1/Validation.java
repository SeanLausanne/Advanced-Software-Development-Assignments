/*
 * Xiao Ling, xz540782@dal.ca
 */

package csci5308_a1;

import java.util.ArrayList;
import java.util.List;

// step 9, create Validation class
public class Validation {

	// step 10, 11, 12, create and improve validate method
	public List<String> validate(String... values) {
		List<String> messages = new ArrayList<>();
		String decimalMessage = "Too many decimal places for value ";

		for (String valueStr : values) {
			String[] valueArr = valueStr.split("\\.");
			if (valueArr.length > 1 && valueArr[1].length() > 2) {
				messages.add(decimalMessage + valueStr);
			}
		}
		return messages;
	}
}
