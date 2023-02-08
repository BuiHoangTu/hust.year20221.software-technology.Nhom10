package cnpm.traothuonghs.controllers.thongke;

import cnpm.traothuonghs.controllers.BaseLeftController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ThongKeController extends BaseLeftController {
	public static final RadioButton BY_DOT = new RadioButton();
	public static final RadioButton BY_HO = new RadioButton();
	// region fxml
	@FXML
	protected TextField tfFilter;
	@FXML
	protected RadioButton rbDot;
	@FXML
	protected RadioButton rbHo;
	@FXML
	protected ToggleGroup filterType;
	// endregion


	public ThongKeController() {}
	/**
	 * Tạo controller với chọn sẵn 1 loại lọc
	 * @param selectedToggle loại lọc. BY_DOT : lọc theo đợt phát, BY_HO : lọc theo hộ
	 */
	public ThongKeController(RadioButton selectedToggle) {
		if (BY_DOT.equals(selectedToggle)) {
			filterType.selectToggle(rbDot);
		} else if (BY_HO.equals(selectedToggle)) {
			filterType.selectToggle(rbHo);
		}
	}


	@FXML
	protected void onFindClicked(ActionEvent ignored) {
		if (filterType.getSelectedToggle().equals(rbDot)) {
			// TODO: 08/02/2023 find by dot
		} else if (filterType.getSelectedToggle().equals(rbHo)) {
			// TODO: 08/02/2023 find by ho
		}
	}

	@FXML
	protected void onExportClicked(ActionEvent ignored) {
	}

	@FXML
	protected void onReturnClicked(ActionEvent ignored) {
	}
}
