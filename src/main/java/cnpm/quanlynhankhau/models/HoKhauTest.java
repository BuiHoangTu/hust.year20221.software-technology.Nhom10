package cnpm.quanlynhankhau.models;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HoKhauTest {
	public static void main(String[] args) throws SQLException {
		DiaChi KhuongTrung = new DiaChi("Hà Nội", "Thanh Xuân", "Khương Trung", "99", " ");
		DiaChi NoiSinh = new DiaChi("Hà Nội", "Mai Dịch", "Trần Bình", "9", " ");
		DiaChi NguyenQuan = new DiaChi("Hưng Yên", "Đoàn Đào", " ", " ", " ");
		DiaChi BK = new DiaChi("Hà Nội","Hai Bà Trưng", "Đại Cồ Việt", "1", " ");
		NhanKhau NK = new NhanKhau("123","Lê Ngọc Đăng Khoa","taptapking", "Không",true,KhuongTrung,LocalDate.now(),NoiSinh,NguyenQuan,"Không có","Việt Nam",KhuongTrung,"Sinh Viên","12/12","IELTS 6.0","Sinh Viên",BK,"Không");
		NhanKhau NK2 = new NhanKhau ("234", "Lê Thanh Bình", "lethanhbinhkts", "Không", true, KhuongTrung, LocalDate.now(),NoiSinh,NguyenQuan, "Không có", "Việt Nam",KhuongTrung,"Kiến Trúc Sư","12/12","Không rõ", "Kiến Trúc Sư",BK,"không");
		HoKhau HK = new HoKhau("456", NK2, "11413", KhuongTrung,LocalDate.now());
		
		//HK.themThanhVien(NK, "con");
		//HK.xoaThanhVien(NK);
		for (int i=0; i<HK.filterBySoLuong(4).size(); i++)
			System.out.println(HK.filterBySoLuong(4).get(i).getSoHoKhau());
	}
}
