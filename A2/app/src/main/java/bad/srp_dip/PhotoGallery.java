package bad.srp_dip;

import java.util.LinkedList;
import java.util.List;

public class PhotoGallery {
	
	List<Photo> photos;

	public PhotoGallery() {
		photos = new LinkedList<>();
	}

	public void savePhoto(Photo photo) {
		photos.add(photo);
	}

	public List<Photo> loadAllPhotos() {
		return photos;
	}

}
