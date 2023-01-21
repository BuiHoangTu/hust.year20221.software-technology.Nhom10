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

    public static final int BY_MA_NHAN_KHAU = 1, BY_SO_DIEN_THOAI = 2, BY_TEN = 3, BY_NGAY_SINH = 4, BY_DIA_CHI = 5;
    public static List<NhanKhau> getNhanKhau(int loaiMa, String ma) throws SQLException {
        List<NhanKhau> result = new ArrayList<>();
        // TODO tim nk co ma = maNhanKhau
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("Select * from quan_ly_nhan_khau.nhan_khau ");
        if(loaiMa == 1) sqlQuery.append("where maNhanKhau = ?");
        else if(loaiMa == 2) sqlQuery.append("where soDienThoai = ?");
        else if(loaiMa == 3) {
            ma = "%" + ma + "%";
            sqlQuery.append("where hoTen LIKE ?;");
        }
        else if(loaiMa == 4) sqlQuery.append("where namSinh = ?");
        else if(loaiMa == 5) {
            ma = "%" + ma + "%";
            sqlQuery.append("where diaChiHienNay LIKE ?");
        }
        else{
            System.out.println("Khong kha dung");
            return null;
        }
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
        statement.setString(1, ma);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            boolean Gender = true;
            if(rs.getString(5).equals("Nam")){
                Gender = true;
            }else{
                Gender = false;
            }
            NhanKhau x = new NhanKhau(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(9),Gender,DiaChi.parse(rs.getString(12)),
                    rs.getDate(4).toLocalDate(), /*DiaChi.parse(rs.getString(6))*/null,DiaChi.parse(rs.getString(7)), rs.getString(8), rs.getString(11),DiaChi.parse(rs.getString(13)),
                    rs.getString(15),rs.getString(14), rs.getString(17), rs.getString(18),DiaChi.parse(rs.getString(19)), rs.getString(20),/*rs.getDate(21).toLocalDate()*/null,
                    rs.getString(22), rs.getString(31), null,rs.getString(27),/*rs.getDate(28).toLocalDate()*/ null,rs.getString(29),rs.getString(30), rs.getDate(26).toLocalDate());
            result.add(x);
        }
        for (NhanKhau nk : result){
            System.out.println(nk.getTen());
        }
        //finish(chac the)
        return result;
    }

    public static void xoaNhanKhau (NhanKhau nhanKhau) throws SQLException {
        // TODO xoaNhanKhau
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("Delete from quan_ly_nhan_khau.nhan_khau where maNhanKhau = ?;");
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
        statement.setString(1, nhanKhau.getSoNhanKhau());
        ResultSet resultSet = statement.executeQuery();
        if(!resultSet.next()){
            throw new SQLException("Nhan Khau khong ton tai");
        }
    }

    public static void taoHoKhau (HoKhau hoKhau) throws SQLException {
        // TODO: 14/01/2023 insert database
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("Insert into quan_ly_nhan_khau.ho_khau (idChuHo, maKhuVuc, diaChi, ngayLap) values(?, ?, ?, ?, ?);");
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());

        statement.setString(1, hoKhau.getChuHo().getSoNhanKhau());
        statement.setString(2, hoKhau.getMaKhuVuc());
        statement.setString(3, hoKhau.getDiaChi().toString());
        statement.setString(4, hoKhau.getNgayLap().toString());
        statement.executeUpdate();
    }

}
