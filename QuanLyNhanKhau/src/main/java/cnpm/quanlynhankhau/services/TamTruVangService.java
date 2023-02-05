package cnpm.quanlynhankhau.services;

import cnpm.quanlynhankhau.models.DiaChi;
import cnpm.quanlynhankhau.models.TamTruVang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TamTruVangService {

    public static TamTruVang getTamTruVang(String maTamTruVang) throws SQLException {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("Select * from quan_ly_nhan_khau.tam_tru_vang where maGiayTamVang = ?");
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
        statement.setString(1, maTamTruVang);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            TamTruVang x = new TamTruVang(rs.getString(2), rs.getDate(4).toLocalDate(),rs.getDate(5).toLocalDate()
                                            , DiaChi.parse(rs.getString(7)),DiaChi.parse(rs.getString(3)), rs.getString(6));
            return x;
        }
        return null;
    }

    public static void xacNhanTamTruVang(String maTamTruVang) throws SQLException {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("Update quan_ly_nhan_khau.tam_tru_vang " +
                        "set daXacNhanTamVangTru = 1 " +
                        "where maGiayTamVang = ?");
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
        statement.setString(1, maTamTruVang);
        statement.executeUpdate();
    }
}
