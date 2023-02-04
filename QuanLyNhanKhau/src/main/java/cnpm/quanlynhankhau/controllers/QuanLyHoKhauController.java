package cnpm.quanlynhankhau.controllers;

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


    public QuanLyHoKhauController(){
    }


    @FXML
    public void initialize() {
		// todo get hk khu vuc hien tai

        colMaHoKhau.setCellValueFactory(new PropertyValueFactory<>("soHoKhau"));
        colHoTenChuHo.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getChuHo().getTen()));
        colDiaChi.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getDiaChi().toString()));
        tvHoKhau.setItems(hkKhuVuc);
    }

    public void onSeparateClicked(ActionEvent actionEvent) {
    }

    public void onMoveClicked(ActionEvent actionEvent) {
    }

	public void onAddClicked(ActionEvent event) {
		changeScene("/cnpm/quanlynhankhau/views/ThemMoiHoKhau.fxml");
	}
}
