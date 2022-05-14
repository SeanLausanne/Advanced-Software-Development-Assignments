package bad.srp_dip;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class PhotoManager {
	
	// violate DIP
	PhotoGallery gallery = new PhotoGallery();

	public void savePhotoWithDate(Photo photo) {
		photo.setSaveDate(getDate());
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

	// get current date, violate SRP
	public String getDate() {
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		String formatedDate = String.valueOf(year) + String.format("%02d", month) + String.format("%02d", day);
		return formatedDate;
	}
}
