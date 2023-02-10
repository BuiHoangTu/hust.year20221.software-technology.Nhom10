package cnpm.traothuonghs.controllers;

import javafx.event.ActionEvent;

public abstract class EdgeController extends ChangeSceneControllers {
	public void onTrangChuClicked(ActionEvent event) {
		changeScene("/cnpm/quanlynhankhau/views/Trang_chinh.fxml");
	}

	public void onNhanKhauClicked(ActionEvent event) {
		changeScene("/cnpm/quanlynhankhau/views/QuanLyNhanKhau.fxml");
	}

	public void onHoKhauClicked(ActionEvent event) {
		changeScene("/cnpm/quanlynhankhau/views/QuanLyHoKhau.fxml");
	}

	public void onThongKeClicked(ActionEvent event) {
		changeScene("/cnpm/quanlynhankhau/views/ThongKe.fxml");
	}

}
