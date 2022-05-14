/*
 * Xiao Ling, xz540782@dal.ca
 */

package csci5308_a1;

import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class CalculatorTest {

	// step 1, not null test
	@Test
	public void checkCalculatorExists() {
		assertNotNull(new Calculator());
	}

	// step 2, test the add method of two integers
	@Test
	public void checkAddInts() {
		Calculator c = new Calculator();
		Random rand = new Random();

		// test with positive numbers
		int pos1 = rand.nextInt(10000);
		int pos2 = rand.nextInt(10000);
		assertEquals(pos1 + pos2, c.addInts(pos1, pos2));

		// test with negative numbers
		int neg1 = -rand.nextInt(10000);
		int neg2 = -rand.nextInt(10000);
		assertEquals(neg1 + neg2, c.addInts(neg1, neg2));

		// test integer overflow
		long ans = Long.valueOf(Integer.MAX_VALUE) + Long.valueOf(Integer.MAX_VALUE);
		assertEquals(ans, c.addInts(Integer.MAX_VALUE, Integer.MAX_VALUE));
		ans = Long.valueOf(Integer.MIN_VALUE) + Long.valueOf(Integer.MIN_VALUE);
		assertEquals(ans, c.addInts(Integer.MIN_VALUE, Integer.MIN_VALUE));
	}

	// step 3, test the subtract method of two integers
	@Test
	public void checkSubstractInts() {
		Calculator c = new Calculator();
		Random rand = new Random();

		// test with positive numbers
		int pos1 = rand.nextInt(10000);
		int pos2 = rand.nextInt(10000);
		assertEquals(pos1 - pos2, c.subtractInts(pos1, pos2));

		// test with negative numbers
		int neg1 = -rand.nextInt(10000);
		int neg2 = -rand.nextInt(10000);
		assertEquals(neg1 - neg2, c.subtractInts(neg1, neg2));

		// test integer overflow
		long ans = Long.valueOf(Integer.MAX_VALUE) - Long.valueOf(Integer.MIN_VALUE);
		assertEquals(ans, c.subtractInts(Integer.MAX_VALUE, Integer.MIN_VALUE));
		ans = Long.valueOf(Integer.MIN_VALUE) - Long.valueOf(Integer.MAX_VALUE);
		assertEquals(ans, c.subtractInts(Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	// step 3, test the multiply method of two integers
	@Test
	public void checkMultiplyInts() {
		Random rand = new Random();
		Calculator c = new Calculator();

		// test with positive numbers
		int int1 = rand.nextInt(10000);
		int int2 = rand.nextInt(10000);
		assertEquals(int1 * int2, c.multiplyInts(int1, int2));

		// test with positive and negative numbers
		int1 = rand.nextInt(10000);
		int2 = -rand.nextInt(10000);
		assertEquals(int1 * int2, c.multiplyInts(int1, int2));

		// test integer overflow
		long ans = Long.valueOf(Integer.MAX_VALUE) * Long.valueOf(Integer.MAX_VALUE);
		assertEquals(ans, c.multiplyInts(Integer.MAX_VALUE, Integer.MAX_VALUE));
		ans = Long.valueOf(Integer.MIN_VALUE) * Long.valueOf(Integer.MIN_VALUE);
		assertEquals(ans, c.multiplyInts(Integer.MIN_VALUE, Integer.MIN_VALUE));
	}

	// step 3, test the divide method of two integers
	@Test
	public void checkDevideInts() {
		Calculator c = new Calculator();
		Random rand = new Random();

		// test with positive numbers
		int num1 = rand.nextInt(10000);
		int num2 = rand.nextInt(10000);
		assertEquals((double) num1 / (double) num2, c.divideInts(num1, num2), 0);

		// test with positive and negative numbers
		num1 = rand.nextInt(10000);
		num2 = -rand.nextInt(10000);
		assertEquals((double) num1 / (double) num2, c.divideInts(num1, num2), 0);
	}

	// step 4, test the fizzbuzz method
	@Test
	public void checkFizzbuzz() {
		Calculator c = new Calculator();
		Random rand = new Random();
		int num = rand.nextInt(Integer.MAX_VALUE / 15); // to avoid overflow when testing with num * 15

		// make sure num is not divisible by 3 or 5
		while (num % 3 == 0) {
			num /= 3;
		}
		while (num % 5 == 0) {
			num /= 5;
		}

		// test all four cases
		assertEquals(String.valueOf(num), c.fizzbuzz(num));
		assertEquals("fizz", c.fizzbuzz(num * 3));
		assertEquals("buzz", c.fizzbuzz(num * 5));
		assertEquals("fizzbuzz", c.fizzbuzz(num * 15));
	}

	// step 5, test the add method of two strings
	@Test
	public void checkAddString() {
		Calculator c = new Calculator();
		double num1 = 1.234;
		double num2 = 4.321;

		// test with positive numbers and different decimal digits
		String str1 = String.format("%.0f", num1);
		String str2 = String.format("%.0f", num2);
		assertEquals("5.00", c.addStrings(str1, str2));
		str1 = String.format("%.1f", num1);
		str2 = String.format("%.1f", num2);
		assertEquals("5.50", c.addStrings(str1, str2));
		str1 = String.format("%.1f", num1);
		str2 = String.format("%.2f", num2);
		assertEquals("5.52", c.addStrings(str1, str2));
		str1 = String.format("%.2f", num1);
		str2 = String.format("%.2f", num2);
		assertEquals("5.55", c.addStrings(str1, str2));

		// test with negative numbers and different decimal digits
		str1 = String.format("%.0f", -num1);
		str2 = String.format("%.0f", -num2);
		assertEquals("-5.00", c.addStrings(str1, str2));
		str1 = String.format("%.1f", -num1);
		str2 = String.format("%.1f", -num2);
		assertEquals("-5.50", c.addStrings(str1, str2));
		str1 = String.format("%.1f", -num1);
		str2 = String.format("%.2f", -num2);
		assertEquals("-5.52", c.addStrings(str1, str2));
		str1 = String.format("%.2f", -num1);
		str2 = String.format("%.2f", -num2);
		assertEquals("-5.55", c.addStrings(str1, str2));
	}

	// step 6, test exception in case of more than two decimal digits
	// test the first parameter
	@Test(expected = NumberFormatException.class)
	public void checkAddStringFirstDecimal() {
		Calculator c = new Calculator();
		String str1 = "1.234";
		String str2 = "4.32";
		c.addStrings(str1, str2);
	}

	// test the second parameter
	@Test(expected = NumberFormatException.class)
	public void checkAddStringSecondDecimal() {
		Calculator c = new Calculator();
		String str1 = "1.23";
		String str2 = "4.321";
		c.addStrings(str1, str2);
	}

	// step 7, test the subtract method of two strings
	@Test
	public void checkSubtractString() {
		Calculator c = new Calculator();
		double num1 = 1.234;
		double num2 = 4.321;

		// test with positive numbers and different decimal digits
		String str1 = String.format("%.0f", num1);
		String str2 = String.format("%.0f", num2);
		assertEquals("-3.00", c.subtractStrings(str1, str2));
		str1 = String.format("%.1f", num1);
		str2 = String.format("%.1f", num2);
		assertEquals("-3.10", c.subtractStrings(str1, str2));
		str1 = String.format("%.1f", num1);
		str2 = String.format("%.2f", num2);
		assertEquals("-3.12", c.subtractStrings(str1, str2));
		str1 = String.format("%.2f", num1);
		str2 = String.format("%.2f", num2);
		assertEquals("-3.09", c.subtractStrings(str1, str2));

		// test with negative numbers and different decimal digits
		str1 = String.format("%.0f", -num1);
		str2 = String.format("%.0f", -num2);
		assertEquals("3.00", c.subtractStrings(str1, str2));
		str1 = String.format("%.1f", -num1);
		str2 = String.format("%.1f", -num2);
		assertEquals("3.10", c.subtractStrings(str1, str2));
		str1 = String.format("%.1f", -num1);
		str2 = String.format("%.2f", -num2);
		assertEquals("3.12", c.subtractStrings(str1, str2));
		str1 = String.format("%.2f", -num1);
		str2 = String.format("%.2f", -num2);
		assertEquals("3.09", c.subtractStrings(str1, str2));
	}

	// test exception in case of more than two decimal digits
	// test the first parameter
	@Test(expected = NumberFormatException.class)
	public void checkSubtractStringFirstDecimal() {
		Calculator c = new Calculator();
		String str1 = "1.234";
		String str2 = "4.32";
		c.subtractStrings(str1, str2);
	}

	// test the second parameter
	@Test(expected = NumberFormatException.class)
	public void checkSubtractStringSecondDecimal() {
		Calculator c = new Calculator();
		String str1 = "1.23";
		String str2 = "4.321";
		c.subtractStrings(str1, str2);
	}

	// step 7, test the multiply method of two strings
	@Test
	public void checkMultiplyStrings() {
		Calculator c = new Calculator();
		double num1 = 1.234;
		double num2 = 4.321;

		// test with positive numbers and different decimal digits
		String str1 = String.format("%.0f", num1);
		String str2 = String.format("%.0f", num2);
		assertEquals("4.0000", c.multiplyStrings(str1, str2));
		str1 = String.format("%.1f", num1);
		str2 = String.format("%.1f", num2);
		assertEquals("5.1600", c.multiplyStrings(str1, str2));
		str1 = String.format("%.1f", num1);
		str2 = String.format("%.2f", num2);
		assertEquals("5.1840", c.multiplyStrings(str1, str2));
		str1 = String.format("%.2f", num1);
		str2 = String.format("%.2f", num2);
		assertEquals("5.3136", c.multiplyStrings(str1, str2));

		// test with positive and negative numbers and different decimal digits
		str1 = String.format("%.0f", -num1);
		str2 = String.format("%.0f", num2);
		assertEquals("-4.0000", c.multiplyStrings(str1, str2));
		str1 = String.format("%.1f", -num1);
		str2 = String.format("%.1f", num2);
		assertEquals("-5.1600", c.multiplyStrings(str1, str2));
		str1 = String.format("%.1f", -num1);
		str2 = String.format("%.2f", num2);
		assertEquals("-5.1840", c.multiplyStrings(str1, str2));
		str1 = String.format("%.2f", -num1);
		str2 = String.format("%.2f", num2);
		assertEquals("-5.3136", c.multiplyStrings(str1, str2));
	}

	// test exception in case of more than two decimal digits
	// test the first parameter
	@Test(expected = NumberFormatException.class)
	public void checkMultiplyStringFirstDecimal() {
		Calculator c = new Calculator();
		String str1 = "1.234";
		String str2 = "4.32";
		c.multiplyStrings(str1, str2);
	}

	// test the second parameter
	@Test(expected = NumberFormatException.class)
	public void checkMultiplyStringSecondDecimal() {
		Calculator c = new Calculator();
		String str1 = "1.23";
		String str2 = "4.321";
		c.multiplyStrings(str1, str2);
	}

	// step 7, test the divide method of two strings
	@Test
	public void checkDivideString() {
		Calculator c = new Calculator();
		double num1 = 1.234;
		double num2 = 4.321;

		// test with positive numbers and different decimal digits
		String str1 = String.format("%.0f", num1);
		String str2 = String.format("%.0f", num2);
		assertEquals("0.2500", c.divideStrings(str1, str2));
		str1 = String.format("%.1f", num1);
		str2 = String.format("%.1f", num2);
		assertEquals("0.2791", c.divideStrings(str1, str2));
		str1 = String.format("%.1f", num1);
		str2 = String.format("%.2f", num2);
		assertEquals("0.2778", c.divideStrings(str1, str2));
		str1 = String.format("%.2f", num1);
		str2 = String.format("%.2f", num2);
		assertEquals("0.2847", c.divideStrings(str1, str2));

		// test with positive and negative numbers and different decimal digits
		str1 = String.format("%.0f", -num1);
		str2 = String.format("%.0f", num2);
		assertEquals("-0.2500", c.divideStrings(str1, str2));
		str1 = String.format("%.1f", -num1);
		str2 = String.format("%.1f", num2);
		assertEquals("-0.2791", c.divideStrings(str1, str2));
		str1 = String.format("%.1f", -num1);
		str2 = String.format("%.2f", num2);
		assertEquals("-0.2778", c.divideStrings(str1, str2));
		str1 = String.format("%.2f", -num1);
		str2 = String.format("%.2f", num2);
		assertEquals("-0.2847", c.divideStrings(str1, str2));
	}

	// test exception in case of more than two decimal digits
	// test the first parameter
	@Test(expected = NumberFormatException.class)
	public void checkDivideStringFirstDecimal() {
		Calculator c = new Calculator();
		String str1 = "1.234";
		String str2 = "4.32";
		c.divideStrings(str1, str2);
	}

	// test the second parameter
	@Test(expected = NumberFormatException.class)
	public void checkDivideStringSecondDecimal() {
		Calculator c = new Calculator();
		String str1 = "1.23";
		String str2 = "4.321";
		c.divideStrings(str1, str2);
	}

	// step 8, test 0 divisor of integer division
	@Test(expected = ArithmeticException.class)
	public void checkDivideIntsZeroDivisor() {
		Calculator c = new Calculator();
		c.divideInts(1, 0);
	}

	// step 8, test 0 divisor of string division with different decimal digits
	@Test(expected = ArithmeticException.class)
	public void checkDivideStringsZeroDivisor() {
		Calculator c = new Calculator();
		c.divideStrings("1", "0");
	}

	@Test(expected = ArithmeticException.class)
	public void checkDivideStringsZeroDivisor2() {
		Calculator c = new Calculator();
		c.divideStrings("1", "0.0");
	}

	/*
	 * ************ Step 13 The following are the exact same tests for
	 * add/subtract/multiply/divideRevised as for
	 * add/subtract/multiply/divideStrings ************
	 */

	// tests for addRevised()
	@Test
	public void checkAddRevised() {
		// didn't use random number here because share blind spots
		Calculator c = new Calculator();
		double num1 = 1.234;
		double num2 = 4.321;

		// test with positive numbers and different decimal digits
		String str1 = String.format("%.0f", num1);
		String str2 = String.format("%.0f", num2);
		assertEquals("5.00", c.addRevised(str1, str2));
		str1 = String.format("%.1f", num1);
		str2 = String.format("%.1f", num2);
		assertEquals("5.50", c.addRevised(str1, str2));
		str1 = String.format("%.1f", num1);
		str2 = String.format("%.2f", num2);
		assertEquals("5.52", c.addRevised(str1, str2));
		str1 = String.format("%.2f", num1);
		str2 = String.format("%.2f", num2);
		assertEquals("5.55", c.addRevised(str1, str2));

		// test with negative number and different decimal digits
		str1 = String.format("%.0f", -num1);
		str2 = String.format("%.0f", -num2);
		assertEquals("-5.00", c.addRevised(str1, str2));
		str1 = String.format("%.1f", -num1);
		str2 = String.format("%.1f", -num2);
		assertEquals("-5.50", c.addRevised(str1, str2));
		str1 = String.format("%.1f", -num1);
		str2 = String.format("%.2f", -num2);
		assertEquals("-5.52", c.addRevised(str1, str2));
		str1 = String.format("%.2f", -num1);
		str2 = String.format("%.2f", -num2);
		assertEquals("-5.55", c.addRevised(str1, str2));
	}

	// test exception in case of more two decimal digits
	@Test(expected = NumberFormatException.class)
	public void checkAddRevisedFirstDecimal() {
		Calculator c = new Calculator();
		String str1 = "1.234";
		String str2 = "4.32";
		c.addRevised(str1, str2);
	}

	@Test(expected = NumberFormatException.class)
	public void checkAddRevisedSecondDecimal() {
		Calculator c = new Calculator();
		String str1 = "1.23";
		String str2 = "4.321";
		c.addRevised(str1, str2);
	}

	// tests for subtractRevised()
	@Test
	public void checkSubtractRevised() {
		Calculator c = new Calculator();
		double num1 = 1.234;
		double num2 = 4.321;

		// test with positive numbers and different decimal digits
		String str1 = String.format("%.0f", num1);
		String str2 = String.format("%.0f", num2);
		assertEquals("-3.00", c.subtractRevised(str1, str2));
		str1 = String.format("%.1f", num1);
		str2 = String.format("%.1f", num2);
		assertEquals("-3.10", c.subtractRevised(str1, str2));
		str1 = String.format("%.1f", num1);
		str2 = String.format("%.2f", num2);
		assertEquals("-3.12", c.subtractRevised(str1, str2));
		str1 = String.format("%.2f", num1);
		str2 = String.format("%.2f", num2);
		assertEquals("-3.09", c.subtractRevised(str1, str2));

		// test with positive and negative numbers and different decimal digits
		str1 = String.format("%.0f", -num1);
		str2 = String.format("%.0f", -num2);
		assertEquals("3.00", c.subtractRevised(str1, str2));
		str1 = String.format("%.1f", -num1);
		str2 = String.format("%.1f", -num2);
		assertEquals("3.10", c.subtractRevised(str1, str2));
		str1 = String.format("%.1f", -num1);
		str2 = String.format("%.2f", -num2);
		assertEquals("3.12", c.subtractRevised(str1, str2));
		str1 = String.format("%.2f", -num1);
		str2 = String.format("%.2f", -num2);
		assertEquals("3.09", c.subtractRevised(str1, str2));
	}

	// test exception in case of more two decimal digits
	@Test(expected = NumberFormatException.class)
	public void checkSubtractRevisedFirstDecimal() {
		Calculator c = new Calculator();
		String str1 = "1.234";
		String str2 = "4.32";
		c.subtractRevised(str1, str2);
	}

	@Test(expected = NumberFormatException.class)
	public void checkSubtractRevisedSecondDecimal() {
		Calculator c = new Calculator();
		String str1 = "1.23";
		String str2 = "4.321";
		c.subtractRevised(str1, str2);
	}

	// tests for multiplyRevised()
	@Test
	public void checkMultiplyRevised() {
		Calculator c = new Calculator();
		double num1 = 1.234;
		double num2 = 4.321;

		// test with positive numbers and different decimal digits
		String str1 = String.format("%.0f", num1);
		String str2 = String.format("%.0f", num2);
		assertEquals("4.0000", c.multiplyRevised(str1, str2));
		str1 = String.format("%.1f", num1);
		str2 = String.format("%.1f", num2);
		assertEquals("5.1600", c.multiplyRevised(str1, str2));
		str1 = String.format("%.1f", num1);
		str2 = String.format("%.2f", num2);
		assertEquals("5.1840", c.multiplyRevised(str1, str2));
		str1 = String.format("%.2f", num1);
		str2 = String.format("%.2f", num2);
		assertEquals("5.3136", c.multiplyRevised(str1, str2));

		// test with positive and negative numbers and different decimal digits
		str1 = String.format("%.0f", -num1);
		str2 = String.format("%.0f", num2);
		assertEquals("-4.0000", c.multiplyRevised(str1, str2));
		str1 = String.format("%.1f", -num1);
		str2 = String.format("%.1f", num2);
		assertEquals("-5.1600", c.multiplyRevised(str1, str2));
		str1 = String.format("%.1f", -num1);
		str2 = String.format("%.2f", num2);
		assertEquals("-5.1840", c.multiplyRevised(str1, str2));
		str1 = String.format("%.2f", -num1);
		str2 = String.format("%.2f", num2);
		assertEquals("-5.3136", c.multiplyRevised(str1, str2));
	}

	// test exception in case of more two decimal digits
	@Test(expected = NumberFormatException.class)
	public void checkMultiplyRevisedFirstDecimal() {
		Calculator c = new Calculator();
		String str1 = "1.234";
		String str2 = "4.32";
		c.multiplyRevised(str1, str2);
	}

	@Test(expected = NumberFormatException.class)
	public void checkMultiplyRevisedSecondDecimal() {
		Calculator c = new Calculator();
		String str1 = "1.23";
		String str2 = "4.321";
		c.multiplyRevised(str1, str2);
	}

	// tests for divideRevised()
	@Test
	public void checkDivideRevised() {
		Calculator c = new Calculator();
		double num1 = 1.234;
		double num2 = 4.321;

		// test with different decimal digits
		String str1 = String.format("%.0f", num1);
		String str2 = String.format("%.0f", num2);
		assertEquals("0.2500", c.divideRevised(str1, str2));
		str1 = String.format("%.1f", num1);
		str2 = String.format("%.1f", num2);
		assertEquals("0.2791", c.divideRevised(str1, str2));
		str1 = String.format("%.1f", num1);
		str2 = String.format("%.2f", num2);
		assertEquals("0.2778", c.divideRevised(str1, str2));
		str1 = String.format("%.2f", num1);
		str2 = String.format("%.2f", num2);
		assertEquals("0.2847", c.divideRevised(str1, str2));

		// test with positive and negative numbers
		str1 = String.format("%.0f", -num1);
		str2 = String.format("%.0f", num2);
		assertEquals("-0.2500", c.divideRevised(str1, str2));
		str1 = String.format("%.1f", -num1);
		str2 = String.format("%.1f", num2);
		assertEquals("-0.2791", c.divideRevised(str1, str2));
		str1 = String.format("%.1f", -num1);
		str2 = String.format("%.2f", num2);
		assertEquals("-0.2778", c.divideRevised(str1, str2));
		str1 = String.format("%.2f", -num1);
		str2 = String.format("%.2f", num2);
		assertEquals("-0.2847", c.divideRevised(str1, str2));
	}

	// test exception in case of more two decimal digits
	@Test(expected = NumberFormatException.class)
	public void checkDivideRevisedFirstDecimal() {
		Calculator c = new Calculator();
		String str1 = "1.234";
		String str2 = "4.32";
		c.divideRevised(str1, str2);
	}

	@Test(expected = NumberFormatException.class)
	public void checkDivideRevisedSecondDecimal() {
		Calculator c = new Calculator();
		String str1 = "1.23";
		String str2 = "4.321";
		c.divideRevised(str1, str2);
	}

	// test 0 divisor
	@Test(expected = ArithmeticException.class)
	public void checkDivideRevisedZeroDivisor() {
		Calculator c = new Calculator();
		c.divideRevised("1", "0");
	}

	@Test(expected = ArithmeticException.class)
	public void checkDivideRevisedZeroDivisor2() {
		Calculator c = new Calculator();
		c.divideRevised("1", "0.0");
	}
}
