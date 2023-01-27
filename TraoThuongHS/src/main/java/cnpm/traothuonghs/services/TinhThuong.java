package cnpm.traothuonghs.services;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;


public class TinhThuong {
	private static volatile TinhThuong tinhThuong = null;

	private BiMap<String, Integer> mapTyLeThuong = HashBiMap.create();
	private int giaVo;


	private TinhThuong() {
		// // TODO: 27/01/2023 get from database
	}


	public static TinhThuong getTinhThuong() {
		if(tinhThuong == null) tinhThuong = new TinhThuong();
		return tinhThuong;
	}


	public int getPhanThuong(String danhHieu) {
		return mapTyLeThuong.get(danhHieu);
	}

	public int getGiaVo() {
		return giaVo;
	}

	/**
	 * Thay tỉ lệ thưởng. Những ô để trống phải thay bằng tỷ lệ gốc
	 * @param mapTyLeThuongMoi
	 */
	public void chinhTyLe(BiMap<String, Integer> mapTyLeThuongMoi) {
		mapTyLeThuong = mapTyLeThuongMoi;
		// todo update database
	}

	public void chinhGiaVo(int giaVoMoi) {
		this.giaVo = giaVoMoi;
		// TODO: 27/01/2023 update db
	}


}
