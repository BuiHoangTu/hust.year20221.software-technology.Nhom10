package cnpm.quanlynhankhau.models;

import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
	@Test
	void taoHoKhau() throws SQLException { //test
		HoKhau x = new HoKhau();
		x.setDiaChi(DiaChi.parse("null,hbc,null,11/195,null"));
		x.setChuHo(Database.getNhanKhau(1, "1").get(0));
		x.setMaKhuVuc("12");
		//model nhu cu
		Database.taoHoKhau(x);
	}
	@Test
	void getNhanKhau() throws SQLException { //test

		System.out.println("getNhanKhauTest");
		System.out.println("Search theo Tên");
		List<NhanKhau> res =  Database.getNhanKhau(3,"Quân"); //search theo ten
		for (NhanKhau x : res){
			System.out.print("result: ");
			System.out.println(x.getSoNhanKhau() + " " + x.getTen());
		}//tìm người có tên Quân

		System.out.println();

		System.out.println("Search theo maNhanKhau");
		res =  Database.getNhanKhau(1,"1"); //search theo maNhanKhau
		for (NhanKhau x : res){
			System.out.print("result: ");
			System.out.println(x.getSoNhanKhau());
		}
		System.out.println();
		System.out.println("\nSeach theo namSinh");
		res =  Database.getNhanKhau(4, "1990"); //search theo nam sinh
		for (NhanKhau x : res){
			System.out.print("result: ");
			System.out.println(x.getSoNhanKhau() + " " + x.getTen());
		}
		System.out.println();
		System.out.println("Search theo DiaChi");
		res =  Database.getNhanKhau(5,"Hai Bà Trưng"); //search theo dia chi
		for (NhanKhau x : res){
			System.out.print("\nresult: ");
			System.out.print(x.getSoNhanKhau());
		}

		System.out.println("\n\nSearch Danh sach Tam Tru:");
		res = Database.getNhanKhau(1, "1");
		for (NhanKhau x : res){
			System.out.print("result: ");
			System.out.println(x.getSoNhanKhau() + " " + x.getTen());
			System.out.println("Danh sach tam tru");
			for (TamTruVang tv : res.get(0).getTamTruVangs()){
				System.out.print(tv.getMaTamTruVang() + " ");
			}
		}
	}

	@Test
	void xoaNhanKhau() throws SQLException {//test
		NhanKhau x = Database.getNhanKhau(1, "6").get(0);//xóa nhân khẩu có maNhanKhau
		Database.xoaNhanKhau(x);
	}


	@Test
	void login() throws SQLException {
		assertFalse(Database.login(null, null) > 0);
		assertFalse(Database.login("wrong", "wrong") > 0);
		assertTrue(Database.login("admin", "1") > 0);
	}
}