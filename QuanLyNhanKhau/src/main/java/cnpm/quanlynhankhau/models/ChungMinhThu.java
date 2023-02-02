package cnpm.quanlynhankhau.models;

import javafx.scene.image.Image;

import java.time.LocalDate;

public class ChungMinhThu {

	private final String soCMT;
	private final LocalDate ngayCap;
	private final DiaChi noiCap;
	private final Image anhChanDung;


	public ChungMinhThu(String soCMT, LocalDate ngayCap, DiaChi noiCap, Image anhChanDung) {
		this.soCMT = soCMT;
		this.ngayCap = ngayCap;
		this.noiCap = noiCap;
		this.anhChanDung = anhChanDung;
	}


	public String getSoCMT() {
		return soCMT;
	}

	public LocalDate getNgayCap() {
		return ngayCap;
	}

	public DiaChi getNoiCap() {
		return noiCap;
	}

	public Image getAnhChanDung() {
		return anhChanDung;
	}
}
