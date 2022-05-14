package bad.lsp;

public abstract class Camera {

	String model;
	String lens;

	public Camera(String model) {
		this.model = model;
	}

	public abstract String getModel();

	public abstract String shootPhoto();

	public abstract String shootVideo();

	public abstract void changeLens(String newLens);

	public abstract String getLens();
}
