package cnpm.quanlynhankhau.models;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class NhanKhauTest {

    @Test
    void testAddTamTruVang() throws SQLException {
        NhanKhau x = new NhanKhau();
        x.setSoNhanKhau("000000000013");
        DiaChi tamVang = new DiaChi("Hanoi", "Ba Dinh", "HHT", "4", "");
        DiaChi tamTru = new DiaChi("Hanoi", "HBT","DCV","12","");
        TamTruVang truVang = new TamTruVang(null,LocalDate.of(2002,11,12), LocalDate.of(2025,11,12), tamVang, tamTru, "");
        x.addTamTruVang(truVang);
    }

    @Test
    void removeTamTruVang() throws SQLException {
        NhanKhau x = new NhanKhau();
        DiaChi tamVang = new DiaChi("Hanoi", "Ba Dinh", "HHT", "4", "");
        DiaChi tamTru = new DiaChi("Hanoi", "HBT","DCV","12","");
        TamTruVang truVang = new TamTruVang("3", LocalDate.of(2002,11,12), LocalDate.of(2025,11,12), tamVang, tamTru, "");
        x.removeTamTruVang(truVang);
    }
}