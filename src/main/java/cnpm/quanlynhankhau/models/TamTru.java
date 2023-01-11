package cnpm.quanlynhankhau.models;

import java.time.LocalDate;

public class TamTru {
	private int id;
	private NhanKhau idNhanKhau = new NhanKhau();
	private String maGiayTamTru;
	private String soDienThoaiNguoiDangKy;
	private LocalDate tuNgay;
	private LocalDate denNgay;
	private String lyDo;
}
