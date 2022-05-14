package good.srp_dip;

import java.util.List;

public interface PhotoGalleryInterface {
	public void savePhoto(Photo photo);

	public List<Photo> loadAllPhotos();
}
