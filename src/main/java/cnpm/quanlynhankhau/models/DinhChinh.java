package cnpm.quanlynhankhau.models;

import java.time.LocalDate;

public class DinhChinh {
	private int id;
	private HoKhau idHoKhau = new HoKhau();
	private String thongTinThayDoi;
	private String thayDoiTu;
	private String thayDoiThanh;
	private LocalDate ngayThayDoi;
	private String nguoiThayDoi;
}
