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
import java.sql.Statement;
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
		String i = "";
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("Insert into quan_ly_nhan_khau.chung_minh_thu(noiCap, anhChanDung) values (?, ?)");
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString(), Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, noiCap.toString());
		statement.setBinaryStream(2, null);
		statement.executeUpdate();

		ResultSet output = statement.getGeneratedKeys();
		while (output.next()){
			i = output.getString(1);
		}
		PreparedStatement statement2 = Database.getConnection().prepareStatement("Select * from quan_ly_nhan_khau.chung_minh_thu where soCMT = ?");
		statement2.setString(1, i);
		ResultSet rs = statement2.executeQuery();
		while (rs.next()){
			ChungMinhThu cmt = new ChungMinhThu(rs.getString(1),rs.getDate(2).toLocalDate(),DiaChi.parse(rs.getString(3)), null);
			System.out.println(cmt.getSoCMT() + " " + cmt.getNoiCap());
			return cmt;
		}
		return null;
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
