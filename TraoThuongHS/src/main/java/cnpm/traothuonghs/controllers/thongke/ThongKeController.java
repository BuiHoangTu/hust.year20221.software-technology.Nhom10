package cnpm.traothuonghs.controllers.thongke;

import cnpm.traothuonghs.application.TraoThuongHSApplication;
import cnpm.traothuonghs.controllers.BaseLeftController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	@FXML
	protected TableView tvThongKe;
	// endregion
	private final Scene previousScene;


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
			fileName = createTime + "Đợt phát thưởng \"" + tfFilter.getText() + "\".csv";
		}
		if (filterType.getSelectedToggle().equals(rbHo)) {
			fileName = createTime + "Hộ nhận thưởng \"" + tfFilter.getText() + "\".csv";
		}
		// make file
		if (fileName != null) {
			File applicationFile = new File(applicationFolder, fileName);
			try {
				applicationFile.createNewFile();
				// write tv
				export(applicationFile);
			} catch (IOException e) {/*todo error*/}
		} else {
			// TODO: 10/02/2023 nodate notification
		}

	}

	@FXML
	protected void onReturnClicked(ActionEvent ignored) {
		TraoThuongHSApplication.MAIN_STAGE.setScene(previousScene);
	}

	/**
	 * viết cái tv thành file
	 * @param outputFile file output
	 */
	private void export(File outputFile) {
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet hssfSheet = hssfWorkbook.createSheet("Sheet1");
		HSSFRow firstRow = hssfSheet.createRow(0);

		///set titles of columns
		for (int i = 0; i < tvThongKe.getColumns().size(); i++) {
			firstRow.createCell(i).setCellValue(((TableColumn<?, ?>)tvThongKe.getColumns().get(i)).getText());

		}

		for (int row = 0; row < tvThongKe.getItems().size(); row++) {
			HSSFRow hssfRow = hssfSheet.createRow(row + 1);
			for (int col = 0; col < tvThongKe.getColumns().size(); col++) {
				Object celValue = ((TableColumn<?,?>)tvThongKe.getColumns().get(col)).getCellObservableValue(row).getValue();
				try {
					if (celValue != null && Double.parseDouble(celValue.toString()) != 0.0) {
						hssfRow.createCell(col).setCellValue(Double.parseDouble(celValue.toString()));
					}
				} catch (NumberFormatException e) {
					hssfRow.createCell(col).setCellValue(celValue.toString());
				}
			}
		}

		//save Excel file and close the workbook
		try {
			hssfWorkbook.write(outputFile);
			hssfWorkbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
