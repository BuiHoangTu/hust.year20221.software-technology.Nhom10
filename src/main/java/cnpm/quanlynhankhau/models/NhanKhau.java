package cnpm.quanlynhankhau.models;

import java.time.LocalDate;

public class NhanKhau {
    private String soNhanKhau;
    public boolean soNhanKhauIsChanged = false;
    private String ten;
    public boolean tenIsChanged = false;
    private String bietDanh;
    public boolean bietDanhIsChanged = false;
    private String tonGiao;
    public boolean tonGiaoIsChanged = false;
    private boolean isMale;
    public boolean isMaleIsChanged = false;
    private DiaChi thuongTru;
    public boolean thuongTruIsChanged = false;
    private LocalDate ngaySinh;
    public boolean ngaySinhIsChanged = false;
    private DiaChi noiSinh;
    public boolean noiSinhIsChanged = false;
    private DiaChi nguyenQuan;
    public boolean nguyenQuanIsChanged = false;
    private String danToc;
    public boolean danTocIsChanged = false;
    private String hoChieu;
    public boolean hoChieuIsChanged = false;
    private DiaChi diaChiHienTai;
    public boolean diaChiHienTaiIsChanged = false;
    private String trinhDoChuyenMon;
    public boolean trinhDoChuyenMonIsChanged = false;
    private String trinhDoHocVan;
    public boolean trinhDoHocVanIsChanged = false;
    private String trinhDoNgoaiNgu;
    public boolean trinhDoNgoaiNguIsChanged = false;
    private String ngheNghiep;
    public boolean ngheNghiepIsChanged = false;
    private DiaChi noiLamViec;
    public boolean noiLamViecIsChanged = false;
    private String tienAn;
    public boolean tienAnIsChanged = false;
    private LocalDate ngayChuyenDen;
    public boolean ngayChuyenDenIsChanged = false;
    private String lyDoChuyenDen;
    public boolean lyDoChuyenDenIsChanged = false;
    private String ghiChu;
    public boolean ghiChuIsChanged = false;

    private ChungMinhThu chungMinhThu;
    private String idNguoiTao;
    private LocalDate ngayXoa;
    private String idNguoiXoa;
    private String lyDoXoa;
    private LocalDate ngayTao;

    public NhanKhau() {
    }


    public String getSoNhanKhau() {
        return soNhanKhau;
    }

    public void setSoNhanKhau(String soNhanKhau) {
        this.soNhanKhau = soNhanKhau;
        soNhanKhauIsChanged = true;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
        tenIsChanged = true;
    }

    public String getBietDanh() {
        return bietDanh;
    }

    public void setBietDanh(String bietDanh) {
        this.bietDanh = bietDanh;
        bietDanhIsChanged = true;
    }

    public String getTonGiao() {
        return tonGiao;
    }

    public void setTonGiao(String tonGiao) {
        this.tonGiao = tonGiao;
        tonGiaoIsChanged = true;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
        isMaleIsChanged = true;
    }

    public DiaChi getThuongTru() {
        return thuongTru;
    }

    public void setThuongTru(DiaChi thuongTru) {
        this.thuongTru = thuongTru;
        thuongTruIsChanged = true;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
        ngaySinhIsChanged = true;
    }

    public DiaChi getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(DiaChi noiSinh) {
        this.noiSinh = noiSinh;
        noiSinhIsChanged = true;
    }

    public DiaChi getNguyenQuan() {
        return nguyenQuan;
    }

    public void setNguyenQuan(DiaChi nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
        nguyenQuanIsChanged = true;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
        danTocIsChanged = true;
    }

    public String getHoChieu() {
        return hoChieu;
    }

    public void setHoChieu(String hoChieu) {
        this.hoChieu = hoChieu;
        hoChieuIsChanged = true;
    }

    public DiaChi getDiaChiHienTai() {
        return diaChiHienTai;
    }

    public void setDiaChiHienTai(DiaChi diaChiHienTai) {
        this.diaChiHienTai = diaChiHienTai;
        diaChiHienTaiIsChanged = true;
    }

    public String getTrinhDoChuyenMon() {
        return trinhDoChuyenMon;
    }

    public void setTrinhDoChuyenMon(String trinhDoChuyenMon) {
        this.trinhDoChuyenMon = trinhDoChuyenMon;
        trinhDoChuyenMonIsChanged = true;
    }

    public String getTrinhDoHocVan() {
        return trinhDoHocVan;
    }

    public void setTrinhDoHocVan(String trinhDoHocVan) {
        this.trinhDoHocVan = trinhDoHocVan;
        trinhDoHocVanIsChanged = true;
    }

    public String getTrinhDoNgoaiNgu() {
        return trinhDoNgoaiNgu;
    }

    public void setTrinhDoNgoaiNgu(String trinhDoNgoaiNgu) {
        this.trinhDoNgoaiNgu = trinhDoNgoaiNgu;
        trinhDoNgoaiNguIsChanged = true;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
        ngheNghiepIsChanged = true;
    }

    public DiaChi getNoiLamViec() {
        return noiLamViec;
    }

    public void setNoiLamViec(DiaChi noiLamViec) {
        this.noiLamViec = noiLamViec;
        noiLamViecIsChanged = true;
    }

    public String getTienAn() {
        return tienAn;
    }

    public void setTienAn(String tienAn) {
        this.tienAn = tienAn;
        tienAnIsChanged = true;
    }

    public LocalDate getNgayChuyenDen() {
        return ngayChuyenDen;
    }

    public void setNgayChuyenDen(LocalDate ngayChuyenDen) {
        this.ngayChuyenDen = ngayChuyenDen;
        ngayChuyenDenIsChanged = true;
    }

    public String getLyDoChuyenDen() {
        return lyDoChuyenDen;
    }

    public void setLyDoChuyenDen(String lyDoChuyenDen) {
        this.lyDoChuyenDen = lyDoChuyenDen;
        lyDoChuyenDenIsChanged = true;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public String getIdNguoiTao() {
        return idNguoiTao;
    }

    public LocalDate getNgayXoa() {
        return ngayXoa;
    }

    public String getIdNguoiXoa() {
        return idNguoiXoa;
    }

    public String getLyDoXoa() {
        return lyDoXoa;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
        ghiChuIsChanged = true;
    }

    public ChungMinhThu getChungMinhThu() {
        return chungMinhThu;
    }


    /**
     * Save changes in this NK in database
     */
    public void commit() {
        // TODO make commit
    }
}
