package cnpm.quanlynhankhau.models;

import java.time.LocalDate;

public class TamVang {
	private int id;
	private NhanKhau idNhanKhau = new NhanKhau();
	private String maGiayTamVang;
	private Address noiTamTru = new Address();
	private LocalDate tuNgay;
	private LocalDate denNgay;
	private String lyDo;
}
