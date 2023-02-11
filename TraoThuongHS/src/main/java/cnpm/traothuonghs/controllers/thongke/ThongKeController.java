package cnpm.traothuonghs.controllers.thongke;

import cnpm.traothuonghs.application.TraoThuongHSApplication;
import cnpm.traothuonghs.controllers.BaseLeftController;
import cnpm.traothuonghs.records.PhanThuongDot;
import cnpm.traothuonghs.records.PhanThuongHK;
import cnpm.traothuonghs.services.PhanThuongService;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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
	private RadioButton selectedToggle = null;


	public ThongKeController(Scene previousScene) {
		this.previousScene = previousScene;
	}
	/**
	 * Tạo controller với chọn sẵn 1 loại lọc
	 * @param selectedToggle loại lọc. BY_DOT : lọc theo đợt phát, BY_HO : lọc theo hộ
	 */
	public ThongKeController(Scene previousScene, RadioButton selectedToggle) {
		this.previousScene = previousScene;
		this.selectedToggle = selectedToggle;
	}


	@FXML
	protected void initialize() {
		if (BY_DOT.equals(selectedToggle)) {
			filterType.selectToggle(rbDot);
			onFindClicked(new ActionEvent());
		} else if (BY_HO.equals(selectedToggle)) {
			filterType.selectToggle(rbHo);
			onFindClicked(new ActionEvent());
		}
	}

	@FXML
	public void onFindClicked(ActionEvent ignored) {
		try {
			if (filterType.getSelectedToggle().equals(rbDot)) {
				tvThongKe.setItems(FXCollections.observableList(PhanThuongService.getPTDot(tfFilter.getText())));

				// clean table cols
				tvThongKe.getColumns().clear();
				// name col
				TableColumn<PhanThuongDot, String> colTenDot = new TableColumn<>("Đợt phát thưởng");
				colTenDot.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().tenDotPhat()));
				colTenDot.prefWidthProperty().bind(tvThongKe.widthProperty().multiply(0.3));
				// date col
				TableColumn<PhanThuongDot, String> colNgayPhat = new TableColumn<>("Ngày phát");
				colNgayPhat.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().ngayPhat().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))));
				colNgayPhat.prefWidthProperty().bind(tvThongKe.widthProperty().multiply(0.2));
				// sum vo
				TableColumn<PhanThuongDot, Integer> colVo = new TableColumn<>("Tổng số vở");
				colVo.setCellValueFactory(x -> new SimpleIntegerProperty(x.getValue().tongSoVo()).asObject());
				colVo.prefWidthProperty().bind(tvThongKe.widthProperty().multiply(0.2));
				// sum tien
				TableColumn<PhanThuongDot, Integer> colTien = new TableColumn<>("Tổng số tiền");
				colTien.setCellValueFactory(x -> new SimpleIntegerProperty(x.getValue().tongSoTien()).asObject());
				colTien.prefWidthProperty().bind(tvThongKe.widthProperty().multiply(0.3));
				// add col to table
				tvThongKe.getColumns().addAll(colTenDot, colNgayPhat, colVo, colTien);

			} else if (filterType.getSelectedToggle().equals(rbHo)) {
				tvThongKe.setItems(FXCollections.observableList(PhanThuongService.getPTHK(tfFilter.getText())));

				// clean table cols
				tvThongKe.getColumns().clear();
				// name col
				TableColumn<PhanThuongHK, String> colMaHK = new TableColumn<>("Mã hộ khẩu");
				colMaHK.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().maHK()));
				colMaHK.prefWidthProperty().bind(tvThongKe.widthProperty().multiply(0.3));
				// sum vo
				TableColumn<PhanThuongHK, Integer> colVo = new TableColumn<>("Tổng số vở");
				colVo.setCellValueFactory(x -> new SimpleIntegerProperty(x.getValue().tongSoVo()).asObject());
				colVo.prefWidthProperty().bind(tvThongKe.widthProperty().multiply(0.2));
				// sum tien
				TableColumn<PhanThuongHK, Integer> colTien = new TableColumn<>("Tổng số tiền");
				colTien.setCellValueFactory(x -> new SimpleIntegerProperty(x.getValue().tongSoTien()).asObject());
				colTien.prefWidthProperty().bind(tvThongKe.widthProperty().multiply(0.5));
				// add col to table
				tvThongKe.getColumns().addAll(colMaHK, colVo, colTien);
			}
		} catch (SQLException e) {
			tvThongKe.setPlaceholder(new Label("Lỗi hệ thống"));
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

				Alert success = new Alert(Alert.AlertType.INFORMATION);
				success.setContentText("Export thành công. Đường dẫn : " + applicationFile.getAbsolutePath());
				success.show();
			} catch (IOException e) {
				Alert noFile = new Alert(Alert.AlertType.ERROR);
				noFile.setContentText("Hệ thống không phản hồi. Chưa ghi ra file");
				noFile.show();
			}
		} else {
			Alert noData = new Alert(Alert.AlertType.WARNING);
			noData.setContentText("Không có dữ liệu");
			noData.show();
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
