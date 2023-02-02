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
				where ho_Khau.idHoKhau like ?""");
		statement.setString(1, "%" + filter + "%");
		ResultSet res = statement.executeQuery();

		while (res.next()) {
			var idCH = res.getString("idChuHo");
			var cH = NhanKhauService.getNhanKhau(idCH);

			var hk = new HoKhau(res.getString("idHoKhau"), cH, res.getString("maKhuVuc"), DiaChi.parse(res.getString("diaChi")), LocalDate.parse(res.getString("ngayLap")));
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
				where ho_Khau.idHoKhau=?
				""");
		statement.setString(1, soHK);
		ResultSet res = statement.executeQuery();

		if (res.next()) {
			var idCH = res.getString("idChuHo");
			var cH = NhanKhauService.getNhanKhau(idCH);

			var hk = new HoKhau(res.getString("idHoKhau"), cH, res.getString("maKhuVuc"), DiaChi.parse(res.getString("diaChi")), LocalDate.parse(res.getString("ngayLap")));
			var tvs = hk.getThanhViens();

			PreparedStatement subStatement = Database.getConnection().prepareStatement("""
					select * from quan_ly_nhan_khau.thanh_vien_cua_ho
					where ho_Khau.idHoKhau=?
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
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);

		statement.setString(1, soHKChuHo);
		statement.setString(2, maKhuVuc);
		statement.setString(3, diaChi);
		statement.executeUpdate();
		ResultSet rs = statement.getGeneratedKeys();
		while (rs.next()) {
			String soHK = rs.getString(1);
			String sqlQuery2 = "Select * from quan_ly_nhan_khau.ho_khau where maHoKhau = ?";
			PreparedStatement statement1 = Database.getConnection().prepareStatement(sqlQuery2);
			statement1.setString(1, soHK);
			ResultSet resultSet = statement1.executeQuery();

			while (resultSet.next()) {
				try {
					return new HoKhau(soHK, NhanKhauService.findNhanKhau(1, resultSet.getString(2)).get(0), maKhuVuc, DiaChi.parse(resultSet.getString(4)), resultSet.getDate(5).toLocalDate());
				} catch (NullPointerException | IndexOutOfBoundsException e) {
					return null;
				}
			}
		}
		// TODO: 28/01/2023 thay bằng tên cột, get HK tu DB and return
		return null;
	}

}
