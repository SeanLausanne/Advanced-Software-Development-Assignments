/*
 * Xiao Ling, xz540782@dal.ca
 */

package csci5308_a1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class ValidationTest {

	// step 9, not null test
	@Test
	public void checkValidationExists() {
		assertNotNull(new Validation());
	}

	// step 10, test with two decimal digits
	@Test
	public void checkValidationTwoDigitDecimals() {
		Validation v = new Validation();
		List<String> output = v.validate("1.11", "2,22", "3.33");
		List<String> ans = new ArrayList<>();
		assertEquals(ans, output);
	}

	// step 11, test with single three decimal digits
	@Test
	public void checkValidationSingleThreeDigitDecimal() {
		Validation v = new Validation();
		List<String> output = v.validate("1.111");
		List<String> ans = new ArrayList<>();
		ans.add("Too many decimal places for value 1.111");
		assertEquals(ans, output);
	}

	// step 12, test with multiple three decimal digits
	@Test
	public void checkValidationMultipleThreeDigitDecimals() {
		Validation v = new Validation();
		List<String> output = v.validate("1.111", "2.222");
		List<String> ans = new ArrayList<>();
		ans.add("Too many decimal places for value 1.111");
		ans.add("Too many decimal places for value 2.222");
		assertEquals(ans, output);
	}
}
