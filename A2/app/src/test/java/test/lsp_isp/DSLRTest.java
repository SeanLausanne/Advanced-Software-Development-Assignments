package test.lsp_isp;

import static org.junit.Assert.*;
import org.junit.Test;

import good.lsp_isp.DSLR;

public class DSLRTest {
	@Test
	public void checkExists() {
		DSLR dslr = new DSLR("Canon 80D");
		assertNotNull(dslr);
	}

	@Test
	public void checkGetModel() {
		DSLR dslr = new DSLR("Canon 80D");
		assertEquals(dslr.getModel(), "Canon 80D");
	}

	@Test
	public void checkGetLens() {
		DSLR dslr = new DSLR("Canon 80D");
		assertEquals(dslr.getLens(), "Original lens");
	}

	@Test
	public void changeGetLens() {
		DSLR dslr = new DSLR("Canon 80D");
		String newLens = "Canon 50mm F1.8";
		dslr.changeLens(newLens);
		assertEquals(dslr.getLens(), newLens);
	}

	@Test
	public void checkShootPhoto() {
		DSLR dslr = new DSLR("Canon 80D");
		assertEquals(dslr.shootPhoto(), "Shooting photo");
	}

	@Test
	public void checkShootVideo() {
		DSLR dslr = new DSLR("Canon 80D");
		assertEquals(dslr.shootVideo(), "Shooting video");
	}

}
