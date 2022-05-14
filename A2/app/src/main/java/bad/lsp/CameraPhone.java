package bad.lsp;

public class CameraPhone extends Camera {

	public CameraPhone(String model) {
		super(model);
		this.lens = "Original Lens";
	}

	@Override
	public String getModel() {
		return this.model;
	}

	@Override
	public String shootPhoto() {
		return "Shooting photo";
	}

	@Override
	public String shootVideo() {
		return "Shooting video";
	}
	
	// method not supported, violate LSP
	@Override
	public void changeLens(String newLens) {
		System.out.println("Phones can't change lens");
	}

	@Override
	public String getLens() {
		return this.lens;
	}

	public String text() {
		return "Texting";
	}

	public String call() {
		return "Calling";
	}
}
