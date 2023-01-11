package cnpm.quanlynhankhau.models;

import java.time.LocalDate;

public class CMND {
	private int id;
	private NhanKhau idNhanKhau = new NhanKhau();
	private String soCMT;
	private LocalDate ngayCap;
	private String noiCap;
}
