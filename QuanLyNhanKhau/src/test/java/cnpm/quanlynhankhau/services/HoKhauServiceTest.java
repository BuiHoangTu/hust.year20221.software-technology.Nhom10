package cnpm.quanlynhankhau.services;

import cnpm.quanlynhankhau.models.HoKhau;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class HoKhauServiceTest {

    @Test
    void getHoKhau() throws SQLException {
        ObservableList<HoKhau> HK = FXCollections.observableArrayList();
        for (int i=13; HoKhauService.getHoKhau(String.format("%d", i)) != null ; i++) {
            HK.add(HoKhauService.getHoKhau(String.format("%d", i)));
            // System.out.println(HK.get(i-13).getHoTenChuHo()+" "+HK.get(i-13).getDiaChiString());
        }
    }

    @Test
    void taoHoKhau() throws SQLException {
        HoKhauService.taoHoKhau("1", "HN03", "Đồng nai.");

    }

    @Test
    void testGetHoKhau() throws SQLException {
        HoKhauService.getHoKhau("0");
    }
}