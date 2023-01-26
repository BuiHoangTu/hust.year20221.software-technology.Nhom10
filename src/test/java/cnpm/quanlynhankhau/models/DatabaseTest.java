package cnpm.quanlynhankhau.models;

import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    @Test
    void taoHoKhau() throws SQLException {
        HoKhau x = new HoKhau();
        NhanKhau chuHo = new NhanKhau();
        //chuHo.setSoNhanKhau("000000000001");
        DiaChi diaChi = new DiaChi(null,"hbc",null,"11/195",null);
        x.setChuHo(chuHo);
        x.setDiaChi(diaChi);
        x.setMaKhuVuc("12");

        Database test = new Database();
        test.taoHoKhau(x);
    }
    @Test
    void getNhanKhau() throws SQLException {

        System.out.println("getNhanKhauTest");
        List<NhanKhau> res =  Database.getNhanKhau(3,"Mỹ Linh");
        for (NhanKhau x : res){
            System.out.println(x.getSoNhanKhau());
        }

        res =  Database.getNhanKhau(1,"Mỹ Linh");
        for (NhanKhau x : res){
            System.out.println(x.getSoNhanKhau());
        }
        res =  Database.getNhanKhau(2,"Mỹ Linh");
        for (NhanKhau x : res){
            System.out.println(x.getSoNhanKhau());
        }
        res =  Database.getNhanKhau(4,"Mỹ Linh");
        for (NhanKhau x : res){
            System.out.println(x.getSoNhanKhau());
        }
        res =  Database.getNhanKhau(5,"Mỹ Linh");
        for (NhanKhau x : res){
            System.out.println(x.getSoNhanKhau());
        }

    }

    @Test
    void xoaNhanKhau() throws SQLException {
        NhanKhau x = Database.getNhanKhau(1, "5").get(0);
        Database.xoaNhanKhau(x);
    }


//	@Test
//	void login() throws SQLException {
//		assertFalse(Database.login(null, null));
//		assertFalse(Database.login("wrong", "wrong"));
//		assertTrue(Database.login("admin", "1"));
//	}
}