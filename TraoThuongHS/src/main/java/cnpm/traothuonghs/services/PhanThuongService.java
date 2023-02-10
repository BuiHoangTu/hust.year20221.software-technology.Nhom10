package cnpm.traothuonghs.services;

import cnpm.traothuonghs.models.PhanThuong;

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
}
