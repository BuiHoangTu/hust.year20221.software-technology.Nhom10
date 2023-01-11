package cnpm.quanlynhankhau.models;

import java.time.LocalDate;

public class TieuSu {
	private int id;
	private NhanKhau idNhanKhau = new NhanKhau();
	private LocalDate tuNgay;
	private LocalDate denNgay;
	private Address diaChi = new Address();
	private String ngheNghiep = idNhanKhau.ngheNghiep;
	private String noiLamViec = idNhanKhau.noiLamViec;
}
