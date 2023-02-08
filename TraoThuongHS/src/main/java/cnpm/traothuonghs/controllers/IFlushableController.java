package cnpm.traothuonghs.controllers;

public interface IFlushableController {
	/**
	 * Hàm xóa các dữ liệu tạm thời của controller để xử lý thông tin kế tiếp
	 */
	void flush_data();
}
