package cnpm.quanlynhankhau.services;

import cnpm.quanlynhankhau.models.ChungMinhThu;
import cnpm.quanlynhankhau.models.DiaChi;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.models.TamTruVang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public static List<NhanKhau> findNhanKhau(int loaiMa, String ma) throws SQLException {
		List<NhanKhau> result = new ArrayList<>();
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("Select * from quan_ly_nhan_khau.nhan_khau ");

		if (loaiMa == 1) sqlQuery.append("where maNhanKhau = ?");
		else if (loaiMa == 2) sqlQuery.append("where soDienThoai = ?");
		else if (loaiMa == 3) {
			ma = "%" + ma + "%";
			sqlQuery.append("where hoTen LIKE ?;");
		} else if (loaiMa == 4) {
			ma = "%" + ma + "%";
			sqlQuery.append("where namSinh LIKE ?;");
		} else if (loaiMa == 5) {
			ma = "%" + ma + "%";
			sqlQuery.append("where diaChiHienNay LIKE ?");
		} else {
			System.out.println("Khong kha dung");
			return null;
		}

		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery.toString());
		statement.setString(1, ma);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			boolean Gender;
			Gender = rs.getString(5).equals("Nam");
			NhanKhau x = new NhanKhau(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(9), Gender, DiaChi.parse(rs.getString(12)),
					rs.getDate(4).toLocalDate(), /*DiaChi.parse(rs.getString(6))*/null, DiaChi.parse(rs.getString(7)), rs.getString(8), rs.getString(11), DiaChi.parse(rs.getString(13)),
					rs.getString(15), rs.getString(14), rs.getString(17), rs.getString(18), DiaChi.parse(rs.getString(19)), rs.getString(20),/*rs.getDate(21).toLocalDate()*/null,
					rs.getString(22), rs.getString(31), null, rs.getString(27),/*rs.getDate(28).toLocalDate()*/ null, rs.getString(29), rs.getString(30), rs.getDate(26).toLocalDate());

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
			return findNhanKhau(1, maNK).get(0);
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			return null;
		}
	}

	public static void xoaNhanKhau(NhanKhau nhanKhau) throws SQLException {
		String sqlQuery = "Delete from quan_ly_nhan_khau.nhan_khau where maNhanKhau = ?;";
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery);
		statement.setString(1, nhanKhau.getSoNhanKhau());
		statement.executeUpdate();
	}

	public static NhanKhau taoNhanKhau(String ten, String bietDanh, String tonGiao, boolean isMale, DiaChi thuongTru, LocalDate ngaySinh, DiaChi noiSinh, DiaChi nguyenQuan, String danToc, String hoChieu, DiaChi diaChiHienTai, String trinhDoChuyenMon, String trinhDoHocVan, String trinhDoNgoaiNgu, String ngheNghiep, DiaChi noiLamViec, String tienAn, LocalDate ngayChuyenDen, String lyDoChuyenDen, String ghiChu, ChungMinhThu chungMinhThu) throws SQLException {
		String idNK;
		String sqlQuery = "Insert into quan_ly_nhan_khau.nhan_khau (hoTen, bietDanh, tonGiao, gioiTinh, noiThuongTru, namSinh, noiSinh, nguyenQuan, danToc, hoChieu, " +
				"diaChiHienNay, TrinhDoChuyenMon, trinhDoHocVan, trinhDoNgoaiNgu, ngheNghiep, noiLamViec, tienAn, " +
				"ngayChuyenDen, lyDoChuyenDen, ghiChu)" +
				"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = Database.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, ten);
		statement.setString(2, bietDanh);
		if (isMale) {
			statement.setString(3, "Nam");
		} else {
			statement.setString(3, "Nu");
		}
		statement.setString(4, thuongTru.toString());
		statement.setString(5, ngaySinh.toString());
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
		statement.setString(18, ngayChuyenDen.toString());
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

}