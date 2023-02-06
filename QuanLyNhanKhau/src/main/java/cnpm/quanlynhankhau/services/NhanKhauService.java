package cnpm.quanlynhankhau.services;

import cnpm.quanlynhankhau.models.ChungMinhThu;
import cnpm.quanlynhankhau.models.DiaChi;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.models.TamTruVang;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NhanKhauService {
	public static final int BY_MA_NHAN_KHAU = 1, BY_SO_DIEN_THOAI = 2, BY_TEN = 3, BY_NGAY_SINH = 4, BY_DIA_CHI = 5;

	/**
	 * Lấy các nhân khẩu dựa theo tiêu chí
	 *
	 * @param loaiMa tiêu chí lọc <p>Example: <code>{@link Database}.BY_MA_NHAN_KHAU</code>
	 * @param ma     thông tin để lọc
	 * @return Danh sách các nhân khẩu
	 * @throws SQLException khi query lỗi
	 */
	public static List<NhanKhau> findNhanKhau(int loaiMa, String ma, String quanHeVoiChuHo) throws SQLException {
		List<NhanKhau> result = new ArrayList<>();
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("Select * from quan_ly_nhan_khau.nhan_khau ");

		switch (loaiMa) {
			case BY_MA_NHAN_KHAU -> sqlQuery.append("where maNhanKhau = ?");
			case BY_SO_DIEN_THOAI -> sqlQuery.append("where soDienThoai = ?");
			case BY_TEN -> {
				ma = "%" + ma + "%";
				sqlQuery.append("where hoTen LIKE ?;");
			}
			case BY_NGAY_SINH -> sqlQuery.append("where namSinh = ?;");
			case BY_DIA_CHI -> {
				ma = "%" + ma + "%";
				sqlQuery.append("where diaChiHienNay LIKE ?");
			}
			default -> { return null; }
		}

		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
		statement.setString(1, ma);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			boolean Gender;
			Gender = rs.getString(5).equals("Nam");

			ChungMinhThu cmt = ChungMinhThuService.getChungMinhThu(rs.getString(1));

			String sqlQuery2 = "Select * from quan_ly_nhan_khau.tam_tru_vang where idNhanKhau = ?";
			PreparedStatement statement1 = Database.getConnection().prepareStatement(sqlQuery2);
			statement1.setString(1, rs.getString(1));
			ResultSet lis = statement1.executeQuery();
			List<TamTruVang> ttvs = new ArrayList<>();
			while (lis.next()) {
				ttvs.add(new TamTruVang(lis.getString(2), lis.getDate(4).toLocalDate(), lis.getDate(5).toLocalDate(),
						DiaChi.parse(lis.getString(7)), DiaChi.parse(lis.getString(3)), lis.getString(6)));
			}

			NhanKhau x = new NhanKhau(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(9), Gender, DiaChi.parse(rs.getString(12)),
					rs.getDate(4).toLocalDate(), /*DiaChi.parse(rs.getString(6))*/null, DiaChi.parse(rs.getString(7)), rs.getString(8), rs.getString(11), DiaChi.parse(rs.getString(13)),
					rs.getString(15), rs.getString(14), rs.getString(17), rs.getString(18), DiaChi.parse(rs.getString(19)), rs.getString(20),/*rs.getDate(21).toLocalDate()*/null,
					rs.getString(22), rs.getString(31), cmt, rs.getString(27),/*rs.getDate(28).toLocalDate()*/ null, rs.getString(29), rs.getString(30), /*rs.getDate(26).toLocalDate()*/null, quanHeVoiChuHo);
			x.getTamTruVangs().addAll(ttvs);

			result.add(x);
		}

		String sqlQuery2 = "Select * from quan_ly_nhan_khau.tam_tru_vang where idNhanKhau = ?";
		PreparedStatement statement1 = Database.getConnection().prepareStatement(sqlQuery2);
		for (NhanKhau nk : result) {
			statement1.setString(1, nk.getSoNhanKhau());
			ResultSet lis = statement1.executeQuery();
			while (lis.next()) {
				TamTruVang ttv = new TamTruVang(lis.getString(2), lis.getDate(4).toLocalDate(), lis.getDate(5).toLocalDate(),
						DiaChi.parse(lis.getString(7)), DiaChi.parse(lis.getString(3)), lis.getString(6));
				nk.getTamTruVangs().add(ttv);
			}
		}
		return result;
	}

	/**
	 * Lấy nhân khẩu
	 *
	 * @param maNK mã NK của NK cần lấy
	 * @return NK cần tìm
	 * @throws SQLException query lỗi
	 */
	public static NhanKhau getNhanKhau(String maNK) throws SQLException {
		try {
			return findNhanKhau(1, maNK, null).get(0);
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			return null;
		}
	}
	public static NhanKhau getNhanKhau(String maNK, String quanHeVoiChuHo) throws SQLException {
		try {
			return findNhanKhau(1, maNK, quanHeVoiChuHo).get(0);
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			return null;
		}
	}

	public static void xoaNhanKhau(NhanKhau nhanKhau) throws SQLException {
		xoaNhanKhau(nhanKhau.getSoNhanKhau());
	}
	public static void xoaNhanKhau(String idNhanKhau) throws SQLException{
		String sqlQuery = "Delete from quan_ly_nhan_khau.nhan_khau where maNhanKhau = ?;";
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery);
		statement.setString(1, idNhanKhau);
		statement.executeUpdate();
	}

	public static NhanKhau taoNhanKhau(String ten, String bietDanh, String tonGiao, boolean isMale, DiaChi thuongTru, LocalDate ngaySinh, DiaChi noiSinh, DiaChi nguyenQuan, String danToc, String hoChieu, DiaChi diaChiHienTai, String trinhDoChuyenMon, String trinhDoHocVan, String trinhDoNgoaiNgu, String ngheNghiep, DiaChi noiLamViec, String tienAn, LocalDate ngayChuyenDen, String lyDoChuyenDen, String ghiChu, ChungMinhThu chungMinhThu) throws SQLException {
		String idNK;
		String sqlQuery = "Insert into quan_ly_nhan_khau.nhan_khau (hoTen, bietDanh, tonGiao, gioiTinh, noiThuongTru, namSinh, noiSinh, nguyenQuan, danToc, soHoChieu, " +
				"diaChiHienNay, TrinhDoChuyenMon, trinhDoHocVan, trinhDoNgoaiNgu, ngheNghiep, noiLamViec, tienAn, " +
				"ngayChuyenDen, lyDoChuyenDen, ghiChu)" +
				"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, ten);
		statement.setString(2, bietDanh);
		statement.setString(3,tonGiao);
		if (isMale) {
			statement.setString(4, "Nam");
		} else {
			statement.setString(4, "Nu");
		}
		statement.setString(5, thuongTru.toString());
		statement.setString(6, ngaySinh.toString());
		statement.setString(7, noiSinh.toString());
		statement.setString(8, nguyenQuan.toString());
		statement.setString(9, danToc);
		statement.setString(10, hoChieu);
		statement.setString(11, diaChiHienTai.toString());
		statement.setString(12, trinhDoChuyenMon);
		statement.setString(13, trinhDoHocVan);
		statement.setString(14, trinhDoNgoaiNgu);
		statement.setString(15, ngheNghiep);
		statement.setString(16, noiLamViec.toString());
		statement.setString(17, tienAn);
		statement.setString(18, null);
		statement.setString(19, lyDoChuyenDen);
		statement.setString(20, ghiChu);
		statement.executeUpdate();
		ResultSet rs = statement.getGeneratedKeys();
		while (rs.next()) {
			idNK = rs.getString(1);
			return NhanKhauService.getNhanKhau(idNK);
		}

		return null;
	}

	/**
	 * Tìm những người không có HK trong khu vực
	 * @param vungHienTai khu vực
	 * @return danh sách
	 * @throws SQLException kết nối lỗi
	 */
	public static List<NhanKhau> hoKhauLessRegion(DiaChi vungHienTai) throws SQLException {
		List<NhanKhau> result = new ArrayList<>();
		String sqlQuery = "select nk.* " +
				"from nhan_khau nk " +
				"left join thanh_vien_cua_ho tvch on tvch.idNhanKhau = nk.maNhanKhau " +
				"WHERE tvch.quanHeVoiChuHo IS NULL " +
				"AND nk.diaChiHienNay LIKE ?";

		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery);
		statement.setString(1, "%" + vungHienTai.thanhPho + "%");

		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			boolean Gender;
			Gender = rs.getString(5).equals("Nam");

			ChungMinhThu cmt = ChungMinhThuService.getChungMinhThu(rs.getString(1));

			NhanKhau x = new NhanKhau(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(9), Gender, DiaChi.parse(rs.getString(12)),
					rs.getDate(4).toLocalDate(), /*DiaChi.parse(rs.getString(6))*/null, DiaChi.parse(rs.getString(7)), rs.getString(8), rs.getString(11), DiaChi.parse(rs.getString(13)),
					rs.getString(15), rs.getString(14), rs.getString(17), rs.getString(18), DiaChi.parse(rs.getString(19)), rs.getString(20),/*rs.getDate(21).toLocalDate()*/null,
					rs.getString(22), rs.getString(31), cmt, rs.getString(27),/*rs.getDate(28).toLocalDate()*/ null, rs.getString(29), rs.getString(30), /*rs.getDate(26).toLocalDate()*/null, null);

			result.add(x);
		}
		return result;
	}


	public static void khaiTu(NhanKhau nguoiMat, NhanKhau nguoiKhai, LocalDate ngayMat, String lyDoMat) throws SQLException {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("Insert into quan_ly_nhan_khau.khai_tu (idNguoiChet, idNguoiKhai, ngayChet, lyDoChet) values (?, ?, ?, ?)");
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString(), Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, nguoiMat.getSoNhanKhau());
		statement.setString(2, nguoiKhai.getSoNhanKhau());
		statement.setDate(3, java.sql.Date.valueOf(ngayMat.toString()));
		statement.setString(4, lyDoMat);
		statement.executeUpdate();
		ResultSet rs = statement.getGeneratedKeys();
		rs.next();
		String sqlQuery2 = "Select idNguoiChet from quan_ly_nhan_khau.khai_tu where soGiayKhaiTu = ?";
		PreparedStatement statement1 = Database.getConnection().prepareStatement(sqlQuery2);
		statement1.setString(1, rs.getString(1));
		rs = statement1.executeQuery();
		while (rs.next()){
			String sqlQuery3 = "UPDATE nhan_khau SET lyDoXoa = 'Đã Mất' WHERE maNhanKhau = ?";
			PreparedStatement statement2 = Database.getConnection().prepareStatement(sqlQuery3);
			statement2.setString(1, rs.getString(1));
			statement2.executeUpdate();
		}

	}

	public static List<NhanKhau> thongKeNhanKhau(String tuTuoi, String denTuoi, String gioiTinh, String tinhTrang, String tuNam, String denNam) throws SQLException {

		if (tuNam.equalsIgnoreCase("")) tuNam = "0";
		if (denNam.equalsIgnoreCase("")) denNam = "2100";
		if (tuTuoi.equalsIgnoreCase("")) tuTuoi = "0";
		if (denTuoi.equalsIgnoreCase("")) denTuoi = "200";

		List<NhanKhau> result = new ArrayList<>();
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("Select * from quan_ly_nhan_khau.nhan_khau ");
		sqlQuery.append(" WHERE ROUND(DATEDIFF(CURDATE(),namSinh)/365 , 0) >= " + Integer.parseInt(tuTuoi));
		sqlQuery.append(" AND ROUND(DATEDIFF(CURDATE(),namSinh)/365 , 0) <= " + Integer.parseInt(denTuoi));

		if (!gioiTinh.equalsIgnoreCase("Toàn bộ")) {
			sqlQuery.append(" AND nhan_khau.gioiTinh = '" + gioiTinh + "'");
		}
		sqlQuery.append(" AND (YEAR(nhan_khau.ngayTao) BETWEEN " + Integer.parseInt(tuNam) + " AND " + Integer.parseInt(denNam) + ")");
		sqlQuery.append(" ORDER BY ngayTao DESC");
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString(), Statement.RETURN_GENERATED_KEYS);

		ResultSet rs = statement.executeQuery();
		String idNhanKhau = null;
		while (rs.next()) {
			idNhanKhau = rs.getString("maNhanKhau");
			NhanKhau x = findNhanKhau(1, idNhanKhau, null).get(0);
			result.add(x);
		}

		String sqlQuery2 = "Select * from quan_ly_nhan_khau.tam_tru_vang where idNhanKhau = ?";
		PreparedStatement statement1 = Database.getConnection().prepareStatement(sqlQuery2);
		for (NhanKhau nk : result) {
			statement1.setString(1, nk.getSoNhanKhau());
			ResultSet lis = statement1.executeQuery();
			while (lis.next()) {
				TamTruVang ttv = new TamTruVang(lis.getString(2), lis.getDate(4).toLocalDate(), lis.getDate(5).toLocalDate(),
						DiaChi.parse(lis.getString(7)), DiaChi.parse(lis.getString(3)), lis.getString(6));
				nk.getTamTruVangs().add(ttv);
				if (tuTuoi.equalsIgnoreCase("Tạm vắng/Tạm trú") && nk.getTamTruVangs().get(nk.getTamTruVangs().size()-1).getDenNgay().compareTo(LocalDate.now()) < 0) {
					result.remove(nk);
				}
			}
		}

		return result;
	}
}
