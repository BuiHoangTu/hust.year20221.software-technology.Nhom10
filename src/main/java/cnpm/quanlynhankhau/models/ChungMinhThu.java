package cnpm.quanlynhankhau.models;

import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ChungMinhThu {

	private String soCMT;
	private LocalDate ngayCap;
	private DiaChi noiCap;
	private Image anhChanDung;


	ChungMinhThu(){}
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
	public static ChungMinhThu lamCMT(Image anhChanDung, DiaChi noiCap) throws SQLException, FileNotFoundException, URISyntaxException {
		URI url = new URI(anhChanDung.getUrl());
		File f = new File(url);
		FileInputStream input = new FileInputStream(f);

		ChungMinhThu output = new ChungMinhThu();
		output.anhChanDung = anhChanDung;
		output.noiCap = noiCap;

		// todo thay bang database output
		output.soCMT = null;
		output.ngayCap = null;
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("Insert into quan_ly_nhan_khau.chung_minh_thu(noiCap, anhChanDung) values (?, ?, ?)");
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
		statement.setString(1, noiCap.toString());
		statement.setBinaryStream(2, (InputStream) input, (int) f.length());

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
