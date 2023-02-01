package cnpm.quanlynhankhau.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import cnpm.quanlynhankhau.services.HoKhauService;
import cnpm.quanlynhankhau.services.NhanKhauService;
import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import cnpm.quanlynhankhau.models.DiaChi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class QuanLyHoKhauController {
	@FXML
    private TextField tfMaHoKhau;
	@FXML
    private TableView<HoKhau> tvHoKhau;
	
	@FXML
	protected void onThemMoiHoKhauClicked() throws IOException {
		FXMLLoader loader = new FXMLLoader(QuanLyNhanKhauApplication.class.getResource("/cnpm/quanlynhankhau/views/ThemMoiHoKhau.fxml"));
		Scene scene = new Scene(loader.load());
		Stage newWindow = new Stage();
		newWindow.setScene(scene);
		newWindow.show();
    }
    
	@FXML
	protected void onTachHoKhauClicked() {
		
    }
	
    @FXML
    protected void onChuyenHoKhauClicked() throws SQLException {
    	
    }
}
