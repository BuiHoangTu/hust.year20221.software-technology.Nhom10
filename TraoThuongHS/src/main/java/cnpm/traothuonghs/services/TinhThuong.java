package cnpm.traothuonghs.services;

import java.util.HashMap;
import java.util.Map;


public class TinhThuong {
	private static volatile TinhThuong tinhThuong = null;
	private String[] cacDanhHieu;

	private Map<String, Integer> mapTyLeThuong = new HashMap<>();
	private int giaVo;


	private TinhThuong() {
		// // TODO: 27/01/2023 get from database
		// lay cac danh hieu tu DB
		cacDanhHieu = mapTyLeThuong.keySet().toArray(new String[0]);
	}


	public static TinhThuong getTinhThuong() {
		if(tinhThuong == null) tinhThuong = new TinhThuong();
		return tinhThuong;
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
