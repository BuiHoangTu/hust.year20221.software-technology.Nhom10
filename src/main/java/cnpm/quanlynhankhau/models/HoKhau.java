package cnpm.quanlynhankhau.models;

import java.time.LocalDate;
import java.util.List;

public class HoKhau {
    private String soHoKhau;
    private NhanKhau chuHo;
    // TODO làm IsChanged như NK
    private String maKhuVuc;
    private DiaChi diaChi;
    private LocalDate ngayLap;
    private List<NhanKhau> thanhViens;


    public String getSoHoKhau() {
        return soHoKhau;
    }


    public NhanKhau getChuHo() {
        return chuHo;
    }

    public void setChuHo(NhanKhau chuHo) {
        this.chuHo = chuHo;
    }

    public String getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public List<NhanKhau> getThanhViens() {
        return thanhViens;
    }

    public void themThanhVien(NhanKhau thanhVien) {
        this.thanhViens.add(thanhVien);
    }

    public void xoaThanhVien(NhanKhau nhanKhau) {
        this.thanhViens.remove(nhanKhau);
    }
    public void xoaThanhVien(int sttNhanKhau) {
        this.thanhViens.remove(sttNhanKhau);
    }


    /**
     * Save changes in this HK in database
     * Changes don't include NKs' content changes
     */
    public void commit() {
        // TODO make commit
    }
}
