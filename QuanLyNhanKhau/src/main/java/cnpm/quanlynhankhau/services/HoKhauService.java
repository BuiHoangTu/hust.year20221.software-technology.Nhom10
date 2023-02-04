package cnpm.quanlynhankhau.services;

import cnpm.quanlynhankhau.models.DiaChi;
import cnpm.quanlynhankhau.models.HoKhau;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HoKhauService {
	/**
	 * Lấy các hộ khẩu có
	 *
	 * @param filter
	 * @return hộ khẩu chứa filter
	 * @throws SQLException query lỗi
	 */
	public static List<HoKhau> findHoKhau(String filter) throws SQLException {
		List<HoKhau> output = new ArrayList<>();
		PreparedStatement statement = Database.getConnection().prepareStatement("""
				select * from quan_ly_nhan_khau.ho_khau
				where maHoKhau like ?""");
		statement.setString(1, "%" + filter + "%");
		ResultSet res = statement.executeQuery();

		while (res.next()) {
			var idCH = res.getString("idChuHo");
			var cH = NhanKhauService.getNhanKhau(idCH);

			var hk = new HoKhau(res.getString("maHoKhau"), cH, res.getString("maKhuVuc"), DiaChi.parse(res.getString("diaChi")), LocalDate.parse(res.getString("ngayLap")));
			var tvs = hk.getThanhViens();

			PreparedStatement subStatement = Database.getConnection().prepareStatement("""
					select * from quan_ly_nhan_khau.thanh_vien_cua_ho
					where ho_Khau.idHoKhau=?
					""");
			subStatement.setString(1, res.getString("idHoKhau"));
			res = subStatement.executeQuery();

			while (res.next()) {
				tvs.add(NhanKhauService.getNhanKhau(res.getString("idNhanKhau")));
			}

			output.add(hk);
		}
		return output;
	}

	/**
	 * Lấy MỘT hộ khẩu
	 *
	 * @param soHK số hộ khẩu
	 * @return Object hộ khẩu
	 * @throws SQLException when execute query
	 */
	public static HoKhau getHoKhau(String soHK) throws SQLException {
		PreparedStatement statement = Database.getConnection().prepareStatement("""
				select * from quan_ly_nhan_khau.ho_khau
				where maHoKhau =?
				""");
		statement.setString(1, soHK);
		ResultSet res = statement.executeQuery();

		if (res.next()) {
			var idCH = res.getString("idChuHo");
			var cH = NhanKhauService.getNhanKhau(idCH);

			var hk = new HoKhau(soHK, cH, res.getString("maKhuVuc"), DiaChi.parse(res.getString("diaChi")), LocalDate.parse(res.getString("ngayLap")));
			var tvs = hk.getThanhViens();

			PreparedStatement subStatement = Database.getConnection().prepareStatement("""
					select * from quan_ly_nhan_khau.thanh_vien_cua_ho
					where maHoKhau = ?
					""");
			subStatement.setString(1, soHK);
			res = subStatement.executeQuery();

			while (res.next()) {
				tvs.add(NhanKhauService.getNhanKhau(res.getString("idNhanKhau")));
			}

			return hk;
		} else return null;
	}

	public static HoKhau taoHoKhau(String soHKChuHo, String maKhuVuc, String diaChi) throws SQLException {
		String sqlQuery = "Insert into quan_ly_nhan_khau.ho_khau (idChuHo, maKhuVuc, diaChi) values(?, ?, ?);";
		ResultSet rs = null;

		try {
			PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, soHKChuHo);
			statement.setString(2, maKhuVuc);
			statement.setString(3, diaChi);
			statement.executeUpdate();
			rs = statement.getGeneratedKeys();
		} catch (SQLException e) {
			throw new SQLException("Hộ khẩu không được tạo, vui lòng thử lại sau");
		}

		if (rs.next()) {
			return getHoKhau(rs.getString(1));
		} else throw new SQLException("Hộ khẩu đã được tạo nhưng không tìm thấy, thử lại sau");

	}

}
