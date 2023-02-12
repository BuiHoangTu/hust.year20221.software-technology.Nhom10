package cnpm.traothuonghs.models;

import cnpm.traothuonghs.services.TinhThuongService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HocSinh {
	public static final String[] tenCacTruongHoc = {"Tiểu Học Tây Sơn", "Tiểu Học Thanh Lương", "THCS Đoàn Kết", "THCS Hà Huy Tập", "THPT Thăng Long", "THPT Trần Nhân Tông"}; // TODO: 27/01/2023 thêm tên các trường

	private String ten;
	private LocalDate ngaySinh;
	private String truongHoc;
	private String maHoKhau;
	private String phuHuynh;
	private final List<PhanThuong> cacPhanThuong = new ArrayList<>();

	public HocSinh(String ten, LocalDate ngaySinh, String truongHoc, String maHoKhau, String phuHuynh) {
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.truongHoc = truongHoc;
		this.maHoKhau = maHoKhau;
		this.phuHuynh = phuHuynh;
	}

	public void themPhanThuong(String danhHieu) {
		/* todo
		tạo phần thưởng mới, thêm vào cacPhanThuong
		gọi phần thưởng service để thêm vào DB
		 */
	}
}
