package bad.ocp;

public class PhotoExposureCalculator {
	
	// violate OCP
	public String calculateBlackWhitePhotoAverageExposure(int[][] photo) {
		
		int sum = 0;
		int width = photo.length;
		int height = photo[0].length;

		if (width == 0 || height == 0) {
			return "0.00";
		}
		
		// get sum
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				sum += photo[i][j];
			}
		}

		double avg = Double.valueOf(sum) / (height * width);
		return String.format("%.2f", avg);
	}
}
