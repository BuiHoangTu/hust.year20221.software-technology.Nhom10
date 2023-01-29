package cnpm.quanlynhankhau.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private List<TamTruVang> tamTruVangs = new ArrayList<>();

    private ChungMinhThu chungMinhThu;
    private String idNguoiTao;
    private LocalDate ngayXoa;
    private String idNguoiXoa;
    private String lyDoXoa;
    private LocalDate ngayTao;

    public NhanKhau() {}
    public NhanKhau(String soNhanKhau, String ten, String bietDanh, String tonGiao, boolean isMale, DiaChi thuongTru, LocalDate ngaySinh, DiaChi noiSinh, DiaChi nguyenQuan, String danToc, String hoChieu, DiaChi diaChiHienTai, String trinhDoChuyenMon, String trinhDoHocVan, String trinhDoNgoaiNgu, String ngheNghiep, DiaChi noiLamViec, String tienAn, LocalDate ngayChuyenDen, String lyDoChuyenDen, String ghiChu, ChungMinhThu chungMinhThu, String idNguoiTao, LocalDate ngayXoa, String idNguoiXoa, String lyDoXoa, LocalDate ngayTao) {
        this.soNhanKhau = soNhanKhau;
        this.ten = ten;
        this.bietDanh = bietDanh;
        this.tonGiao = tonGiao;
        this.isMale = isMale;
        this.thuongTru = thuongTru;
        this.ngaySinh = ngaySinh;
        this.noiSinh = noiSinh;
        this.nguyenQuan = nguyenQuan;
        this.danToc = danToc;
        this.hoChieu = hoChieu;
        this.diaChiHienTai = diaChiHienTai;
        this.trinhDoChuyenMon = trinhDoChuyenMon;
        this.trinhDoHocVan = trinhDoHocVan;
        this.trinhDoNgoaiNgu = trinhDoNgoaiNgu;
        this.ngheNghiep = ngheNghiep;
        this.noiLamViec = noiLamViec;
        this.tienAn = tienAn;
        this.ngayChuyenDen = ngayChuyenDen;
        this.lyDoChuyenDen = lyDoChuyenDen;
        this.ghiChu = ghiChu;
        this.chungMinhThu = chungMinhThu;
        this.idNguoiTao = idNguoiTao;
        this.ngayXoa = ngayXoa;
        this.idNguoiXoa = idNguoiXoa;
        this.lyDoXoa = lyDoXoa;
        this.ngayTao = ngayTao;
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
    public void setISMale(boolean male) {
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

    public void addTamTruVang(DiaChi dcTamTru, LocalDate tuNgay, LocalDate denNgay, String lyDo, DiaChi dcTamVang) throws SQLException {
    	String i = "";
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("Insert INTO quan_ly_nhan_khau.tam_tru_vang (idNhanKhau, noiTamTru, tuNgay, denNgay, lyDo, noiTamVang) values(?, ?, ?, ?, ?, ?)");
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString(), Statement.RETURN_GENERATED_KEYS);
        
        statement.setString(1, this.soNhanKhau);
        statement.setString(2, dcTamTru.toString());
        statement.setString(3, tuNgay.toString());
        statement.setString(4, denNgay.toString());
        statement.setString(5, lyDo);
        statement.setString(6, dcTamVang.toString());
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        rs.next();
        String maTamTruVang = rs.getString(1);
        System.out.print(maTamTruVang);
        tamTruVangs.add(new TamTruVang(maTamTruVang, tuNgay, denNgay, dcTamVang, dcTamTru, lyDo));
    }
    
    public void removeTamTruVang(TamTruVang x) throws SQLException {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("Delete from quan_ly_nhan_khau.tam_tru_vang where maGiayTamVang = ?;");
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
        statement.setString(1, x.getMaTamTruVang());
        statement.executeUpdate();
        tamTruVangs.remove(x);
    }
    
    public List<TamTruVang> getTamTruVangs() {
        return tamTruVangs;
    }

    public ChungMinhThu getChungMinhThu() {
        return chungMinhThu;
    }

    /**
     * Save changes in this NK in database
     */
public void commit() throws SQLException {
        
    	StringBuilder sqlQuery = new StringBuilder();
    	// commit to db
        sqlQuery = new StringBuilder();
        sqlQuery.append("UPDATE quan_ly_nhan_khau.nhan_khau ");

        if (tenIsChanged) sqlQuery.append("SET hoTen= ? ");
        if (bietDanhIsChanged) sqlQuery.append("SET bietDanh = ? ");
        if (tonGiaoIsChanged) sqlQuery.append("SET tonGiao = ? ");
        if (isMaleIsChanged) sqlQuery.append("SET gioiTinh = ? ");
        if (thuongTruIsChanged) sqlQuery.append("SET noiThuongTru = ? ");
        if (ngaySinhIsChanged) sqlQuery.append("SET namSinh = ? ");
        if (noiSinhIsChanged) sqlQuery.append("SET noiSinh = ? ");
        if (danTocIsChanged) sqlQuery.append("SET danToc = ? ");
        if (hoChieuIsChanged) sqlQuery.append("SET soHoChieu = ? ");
        if (diaChiHienTaiIsChanged) sqlQuery.append("SET diaChiHienNay= ? ");
        if (trinhDoChuyenMonIsChanged) sqlQuery.append("SET trinhDoChuyenMon = ? ");
        if (trinhDoHocVanIsChanged) sqlQuery.append("SET trinhDoHocVan = ? ");
        if (trinhDoNgoaiNguIsChanged) sqlQuery.append("SET trinhDoNgoaiNgu = ? ");
        if (ngheNghiepIsChanged) sqlQuery.append("SET ngheNghiep = ? ");
        if (noiLamViecIsChanged) sqlQuery.append("SET noiLamViec = ? ");
        if (tienAnIsChanged) sqlQuery.append("SET tienAn = ? ");
        if (ghiChuIsChanged) sqlQuery.append("SET ghiChu = ? ");
        
        // TODO: 14/01/2023 tuong tu
        sqlQuery.append("WHERE maNhanKhau = ? ");

        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
        int i = 1;
        if (tenIsChanged) {
            statement.setString(i, this.ten);
            i += 1;
        };
        if (bietDanhIsChanged) {
        	statement.setString(i, this.bietDanh);
            i += 1;
        }
        if (tonGiaoIsChanged) {
        	statement.setString(i, this.tonGiao);
            i += 1;
        }
        if (isMaleIsChanged) {
        	if (this.isMale) statement.setString(i, "Nam");
        	else statement.setString(i, "Nữ");
            i += 1;
        }
        if (thuongTruIsChanged) {
        	statement.setString(i, this.thuongTru.toString());
            i += 1;
        }
        if (ngaySinhIsChanged) {
        	statement.setString(i, this.ngaySinh.toString());
            i += 1;
        }
        if (noiSinhIsChanged) {
        	statement.setString(i, this.noiSinh.toString());
            i += 1;
        }
        if (danTocIsChanged) {
        	statement.setString(i, this.danToc);
            i += 1;
        }
        if (hoChieuIsChanged) {
        	statement.setString(i, this.hoChieu);
            i += 1;
        }
        if (diaChiHienTaiIsChanged) {
        	statement.setString(i, this.diaChiHienTai.toString());
            i += 1;
        }
        if (trinhDoChuyenMonIsChanged) {
        	statement.setString(i, this.trinhDoChuyenMon);
            i += 1;
        }
        if (trinhDoHocVanIsChanged) {
        	statement.setString(i, this.trinhDoHocVan);
            i += 1;
        }
        if (trinhDoNgoaiNguIsChanged) {
        	statement.setString(i, this.trinhDoNgoaiNgu);
            i += 1;
        }
        if (ngheNghiepIsChanged) {
        	statement.setString(i, this.ngheNghiep);
            i += 1;
        }
        if (noiLamViecIsChanged) {
        	statement.setString(i, this.noiLamViec.toString());
            i += 1;
        }
        if (tienAnIsChanged) {
        	statement.setString(i, this.tienAn);
            i += 1;
        }
        if (ghiChuIsChanged) {
        	statement.setString(i, this.ghiChu);
            i += 1;
        }
        
        // TODO: 14/01/2023 tuong tu
        statement.setString(i, this.soNhanKhau);
        // gửi câu lệnh đến DB
        statement.executeUpdate();
    	
        soNhanKhauIsChanged = false;
        tenIsChanged = false;
        bietDanhIsChanged = false;
        tonGiaoIsChanged = false;
        isMaleIsChanged = false;
        thuongTruIsChanged = false;
        ngaySinhIsChanged = false;
        noiSinhIsChanged = false;
        nguyenQuanIsChanged = false;
        danTocIsChanged = false;
        hoChieuIsChanged = false;
        diaChiHienTaiIsChanged = false;
        trinhDoChuyenMonIsChanged = false;
        trinhDoHocVanIsChanged = false;
        trinhDoNgoaiNguIsChanged = false;
        ngheNghiepIsChanged = false;
        noiLamViecIsChanged = false;
        tienAnIsChanged = false;
        ngayChuyenDenIsChanged = false;
        lyDoChuyenDenIsChanged = false;
        ghiChuIsChanged = false;

    }
}
