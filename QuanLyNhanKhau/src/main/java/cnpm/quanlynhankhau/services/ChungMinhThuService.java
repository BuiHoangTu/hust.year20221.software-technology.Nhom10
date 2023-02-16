package cnpm.quanlynhankhau.services;

import cnpm.quanlynhankhau.models.ChungMinhThu;
import cnpm.quanlynhankhau.models.DiaChi;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.models.TamTruVang;
import javafx.scene.image.Image;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChungMinhThuService {
	/**
	 * Làm chứng minh thư mới. CMT được cập nhật luôn trong DB
	 * @param anhChanDung ảnh chân dung
	 * @param noiCap địa chỉ nơi cấp
	 * @return chứng minh thư mới
	 */
	public static ChungMinhThu lamCMT(NhanKhau nhanKhau, Image anhChanDung, DiaChi noiCap) throws SQLException {
		String i = "";
		String sqlQuery = "Insert into quan_ly_nhan_khau.chung_minh_thu(noiCap, anhChanDung, maNhanKhau) values (?, ?, ?)";
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, noiCap.toString());
		statement.setBinaryStream(2, null);
		statement.setString(3, nhanKhau.getSoNhanKhau());
		statement.executeUpdate();

		ResultSet output = statement.getGeneratedKeys();
		while (output.next()){
			i = output.getString(1);
		}
		PreparedStatement statement2 = Database.getConnection().prepareStatement("Select * from quan_ly_nhan_khau.chung_minh_thu where soCMT = ?");
		statement2.setString(1, i);
		ResultSet rs = statement2.executeQuery();
		while (rs.next()){
			ChungMinhThu cmt = new ChungMinhThu(rs.getString(1),rs.getDate(2).toLocalDate(),DiaChi.parse(rs.getString(3)), null);
			System.out.println(cmt.getSoCMT() + " " + cmt.getNoiCap());
			return cmt;
		}
		return null;
	}

	public static ChungMinhThu getChungMinhThu (String maNhanKhau) throws SQLException {
		String sqlQuery = "Select * from quan_ly_nhan_khau.chung_minh_thu where maNhanKhau = ?";
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery);
		statement.setString(1, maNhanKhau);
		var rs = statement.executeQuery();

		if (!rs.next()) return null;
		return new ChungMinhThu(rs.getString(1), rs.getDate(2).toLocalDate(),null, /*DiaChi.parse(rs.getString(3)),*/ null);
	}

	public static NhanKhau getNhanKhau(String CMND) throws SQLException {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("select * from quan_ly_nhan_khau.chung_minh_thu where soCMT = ?");
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
		statement.setString(1, CMND);

		ResultSet rs = statement.executeQuery();
		while (rs.next()){
			NhanKhau x = NhanKhauService.getNhanKhau(rs.getString(5));
			return x;
		}
		return null;
	}

	public static ChungMinhThu getCMT(String maTamTruVang) throws SQLException {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("Select * from quan_ly_nhan_khau.tam_tru_vang where maGiayTamVang = ?");
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
		statement.setString(1, maTamTruVang);
		ResultSet rs = statement.executeQuery();
		while (rs.next()){
			ChungMinhThu x = ChungMinhThuService.getChungMinhThu(rs.getString(1));
			return x;
		}
		return null;
	}
}
