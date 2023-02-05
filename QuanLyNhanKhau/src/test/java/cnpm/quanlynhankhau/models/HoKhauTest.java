package cnpm.quanlynhankhau.models;

import cnpm.quanlynhankhau.services.HoKhauService;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HoKhauTest {

    @Test

    void commit() {

    }

    @Test
    void change() throws SQLException {
        HoKhau HKtest = HoKhauService.getHoKhau("3");
        HKtest.change(null, "HN05",null, LocalDate.now());
    }
}