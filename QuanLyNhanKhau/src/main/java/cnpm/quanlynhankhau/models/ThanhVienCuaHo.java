package cnpm.quanlynhankhau.models;

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

    public void setQuanHeVoiChuHo(String quanHeVoiChuHo) {
        this.quanHeVoiChuHo = quanHeVoiChuHo;
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
