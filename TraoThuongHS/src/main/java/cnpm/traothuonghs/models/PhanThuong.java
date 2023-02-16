package cnpm.traothuonghs.models;

import cnpm.traothuonghs.services.TinhThuongService;

import java.time.LocalDate;

public class PhanThuong {
	private LocalDate ngayPhatThuong;
	private String tenDotPhatThuong;
	private String danhHieu;
	private String lop;
	private int soVo;
	private int giaTri;

	/**
	 * Dùng khi tạo phần thưởng mới
	 * @param ngayPhatThuong
	 * @param tenDotPhatThuong
	 * @param danhHieu
	 */
	public PhanThuong(LocalDate ngayPhatThuong, String tenDotPhatThuong, String danhHieu, String lop) {
		this.ngayPhatThuong = ngayPhatThuong;
		this.tenDotPhatThuong = tenDotPhatThuong;
		this.danhHieu = danhHieu;
		this.lop = lop;

		TinhThuongService tinhThuongService = new TinhThuongService(ngayPhatThuong);
		this.soVo = tinhThuongService.getPhanThuong(danhHieu);
		this.giaTri = soVo * tinhThuongService.getGiaVo();

		// TODO: 27/01/2023 database this
	}

	public LocalDate getNgayPhatThuong() {
		return ngayPhatThuong;
	}

	public void setNgayPhatThuong(LocalDate ngayPhatThuong) {
		this.ngayPhatThuong = ngayPhatThuong;
	}

	public String getTenDotPhatThuong() {
		return tenDotPhatThuong;
	}

	public void setTenDotPhatThuong(String tenDotPhatThuong) {
		this.tenDotPhatThuong = tenDotPhatThuong;
	}

	public String getDanhHieu() {
		return danhHieu;
	}

	public void setDanhHieu(String danhHieu) {
		this.danhHieu = danhHieu;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public int getSoVo() {
		return soVo;
	}

	public void setSoVo(int soVo) {
		this.soVo = soVo;
	}

	public int getGiaTri() {
		return giaTri;
	}

	public void setGiaTri(int giaTri) {
		this.giaTri = giaTri;
	}
}
