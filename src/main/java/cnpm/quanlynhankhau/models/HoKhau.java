package cnpm.quanlynhankhau.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HoKhau {
    private String soHoKhau;
    private NhanKhau chuHo;
    // TODO làm IsChanged như NK
    private boolean chuHoIsChanged = false;
    private String maKhuVuc;
    private boolean maKhuVucIsChanged = false;
    private DiaChi diaChi;
    private boolean diaChiIsChanged = false;
    private LocalDate ngayLap;
    private boolean ngayLapIsChanged = false;
    private final List<NhanKhau> thanhViens = new ArrayList<>();
    private boolean thanhVienIsChanged = false;


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
        thanhVienIsChanged = true;
    }

    public void xoaThanhVien(NhanKhau nhanKhau) {
        this.thanhViens.remove(nhanKhau);
        thanhVienIsChanged = true;
    }
    public void xoaThanhVien(int sttNhanKhau) {
        this.thanhViens.remove(sttNhanKhau);
        thanhVienIsChanged = true;
    }


    /**
     * Save changes in this HK in database
     * Changes don't include NKs' content changes
     */
    public void commit() {
        chuHoIsChanged = false;
        maKhuVucIsChanged = false;
        diaChiIsChanged = false;
        ngayLapIsChanged = false;
        thanhVienIsChanged = false;
        // TODO make commit
    }
}
