package cnpm.quanlynhankhau.models;

import cnpm.quanlynhankhau.services.ChungMinhThuService;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;

class ChungMinhThuTest {

    @Test
    void lamCMT() throws SQLException {//test
        DiaChi diaChi = new DiaChi("HCM", "TX", "HBT", "120","");
        ChungMinhThuService.lamCMT(null, diaChi);
    }
}