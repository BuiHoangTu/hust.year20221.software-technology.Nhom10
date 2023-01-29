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

    public static final int BY_MA_NHAN_KHAU = 1, BY_SO_DIEN_THOAI = 2, BY_TEN = 3, BY_NGAY_SINH = 4, BY_DIA_CHI = 5;
    public static List<NhanKhau> getNhanKhau(int loaiMa, String ma) throws SQLException {
        List<NhanKhau> result = new ArrayList<>();
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("Select * from quan_ly_nhan_khau.nhan_khau ");

        if(loaiMa == 1) sqlQuery.append("where maNhanKhau = ?");
        else if(loaiMa == 2) sqlQuery.append("where soDienThoai = ?");
        else if(loaiMa == 3) {
            ma = "%" + ma + "%";
            sqlQuery.append("where hoTen LIKE ?;");
        }
        else if(loaiMa == 4) {
            ma = "%" + ma + "%";
            sqlQuery.append("where namSinh LIKE ?;");
        }
        else if(loaiMa == 5) {
            ma = "%" + ma + "%";
            sqlQuery.append("where diaChiHienNay LIKE ?");
        } else{
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

        StringBuilder sqlQuery2 = new StringBuilder();
        sqlQuery2.append("Select * from quan_ly_nhan_khau.tam_tru_vang where idNhanKhau = ?");
        PreparedStatement statement1 = Database.getConnection().prepareStatement(sqlQuery2.toString());
        for(NhanKhau nk : result){
            statement1.setString(1, nk.getSoNhanKhau());
            ResultSet lis = statement1.executeQuery();
            while (lis.next()){
                TamTruVang ttv = new TamTruVang(lis.getString(2),lis.getDate(4).toLocalDate(), lis.getDate(5).toLocalDate(),
                                        DiaChi.parse(lis.getString(7)), DiaChi.parse(lis.getString(3)),lis.getString(6));
                nk.getTamTruVangs().add(ttv);
            }
        }

        //finish(chac the)
        return result;
    }
    public static List<NhanKhau> getNhanKhau(String maNK) throws SQLException {
        return getNhanKhau(1, maNK);
    }

    public static HoKhau getHoKhau(String soHK) throws SQLException{
        PreparedStatement subStatement = Database.getConnection().prepareStatement("""
                select * from quan_ly_nhan_khau.ho_khau
                inner join thanh_vien_cua_ho on thanh_vien_cua_ho.idHoKhau = ho_khau.idHoKhau
        		inner join nhan_khau on nhan_khau.maNhanKhau = ho_khau.idChuHo
        		where ho_Khau.idHoKhau=?
                """);
        subStatement.setString(1, String.format("%d", soHK));
        ResultSet res = subStatement.executeQuery();

        NhanKhau NK = new NhanKhau();
        NK.setTen(res.getString("hoTen"));
        NK.setBietDanh(res.getString("bietDanh"));
        NK.setDanToc(res.getString("danToc"));
        NK.setGhiChu(res.getString("ghiChu"));
        NK.setHoChieu(res.getString("soHoChieu"));
        NK.setDiaChiHienTai(DiaChi.parse(res.getString("diaChiHienNay")));
        NK.setNgaySinh(LocalDate.parse(res.getString("namSinh")));
        NK.setNoiSinh(DiaChi.parse(res.getString("noiSinh")));
        NK.setNguyenQuan(DiaChi.parse(res.getString("nguyenQuan")));
        NK.setTonGiao(res.getString("tonGiao"));
        NK.setTrinhDoHocVan(res.getString("trinhDoHocVan"));
        NK.setTrinhDoChuyenMon(res.getString("TrinhDoChuyenMon"));
        NK.setTrinhDoNgoaiNgu(res.getString("trinhDoNgoaiNgu"));
        NK.setNgheNghiep(res.getString("ngheNghiep"));
        NK.setNoiLamViec(DiaChi.parse(res.getString("noiLamViec")));
        NK.setTienAn(res.getString("tienAn"));
        NK.setNgayChuyenDen(LocalDate.parse(res.getString("ngayChuyenDen")));
        NK.setLyDoChuyenDen(res.getString("lyDoChuyenDen"));
        return new HoKhau(res.getString("idHoKhau"), NK, res.getString("maKhuVuc"), DiaChi.parse(res.getString("diaChi")), LocalDate.parse(res.getString("ngayLap")));
        }



    public static void xoaNhanKhau (NhanKhau nhanKhau) throws SQLException {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("Delete from quan_ly_nhan_khau.nhan_khau where maNhanKhau = ?;");
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
        statement.setString(1, nhanKhau.getSoNhanKhau());
        statement.executeUpdate();
    }

    public static NhanKhau taoNhanKhau(String ten, String bietDanh, String tonGiao, boolean isMale, DiaChi thuongTru, LocalDate ngaySinh, DiaChi noiSinh, DiaChi nguyenQuan, String danToc, String hoChieu, DiaChi diaChiHienTai, String trinhDoChuyenMon, String trinhDoHocVan, String trinhDoNgoaiNgu, String ngheNghiep, DiaChi noiLamViec, String tienAn, LocalDate ngayChuyenDen, String lyDoChuyenDen, String ghiChu, ChungMinhThu chungMinhThu) throws SQLException {
        // // TODO: 28/01/2023 tao trong DB
        String idNK = "";
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("Insert into quan_ly_nhan_khau.nhan_khau (hoTen, bietDanh, tonGiao, gioiTinh, noiThuongTru, namSinh, noiSinh, nguyenQuan, danToc, hoChieu, " +
                                                                "diaChiHienNay, TrinhDoChuyenMon, trinhDoHocVan, trinhDoNgoaiNgu, ngheNghiep, noiLamViec, tienAn, " +
                                                                "ngayChuyenDen, lyDoChuyenDen, ghiChu)" +
                                                                "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString(), Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, ten);
        statement.setString(2,bietDanh);
        if(isMale == true){
            statement.setString(3, "Nam");
        }else {
            statement.setString(3, "Nu");
        }
        statement.setString(4, thuongTru.toString());
        statement.setString(5, ngaySinh.toString());
        statement.setString(6, ngaySinh.toString());
        statement.setString(7, noiSinh.toString());
        statement.setString(8, nguyenQuan.toString());
        statement.setString(9, danToc);
        statement.setString(10, hoChieu);
        statement.setString(11, diaChiHienTai.toString());
        statement.setString(12, trinhDoChuyenMon);
        statement.setString(13, trinhDoHocVan);
        statement.setString(14, trinhDoNgoaiNgu);
        statement.setString(15, ngheNghiep);
        statement.setString(16, noiLamViec.toString());
        statement.setString(17, tienAn);
        statement.setString(18, ngayChuyenDen.toString());
        statement.setString(19, lyDoChuyenDen);
        statement.setString(20, ghiChu);
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        while (rs.next()){
            idNK = rs.getString(1);
            NhanKhau x = getNhanKhau(1, idNK).get(0);
            return x;
        }

        return null;
    }

    public static HoKhau taoHoKhau (String soHKChuHo, String maKhuVuc, String diaChi) throws SQLException {
        String i = "";
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("Insert into quan_ly_nhan_khau.ho_khau (idChuHo, maKhuVuc, diaChi) values(?, ?, ?);");
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString(), Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, soHKChuHo);
        statement.setString(2, maKhuVuc);
        statement.setString(3, diaChi);
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        while (rs.next()){
            String soHK = rs.getString(1);
            StringBuilder sqlQuery2 = new StringBuilder();
            sqlQuery2.append("Select * from quan_ly_nhan_khau.ho_khau where maHoKhau = ?");
            PreparedStatement statement1 = Database.getConnection().prepareStatement(sqlQuery2.toString());
            statement1.setString(1, soHK);
            ResultSet resultSet = statement1.executeQuery();
            while (resultSet.next()){
                HoKhau newHK = new HoKhau(soHK, Database.getNhanKhau(1, resultSet.getString(2)).get(0), maKhuVuc,
                        DiaChi.parse(resultSet.getString(4)), resultSet.getDate(5).toLocalDate());
                return newHK;
            }
        }
        // TODO: 28/01/2023 thay bằng tên cột, get HK tu DB and return
        return null;
    }
}
