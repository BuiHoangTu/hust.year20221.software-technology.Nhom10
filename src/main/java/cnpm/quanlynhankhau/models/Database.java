package cnpm.quanlynhankhau.models;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class xứ lý giao tiếp DB mà không phù hợp chứa trong các models khác
 */
public class Database {
    private static final String dbURL = "jdbc:mysql://localhost:3306/quan_ly_nhan_khau";
    private static final String dbUName = "root";
    private static final String dbPasswd = "";
    private static volatile Connection connection = null;


    public static Connection getConnection(boolean autocommit){
        if(connection == null){
            try{
                connection = DriverManager.getConnection(dbURL, dbUName, dbPasswd);
                connection.setAutoCommit(autocommit);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static Connection getConnection(){
        return getConnection(true);
    }

    public static int login(String uname, String passwd) throws SQLException {
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("""
            SELECT ID
            FROM quan_ly_nhan_khau.users
            WHERE quan_ly_nhan_khau.users.userName = ?
            AND quan_ly_nhan_khau.users.passwd = ?
            """);
        preparedStatement.setString(1, uname);
        preparedStatement.setString(2, passwd);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (! resultSet.next()) {
            return -1;
        }

        return Integer.parseInt(resultSet.getString("ID"));
    }

    /**
     * Danh sách tạm trú/vắng của 1 người
     * @param soNhanKhau định danh người này
     * @return Các lần tạm trú/vắng
     * @throws SQLException khi kết nối đến db thất bại. Bật mySQL lên.
     */
    public static List<TamTruVang> searchTamVang(String soNhanKhau) throws SQLException {
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("""
                SELECT maGiayTamtru, tuNgay, denNgay, lyDo
                FROM quan_ly_nhan_khau.tam_tru
                WHERE quan_ly_nhan_khau.tam_tru.idNhanKhau = ?;
                """);
        preparedStatement.setString(1, soNhanKhau);
        ResultSet res = preparedStatement.executeQuery();

        List<TamTruVang> output = new ArrayList<>();
        while (res.next()) {
            output.add(new TamTruVang(
                    res.getString("maGiayTamtru"),
                    LocalDate.parse(res.getString("tuNgay")),
                    LocalDate.parse(res.getString("denNgay")),
                    DiaChi.parse(res.getString("diaChiTamVang")),
                    DiaChi.parse(res.getString("diaChiTamTru")),
                    res.getString("lyDo")
                    ));
        }

        return output;
    }

    public static final int BY_MA_NHAN_KHAU = 1, BY_SO_DIEN_THOAI = 2;
    public static List<NhanKhau> getNhanKhau(int loaiMa, String ma) {
        // TODO tim nk co ma = maNhanKhau
        return null;
    }

    public static void xoaNhanKhau (NhanKhau nhanKhau) {
        // TODO xoaNhanKhau
    }

    public static void taoHoKhau (HoKhau hoKhau) {
        // TODO: 14/01/2023 insert database
        // TODO: 14/01/2023 insert database
    }

}
