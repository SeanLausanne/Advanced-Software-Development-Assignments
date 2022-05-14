package bad.isp;

//violate ISP
public interface PortableElectronicDevice {
	
	public String getModel();

	public String shootPhoto();

	public String shootVideo();

	public String text();

	public String call();

	public String getLens();

	public void changeLens(String newLens);
}
