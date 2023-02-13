package cnpm.traothuonghs.models;

import cnpm.quanlynhankhau.models.DiaChi;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.services.Database;
import cnpm.traothuonghs.services.TinhThuongService;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class PhanThuong {
	private  String idHocSinh;
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
	public PhanThuong(String idHocSinh, LocalDate ngayPhatThuong, String tenDotPhatThuong, String danhHieu, String lop) {
		this.idHocSinh = idHocSinh;
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

	public String getTenDotPhatThuong() {
		return tenDotPhatThuong;
	}

	public String getDanhHieu() {
		return danhHieu;
	}

	public String getLop() {
		return lop;
	}

	public int getSoVo() {
		return soVo;
	}

	public int getGiaTri() {
		return giaTri;
	}

	public void setDanhHieu(String danhHieu) {
		this.danhHieu = danhHieu;
	}

	public void change(LocalDate ngayPhatThuong, String tenDotPhatThuong, String danhHieu, String lop) throws SQLException {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("UPDATE trao_thuong_hoc_sinh.phan_thuong SET  ");

		if (ngayPhatThuong != null) sqlQuery.append("ngayPhatThuong like ? , ");
		if (tenDotPhatThuong != null) sqlQuery.append("dotPhatThuong = ? , ");
		if (danhHieu != null) sqlQuery.append("danhHieu = ? , ");
		if (lop != null) sqlQuery.append("lop = ? , ");

		sqlQuery.deleteCharAt(sqlQuery.length()-2);
		sqlQuery.append(" WHERE idHocSinh = ? ");

		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
		int i = 1;
		if (ngayPhatThuong != null) {
			statement.setString(i, ngayPhatThuong.toString());
			i += 1;
		}
		if (tenDotPhatThuong != null) {
			statement.setString(i, tenDotPhatThuong);
			i += 1;
		}
		if (danhHieu != null) {
			statement.setString(i, danhHieu);
			i += 1;
		}
		if (lop != null) {
			statement.setString(i, lop);
			i += 1;
		}

		statement.setString(i, idHocSinh);
		//System.out.println(statement);
		// gửi câu lệnh đến DB
		statement.executeUpdate();
	}
}
