package cnpm.quanlynhankhau.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaChiTest {

	@Test
	void parse() {
		DiaChi diaChi = new DiaChi(null,"hbc",null,"11/195",null);
		assertEquals(diaChi.toString(), DiaChi.parse(diaChi.toString()).toString());
		System.out.println(diaChi);

		diaChi = new DiaChi("a", null, "c", null, "e");
		assertEquals(diaChi.toString(), DiaChi.parse(diaChi.toString()).toString());
		System.out.println(diaChi);

		diaChi = new DiaChi("a,b,c", null, "c", null, "e");
		assertEquals(diaChi.toString(), DiaChi.parse(diaChi.toString()).toString());
		System.out.println(diaChi);

		diaChi = new DiaChi(null, null, null, null, null);
		assertEquals(diaChi.toString(), DiaChi.parse(diaChi.toString()).toString());
		System.out.println(diaChi);

	}
}