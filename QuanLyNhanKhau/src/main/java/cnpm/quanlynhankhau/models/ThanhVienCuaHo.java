package cnpm.quanlynhankhau.models;

import cnpm.quanlynhankhau.services.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class ThanhVienCuaHo {
    public String hoTen;
    public String quanHeVoiChuHo;

    public LocalDate ngaySinh;

    public String maNhanKhau;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getQuanHeVoiChuHo() {
        return quanHeVoiChuHo;
    }

    public void setQuanHeVoiChuHo(String quanHeVoiChuHo) throws SQLException {
        this.quanHeVoiChuHo = quanHeVoiChuHo;
        PreparedStatement subStatement = Database.getConnection().prepareStatement("""
                UPDATE quan_ly_nhan_khau.thanh_vien_cua_ho
                SET quanHeVoiChuHo = ?
                WHERE idNhanKhau = ?;
                """);
            subStatement.setString(1, quanHeVoiChuHo);
        subStatement.setString(2, this.maNhanKhau);
        subStatement.executeUpdate();
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public ThanhVienCuaHo(String hoTen, String quanHeVoiChuHo, LocalDate ngaySinh, String maNhanKhau) {
        this.hoTen = hoTen;
        this.quanHeVoiChuHo = quanHeVoiChuHo;
        this.ngaySinh = ngaySinh;
        this.maNhanKhau = maNhanKhau;
    }

    public String getMaNhanKhau() {
        return maNhanKhau;
    }

    public void setMaNhanKhau(String maNhanKhau) {
        this.maNhanKhau = maNhanKhau;
    }


}
