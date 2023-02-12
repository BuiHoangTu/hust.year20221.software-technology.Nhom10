package cnpm.traothuonghs.services;

import cnpm.traothuonghs.models.PhanThuong;
import cnpm.traothuonghs.records.PhanThuongDot;
import cnpm.traothuonghs.records.PhanThuongHK;

import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PhanThuongService {
	public static final int BY_SO_VO = 1, BY_GIA_TRI = 2;
	public static int getPhanThuongDaTrao (int loaiMa) throws SQLException {
		int result = 0;
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("Select * from trao_thuong_hoc_sinh.phan_thuong ");
		sqlQuery.append(" Where ROUND(DATEDIFF(CURDATE(),ngayPhatThuong)/365 , 0) <= " + LocalDate.now().getYear());
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString(), Statement.RETURN_GENERATED_KEYS);

		ResultSet rs = statement.executeQuery();
		String idNhanKhau = null;
		int hsxx = 0, hsg = 0, hstt = 0;
		while (rs.next()) {
			String danhHieu = rs.getString("danhHieu");
			switch (danhHieu) {
				case "Học sinh xuất sắc" -> hsxx++;
				case "Học sinh giỏi" -> hsg++;
				case "Học sinh tiên tiến" -> hstt++;
			}
		}

		switch (loaiMa) {
			case BY_SO_VO -> {
				StringBuilder sqlQuery1 = new StringBuilder();
				sqlQuery1.append("Select * from trao_thuong_hoc_sinh.muc_trao_thuong ");
				sqlQuery1.append("Where danhHieu = " + "Học sinh xuất sắc");
				PreparedStatement statement1 = Database.getConnection().prepareStatement(sqlQuery1.toString());
				ResultSet rs1 = statement.executeQuery();
				rs1.next();

				result += hsxx * rs1.getInt(3);

				sqlQuery1 = new StringBuilder();
				sqlQuery1.append("Select * from trao_thuong_hoc_sinh.muc_trao_thuong ");
				sqlQuery1.append("Where danhHieu = " + "Học sinh giỏi");
				statement1 = Database.getConnection().prepareStatement(sqlQuery1.toString());
				rs1 = statement.executeQuery();
				rs1.next();

				result += hsg * rs1.getInt(3);

				sqlQuery1 = new StringBuilder();
				sqlQuery1.append("Select * from trao_thuong_hoc_sinh.muc_trao_thuong ");
				sqlQuery1.append("Where danhHieu = " + "Học sinh tiên tiến");
				statement1 = Database.getConnection().prepareStatement(sqlQuery1.toString());
				rs1 = statement.executeQuery();
				rs1.next();

				result += hstt * rs1.getInt(3);
			}
			case BY_GIA_TRI -> {

			}
		}

		return result;
	}
	public static void themPhanThuong(String ten, String maHK, String danhHieu) {}
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

	public static List<PhanThuongHK> getPTHK(String filter) throws SQLException {
		List<PhanThuongHK> output = new ArrayList<>();

		Connection connection = Database.getConnection();

		String sql = """
				SELECT hs.maHoKhau , SUM(mtt.soVo * gt.giaTien) as tongGiaTri, SUM(mtt.soVo) as tongSoVo
				from hoc_sinh hs\s
				join phan_thuong pt on pt.idHocSinh  = hs.id\s
				JOIN  muc_trao_thuong mtt\s
					on mtt.ngayApDung  = (SELECT MAX(ngayApDung) from muc_trao_thuong WHERE muc_trao_thuong.ngayApDung <= pt.ngayPhatThuong)
					and pt.danhHieu = mtt.danhHieu\s
				Join gia_thuong gt\s
					on gt.ngayApDung  = (SELECT MAX(ngayApDung) from gia_thuong WHERE gia_thuong .ngayApDung <= pt.ngayPhatThuong)
				WHERE hs.maHoKhau like ?
				GROUP by hs.maHoKhau\s""";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "%"+filter+"%");

		var rs = statement.executeQuery();

		while (rs.next()) {
			output.add(new PhanThuongHK(rs.getInt(3), rs.getInt(2), rs.getString(1)));
		}

		return output;
	}

	public static List<PhanThuongDot> getPTDot(String filter) throws SQLException {
		List<PhanThuongDot> output = new ArrayList<>();

		Connection connection = Database.getConnection();

		String sql = """
				SELECT SUM(mtt.soVo * gt.giaTien) as tongSoTien, SUM(mtt.soVo) as tongSoVo, pt.ngayPhatThuong , pt.dotPhatThuong\s
				from phan_thuong pt
				JOIN  muc_trao_thuong mtt\s
					on mtt.ngayApDung  = (SELECT MAX(ngayApDung) from muc_trao_thuong WHERE muc_trao_thuong.ngayApDung <= pt.ngayPhatThuong)
					and pt.danhHieu = mtt.danhHieu\s
				Join gia_thuong gt\s
					on gt.ngayApDung  = (SELECT MAX(ngayApDung) from gia_thuong WHERE gia_thuong .ngayApDung <= pt.ngayPhatThuong)
				where pt.dotPhatThuong like ?
				GROUP by pt.ngayPhatThuong \s""";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "%" + filter + "%");
		var rs = statement.executeQuery();

		while (rs.next()) {
			output.add(new PhanThuongDot(rs.getInt(2), rs.getInt(1), rs.getDate(3).toLocalDate(), rs.getString(4)));
		}

		return output;
	}
}
