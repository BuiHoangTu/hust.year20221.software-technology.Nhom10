package cnpm.traothuonghs.services;

import cnpm.traothuonghs.models.PhanThuong;

import java.lang.ref.PhantomReference;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhanThuongService {
	public static void themPhanThuong(String ten, String maHK, String danhHieu){}
	public static void themPhanThuong(PhanThuong phanThuong) {

	}

	public static int getVoDaPhat() throws SQLException {
		int voDaPhat;
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT SUM(soVo)\n" +
				"FROM (\tSELECT phan_thuong.idHocSinh, phan_thuong.dotPhatThuong, phan_thuong.danhHieu, muc_trao_thuong.soVo \n" +
				"\tFROM phan_thuong \n" +
				"\tJOIN muc_trao_thuong \n" +
				"\tON muc_trao_thuong.ngayApDung = (\n" +
				"    SELECT ngayApDung \n" +
				"\t\tFROM muc_trao_thuong\n" +
				"\t\tORDER BY ABS(DateDiff(phan_thuong.ngayPhatThuong, muc_trao_thuong.ngayApDung)) LIMIT 1\n" +
				"    ) AND phan_thuong.danhHieu = muc_trao_thuong.danhHieu AND phan_thuong.ngayPhatThuong <= CURRENT_DATE) as voDaPhat;");
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
		ResultSet res = statement.executeQuery();
		res.next();
		voDaPhat = res.getInt("SUM(soVo)");
		return voDaPhat;
	}

	public static int getVoChuaPhat() throws SQLException {
		int voChuaPhat;
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT SUM(soVo)\n" +
				"FROM (\tSELECT phan_thuong.idHocSinh, phan_thuong.dotPhatThuong, phan_thuong.danhHieu, muc_trao_thuong.soVo \n" +
				"\tFROM phan_thuong \n" +
				"\tJOIN muc_trao_thuong \n" +
				"\tON muc_trao_thuong.ngayApDung = (\n" +
				"    SELECT ngayApDung \n" +
				"\t\tFROM muc_trao_thuong\n" +
				"\t\tORDER BY ABS(DateDiff(phan_thuong.ngayPhatThuong, muc_trao_thuong.ngayApDung)) LIMIT 1\n" +
				"    ) AND phan_thuong.danhHieu = muc_trao_thuong.danhHieu AND phan_thuong.ngayPhatThuong >= CURRENT_DATE) as voChuaPhat;");
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
		ResultSet res = statement.executeQuery();
		res.next();
		voChuaPhat = res.getInt("SUM(soVo)");
		return voChuaPhat;
	}
}
