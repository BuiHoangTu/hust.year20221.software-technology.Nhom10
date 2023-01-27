package cnpm.traothuonghs.models;

import cnpm.traothuonghs.services.TinhThuong;

import java.time.LocalDate;

public class PhanThuong {
	public static String[] cacDanhHieu = {"Giỏi, Khá, Trung Bình"};

	private LocalDate ngayPhatThuong;
	private String tenDotPhatThuong;
	private String danhHieu;
	private int soVo;
	private int giaTri;

	/**
	 * Dùng khi tạo phần thưởng mới
	 * @param ngayPhatThuong
	 * @param tenDotPhatThuong
	 * @param danhHieu
	 */
	public PhanThuong(LocalDate ngayPhatThuong, String tenDotPhatThuong, String danhHieu) {
		this.ngayPhatThuong = ngayPhatThuong;
		this.tenDotPhatThuong = tenDotPhatThuong;
		this.danhHieu = danhHieu;

		TinhThuong tinhThuong = TinhThuong.getTinhThuong();
		this.soVo = tinhThuong.getPhanThuong(danhHieu);
		this.giaTri = soVo * tinhThuong.getGiaVo();

		// TODO: 27/01/2023 database this
	}
}
