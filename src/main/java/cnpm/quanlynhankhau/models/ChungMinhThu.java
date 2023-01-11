package cnpm.quanlynhankhau.models;

import javafx.scene.image.Image;

import java.time.LocalDate;

public class ChungMinhThu {

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


	/**
	 * Làm chứng minh thư mới. CMT được cập nhật luôn trong DB
	 * @param anhChanDung ảnh chân dung
	 * @param noiCap địa chỉ nơi cấp
	 * @return chứng minh thư mới
	 */
	public static ChungMinhThu lamCMT(Image anhChanDung, DiaChi noiCap) {
		ChungMinhThu output = new ChungMinhThu();
		output.anhChanDung = anhChanDung;
		output.noiCap = noiCap;

		// thay bang database output// TODO database auto generate
		output.soCMT = null;
		output.ngayCap = null;

		return output;
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
