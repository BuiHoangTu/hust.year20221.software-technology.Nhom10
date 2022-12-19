package cnpm.quanlynhankhau.models;

import java.time.LocalDate;
import java.util.List;

public class HoKhau {
    private String SoHoKhau;
    private NhanKhau chuHo;
    private List<NhanKhau> thanhVien;
    private LocalDate ngayLap;
    private Address address;
}
