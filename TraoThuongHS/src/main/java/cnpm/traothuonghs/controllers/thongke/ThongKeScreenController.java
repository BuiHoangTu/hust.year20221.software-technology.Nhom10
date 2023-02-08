package cnpm.traothuonghs.controllers.thongke;

import cnpm.traothuonghs.controllers.BaseLeftController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ThongKeScreenController extends BaseLeftController{
    @FXML
    protected void onGDClicked(ActionEvent ignoredEvent) {
        changeScene("/cnpm/traothuonghs/views/thongke/ThongKeScreen-view.fxml", new ThongKeController()); // todo add link, controller
    }

	@FXML
	protected void onDotClicked(ActionEvent ignoredEvent) {
	}

	@FXML
	protected void onRawClicked(ActionEvent ignoredEvent) {
	}

}
