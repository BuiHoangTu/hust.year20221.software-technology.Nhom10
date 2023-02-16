package cnpm.traothuonghs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public abstract class BaseLeftController extends ChangeSceneControllers{
	@FXML
	public void onHomeClicked(ActionEvent ignored) {
		changeScene("/cnpm/traothuonghs/views/Trang_chinh.fxml"); // link to home
	}

	@FXML
	public void onHSClicked(ActionEvent ignored) {
		// link to hs
		changeScene("/cnpm/traothuonghs/views/hocsinh/Quan-ly-hoc-sinh.fxml");
	}

	@FXML
	public void onPTClicked(ActionEvent ignored) {
		// link ti pt
		changeScene("/cnpm/traothuonghs/views/phanthuong/Chinh_Ti_Le_Phan_Thuong.fxml");
	}

	@FXML
	public void onTKClicked(ActionEvent ignored) {
		changeScene("/cnpm/traothuonghs/views/thongke/ThongKeScreen-view.fxml");
	}
}
