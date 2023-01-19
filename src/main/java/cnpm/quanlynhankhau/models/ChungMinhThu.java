package cnpm.quanlynhankhau.models;

import javafx.scene.image.Image;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public static ChungMinhThu lamCMT(Image anhChanDung, DiaChi noiCap) throws SQLException {
		ChungMinhThu output = new ChungMinhThu();
		output.anhChanDung = anhChanDung;
		output.noiCap = noiCap;

		// todo thay bang database output
		output.soCMT = null;
		output.ngayCap = null;
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("Insert into quan_ly_nhan_khau.chung_minh_thu(ngayCap, noiCap, anhChanDung) values (?, ?, ?)");
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
		statement.setString(1, LocalDate.now().toString());
		statement.setString(2, noiCap.toString());
		statement.setString(3, anhChanDung.toString());

		ResultSet resultSet = statement.executeQuery();

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
