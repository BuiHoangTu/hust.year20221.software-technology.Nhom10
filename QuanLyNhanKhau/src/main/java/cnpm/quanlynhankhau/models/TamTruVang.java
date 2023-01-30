package cnpm.quanlynhankhau.models;

import java.time.LocalDate;

/**
 * Thể hiện 1 lần tạm trú tạm vắng của 1 người
 */
public class TamTruVang {
	private final String maTamTruVang;
	private final LocalDate tuNgay;
	private final LocalDate denNgay;
	private final DiaChi dcTamVang;
	private final DiaChi dcTamTru;
	private final String lyDo;


	public TamTruVang(String maTamTruVang, LocalDate tuNgay, LocalDate denNgay, DiaChi dcTamVang, DiaChi dcTamTru, String lyDo) {
		this.maTamTruVang = maTamTruVang;
		this.tuNgay = tuNgay;
		this.denNgay = denNgay;
		this.dcTamVang = dcTamVang;
		this.dcTamTru = dcTamTru;
		this.lyDo = lyDo;
	}

	public String getMaTamTruVang() {
		return maTamTruVang;
	}

	public LocalDate getTuNgay() {
		return tuNgay;
	}

	public LocalDate getDenNgay() {
		return denNgay;
	}

	public DiaChi getDcTamVang() {
		return dcTamVang;
	}

	public DiaChi getDcTamTru() {
		return dcTamTru;
	}

	public String getLyDo() {
		return lyDo;
	}
}
