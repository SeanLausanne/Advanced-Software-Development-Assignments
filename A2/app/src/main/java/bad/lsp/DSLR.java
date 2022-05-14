package bad.lsp;

public class DSLR extends Camera {

	public DSLR(String model) {
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

	@Override
	public void changeLens(String newLens) {
		this.lens = newLens;
	}

	@Override
	public String getLens() {
		return this.lens;
	}
}