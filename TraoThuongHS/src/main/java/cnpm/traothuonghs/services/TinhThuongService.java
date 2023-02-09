package cnpm.traothuonghs.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TinhThuongService {
	private String[] cacDanhHieu;

	private Map<String, Integer> mapTyLeThuong = new HashMap<>();
	private int giaVo;


	public TinhThuongService() {
		// // TODO: 27/01/2023 get from database
		// lay cac danh hieu mới nhất tu DB
		cacDanhHieu = mapTyLeThuong.keySet().toArray(new String[0]);
	}
	public TinhThuongService(Date ngayThuong) {
		// TODO: 27/01/2023 get from database
		// lay cac danh hieu phù hơp với @ngayThuong tu DB
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
