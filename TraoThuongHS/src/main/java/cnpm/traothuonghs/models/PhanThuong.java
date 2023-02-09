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
}
