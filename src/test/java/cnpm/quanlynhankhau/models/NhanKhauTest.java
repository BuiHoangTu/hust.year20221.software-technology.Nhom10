package cnpm.quanlynhankhau.models;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class NhanKhauTest {

	@Test
	void testCommit() throws SQLException {
		
		NhanKhau x = Database.getNhanKhau(1, "8").get(0);
		x.setNgaySinh(LocalDate.parse("2002-05-06"));
		x.commit();
		
	}
	
//	@Test
//    void testAddTamTruVang() throws SQLException {
//        NhanKhau x = new NhanKhau();
//        x.setSoNhanKhau("000000000013");
//        DiaChi tamVang = new DiaChi("HCM", "Ba Dinh", "HHT", "4", "");
//        DiaChi tamTru = new DiaChi("Hanoi", "HBT","DCV","12","");
//        TamTruVang truVang = new TamTruVang(null,LocalDate.of(2002,11,12), LocalDate.of(2025,11,12), tamVang, tamTru, "");
//        x.addTamTruVang(truVang);
//    }
//
//    @Test
//    void removeTamTruVang() throws SQLException {
//        NhanKhau x = new NhanKhau(); //lấy từ database
//        System.out.println("ma giay tam tru vang: ");
//        System.out.println(x.getTamTruVangs().get(0).getMaTamTruVang());
//        x.removeTamTruVang(x.getTamTruVangs().get(0));
//    }

}
