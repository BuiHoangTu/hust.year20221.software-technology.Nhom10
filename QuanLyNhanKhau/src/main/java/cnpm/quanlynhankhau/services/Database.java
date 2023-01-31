package cnpm.quanlynhankhau.services;

import cnpm.quanlynhankhau.models.ChungMinhThu;
import cnpm.quanlynhankhau.models.DiaChi;
import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.models.NhanKhau;

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
}