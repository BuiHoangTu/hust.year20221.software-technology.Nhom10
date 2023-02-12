package cnpm.traothuonghs.services;

import cnpm.traothuonghs.models.HocSinh;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HocSinhServiceTest {

    @Test
    void findHocSinh() throws SQLException {
        List<HocSinh> hocSinhs = HocSinhService.findHocSinh(1,"1");
        for (HocSinh hs : hocSinhs) System.out.println(hs.getTen());
    }

    @Test
    void getHocSinh() throws SQLException {
        HocSinh hs = HocSinhService.getHocSinh(1,"1");
        System.out.println(hs.getTen());
    }

    @Test
    void themHocSinh() throws SQLException {
        HocSinhService.themHocSinh("Nguyễn Ngọc Bích", "Nguyễn Duy Luân", LocalDate.parse("2003-06-05"), "Đại Học Ngoại Ngữ", "N.N.Nhật", "10", "Học sinh giỏi", "Tết Nguyên Đán Quý Mão 2023");
    }
}