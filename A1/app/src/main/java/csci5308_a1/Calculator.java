/*
 * Xiao Ling, xz540782@dal.ca
 */

package csci5308_a1;

// step 1, create the class
public class Calculator {

	// step 13, create a Validation instance
	private Validation validator;

	public Calculator() {
		this.validator = new Validation();
	}

	// step 2, add two integers
	public long addInts(int num1, int num2) {
		// use long to avoid integer overflow
		return Long.valueOf(num1) + Long.valueOf(num2);
	}

	// step 3, subtract two integers
	public long subtractInts(int num1, int num2) {
		// use long to avoid integer overflow
		return Long.valueOf(num1) - Long.valueOf(num2);
	}

	// step 3, multiply two integers
	public long multiplyInts(int num1, int num2) {
		// use long to avoid integer overflow
		return Long.valueOf(num1) * Long.valueOf(num2);
	}

	// step 3, divide two integers
	public double divideInts(int num1, int num2) {
		// step 8, throw exception in case of 0 divisor
		if (num2 == 0) {
			throw new ArithmeticException();
		}
		return Double.valueOf(num1) / Double.valueOf(num2);
	}

	// step 4, fizzbuzz method
	public String fizzbuzz(int num) {
		if (num % 3 == 0 && num % 5 == 0) {
			return "fizzbuzz";
		} else if (num % 3 == 0) {
			return "fizz";
		} else if (num % 5 == 0) {
			return "buzz";
		} else {
			return String.valueOf(num);
		}
	}

	// step 5, add two strings
	public String addStrings(String num1, String num2) {
		String[] arr1 = num1.split("\\.");
		String[] arr2 = num2.split("\\.");
		// step 6, throw exception in case of more than two decimal digits
		if ((arr1.length > 1 && arr1[1].length() > 2) || (arr2.length > 1 && arr2[1].length() > 2)) {
			throw new NumberFormatException();
		}
		double ans = Double.parseDouble(num1) + Double.parseDouble(num2);
		// format answer to 2 digits
		return String.format("%.2f", ans);
	}

	// step 7, subtract two strings
	public String subtractStrings(String num1, String num2) {
		String[] arr1 = num1.split("\\.");
		String[] arr2 = num2.split("\\.");
		if ((arr1.length > 1 && arr1[1].length() > 2) || (arr2.length > 1 && arr2[1].length() > 2)) {
			throw new NumberFormatException();
		}
		double ans = Double.parseDouble(num1) - Double.parseDouble(num2);
		// format answer to 2 digits
		return String.format("%.2f", ans);
	}

	// step 7, multiply two strings
	public String multiplyStrings(String num1, String num2) {
		String[] arr1 = num1.split("\\.");
		String[] arr2 = num2.split("\\.");
		if ((arr1.length > 1 && arr1[1].length() > 2) || (arr2.length > 1 && arr2[1].length() > 2)) {
			throw new NumberFormatException();
		}
		double ans = Double.parseDouble(num1) * Double.parseDouble(num2);
		// format answer to 4 digits
		return String.format("%.4f", ans);
	}

	// step 7, divide two strings
	public String divideStrings(String num1, String num2) {
		String[] arr1 = num1.split("\\.");
		String[] arr2 = num2.split("\\.");
		if ((arr1.length > 1 && arr1[1].length() > 2) || (arr2.length > 1 && arr2[1].length() > 2)) {
			throw new NumberFormatException();
		}
		double dividend = Double.parseDouble(num1);
		double divisor = Double.parseDouble(num2);
		// step 8, throw exception in case of 0 divisor
		if (divisor == 0) {
			throw new ArithmeticException();
		}
		double ans = dividend / divisor;
		// format answer to 4 digits
		return String.format("%.4f", ans);
	}

	/*
	 * The followings are the new methods of step 13, which utilize the validation
	 * class to validate inputs
	 */

	public String addRevised(String num1, String num2) {
		// validate input decimal digits
		if (validator.validate(num1, num2).size() > 0) {
			throw new NumberFormatException();
		}
		double ans = Double.parseDouble(num1) + Double.parseDouble(num2);
		return String.format("%.2f", ans);
	}

	public String subtractRevised(String num1, String num2) {
		// validate input decimal digits
		if (validator.validate(num1, num2).size() > 0) {
			throw new NumberFormatException();
		}
		double ans = Double.parseDouble(num1) - Double.parseDouble(num2);
		return String.format("%.2f", ans);
	}

	public String multiplyRevised(String num1, String num2) {
		// validate input decimal digits
		if (validator.validate(num1, num2).size() > 0) {
			throw new NumberFormatException();
		}
		double ans = Double.parseDouble(num1) * Double.parseDouble(num2);
		return String.format("%.4f", ans);
	}

	public String divideRevised(String num1, String num2) {
		// validate input decimal digits
		if (validator.validate(num1, num2).size() > 0) {
			throw new NumberFormatException();
		}
		double dividend = Double.parseDouble(num1);
		double divisor = Double.parseDouble(num2);
		// throw exception in case of 0 divisor
		if (divisor == 0) {
			throw new ArithmeticException();
		}
		double ans = dividend / divisor;
		return String.format("%.4f", ans);
	}
}
