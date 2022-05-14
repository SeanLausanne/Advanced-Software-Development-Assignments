package bad.srp_dip;

public class Photo {
	
	// date photo being saved
	String savedDate;

	public Photo() {
		this.savedDate = "Not saved";
	}

	public void setSaveDate(String date) {
		this.savedDate = date;
	}

	public String getSavedDate() {
		return this.savedDate;
	}
}
