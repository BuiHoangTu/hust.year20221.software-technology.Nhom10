package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.services.HoKhauService;
import cnpm.quanlynhankhau.services.NhanKhauService;
import cnpm.quanlynhankhau.utilities.DoubleClickCallBack;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ThemMoiHoKhauController extends ChangeSceneControllers implements IController{
    // region FXML attributes
	@FXML
    public Label lblMaHoKhau;
    @FXML
    public TextField tfMaKhuVuc;
    @FXML
    public TextField tfDiaChi;
    @FXML
    public TextField tfChuHo;
    @FXML
    public TableView<NhanKhau> tvThanhVien;
    @FXML
    private TableColumn<NhanKhau, String> colHoTen;
    @FXML
    private TableColumn<NhanKhau, String> colNgaySinh;
    @FXML
    private TableColumn<NhanKhau, String> colQuanHeVoiChuHo;
    @FXML
    private Button Luu;
    @FXML
    private Button Them;
	// endregion

	NhanKhau chuHo;
	ObservableList<NhanKhau> thanhVienMoi = FXCollections.observableArrayList();
	ObservableList<NhanKhau> thanhVienTrong = FXCollections.observableArrayList();

	@FXML
    private void initialize() {
		try {
			thanhVienTrong.addAll(NhanKhauService.hoKhauLessRegion(QuanLyNhanKhauApplication.CO_SO_HIEN_TAI));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		lblMaHoKhau.setText("0");

		tvThanhVien.setItems(thanhVienMoi);
		tvThanhVien.setEditable(true);
        colHoTen.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getTen()));
        colNgaySinh.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getNgaySinh().toString()));
		colQuanHeVoiChuHo.setCellFactory(TextFieldTableCell.forTableColumn());
		colQuanHeVoiChuHo.setEditable(true);

		Luu.setDisable(false);
        Them.setDisable(false);
		tfChuHo.setDisable(true);
    }

	@FXML
    public void onChonClicked(ActionEvent actionEvent) {
		chuHo = tvThanhVien.getSelectionModel().getSelectedItem();
		tfChuHo.setText(chuHo.getTen());
    }

	@FXML
    public void onLuuClicked(ActionEvent ignore) {
		if (tfChuHo.getText().trim().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Thêm hộ khẩu thất bại");
			alert.setContentText("Không có chủ hộ");
			alert.show();

			return;
		}
		if (tfMaKhuVuc.getText().trim().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Thêm hộ khẩu thất bại");
			alert.setContentText("Không có mã khu vực");
			alert.show();

			return;
		}
		if (tfDiaChi.getText().trim().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Thêm hộ khẩu thất bại");
			alert.setContentText("Không có địa chỉ");
			alert.show();

			return;
		}

		try {
			// tao HK
			var hkMoi = HoKhauService.taoHoKhau(
					chuHo.getSoNhanKhau(),
					tfMaKhuVuc.toString(),
					tfDiaChi.toString()
			);

			// add tv to that HK
			for (int i = 0; i < thanhVienMoi.size(); i++) {
				hkMoi.themThanhVien(
						thanhVienMoi.get(i),
						colQuanHeVoiChuHo.getCellObservableValue(i).getValue());
			}

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Thêm hộ khẩu thành công");
			alert.setContentText(hkMoi.toString());
			alert.show();
		} catch (SQLException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Thêm hộ khẩu thất bại");
			alert.setContentText(e.getMessage());
			alert.show();
		}

		flush_data();
    }

    public void onXoaClicked(ActionEvent ignore){
		thanhVienMoi.remove(tvThanhVien.getSelectionModel().getSelectedItem());
    }


	public void onThemClicked(ActionEvent ignore) {
		Stage secondary = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader(QuanLyNhanKhauApplication.class.getResource("/cnpm/quanlynhankhau/views/HomeLess.fxml"));
		fxmlLoader.setController(new HomeLessController());
		Scene scene = null;
		try {
			scene = new Scene(fxmlLoader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Image icon = new Image(" "); /*path to icon */

		secondary.setTitle("Chọn thành viên");
		//stage.getIcons().add(icon);
		secondary.setScene(scene);
		QuanLyNhanKhauApplication.addSecondaryStage(secondary);

		secondary.show();
	}

	public void onHoKhauClicked(ActionEvent ignore) {
		changeScene("/cnpm/quanlynhankhau/views/QuanLyHoKhau.fxml");
	}


	public void flush_data() {
		tfChuHo.setText("");
		tfDiaChi.setText("");
		tfMaKhuVuc.setText("");

		thanhVienMoi.clear();
	}

	private class HomeLessController {
		// region fxml
		@FXML
		public TableView<NhanKhau> tv;
		@FXML
		public TableColumn<NhanKhau, String> tcMaNK;
		@FXML
		public TableColumn<NhanKhau, String> tcTen;
		@FXML
		public TableColumn<NhanKhau, String> tcNgaySinh;
		// endregion

		@FXML
		public void initialize() {
			tv.setItems(thanhVienTrong);

			tcMaNK.prefWidthProperty().bind(tv.widthProperty().multiply(0.2));
			tcTen.prefWidthProperty().bind(tv.widthProperty().multiply(0.6));
			tcNgaySinh.prefWidthProperty().bind(tv.widthProperty().multiply(0.2));

			tcMaNK.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getSoNhanKhau()));
			tcTen.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getTen()));
			tcNgaySinh.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getNgaySinh().toString()));

			tv.setRowFactory(new DoubleClickCallBack<>(() -> {
				thanhVienMoi.add(tv.getSelectionModel().getSelectedItem());
				thanhVienTrong.remove(tv.getSelectionModel().getSelectedItem());
				return null;
			}));
		}
	}
}
