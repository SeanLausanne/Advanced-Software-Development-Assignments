package good.srp_dip;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateManager {

	// get current date
	public String getDate() {
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		String formatedDate = String.valueOf(year) + String.format("%02d", month) + String.format("%02d", day);
		System.out.println(formatedDate);
		return formatedDate;
	}
}
