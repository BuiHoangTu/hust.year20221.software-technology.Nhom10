package cnpm.traothuonghs.controllers.thongke;

import cnpm.traothuonghs.application.TraoThuongHSApplication;
import cnpm.traothuonghs.controllers.BaseLeftController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ThongKeScreenController extends BaseLeftController{
    @FXML
    protected void onGDClicked(ActionEvent ignoredEvent) {
		var controller = new ThongKeController(TraoThuongHSApplication.MAIN_STAGE.getScene(), ThongKeController.BY_HO);
		controller.onFindClicked(new ActionEvent());

		changeScene(
				"/cnpm/traothuonghs/views/thongke/ThongKeScreen-view.fxml",
				controller);
    }

	@FXML
	protected void onDotClicked(ActionEvent ignoredEvent) {
		var controller = new ThongKeController(TraoThuongHSApplication.MAIN_STAGE.getScene(), ThongKeController.BY_DOT);
		controller.onFindClicked(new ActionEvent());
		changeScene(
				"/cnpm/traothuonghs/views/thongke/ThongKeScreen-view.fxml",
				controller);
	}

	@FXML
	protected void onRawClicked(ActionEvent ignoredEvent) {
		changeScene(
				"/cnpm/traothuonghs/views/thongke/ThongKeScreen-view.fxml",
				new ThongKeController(TraoThuongHSApplication.MAIN_STAGE.getScene()));
	}

}
