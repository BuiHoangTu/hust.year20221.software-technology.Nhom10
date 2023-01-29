package cnpm.quanlynhankhau.models;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class NhanKhauTest2 {

	@Test
	void test() throws SQLException {
		NhanKhau x = Database.getNhanKhau(1, "8").get(0);
		x.addTamTruVang(x.getDiaChiHienTai(), LocalDate.parse("2022-01-28"), LocalDate.parse("2022-02-28"), "Thích", DiaChi.parse("Số 1, Đại Cồ Việt"));
	}
}
