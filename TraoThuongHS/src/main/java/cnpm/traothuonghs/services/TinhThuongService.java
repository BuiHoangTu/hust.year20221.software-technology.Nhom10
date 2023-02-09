package cnpm.traothuonghs.services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class TinhThuongService {
	private String[] cacDanhHieu;

	private Map<String, Integer> mapTyLeThuong = new HashMap<>();
	private int giaVo;


	public TinhThuongService() {
		new TinhThuongService(LocalDate.now());
	}
	public TinhThuongService(LocalDate ngayThuong) {
		// lay cac danh hieu phù hơp với @ngayThuong tu DB
		var con = Database.getConnection();
		String query = """
				Select danhHieu, soVo
				from muc_trao_thuong
				where muc_trao_thuong.ngayApDung =
					(select MAX(ngayApDung)
					from muc_trao_thuong
					where muc_trao_thuong.ngayApDung < ?)""";
		try {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setDate(1, Date.valueOf(ngayThuong));
			var rs = statement.executeQuery();
			while (rs.next()) {
				// đặt danh hiệu - số vở vào map
				mapTyLeThuong.put(rs.getString(1), Integer.parseInt(rs.getString(2)));
			}
		} catch (SQLException ignored) {}

		query = """
				Select giaTien
				from gia_thuong
				where gia_thuong.ngayApDung =
					(select MAX(ngayApDung)
					from gia_thuong
					where gia_thuong.ngayApDung < ?)""";
		try {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setDate(1, Date.valueOf(ngayThuong));
			var rs = statement.executeQuery();
			if (rs.next()) {
				giaVo =Integer.parseInt(rs.getString(1));
			}
		} catch (SQLException ignored) {
		} catch (NumberFormatException e) {
			e.printStackTrace();
			giaVo = -1;
		}

		cacDanhHieu = mapTyLeThuong.keySet().toArray(new String[0]);
	}

	public String[] getCacDanhHieu() {
		return cacDanhHieu;
	}

	public int getPhanThuong(String danhHieu) {
		return mapTyLeThuong.get(danhHieu);
	}

	public int getGiaVo() {
		return giaVo;
	}

	/**
	 * Thay tỉ lệ thưởng. Những ô để trống phải thay bằng tỷ lệ gốc
	 * @param mapTyLeThuongMoi tỉ lệ mới
	 */
	public void chinhTyLe(Map<String, Integer> mapTyLeThuongMoi) {
		mapTyLeThuong = mapTyLeThuongMoi;
		// todo update database
	}

	public void chinhGiaVo(int giaVoMoi) {
		this.giaVo = giaVoMoi;
		// TODO: 27/01/2023 update db
	}


}
