package test.ocp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import good.ocp.BlackWhitePhotoExposureCalculator;
import good.ocp.PhotoExposureCalculator;

public class BlackWhitePhotoExposureCalculatorTest {

	@Test
	public void checkExists() {
		PhotoExposureCalculator bwCalculator = new BlackWhitePhotoExposureCalculator();
		assertNotNull(bwCalculator);
	}

	@Test
	public void checkCalculatorAverageExposure() {
		// only bwPhoto[0] will be calculated
		int[][][] bwPhoto = new int[][][] { { { 1, 2, 3 }, { 4, 5, 6 } }, { { 1, 1, 1 }, { 1, 1, 1 } },
				{ { 1, 1, 1 }, { 1, 1, 1 } } };
		PhotoExposureCalculator bwCalculator = new BlackWhitePhotoExposureCalculator();
		assertEquals(bwCalculator.calculateAverageExposure(bwPhoto), "3.50");
	}
}
