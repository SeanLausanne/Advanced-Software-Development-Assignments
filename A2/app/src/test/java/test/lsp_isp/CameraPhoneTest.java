package test.lsp_isp;

import static org.junit.Assert.*;
import org.junit.Test;

import good.lsp_isp.CameraPhone;

public class CameraPhoneTest {

	@Test
	public void checkExists() {
		CameraPhone phone = new CameraPhone("iPhone 13");
		assertNotNull(phone);
	}

	@Test
	public void checkGetModel() {
		CameraPhone phone = new CameraPhone("iPhone 13");
		assertEquals(phone.getModel(), "iPhone 13");
	}

	@Test
	public void checkShootPhoto() {
		CameraPhone phone = new CameraPhone("iPhone 13");
		assertEquals(phone.shootPhoto(), "Shooting photo");
	}

	@Test
	public void checkShootVideo() {
		CameraPhone phone = new CameraPhone("iPhone 13");
		assertEquals(phone.shootVideo(), "Shooting video");
	}

	@Test
	public void checkGetLens() {
		CameraPhone phone = new CameraPhone("iPhone 13");
		assertEquals(phone.getLens(), "Original lens");
	}

	@Test
	public void checkCall() {
		CameraPhone phone = new CameraPhone("iPhone 13");
		assertEquals(phone.call(), "Calling");
	}

	@Test
	public void checkText() {
		CameraPhone phone = new CameraPhone("iPhone 13");
		assertEquals(phone.text(), "Texting");
	}
}
