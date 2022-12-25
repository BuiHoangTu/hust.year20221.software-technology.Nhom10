package cnpm.quanlynhankhau.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NhanKhau {
    private final StringProperty NK_ID;
    private final StringProperty NK_name;
    private final StringProperty NK_NamSinh;
    private final StringProperty NK_noiSinh;
    private final StringProperty NK_gender;
    private final StringProperty NK_danToc;
    private final StringProperty NK_NguyenQuan;
    private final StringProperty NK_DiaChiHienNay;
    private final StringProperty NK_NoiThuongTru;
    private final StringProperty NK_TrinhDoHV;
    private final StringProperty NK_TrinhDoChuyenMon;
    private final StringProperty NK_ngheNghiep;
    private final StringProperty NK_noiLamViec;
    private final StringProperty NK_trinhDoNgoaiNgu;

    public NhanKhau(String id, String name, String gender , String danToc, String NamSinh ,String noiSinh, String NguyenQuan, String DiaChiHienNay, String NoiThuongTru, String TrinhDoHV, String TrinhDoChuyenMon, String NgheNghiep, String NoiLamViec, String trinhDoNgoaiNgu) {
        this.NK_ID = new SimpleStringProperty(id);
        this.NK_name = new SimpleStringProperty(name);
        this.NK_gender = new SimpleStringProperty(gender);
        this.NK_danToc = new SimpleStringProperty(danToc);
        this.NK_NamSinh = new SimpleStringProperty(NamSinh);
        this.NK_noiSinh = new SimpleStringProperty(noiSinh);
        this.NK_NguyenQuan = new SimpleStringProperty(NguyenQuan);
        this.NK_DiaChiHienNay = new SimpleStringProperty(DiaChiHienNay);
        this.NK_NoiThuongTru = new SimpleStringProperty(NoiThuongTru);
        this.NK_TrinhDoHV = new SimpleStringProperty(TrinhDoHV);
        this.NK_TrinhDoChuyenMon = new SimpleStringProperty(TrinhDoChuyenMon);
        this.NK_ngheNghiep = new SimpleStringProperty(NgheNghiep);
        this.NK_noiLamViec = new SimpleStringProperty(NoiLamViec);
        this.NK_trinhDoNgoaiNgu = new SimpleStringProperty(trinhDoNgoaiNgu);
    }

    public String getNK_name() {
        return NK_name.get();
    }
    public StringProperty NK_nameProperty() {
        return NK_name;
    }
    public String getNK_gender() {
        return NK_gender.get();
    }
    public StringProperty NK_genderProperty() {
        return NK_gender;
    }
    public String getNK_danToc() {
        return NK_danToc.get();
    }
    public StringProperty NK_danTocProperty() {
        return NK_danToc;
    }
    public String getNK_NamSinh() {
        return NK_NamSinh.get();
    }
    public StringProperty NK_NamSinhProperty() {
        return NK_NamSinh;
    }
    public String getNK_ID() { return NK_ID.get(); }
    public StringProperty NK_IDProperty() { return NK_ID;}
    public  String getNK_noiSinh(){
        return NK_noiSinh.get();
    }
    public StringProperty NK_noiSinhProperty() {
        return NK_noiSinh;
    }

    public String getNK_NguyenQuan() {
        return NK_NguyenQuan.get();
    }
    public StringProperty NK_NguyenQuanProperty() {
        return NK_NguyenQuan;
    }

    public String getNK_DiaChiHienNay() {
        return NK_DiaChiHienNay.get();
    }

    public StringProperty NK_DiaChiHienNayProperty() {
        return NK_DiaChiHienNay;
    }

    public String getNK_NoiThuongTru() {
        return NK_NoiThuongTru.get();
    }

    public StringProperty NK_NoiThuongTruProperty() {
        return NK_NoiThuongTru;
    }

    public String getNK_TrinhDoHV() {
        return NK_TrinhDoHV.get();
    }

    public StringProperty NK_TrinhDoHVProperty() {
        return NK_TrinhDoHV;
    }

    public String getNK_TrinhDoChuyenMon() {
        return NK_TrinhDoChuyenMon.get();
    }

    public StringProperty NK_TrinhDoChuyenMonProperty() {
        return NK_TrinhDoChuyenMon;
    }

    public String getNK_ngheNghiep() {
        return NK_ngheNghiep.get();
    }

    public StringProperty NK_ngheNghiepProperty() {
        return NK_ngheNghiep;
    }

    public String getNK_noiLamViec() {
        return NK_noiLamViec.get();
    }

    public StringProperty NK_noiLamViecProperty() {
        return NK_noiLamViec;
    }

    public String getNK_trinhDoNgoaiNgu() {
        return NK_trinhDoNgoaiNgu.get();
    }

    public StringProperty NK_trinhDoNgoaiNguProperty() {
        return NK_trinhDoNgoaiNgu;
    }
}
