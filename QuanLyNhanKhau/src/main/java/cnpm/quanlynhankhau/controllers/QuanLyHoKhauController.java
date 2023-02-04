package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.services.HoKhauService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class QuanLyHoKhauController extends EdgeController {
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
    ObservableList<HoKhau> HK = FXCollections.observableArrayList();
    public QuanLyHoKhauController(){

    }
    @FXML
    public void initialize() throws SQLException {

        for (int i=13; HoKhauService.getHoKhau(String.format("%d", i)) != null ; i++) {
            HK.add(HoKhauService.getHoKhau(String.format("%d", i)));
        }

        colMaHoKhau.setCellValueFactory(new PropertyValueFactory<HoKhau, String>("soHoKhau"));
        colHoTenChuHo.setCellValueFactory(new PropertyValueFactory<HoKhau, String>("hoTenChuHo"));
        colDiaChi.setCellValueFactory(new PropertyValueFactory<HoKhau, String>("diaChiString"));
        tvHoKhau.setItems(HK);
    }

    public void onSeparateClicked(ActionEvent actionEvent) {
    }

    public void onMoveClicked(ActionEvent actionEvent) {
    }

	public void onAddClicked(ActionEvent event) {
		changeScene("/cnpm/quanlynhankhau/views/ThemMoiHoKhau.fxml");
	}
}
