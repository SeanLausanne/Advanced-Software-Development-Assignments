package bad.isp;

public class DSLR implements PortableElectronicDevice {

	String model;
	String lens;

	public DSLR(String model) {
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

	// method not supported
	@Override
	public String call() {
		return "I can't text";
	}

	// method not supported
	@Override
	public String text() {
		return "I can't text";
	}

	@Override
	public void changeLens(String newLens) {
		this.lens = newLens;
	}

	@Override
	public String getLens() {
		return this.lens;
	}

}
