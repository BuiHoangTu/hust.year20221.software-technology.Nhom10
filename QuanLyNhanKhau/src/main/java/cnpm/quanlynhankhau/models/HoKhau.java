package cnpm.quanlynhankhau.models;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HoKhau {
    private String soHoKhau;
    private NhanKhau chuHo;
    private boolean chuHoIsChanged = false;
    private String maKhuVuc;
    private boolean maKhuVucIsChanged = false;
    private DiaChi diaChi;
    private boolean diaChiIsChanged = false;
    private LocalDate ngayLap;
    private boolean ngayLapIsChanged = false;
    private final List<NhanKhau> thanhViens = new ArrayList<>();
    // TODO add or delete from database directly, remove isChanged


    public String getSoHoKhau() {
        return soHoKhau;
    }


    public NhanKhau getChuHo() {
        return chuHo;
    }

    public void setChuHo(NhanKhau chuHo) {
        this.chuHo = chuHo;
        chuHoIsChanged = true;
    }

    public String getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
        maKhuVucIsChanged = true;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
        diaChiIsChanged = true;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
        ngayLapIsChanged = true;
    }

    public List<NhanKhau> getThanhViens() {
        return thanhViens;
    }

    public void themThanhVien(NhanKhau thanhVien) {
        this.thanhViens.add(thanhVien);
        // TODO: 14/01/2023 insert database
    }

    public void xoaThanhVien(NhanKhau nhanKhau) {
        this.thanhViens.remove(nhanKhau);
        // TODO: 14/01/2023 remove databse
    }
    public void xoaThanhVien(int sttNhanKhau) {
        this.thanhViens.remove(sttNhanKhau);
        // TODO: 14/01/2023 remove db
    }


    public List<HoKhau> filterBySoLuong(int slnk) {
        List<HoKhau> output = new ArrayList<>();
        // TODO here

        return output;
    }

    public void chuyenDiaChi (DiaChi diaChiMoi) {
        // TODO chuyen dia chi
    }


    /**
     * Save changes in this HK in database
     * Changes don't include NKs' content changes
     */
    public void commit() throws SQLException {
        // lưu loại thay đổi

        // region thong tin thay doi
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("INSERT INTO quan_ly_nhan_khau.dinh_chinh_ho_khau (idHoKhau, thongTinThayDoi, thayDoiTu, thayDoiThanh, nguoiThayDoi) VALUES( ? , ? , ? , ? , ?);");
        // thông tin thay đổi
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
        statement.setString(1, soHoKhau);
        statement.setString(5, String.valueOf(QuanLyNhanKhauApplication.USER));

        // luu thay doi
        if (chuHoIsChanged) {
            statement.setString(2, "Chủ Hộ");
            statement.setString(4, chuHo.getSoNhanKhau());

            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
                    SELECT idChuHo
                    FROM quan_ly_nhan_khau.ho_khau
                    WHERE maHoKhau = ?;
                    """);
            subStatement.setString(1, soHoKhau);

            ResultSet resultSet = subStatement.executeQuery();
            if (!resultSet.next()) {
                throw new SQLException("HoKhau khong ton tai");
            }
            String chuHoCu = resultSet.getString("idChuHo");

            statement.setString(3, chuHoCu);

            statement.executeUpdate();
        }
        if (maKhuVucIsChanged) {
            statement.setString(2, "Mã Khu Vực");
            statement.setString(4, maKhuVuc);

            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
                    SELECT maKhuVuc
                    FROM quan_ly_nhan_khau.ho_khau
                    WHERE maHoKhau = ?;
                    """);
            subStatement.setString(1, soHoKhau);

            ResultSet resultSet = subStatement.executeQuery();
            if (!resultSet.next()) {
                throw new SQLException("HoKhau khong ton tai");
            }
            String MKVcu = resultSet.getString("maKhuVuc");

            statement.setString(3, MKVcu);

            statement.executeUpdate();
        }
        // TODO: 14/01/2023 tuong tu
        // endregion


        // commit to db
        sqlQuery = new StringBuilder();
        sqlQuery.append("UPDATE quan_ly_nhan_khau.ho_khau ");
        // SET idChuHo=NULL, maKhuVuc=NULL, diaChi=NULL, ngayLap=NULL, nguoiThucHien=NULL

        if (chuHoIsChanged) sqlQuery.append("SET idChuHo= ? ");
        if (maKhuVucIsChanged) sqlQuery.append("SET maKhuVuc= ? ");
        // TODO: 14/01/2023 tuong tu
        sqlQuery.append("WHERE maHoKhau = ? ");

        statement = Database.getConnection().prepareStatement(sqlQuery.toString());
        int i = 1;
        if (chuHoIsChanged) {
            statement.setString(i, chuHo.getSoNhanKhau());
            i += 1;
        }
        if (maKhuVucIsChanged) {
            statement.setString(i, maKhuVuc.toString());
            i += 1;
        };
        // TODO: 14/01/2023 tuong tu
        statement.setString(i, soHoKhau);
        // gửi câu lệnh đến DB
        statement.executeUpdate();

        chuHoIsChanged = false;
        maKhuVucIsChanged = false;
        diaChiIsChanged = false;
        ngayLapIsChanged = false;
    }

    public static void main(String[] args) {
        HoKhau x = null;
        x.setChuHo(new NhanKhau());
    }
}
