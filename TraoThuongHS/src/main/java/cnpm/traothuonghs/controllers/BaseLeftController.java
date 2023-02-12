package cnpm.traothuonghs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public abstract class BaseLeftController extends ChangeSceneControllers{
	@FXML
	public void onHomeClicked(ActionEvent ignored) {
		changeScene(""); // link to home
	}

	@FXML
	public void onHSClicked(ActionEvent ignored) {
		// link to hs
	}

	@FXML
	public void onPTClicked(ActionEvent ignored) {
		// link ti pt
	}

	@FXML
	public void onTKClicked(ActionEvent ignored) {
		changeScene("/cnpm/traothuonghs/views/thongke/ThongKeScreen-view.fxml");
	}
}
