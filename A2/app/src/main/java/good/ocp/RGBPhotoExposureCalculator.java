package good.ocp;

public class RGBPhotoExposureCalculator implements PhotoExposureCalculator {

	@Override
	public String calculateAverageExposure(int[][][] photo) {
		int sum = 0;
		int width = photo[0].length;
		int height = photo[0][0].length;

		if (width == 0 || height == 0) {
			return "0.00";
		}
		
		// get sum, photo.size() = 3 because of RGB
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					sum += photo[k][i][j];
				}
			}
		}

		double avg = Double.valueOf(sum) / (3 * height * width);
		return String.format("%.2f", avg);
	}
}
