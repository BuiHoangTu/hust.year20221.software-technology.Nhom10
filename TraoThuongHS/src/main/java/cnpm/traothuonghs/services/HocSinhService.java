package cnpm.traothuonghs.services;

import cnpm.traothuonghs.models.HocSinh;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HocSinhService {
    public static final int BY_ID_HOC_SINH = 1, BY_TEN = 2, BY_TRUONG = 3, BY_LOP = 4, BY_PHU_HUYNH = 5;
    public static List<HocSinh> findHocSinh (int loaiMa, String filter) throws SQLException {
        List<HocSinh> output = new ArrayList<>();
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("Select * from trao_thuong_hoc_sinh.hoc_sinh ");
        if (loaiMa == 1) {
            sqlQuery.append("where id = ?");
        } else if (loaiMa == 2) {
            filter = "%" + filter + "%";
            sqlQuery.append("where ten like ?");
        } else if (loaiMa == 3) {
            filter = "%" + filter + "%";
            sqlQuery.append("where truongHoc like ?");
        } else if (loaiMa == 4) {
            filter = "%" + filter + "%";
            sqlQuery.append("where lop like ?");
        } else if (loaiMa == 5) {
            filter = "%" + filter + "%";
            sqlQuery.append("where phuHuynh like ?");
        } else {
            System.out.println("Khong kha dung");
            return null;
        }
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
        statement.setString(1, filter);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            HocSinh x = new HocSinh(rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4), rs.getString(6), rs.getString(7));
            output.add(x);
        }

        return output;
    }

    public static HocSinh getHocSinh (int loaiMa, String filter) throws SQLException {
        try {
            return findHocSinh(1, filter).get(0);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return null;
        }
    }

    public static HocSinh themHocSinh (String ten, String phuHuynh, LocalDate ngaySinh, String truongHoc, String lop, String maHK, String danhHieu) throws SQLException {
        String idNK;
        String sqlQuery = "Insert into trao_thuong_hoc_sinh.hoc_sinh (ten, ngaySinh, truongHoc, lop, maHoKhau, phuHuynh) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, ten);
        statement.setString(2, ngaySinh.toString());
        statement.setString(3, truongHoc);
        statement.setString(4, lop);
        statement.setString(5, maHK);
        statement.setString(6, phuHuynh);

        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        while (rs.next()) {

            // TODO : Thêm danh hiệu
            idNK = rs.getString(1);
            String sqlQuery2 = "Insert into trao_thuong_hoc_sinh.phan_thuong (ngayPhatThuong, dotPhatThuong, danhHieu) values (?, ?, ?)";
            PreparedStatement statement1 = Database.getConnection().prepareStatement(sqlQuery2);
            statement1.setString(1, LocalDate.now().toString()); // TODO : thêm theo ngày hôm nay
            statement1.setString(2, new TinhThuongService().toString()); // TODO : thêm tên đợt theo đợt gần nhất so với ngày hiện tại
            statement1.setString(3, danhHieu);

            statement1.executeUpdate();

            return HocSinhService.getHocSinh(1, idNK);
        }

        return null;
    }

    public static int getSoHocSinh() throws SQLException {
        int count = 0;
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("Select COUNT(id) from hoc_sinh");
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
        ResultSet res = statement.executeQuery();
        res.next();
        count = res.getInt("COUNT(id)");
        return count;
    }
}
