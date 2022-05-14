package test.srp_dip;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import good.srp_dip.*;

public class DateManagerTest {

	@Test
	public void checkExists() {
		DateManager dateManager = new DateManager();
		assertNotNull(dateManager);
	}

	@Test
	public void checkGetDate() {
		DateManager dateManager = new DateManager();
		String date = dateManager.getDate();
		// validate date format
		assertEquals(date.length(), 8);
		int month = Integer.valueOf(date.substring(4, 6));
		int day = Integer.valueOf(date.substring(6));
		assertTrue(month >= 1 && month <= 12);
		assertTrue(day >= 1 && day <= 31);
	}

}
