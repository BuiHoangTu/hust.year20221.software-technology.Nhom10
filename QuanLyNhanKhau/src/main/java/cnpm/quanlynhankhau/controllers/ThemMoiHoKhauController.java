package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.services.HoKhauService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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

	@FXML
    private void initialize() {
		// TODO: 04/02/2023 ??
        lblMaHoKhau.setText("0");

		tvThanhVien.setItems(thanhVienMoi);
        colHoTen.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getTen()));
        colNgaySinh.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getNgaySinh().toString()));
        colQuanHeVoiChuHo.setCellValueFactory(new PropertyValueFactory<>("quanHeVoiChuHo"));

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
			for (var tvien : tvThanhVien.getItems()) {
				hkMoi.themThanhVien(tvien);
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
		// // TODO: 04/02/2023 call other
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
}
