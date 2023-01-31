package cnpm.quanlynhankhau.models;

import cnpm.quanlynhankhau.services.Database;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

class NhanKhauTest {

    @Test
    void testAddTamTruVang() throws SQLException { //test
        NhanKhau x = Database.findNhanKhau(1, "2").get(0);
        DiaChi tamVang = new DiaChi("HCM", "Ba Dinh", "HHQ", "4", "");
        DiaChi tamTru = new DiaChi("Hanoi", "HBT","DCV","12","");
        x.addTamTruVang(tamTru,LocalDate.of(2002,11,2),LocalDate.of(2025,11,12),null,tamVang);
    }


    @Test
    void testRemoveTamTruVang() throws SQLException {
        NhanKhau x = Database.findNhanKhau(1,"2").get(0);
        x.removeTamTruVang(x.getTamTruVangs().get(0));
    }
}