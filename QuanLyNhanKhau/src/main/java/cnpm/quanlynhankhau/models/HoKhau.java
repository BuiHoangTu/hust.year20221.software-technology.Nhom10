package cnpm.quanlynhankhau.models;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HoKhau {
	private String soHoKhau;
	private NhanKhau chuHo;
	private boolean chuHoIsChanged = false;
	private String maKhuVuc;
	private boolean maKhuVucIsChanged = false;
	private DiaChi diaChi;
	private boolean diaChiIsChanged = false;
	private LocalDate ngayLap;
	private boolean ngayLapIsChanged = false;
	private final List<NhanKhau> thanhViens = new ArrayList<>();

	public HoKhau(String soHoKhau, NhanKhau chuHo, String maKhuVuc, DiaChi diaChi, LocalDate ngayLap) {
		this.soHoKhau = soHoKhau;
		this.chuHo = chuHo;
		this.maKhuVuc = maKhuVuc;
		this.diaChi = diaChi;
		this.ngayLap = ngayLap;
	}

	public String getSoHoKhau() {
		return soHoKhau;
	}


	public NhanKhau getChuHo() {
		return chuHo;
	}

	public void setChuHo(NhanKhau chuHo) {
		this.chuHo = chuHo;
		chuHoIsChanged = true;
	}

	public String getMaKhuVuc() {
		return maKhuVuc;
	}

	public void setMaKhuVuc(String maKhuVuc) {
		this.maKhuVuc = maKhuVuc;
		maKhuVucIsChanged = true;
	}

	public DiaChi getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
		diaChiIsChanged = true;
	}

	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
		ngayLapIsChanged = true;
	}

	public List<NhanKhau> getThanhViens() {
		return thanhViens;
	}

	public void themThanhVien(NhanKhau thanhVien, String QuanHeVoiChuHo) throws SQLException {
		this.thanhViens.add(thanhVien);

		PreparedStatement subStatement;
		String sqlQuery = "INSERT INTO quan_ly_nhan_khau.thanh_vien_cua_ho (idNhanKhau, idHoKhau, quanHeVoiChuHo) VALUES( ? , ? , ?);";
		subStatement = Database.getConnection().prepareStatement(sqlQuery);
		subStatement.setString(1, thanhVien.getSoNhanKhau());
		subStatement.setString(2, this.soHoKhau);
		subStatement.setString(3, QuanHeVoiChuHo);
		subStatement.executeUpdate();

	}

	public void xoaThanhVien(NhanKhau nhanKhau) throws SQLException {
		this.thanhViens.remove(nhanKhau);
		PreparedStatement subStatement = Database.getConnection().prepareStatement("""
                DELETE
                FROM quan_ly_nhan_khau.thanh_vien_cua_ho
                WHERE idNhanKhau = ?;
                """);
		subStatement.setString(1, nhanKhau.getSoNhanKhau());
		subStatement.executeUpdate();
	}

	public void xoaThanhVien(NhanKhau... nhanKhaus) throws SQLException {
		for (var nk : nhanKhaus) {
			xoaThanhVien(nk);
		}
	}
	public void xoaThanhVien(int sttNhanKhau) throws SQLException {
		this.thanhViens.remove(sttNhanKhau);
		PreparedStatement subStatement = Database.getConnection().prepareStatement("""
                DELETE
                FROM quan_ly_nhan_khau.thanh_vien_cua_ho
                WHERE idNhanKhau = ?;
                """);
		subStatement.setString(1, String.format("%d", sttNhanKhau));
		subStatement.executeUpdate();
	}


	public static List<HoKhau> filterBySoLuong(int slnk) throws SQLException {
		List<HoKhau> output = new ArrayList<>();
		PreparedStatement subStatement = Database.getConnection().prepareStatement("""
                select idHoKhau
                from thanh_vien_cua_ho
                group by idHoKhau
                having count(idNhanKhau) >= ?;
                """);
		subStatement.setString(1, String.valueOf(slnk));
		ResultSet res = subStatement.executeQuery();

		while (res.next()) {
			output.add(Database.getHoKhau(res.getString("idHoKhau")));
		}
		return output;
	}

	public void chuyenDiaChi (DiaChi diaChiMoi) throws SQLException {
		PreparedStatement subStatement = Database.getConnection().prepareStatement("""
                UPDATE quan_ly_nhan_khau.ho_khau
                SET diaChi = ?
                WHERE maHoKhau = ?;
                """);
		subStatement.setString(1, diaChiMoi.toString());
		subStatement.setString(2, this.soHoKhau);
		subStatement.executeUpdate();
	}

	/**
	 * Save changes in this HK in database
	 * Changes don't include NKs' content changes
	 */
	public void commit() throws SQLException {
		// lưu loại thay đổi

		// region thong tin thay doi
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("INSERT INTO quan_ly_nhan_khau.dinh_chinh_ho_khau (idHoKhau, thongTinThayDoi, thayDoiTu, thayDoiThanh, nguoiThayDoi) VALUES( ? , ? , ? , ? , ?);");
		// thông tin thay đổi
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
		statement.setString(1, soHoKhau);
		statement.setString(5, String.valueOf(QuanLyNhanKhauApplication.USER));

		// luu thay doi
		if (chuHoIsChanged) {
			statement.setString(2, "Chủ Hộ");
			statement.setString(4, chuHo.getSoNhanKhau());

			PreparedStatement subStatement = Database.getConnection().prepareStatement("""
                    SELECT idChuHo
                    FROM quan_ly_nhan_khau.ho_khau
                    WHERE maHoKhau = ?;
                    """);
			subStatement.setString(1, soHoKhau);

			ResultSet resultSet = subStatement.executeQuery();
			if (!resultSet.next()) {
				throw new SQLException("HoKhau khong ton tai");
			}
			String chuHoCu = resultSet.getString("idChuHo");

			statement.setString(3, chuHoCu);

			statement.executeUpdate();
		}
		if (maKhuVucIsChanged) {
			statement.setString(2, "Mã Khu Vực");
			statement.setString(4, maKhuVuc);

			PreparedStatement subStatement = Database.getConnection().prepareStatement("""
                    SELECT maKhuVuc
                    FROM quan_ly_nhan_khau.ho_khau
                    WHERE maHoKhau = ?;
                    """);
			subStatement.setString(1, soHoKhau);

			ResultSet resultSet = subStatement.executeQuery();
			if (!resultSet.next()) {
				throw new SQLException("HoKhau khong ton tai");
			}
			String MKVcu = resultSet.getString("maKhuVuc");

			statement.setString(3, MKVcu);

			statement.executeUpdate();
		}
		if (diaChiIsChanged) {
			statement.setString(2, "Địa Chỉ");
			statement.setString(4, diaChi.toString());

			PreparedStatement subStatement = Database.getConnection().prepareStatement("""
                    SELECT maKhuVuc
                    FROM quan_ly_nhan_khau.ho_khau
                    WHERE maHoKhau = ?;
                    """);
			subStatement.setString(1, soHoKhau);

			ResultSet resultSet = subStatement.executeQuery();
			if (!resultSet.next()) {
				throw new SQLException("Dia chi khong ton tai");
			}
			String diaChicu = resultSet.getString("diaChi");

			statement.setString(3, diaChicu);

			statement.executeUpdate();
		}

		if (ngayLapIsChanged) {
			statement.setString(2, "Ngày Lập");
			statement.setString(4, ngayLap.toString());

			PreparedStatement subStatement = Database.getConnection().prepareStatement("""
                    SELECT maKhuVuc
                    FROM quan_ly_nhan_khau.ho_khau
                    WHERE maHoKhau = ?;
                    """);
			subStatement.setString(1, soHoKhau);

			ResultSet resultSet = subStatement.executeQuery();
			if (!resultSet.next()) {
				throw new SQLException("Ngay Lap khong ton tai");
			}
			String ngayLapCu = resultSet.getString("ngayLap");

			statement.setString(3, ngayLapCu);

			statement.executeUpdate();
		}

		// commit to db
		sqlQuery = new StringBuilder();
		sqlQuery.append("UPDATE quan_ly_nhan_khau.ho_khau ");
		// SET idChuHo=NULL, maKhuVuc=NULL, diaChi=NULL, ngayLap=NULL, nguoiThucHien=NULL

		if (chuHoIsChanged) sqlQuery.append("SET idChuHo= ? ");
		if (maKhuVucIsChanged) sqlQuery.append("SET maKhuVuc= ? ");
		if (diaChiIsChanged) sqlQuery.append("SET diaChi= ? ");
		if (ngayLapIsChanged) sqlQuery.append("SET ngayLap= ? ");
		sqlQuery.append("WHERE maHoKhau = ? ");

		statement = Database.getConnection().prepareStatement(sqlQuery.toString());
		int i = 1;
		if (chuHoIsChanged) {
			statement.setString(i, chuHo.getSoNhanKhau());
			i += 1;
		}
		if (maKhuVucIsChanged) {
			statement.setString(i, maKhuVuc);
			i += 1;
		}
		if (diaChiIsChanged) {
			statement.setString(i, diaChi.toString());
			i += 1;
		}
		if (ngayLapIsChanged) {
			statement.setString(i, ngayLap.toString());
			i += 1;
		}
		statement.setString(i, soHoKhau);
		// gửi câu lệnh đến DB
		statement.executeUpdate();

		chuHoIsChanged = false;
		maKhuVucIsChanged = false;
		diaChiIsChanged = false;
		ngayLapIsChanged = false;
	}
}
