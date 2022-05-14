package good.lsp_isp;

public class DSLR implements InterchangeableLensCamera {

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

	@Override
	public void changeLens(String newLens) {
		this.lens = newLens;
	}

	@Override
	public String getLens() {
		return this.lens;
	}
}
