package test.srp_dip;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import good.srp_dip.*;

public class PhotoGalleryTest {

	@Test
	public void checkExists() {
		PhotoGallery gallery = new PhotoGallery();
		assertNotNull(gallery);
	}

	@Test
	public void checkSaveAndLoadPoto() {
		PhotoGallery gallery = new PhotoGallery();
		Photo photo1 = new Photo();
		Photo photo2 = new Photo();
		
		gallery.savePhoto(photo1);
		gallery.savePhoto(photo2);
		
		List<Photo> photos = gallery.loadAllPhotos();
		assertEquals(photos.size(), 2);
		assertEquals(photos.get(0), photo1);
		assertEquals(photos.get(1), photo2);
	}

}
