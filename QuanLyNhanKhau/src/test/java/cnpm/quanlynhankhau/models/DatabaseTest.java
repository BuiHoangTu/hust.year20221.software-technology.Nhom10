package cnpm.quanlynhankhau.models;

import cnpm.quanlynhankhau.services.Database;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    @Test
    void taoHoKhau() throws SQLException {
        NhanKhau chuHo = Database.findNhanKhau(1, "8").get(0);
        DiaChi dc = new DiaChi("Hanoi","HoangMai","HQV","4",null);
        HoKhau nHK = Database.taoHoKhau(chuHo.getSoNhanKhau(), "HN05",dc.toString());
        System.out.println(nHK.getSoHoKhau() + "\t" + nHK.getNgayLap());
    }
    @Test
    void getNhanKhau() throws SQLException {

        System.out.println("getNhanKhauTest");
        List<NhanKhau> res =  Database.findNhanKhau(3,"Mỹ Linh");
        for (NhanKhau x : res){
            System.out.println(x.getSoNhanKhau());
        }

        res =  Database.findNhanKhau(1,"Mỹ Linh");
        for (NhanKhau x : res){
            System.out.println(x.getSoNhanKhau());
        }
        res =  Database.findNhanKhau(2,"Mỹ Linh");
        for (NhanKhau x : res){
            System.out.println(x.getSoNhanKhau());
        }
        res =  Database.findNhanKhau(4,"Mỹ Linh");
        for (NhanKhau x : res){
            System.out.println(x.getSoNhanKhau());
        }
        res =  Database.findNhanKhau(5,"Mỹ Linh");
        for (NhanKhau x : res){
            System.out.println(x.getSoNhanKhau());
        }

    }

    @Test
    void xoaNhanKhau() throws SQLException {
        NhanKhau x = Database.findNhanKhau(1, "5").get(0);
        Database.xoaNhanKhau(x);
    }
	@Test
	void login() throws SQLException {
		assertFalse(Database.login(null, null) > 0);
		assertFalse(Database.login("wrong", "wrong") > 0);
		assertTrue(Database.login("admin", "1") > 0);
	}
}