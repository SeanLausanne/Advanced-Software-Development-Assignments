package good.srp_dip;

import java.util.List;

public class PhotoManager {
	
	// use abstraction ot fix DIP
	PhotoGalleryInterface gallery;

	public PhotoManager(PhotoGalleryInterface gallery) {
		this.gallery = gallery;
	}
	
	// generate current date and save
	public void savePhotoWithAutoDate(Photo photo) {
		DateManager dateManager = new DateManager();
		String date = dateManager.getDate();
		photo.setSavedDate(date);
		gallery.savePhoto(photo);
	}
	
	// receive a date and save
	public void savePhotoWithSetDate(Photo photo, String date) {
		photo.setSavedDate(date);
		gallery.savePhoto(photo);
	}

	public void deleteLastPhotoByDate(String date) {
		List<Photo> photos = gallery.loadAllPhotos();
		for (int i = photos.size() - 1; i >= 0; i--) {
			Photo currentPhoto = photos.get(i);
			if (currentPhoto.savedDate.equals(date)) {
				photos.remove(i);
				break;
			}
		}
	}

	public List<Photo> presentAllPhotos() {
		return gallery.loadAllPhotos();
	}

}