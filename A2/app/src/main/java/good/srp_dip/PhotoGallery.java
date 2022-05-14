package good.srp_dip;

import java.util.LinkedList;
import java.util.List;

public class PhotoGallery implements PhotoGalleryInterface {
	
	List<Photo> photos;

	public PhotoGallery() {
		photos = new LinkedList<>();
	}

	@Override
	public void savePhoto(Photo photo) {
		photos.add(photo);
	}

	@Override
	public List<Photo> loadAllPhotos() {
		return photos;
	}

}
