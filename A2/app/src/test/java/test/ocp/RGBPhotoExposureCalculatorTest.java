package test.ocp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import good.ocp.PhotoExposureCalculator;
import good.ocp.RGBPhotoExposureCalculator;

public class RGBPhotoExposureCalculatorTest {

	@Test
	public void checkExists() {
		PhotoExposureCalculator rgbCalculator = new RGBPhotoExposureCalculator();
		assertNotNull(rgbCalculator);
	}

	@Test
	public void checkCalculatorAverageExposure() {
		int[][][] rgbPhoto = new int[][][] { { { 1, 2, 3 }, { 4, 5, 6 } }, { { 100, 101, 102 }, { 103, 104, 105 } },
				{ { 250, 251, 252 }, { 253, 254, 255 } } };
		PhotoExposureCalculator rgbCalculator = new RGBPhotoExposureCalculator();
		System.out.println(rgbCalculator.calculateAverageExposure(rgbPhoto));
		assertEquals(rgbCalculator.calculateAverageExposure(rgbPhoto), "119.50");
	}
}
