package cnpm.traothuonghs.services;

import cnpm.traothuonghs.models.HocSinh;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class HocSinhServiceTest {

    @Test
    void getHocSinh() throws SQLException {
        List<HocSinh> lis =  HocSinhService.getHocSinh(2, "Nguyễn");
        for (HocSinh x : lis){
            System.out.println(x);
        }
    }
}