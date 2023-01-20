package cnpm.quanlynhankhau.models;

import java.io.IOException;
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
    public static void getNhanKhau(int loaiMa, String ma) throws SQLException {
        // TODO tim nk co ma = maNhanKhau
    	if (loaiMa == 1) { 
	    	PreparedStatement subStatement = Database.getConnection().prepareStatement("""
	                SELECT *
	                FROM quan_ly_nhan_khau.nhan_khau
	                WHERE maNhanKhau = ?;
	                """);
	        subStatement.setString(1, ma);
	        ResultSet res = subStatement.executeQuery();
	        
	        if (!res.next()) {
	            throw new SQLException("NhanKhau khong ton tai");
	        }
	        
	        ChungMinhThu CMTtemp;
	        
	        NhanKhau nk = new NhanKhau(
	        	ma,
	        	res.getString("hoTen"),
	        	res.getString("bietDanh"),
	        	res.getString("tonGiao"),
	        	res.getString("gioiTinh") == "Nam"? true : false,
	        	DiaChi.parse(res.getString("noiThuongTru")),
	        	LocalDate.parse(res.getString("namSinh")),
	        	DiaChi.parse(res.getString("noiSinh")),
	        	DiaChi.parse(res.getString("nguyenQuan")),
	        	res.getString("danToc"),
	        	res.getString("soHoChieu"),
	        	DiaChi.parse(res.getString("diaChiHienNay")),
	        	res.getString("trinhDoChuyenMon"),
	        	res.getString("trinhDoHocVan"),
	        	res.getString("trinhDoNgoaiNgu"),
	        	res.getString("ngheNghiep"),
	        	DiaChi.parse(res.getString("noiLamViec")),
	        	res.getString("tienAn"),
	        	LocalDate.parse(res.getString("ngayChuyenDen")),
	        	res.getString("lyDoChuyenDen"),
	        	res.getString("ghiChu"),
	        	CMTtemp, // chua co CMT parse()
	        	res.getString("idNguoiTao"),
	        	LocalDate.parse(res.getString("ngayXoa")),
	        	res.getString("idNguoiXoa"),
	        	res.getString("lyDoXoa"),
	        	LocalDate.parse(res.getString("ngayTao"))
	        );
	   	        
	        subStatement.executeUpdate();
    	} else if (loaiMa == 2) {
    		
    	}
    }

    public static void xoaNhanKhau (NhanKhau nhanKhau) throws SQLException {
        // TODO xoaNhanKhau
    	StringBuilder sqlQuery = new StringBuilder();
    	sqlQuery = new StringBuilder();
        sqlQuery.append("DELETE FROM quan_ly_nhan_khau.nhan_khau ");
        sqlQuery.append("WHERE idChuHo= ? ");

        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
        
        statement.setString(1, nhanKhau.getSoNhanKhau());
        
        statement.executeUpdate();
        
        // Done. Need Check and Test
    }

    public static void taoHoKhau (HoKhau hoKhau) throws SQLException {
        // TODO: 14/01/2023 insert database
    	StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("INSERT INTO quan_ly_nhan_khau.ho_khau (maHoKhau, idChuHo, maKhuVuc, diaChi, ngayLap) VALUES( ? , ? , ? , ? , ? );");
        // thông tin thêm
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
        
        statement.setString(1, hoKhau.getSoHoKhau());
        statement.setString(2, hoKhau.getChuHo().getSoNhanKhau());
        statement.setString(3, hoKhau.getMaKhuVuc());
        statement.setString(4, hoKhau.getDiaChi().toString());
        statement.setString(5, hoKhau.getNgayLap().toString());
        
        statement.executeUpdate();
        
        // Done. Need Check and Test
    }

}
