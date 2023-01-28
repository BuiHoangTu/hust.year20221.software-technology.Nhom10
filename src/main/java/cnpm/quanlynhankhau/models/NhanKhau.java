package cnpm.quanlynhankhau.models;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;

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
    private final List<TamTruVang> tamTruVangs = new ArrayList<>();
    // TODO commit directly

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

    public void addTamTruVang(TamTruVang x) throws SQLException {
        tamTruVangs.add(x);
        // TODO: 14/01/2023 db
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("INSERT INTO quan_ly_nhan_khau.dinh_chinh_ho_khau (idNhanKhau, maGiayTamVang, noiTamtru, tuNgay, denNgay, lyDo, noiTamVang, daXacNhanTamVangTru)) VALUES( ? , ? , ? , ? , ? , ? , ? , ? );");
        // thông tin thêm
        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
        
        statement.setString(1, this.getSoNhanKhau());
        statement.setString(2, x.getMaTamTruVang());
        statement.setString(3, x.getDcTamTru().toString());
        statement.setString(4, x.getTuNgay().toString());
        statement.setString(5, x.getDenNgay().toString());
        statement.setString(6, x.getLyDo());
        statement.setString(7, x.getDcTamVang().toString());
        statement.setString(8, "1");
        
        statement.executeUpdate();
        
        // Done. Need Check and Test
    }
    public void removeTamTruVang(TamTruVang x) throws SQLException {
        tamTruVangs.remove(x);
        // TODO: 14/01/2023 db
        StringBuilder sqlQuery = new StringBuilder();
    	sqlQuery = new StringBuilder();
        sqlQuery.append("DELETE FROM quan_ly_nhan_khau.tam_tru_vang ");
        sqlQuery.append("WHERE maGiayTamVang = ? ");

        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
        
        statement.setString(1, x.getMaTamTruVang());
        
        statement.executeUpdate();     
        
        // Done. Need Check and Test
    }
    
    public List<TamTruVang> getTamTruVangs() {
        return tamTruVangs;
    }

    public ChungMinhThu getChungMinhThu() {
        return chungMinhThu;
    }


    /**
     * Khai báo tạm vắng
     * @return Mã tạm vắng
     */
//    public String tamVang(LocalDate tuNgay, LocalDate denNgay) throws SQLException {
//        // TODO database make tam vang
//    	StringBuilder sqlQuery = new StringBuilder();
//        sqlQuery.append("INSERT INTO quan_ly_nhan_khau.tam_vang (idNhanKhau, maGiayTamVang, noiTamTru, diaChi, ngayLap) VALUES( ? , ? , ? , ? , ? );");
//        // thông tin thêm
//        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
//        
//        return null;
//        
//        // Not complete
//    }
//    
//    public String tamTru(LocalDate tuNgay, LocalDate denNgay) throws SQLException {
//        // TODO database make tam vang
//    	StringBuilder sqlQuery = new StringBuilder();
//        sqlQuery.append("INSERT INTO quan_ly_nhan_khau.tam_vang (idNhanKhau, maGiayTamVang, noiTamTru, diaChi, ngayLap) VALUES( ? , ? , ? , ? , ? );");
//        // thông tin thêm
//        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
//        
//        return null;
//        
//        // Not complete
//    }

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
    
    
//    public void commit() throws SQLException {
//        // TODO make commit
//    	
//    	StringBuilder sqlQuery = new StringBuilder();
//        sqlQuery.append("INSERT INTO quan_ly_nhan_khau.dinh_chinh_ho_khau (idNhanKhau, thongTinThayDoi, thayDoiTu, thayDoiThanh, nguoiThayDoi) VALUES( ? , ? , ? , ? , ? );");
//        // thông tin thay đổi
//        PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
//        statement.setString(1, soNhanKhau);
//        statement.setString(5, "345");
//
//        // luu thay doi
//        if (tenIsChanged) {
//            statement.setString(2, "Tên");
//            statement.setString(4, ten);
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT hoTen
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String tenCu = resultSet.getString("hoTen");
//
//            statement.setString(3, tenCu);
//
//            statement.executeUpdate();
//        }
//        if (bietDanhIsChanged) {
//            statement.setString(2, "Biệt Danh");
//            statement.setString(4, bietDanh);
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT bietDanh
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String bietDanhCu = resultSet.getString("bietDanh");
//
//            statement.setString(3, bietDanhCu);
//
//            statement.executeUpdate();
//        }
//        if (tonGiaoIsChanged) {
//            statement.setString(2, "Tôn giáo");
//            statement.setString(4, tonGiao);
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT tonGiao
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String tonGiaoCu = resultSet.getString("tonGiao");
//
//            statement.setString(3, tonGiaoCu);
//
//            statement.executeUpdate();
//        }
//        if (isMaleIsChanged) {
//            statement.setString(2, "Giới tính");
//            if (isMale) statement.setString(4, "Nam");
//            else statement.setString(4, "Nữ");
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT gioiTinh
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String gioiTinhCu = resultSet.getString("gioiTinh");
//
//            statement.setString(3, gioiTinhCu);
//
//            statement.executeUpdate();
//        }
//        if (thuongTruIsChanged) {
//            statement.setString(2, "Thường trú");
//            statement.setString(4, thuongTru.toString());
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT noiThuongTru
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String noiThuongTruCu = resultSet.getString("noiThuongTru");
//
//            statement.setString(3, noiThuongTruCu);
//
//            statement.executeUpdate();
//        }
//        if (ngaySinhIsChanged) {
//            statement.setString(2, "Năm Sinh");
//            statement.setString(4, ngaySinh.toString());
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT namSinh
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String ngaySinhCu = resultSet.getString("namSinh");
//
//            statement.setString(3, ngaySinhCu);
//
//            statement.executeUpdate();
//        }
//        if (noiSinhIsChanged) {
//            statement.setString(2, "Năm Sinh");
//            statement.setString(4, noiSinh.toString());
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT noiSinh
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String noiSinhCu = resultSet.getString("noiSinh");
//
//            statement.setString(3, noiSinhCu);
//
//            statement.executeUpdate();
//        }
//        if (danTocIsChanged) {
//            statement.setString(2, "Dân Tộc");
//            statement.setString(4, danToc);
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT danToc
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String danTocCu = resultSet.getString("danToc");
//
//            statement.setString(3, danTocCu);
//
//            statement.executeUpdate();
//        }
//        if (hoChieuIsChanged) {
//            statement.setString(2, "Hộ chiếu");
//            statement.setString(4, hoChieu);
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT soHoChieu
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String hoChieuCu = resultSet.getString("soHoChieu");
//
//            statement.setString(3, hoChieuCu);
//
//            statement.executeUpdate();
//        }
//        if (diaChiHienTaiIsChanged) {
//            statement.setString(2, "Địa chỉ hiện tại");
//            statement.setString(4, diaChiHienTai.toString());
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT diaChiHienNay
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String diaChiHienTaiCu = resultSet.getString("diaChiHienNay");
//
//            statement.setString(3, diaChiHienTaiCu);
//
//            statement.executeUpdate();
//        }
//        if (trinhDoChuyenMonIsChanged) {
//            statement.setString(2, "Trình độ chuyên môn");
//            statement.setString(4, trinhDoChuyenMon);
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT trinhDoChuyenMon
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String trinhDoChuyenMonCu = resultSet.getString("trinhDoChuyenMon");
//
//            statement.setString(3, trinhDoChuyenMonCu);
//
//            statement.executeUpdate();
//        }
//        if (trinhDoHocVanIsChanged) {
//            statement.setString(2, "Trình độ học vấn");
//            statement.setString(4, trinhDoHocVan);
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT trinhDoHocVan
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String trinhDoHocVanCu = resultSet.getString("trinhDoHocVan");
//
//            statement.setString(3, trinhDoHocVanCu);
//
//            statement.executeUpdate();
//        }
//        if (trinhDoNgoaiNguIsChanged) {
//            statement.setString(2, "Trình độ ngoại ngữ");
//            statement.setString(4, trinhDoNgoaiNgu);
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT trinhDoNgoaiNgu
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String trinhDoNgoaiNguCu = resultSet.getString("trinhDoNgoaiNgu");
//
//            statement.setString(3, trinhDoNgoaiNguCu);
//
//            statement.executeUpdate();
//        }
//        if (ngheNghiepIsChanged) {
//            statement.setString(2, "Nghề nghiệp");
//            statement.setString(4, ngheNghiep);
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT ngheNghiep
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String ngheNghiepCu = resultSet.getString("ngheNghiep");
//
//            statement.setString(3, ngheNghiepCu);
//
//            statement.executeUpdate();
//        }
//        if (noiLamViecIsChanged) {
//            statement.setString(2, "Nơi làm việc");
//            statement.setString(4, noiLamViec.toString());
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT noiLamViec
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String noiLamViecCu = resultSet.getString("noiLamViec");
//
//            statement.setString(3, noiLamViecCu);
//
//            statement.executeUpdate();
//        }
//        if (tienAnIsChanged) {
//            statement.setString(2, "Tiền án");
//            statement.setString(4, tienAn);
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT tienAn
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String tienAnCu = resultSet.getString("tienAn");
//
//            statement.setString(3, tienAnCu);
//
//            statement.executeUpdate();
//        }
//        if (ghiChuIsChanged) {
//            statement.setString(2, "Ghi chú");
//            statement.setString(4, ghiChu);
//
//            PreparedStatement subStatement = Database.getConnection().prepareStatement("""
//                    SELECT ghiChu
//                    FROM quan_ly_nhan_khau.nhan_khau
//                    WHERE maNhanKhau = ?;
//                    """);
//            subStatement.setString(1, soNhanKhau);
//
//            ResultSet resultSet = subStatement.executeQuery();
//            if (!resultSet.next()) {
//                throw new SQLException("NhanKhau khong ton tai");
//            }
//            String ghiChuCu = resultSet.getString("ghiChu");
//
//            statement.setString(3, ghiChuCu);
//
//            statement.executeUpdate();
//        }
//
//        // commit to db
//        sqlQuery = new StringBuilder();
//        sqlQuery.append("UPDATE quan_ly_nhan_khau.nhan_khau ");
//
//        if (tenIsChanged) sqlQuery.append("SET hoTen= ? ");
//        if (bietDanhIsChanged) sqlQuery.append("SET bietDanh = ? ");
//        if (tonGiaoIsChanged) sqlQuery.append("SET tonGiao = ? ");
//        if (isMaleIsChanged) sqlQuery.append("SET gioiTinh = ? ");
//        if (thuongTruIsChanged) sqlQuery.append("SET noiThuongTru = ? ");
//        if (ngaySinhIsChanged) sqlQuery.append("SET namSinh = ? ");
//        if (noiSinhIsChanged) sqlQuery.append("SET noiSinh = ? ");
//        if (danTocIsChanged) sqlQuery.append("SET danToc = ? ");
//        if (hoChieuIsChanged) sqlQuery.append("SET soHoChieu = ? ");
//        if (diaChiHienTaiIsChanged) sqlQuery.append("SET diaChiHienNay= ? ");
//        if (trinhDoChuyenMonIsChanged) sqlQuery.append("SET trinhDoChuyenMon = ? ");
//        if (trinhDoHocVanIsChanged) sqlQuery.append("SET trinhDoHocVan = ? ");
//        if (trinhDoNgoaiNguIsChanged) sqlQuery.append("SET trinhDoNgoaiNgu = ? ");
//        if (ngheNghiepIsChanged) sqlQuery.append("SET ngheNghiep = ? ");
//        if (noiLamViecIsChanged) sqlQuery.append("SET noiLamViec = ? ");
//        if (tienAnIsChanged) sqlQuery.append("SET tienAn = ? ");
//        if (ghiChuIsChanged) sqlQuery.append("SET ghiChu = ? ");
//        
//        // TODO: 14/01/2023 tuong tu
//        sqlQuery.append("WHERE maNhanKhau = ? ");
//
//        statement = Database.getConnection().prepareStatement(sqlQuery.toString());
//        int i = 1;
//        if (tenIsChanged) {
//            statement.setString(i, this.ten);
//            i += 1;
//        };
//        if (bietDanhIsChanged) {
//        	statement.setString(i, this.bietDanh);
//            i += 1;
//        }
//        if (tonGiaoIsChanged) {
//        	statement.setString(i, this.tonGiao);
//            i += 1;
//        }
//        if (isMaleIsChanged) {
//        	if (this.isMale) statement.setString(i, "Nam");
//        	else statement.setString(i, "Nữ");
//            i += 1;
//        }
//        if (thuongTruIsChanged) {
//        	statement.setString(i, this.thuongTru.toString());
//            i += 1;
//        }
//        if (ngaySinhIsChanged) {
//        	statement.setString(i, this.ngaySinh.toString());
//            i += 1;
//        }
//        if (noiSinhIsChanged) {
//        	statement.setString(i, this.noiSinh.toString());
//            i += 1;
//        }
//        if (danTocIsChanged) {
//        	statement.setString(i, this.danToc);
//            i += 1;
//        }
//        if (hoChieuIsChanged) {
//        	statement.setString(i, this.hoChieu);
//            i += 1;
//        }
//        if (diaChiHienTaiIsChanged) {
//        	statement.setString(i, this.diaChiHienTai.toString());
//            i += 1;
//        }
//        if (trinhDoChuyenMonIsChanged) {
//        	statement.setString(i, this.trinhDoChuyenMon);
//            i += 1;
//        }
//        if (trinhDoHocVanIsChanged) {
//        	statement.setString(i, this.trinhDoHocVan);
//            i += 1;
//        }
//        if (trinhDoNgoaiNguIsChanged) {
//        	statement.setString(i, this.trinhDoNgoaiNgu);
//            i += 1;
//        }
//        if (ngheNghiepIsChanged) {
//        	statement.setString(i, this.ngheNghiep);
//            i += 1;
//        }
//        if (noiLamViecIsChanged) {
//        	statement.setString(i, this.noiLamViec.toString());
//            i += 1;
//        }
//        if (tienAnIsChanged) {
//        	statement.setString(i, this.tienAn);
//            i += 1;
//        }
//        if (ghiChuIsChanged) {
//        	statement.setString(i, this.ghiChu);
//            i += 1;
//        }
//        
//        // TODO: 14/01/2023 tuong tu
//        statement.setString(i, this.soNhanKhau);
//        // gửi câu lệnh đến DB
//        statement.executeUpdate();
//    	
//        soNhanKhauIsChanged = false;
//        tenIsChanged = false;
//        bietDanhIsChanged = false;
//        tonGiaoIsChanged = false;
//        isMaleIsChanged = false;
//        thuongTruIsChanged = false;
//        ngaySinhIsChanged = false;
//        noiSinhIsChanged = false;
//        nguyenQuanIsChanged = false;
//        danTocIsChanged = false;
//        hoChieuIsChanged = false;
//        diaChiHienTaiIsChanged = false;
//        trinhDoChuyenMonIsChanged = false;
//        trinhDoHocVanIsChanged = false;
//        trinhDoNgoaiNguIsChanged = false;
//        ngheNghiepIsChanged = false;
//        noiLamViecIsChanged = false;
//        tienAnIsChanged = false;
//        ngayChuyenDenIsChanged = false;
//        lyDoChuyenDenIsChanged = false;
//        ghiChuIsChanged = false;
//
//    }
}
