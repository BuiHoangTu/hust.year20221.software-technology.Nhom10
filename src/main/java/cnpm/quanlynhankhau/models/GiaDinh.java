package cnpm.quanlynhankhau.models;

import java.time.LocalDate;

public class GiaDinh {
	private int id;
	private NhanKhau idNhanKhau = new NhanKhau();
	private String hoTen = idNhanKhau.name;
	private String[] bietdanh = idNhanKhau.nickname;
	private LocalDate dateOfBirth = idNhanKhau.birthday;
	private boolean isMale = idNhanKhau.isMale;
	private String quanHeVoiNhanKhau;
	private String ngheNghiep = idNhanKhau.ngheNghiep;
	private Address DCHienTai = idNhanKhau.DCHienTai;
}
