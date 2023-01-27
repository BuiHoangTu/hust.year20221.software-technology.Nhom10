package cnpm.traothuonghs.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HocSinh {
	public static final String[] tenCacTruongHoc = {"", ""}; // TODO: 27/01/2023 thêm tên các trường

	private String ten;
	private LocalDate ngaySinh;
	private String truongHoc;
	private String lop;
	private String maHoKhau;
	private String phuHuynh;
	private final List<PhanThuong> cacPhanThuong = new ArrayList<>();



}
