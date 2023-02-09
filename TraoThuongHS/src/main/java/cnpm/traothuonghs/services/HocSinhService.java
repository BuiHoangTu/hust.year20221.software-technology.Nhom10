package cnpm.traothuonghs.services;

import cnpm.traothuonghs.models.HocSinh;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HocSinhService {
    public static HocSinh themHocSinh(HocSinh hocSinh) throws SQLException {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("Insert into trao_thuong_hoc_sinh.hoc_sinh(ten, ngaySinh, truongHoc, lop, maHoKhau, phuHuynh)" +
                        "Values(?, ?, ?, ?, ?)");
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString(), Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, null/*hocSinh.getTen()*/);
        statement.setString(2, null/*hocSinh.getNgaySinh*/);
        statement.setString(3, null/*hocSinh.getTruongHoc*/);
        statement.setString(4, null/*hocSinh.getMaHoKhau*/);
        statement.setString(5, null/*hocSinh.getPhuHuynh*/);
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        rs.next();
        return null;
    }

    public static final int BY_MA_HOC_SINH = 1, BY_TEN = 2, BY_NGAY_SINH = 3, BY_DIA_CHI = 4;
    public static List<HocSinh> getHocSinh(int loaiMa, String ma) throws SQLException {
        List<HocSinh> lisHS = new ArrayList<>();
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("Select * from trao_thuong_hoc_sinh.hoc_sinh ");
        if (loaiMa == 1){
            sqlQuery.append("where id = ?");
        } else if (loaiMa == 2) {
            ma = "%" + ma + "%";
            sqlQuery.append("where ten LIKE ?");
        } else if (loaiMa == 3) {
            sqlQuery.append("where namSinh = ?");
        } else if (loaiMa == 4) {
            ma = "%" + ma + "%";
            sqlQuery.append("WHERE maHoKhau in (SELECT maHoKhau FROM quan_ly_nhan_khau.ho_khau where diaChi LIKE ?)");
        }else {
            return null;
        }
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
        statement.setString(1, ma);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            HocSinh x = new HocSinh(resultSet.getString(2), resultSet.getDate(3).toLocalDate(), resultSet.getString(4),
                                    resultSet.getString(6), resultSet.getString(7));
            lisHS.add(x);
        }

        return lisHS;
    }
}
