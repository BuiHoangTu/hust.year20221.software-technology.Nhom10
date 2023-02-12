package cnpm.traothuonghs.records;

import java.time.LocalDate;

public record PhanThuongDot(
		int tongSoVo,
		int tongSoTien,
		LocalDate ngayPhat,
		String tenDotPhat) {

}
