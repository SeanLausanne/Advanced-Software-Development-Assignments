package good.ocp;

public class BlackWhitePhotoExposureCalculator implements PhotoExposureCalculator {

	@Override
	public String calculateAverageExposure(int[][][] photo) {
		
		// photo[1], photo[2] are placeholders
		int[][] blackWhitePhoto = photo[0];
		int sum = 0;
		int width = blackWhitePhoto.length;
		int height = blackWhitePhoto[0].length;

		if (width == 0 || height == 0) {
			return "0.00";
		}
		
		// get sum
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				sum += blackWhitePhoto[i][j];
			}
		}

		double avg = Double.valueOf(sum) / (height * width);
		return String.format("%.2f", avg);
	}
}
