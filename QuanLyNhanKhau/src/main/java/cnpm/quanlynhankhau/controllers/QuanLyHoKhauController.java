package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.services.HoKhauService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.Objects;

public class QuanLyHoKhauController extends EdgeController {
    // region FXML
	@FXML
    private TableView<HoKhau> tvHoKhau;
    @FXML
    private TableColumn<HoKhau, String> colMaHoKhau;
    @FXML
    private TableColumn<HoKhau, String> colHoTenChuHo;
    @FXML
    private TableColumn<HoKhau, String> colDiaChi;
    @FXML
    public TextField tfSearch;
    public Label lblThemMoiNum;
	// endregion

    ObservableList<HoKhau> hkKhuVuc = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
		tvHoKhau.setPlaceholder(new Label("Không có hộ khẩu trong thành phố"));
		try {
			hkKhuVuc.addAll(Objects.requireNonNull(HoKhauService.findHoKhau(HoKhauService.BY_DIA_CHI, QuanLyNhanKhauApplication.CO_SO_HIEN_TAI.thanhPho)));
		} catch (SQLException ignored) {
			tvHoKhau.setPlaceholder(new Label("Hệ thống lỗi! Không thể hiển thị"));
		}

        colMaHoKhau.setCellValueFactory(new PropertyValueFactory<>("soHoKhau"));
		try {
			colDiaChi.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getDiaChi().toString()));
		} catch (NullPointerException e) {
			colDiaChi.setCellValueFactory(x -> new SimpleStringProperty(""));
		}
		tvHoKhau.setItems(hkKhuVuc);
    }

    public void onSeparateClicked(ActionEvent actionEvent) {
    	changeScene("/cnpm/quanlynhankhau/views/TachHoKhau.fxml");
	}

    public void onMoveClicked(ActionEvent actionEvent) {
    	changeScene("/cnpm/quanlynhankhau/views/ChuyenHoKhau.fxml");
	}

	public void onAddClicked(ActionEvent event) {
		changeScene("/cnpm/quanlynhankhau/views/ThemMoiHoKhau.fxml");
	}
}
