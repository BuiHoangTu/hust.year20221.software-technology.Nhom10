package cnpm.traothuonghs.models;

import cnpm.quanlynhankhau.services.Database;
import cnpm.traothuonghs.services.TinhThuongService;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HocSinh {
	public static final String[] tenCacTruongHoc = {"Tiểu Học Tây Sơn", "Tiểu Học Thanh Lương", "THCS Đoàn Kết", "THCS Hà Huy Tập", "THPT Thăng Long", "THPT Trần Nhân Tông"}; // TODO: 27/01/2023 thêm tên các trường
	private  String id;
	private String ten;
	private LocalDate ngaySinh;
	private String truongHoc;
	private String maHoKhau;
	private String phuHuynh;
	private final List<PhanThuong> cacPhanThuong = new ArrayList<>();

	public HocSinh(String id, String ten, LocalDate ngaySinh, String truongHoc, String maHoKhau, String phuHuynh) {
		this.id = id;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.truongHoc = truongHoc;
		this.maHoKhau = maHoKhau;
		this.phuHuynh = phuHuynh;
	}

	public String getTen() {
		return ten;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public String getTruongHoc() {
		return truongHoc;
	}

	public String getMaHoKhau() {
		return maHoKhau;
	}

	public String getPhuHuynh() {
		return phuHuynh;
	}

	public String getId() {
		return id;
	}

	public List<PhanThuong> getCacPhanThuong() {
		return cacPhanThuong;
	}

	public void themPhanThuong(String danhHieu) {
		/* todo
		tạo phần thưởng mới, thêm vào cacPhanThuong
		gọi phần thưởng service để thêm vào DB
		 */
	}

	public void change(String ten, LocalDate ngaySinh, String truongHoc, String maHoKhau, String phuHuynh) throws SQLException {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("UPDATE trao_thuong_hoc_sinh.hoc_sinh SET  ");

		if (ten != null) sqlQuery.append("ten = ? , ");
		if (ngaySinh != null) sqlQuery.append("ngaySinh = ? , ");
		if (truongHoc != null) sqlQuery.append("truongHoc = ? , ");
		if (maHoKhau != null) sqlQuery.append("maHoKhau = ? , ");
		if (phuHuynh != null) sqlQuery.append("phuHuynh = ? , ");

		sqlQuery.deleteCharAt(sqlQuery.length()-2);
		sqlQuery.append(" WHERE id = ? ");

		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
		int i = 1;
		if (ten != null) {
			statement.setString(i, ten.toString());
			i += 1;
		}
		if (ngaySinh != null) {
			statement.setString(i, ngaySinh.toString());
			i += 1;
		}
		if (truongHoc != null) {
			statement.setString(i, truongHoc);
			i += 1;
		}
		if (maHoKhau != null) {
			statement.setString(i, maHoKhau);
			i += 1;
		}
		if (phuHuynh != null) {
			statement.setString(i, phuHuynh);
			i += 1;
		}
		statement.setString(i, id);
		//System.out.println(statement);
		// gửi câu lệnh đến DB
		statement.executeUpdate();
	}
}
