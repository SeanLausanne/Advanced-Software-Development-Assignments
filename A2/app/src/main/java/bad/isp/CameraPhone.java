package bad.isp;

public class CameraPhone implements PortableElectronicDevice {

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
	public String call() {
		return "Calling";
	}

	@Override
	public String text() {
		return "Texting";
	}

	@Override
	public String getLens() {
		return this.lens;
	}

	// method not supported
	@Override
	public void changeLens(String newLens) {
		System.out.println("Phones can't change lens");
	}
}
