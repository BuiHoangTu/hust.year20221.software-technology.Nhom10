package cnpm.quanlynhankhau.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaChiTest {

	@Test
	void parse() {
		DiaChi diaChi = new DiaChi(null,"hbc",null,"11/195",null);

		DiaChi diaChiParse = DiaChi.parse(diaChi.toString());

		assertEquals(diaChi.toString(), diaChiParse.toString());
	}
}