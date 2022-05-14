package test.srp_dip;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import good.srp_dip.*;

public class PhotoManagerTest {

	@Test
	public void checkExists() {
		PhotoGalleryInterface gallery = new PhotoGallery();
		PhotoManager photoManager = new PhotoManager(gallery);
		assertNotNull(photoManager);
	}

	@Test
	public void checkSavePhotoWithAutoDate() {
		Photo photo = new Photo();
		PhotoGalleryInterface gallery = new PhotoGallery();
		PhotoManager photoManager = new PhotoManager(gallery);
		
		photoManager.savePhotoWithAutoDate(photo);
		List<Photo> photos = photoManager.presentAllPhotos();
		
		assertEquals(photos.size(), 1);
		assertNotEquals(photos.get(0).getSavedDate(), "Not saved");
	}

	@Test
	public void checkSavePhotoWithSetDate() {
		Photo photo = new Photo();
		PhotoGalleryInterface gallery = new PhotoGallery();
		PhotoManager photoManager = new PhotoManager(gallery);
		
		photoManager.savePhotoWithSetDate(photo, "20211107");
		List<Photo> photos = photoManager.presentAllPhotos();
		
		assertEquals(photos.size(), 1);
		assertEquals(photos.get(0).getSavedDate(), "20211107");
	}

	@Test
	public void checkDeleteLastPhotoByDate() {
		// save to photos and delete the second one
		Photo photo1 = new Photo();
		Photo photo2 = new Photo();
		PhotoGalleryInterface gallery = new PhotoGallery();
		PhotoManager photoManager = new PhotoManager(gallery);
		
		photoManager.savePhotoWithSetDate(photo1, "20211107");
		photoManager.savePhotoWithSetDate(photo2, "20211108");
		
		List<Photo> photos = photoManager.presentAllPhotos();
		assertEquals(photos.size(), 2);
		
		photoManager.deleteLastPhotoByDate("20211108");
		photos = photoManager.presentAllPhotos();
		
		assertEquals(photos.size(), 1);
		assertEquals(photos.get(0).getSavedDate(), "20211107");
	}

}
