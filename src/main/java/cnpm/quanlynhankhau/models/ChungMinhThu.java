package cnpm.quanlynhankhau.models;

import javafx.scene.image.Image;

import java.time.LocalDate;

public class ChungMinhThu {
	public static ChungMinhThu lamCMT(Image anhChanDung, DiaChi noiCap){
		// TODO database auto generate
		ChungMinhThu output = new ChungMinhThu();
		output.anhChanDung = anhChanDung;
		output.noiCap = noiCap;

		// thay bang database output
		output.soCMT = null;
		output.ngayCap = null;

		return output;
	}

	private String soCMT;
	private LocalDate ngayCap;
	private DiaChi noiCap;
	private Image anhChanDung;


	private ChungMinhThu(){}

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
