package test.srp_dip;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import good.srp_dip.Photo;

public class PhotoTest {
	
	@Test
	public void checkExists() {
		Photo photo = new Photo();
		assertNotNull(photo);
		assertEquals(photo.getSavedDate(), "Not saved");
	}
	
	@Test
	public void checkSetSaveDate() {
		Photo photo = new Photo();
		photo.setSavedDate("20211106");
		assertEquals(photo.getSavedDate(), "20211106");
	}

}
