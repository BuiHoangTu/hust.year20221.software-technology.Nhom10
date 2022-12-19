package cnpm.quanlynhankhau.models;

import java.sql.Date;
import java.util.List;

public class HoKhau {
    private String SoHoKhau;
    private NhanKhau chuHo;
    private List<NhanKhau> thanhVien;
    private Date ngayLap;
    private Address address;
}
