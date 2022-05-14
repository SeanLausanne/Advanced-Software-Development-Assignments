package good.lsp_isp;

public class CameraPhone implements Camera, MobilePhone {

	String model;
	String lens;

	public CameraPhone(String model) {
		this.model = model;
		this.lens = "Original lens";
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

	@Override
	public String getLens() {
		return this.lens;
	}

	@Override
	public String call() {
		return "Calling";
	}

	@Override
	public String text() {
		return "Texting";
	}
}
