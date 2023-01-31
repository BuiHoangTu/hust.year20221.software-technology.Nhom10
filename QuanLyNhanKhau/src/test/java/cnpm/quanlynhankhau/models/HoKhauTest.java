package cnpm.quanlynhankhau.models;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class HoKhauTest {

    @Test
    void themThanhVien() throws SQLException {
        NhanKhau NK = new NhanKhau();
        NK.setSoNhanKhau("39");
        NK.setTen("Le Ngoc Dang Khoa");
        NK.setNgaySinh(LocalDate.parse("2002-09-30"));
        NK.setDanToc("Kinh");
        NhanKhau CH = new NhanKhau();
        CH.setSoNhanKhau("40");
        CH.setTen("Le Thanh Binh");
        CH.setNgaySinh(LocalDate.parse("1971-03-19"));
        CH.setDanToc("Kinh");
        HoKhau HK = new HoKhau("14",CH, "HN03", null, LocalDate.now());
        HK.themThanhVien(NK, "Con");
    }

    @Test
    void xoaThanhVien() throws SQLException {
        NhanKhau NK = new NhanKhau();
        NK.setSoNhanKhau("39");
        NK.setTen("Le Ngoc Dang Khoa");
        NK.setNgaySinh(LocalDate.parse("2002-09-30"));
        NK.setDanToc("Kinh");
        NhanKhau CH = new NhanKhau();
        CH.setSoNhanKhau("40");
        CH.setTen("Le Thanh Binh");
        CH.setNgaySinh(LocalDate.parse("1971-03-19"));
        CH.setDanToc("Kinh");
        HoKhau HK = new HoKhau("14",CH, "HN03", null, LocalDate.now());
        HK.xoaThanhVien(NK);
    }

    @Test
    void testXoaThanhVien() {
    }

    @Test
    void filterBySoLuong() throws SQLException {
        List<HoKhau>test = new ArrayList<>();
        test = HoKhau.filterBySoLuong(3);
        for (int i=0; i < test.size() ; i++ ){
            System.out.println(test.get(i).getSoHoKhau()+" "+test.get(i).getMaKhuVuc()+" "+test.get(i).getDiaChi().toString()+" "+test.get(i).getNgayLap()+" ");
        }
    }

    @Test
    void chuyenDiaChi() throws SQLException {
        NhanKhau CH = new NhanKhau();
        CH.setSoNhanKhau("40");
        CH.setTen("Le Thanh Binh");
        CH.setNgaySinh(LocalDate.parse("1971-03-19"));
        CH.setDanToc("Kinh");
        HoKhau HK = new HoKhau("14",CH, "HN03", null, LocalDate.now());
        DiaChi DC = new DiaChi();
        DC = DiaChi.parse("Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội");
        System.out.println(DC.thanhPho);
        //HK.chuyenDiaChi(DC);
    }

    @Test
    void commit() throws SQLException {
        NhanKhau CH = new NhanKhau();
        CH.setSoNhanKhau("40");
        CH.setTen("Le Thanh Binh");
        CH.setNgaySinh(LocalDate.parse("1971-03-19"));
        CH.setDanToc("Kinh");
        HoKhau HK = new HoKhau("14",CH, "HN03", null, LocalDate.now());
        HK.setNgayLap(LocalDate.parse("2022-01-31"));
        HK.commit();
    }




}