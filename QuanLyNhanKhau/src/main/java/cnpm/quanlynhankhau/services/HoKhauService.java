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
	public static final int BY_MA_HO_KHAU = 1, BY_ID_CHU_HO = 2, BY_DIA_CHI = 3;
	/**
	 * Lấy các hộ khẩu có
	 *
	 * @param filter
	 * @return hộ khẩu chứa filter
	 * @throws SQLException query lỗi
	 */
	public static List<HoKhau> findHoKhau(int loaiMa, String filter) throws SQLException {
		List<HoKhau> output = new ArrayList<>();
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("Select * from quan_ly_nhan_khau.ho_khau ");
		if (loaiMa == 1) {
			sqlQuery.append("where maHoKhau = ?");
		} else if (loaiMa == 2) {
			sqlQuery.append("where idChuHo = ?");
		} else if (loaiMa == 3) {
			filter = "%" + filter + "%";
			sqlQuery.append("where diaChi like ?");
		} else {
			System.out.println("Khong kha dung");
			return null;
		}
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
		statement.setString(1, filter);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			HoKhau x = new HoKhau(rs.getString("maHoKhau"), NhanKhauService.getNhanKhau(rs.getString("idChuHo")),
					rs.getString("maKhuVuc"), DiaChi.parse(rs.getString("diaChi")), rs.getDate("ngayLap").toLocalDate());
			output.add(x);
		}

		String sqlQuery2 = "Select * from quan_ly_nhan_khau.thanh_vien_cua_ho where idHoKhau = ?";
		PreparedStatement statement1 = Database.getConnection().prepareStatement(sqlQuery2);
		for (HoKhau hk : output) {
			statement1.setString(1, hk.getSoHoKhau());
			ResultSet lis = statement1.executeQuery();
			while (lis.next()) {
				hk.getThanhViens().add(NhanKhauService.getNhanKhau(lis.getString("idNhanKhau"), lis.getString(3)));
			}
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
					where thanh_vien_cua_ho.idHoKhau=?
					""");
			subStatement.setString(1, soHK);
			res = subStatement.executeQuery();

			while (res.next()) {
				tvs.add(NhanKhauService.getNhanKhau(res.getString("idNhanKhau")));
			}

			subStatement = Database.getConnection().prepareStatement("""
					select * from quan_ly_nhan_khau.nhan_khau
					where nhan_khau.maNhanKhau=?
					""");
			subStatement.setString(1, idCH);
			res = subStatement.executeQuery();
			res.next();

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
