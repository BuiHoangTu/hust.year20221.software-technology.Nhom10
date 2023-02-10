package cnpm.traothuonghs.controllers.thongke;

import cnpm.traothuonghs.application.TraoThuongHSApplication;
import cnpm.traothuonghs.controllers.BaseLeftController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
	private Scene previousScene;


	public ThongKeController(Scene previousScene) {
		this.previousScene = previousScene;
	}
	/**
	 * Tạo controller với chọn sẵn 1 loại lọc
	 * @param selectedToggle loại lọc. BY_DOT : lọc theo đợt phát, BY_HO : lọc theo hộ
	 */
	public ThongKeController(Scene previousScene, RadioButton selectedToggle) {
		this.previousScene = previousScene;

		if (BY_DOT.equals(selectedToggle)) {
			filterType.selectToggle(rbDot);
		} else if (BY_HO.equals(selectedToggle)) {
			filterType.selectToggle(rbHo);
		}
	}


	@FXML
	public void onFindClicked(ActionEvent ignored) {
		if (filterType.getSelectedToggle().equals(rbDot)) {
			// TODO: 08/02/2023 find by dot
		} else if (filterType.getSelectedToggle().equals(rbHo)) {
			// TODO: 08/02/2023 find by ho
		}
	}

	@FXML
	protected void onExportClicked(ActionEvent ignored) {
		// get or make applicationFolder in Home
		String home = System.getProperty("user.home");
		File applicationFolder = new File(home, "Trao Thưởng Học Sinh");
		if (!applicationFolder.exists()) applicationFolder.mkdir();

		// make file name
		var createTime = LocalDateTime.now();
		String fileName = null;
		if (filterType.getSelectedToggle().equals(rbDot)) {
			fileName = createTime + "Đợt phát thưởng \"" + tfFilter.getText() + "\"";
		}
		if (filterType.getSelectedToggle().equals(rbHo)) {
			fileName = createTime + "Hộ nhận thưởng \"" + tfFilter.getText() + "\"";
		}
		// make file
		if (fileName != null) {
			File applicationFile = new File(applicationFolder, fileName);
			try {
				applicationFile.createNewFile();

				BufferedWriter writer = new BufferedWriter(new FileWriter(applicationFile));
				writer.write("strhg\n");
				writer.write("more");

				writer.close();
			} catch (IOException e) {/*todo error*/}
		} else {
			// TODO: 10/02/2023 nodate notification
		}

	}

	@FXML
	protected void onReturnClicked(ActionEvent ignored) {
		TraoThuongHSApplication.MAIN_STAGE.setScene(previousScene);
	}
}
