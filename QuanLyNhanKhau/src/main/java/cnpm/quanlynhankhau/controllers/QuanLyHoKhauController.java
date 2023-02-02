package cnpm.quanlynhankhau.controllers;

import java.io.IOException;
import java.sql.SQLException;

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

public class QuanLyHoKhauController extends EdgeController {
	@FXML
    private TextField tfMaHoKhau;
	@FXML
    private TableView<HoKhau> tvHoKhau;
	
	// changeScene
	private void changeScene(String fxLink) {
		FXMLLoader loader = new FXMLLoader(QuanLyNhanKhauApplication.class.getResource(fxLink));
		Scene scene = null;
		try {
			scene = new Scene(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		QuanLyNhanKhauApplication.MAIN_STAGE.setScene(scene);
	}
	
	public void initialize() {
		
	}
	
	@FXML
	protected void onThemMoiHoKhauClicked() throws IOException {
		
    }
    
	@FXML
	protected void onTachHoKhauClicked() {
		changeScene("/cnpm/quanlynhankhau/views/TachHoKhau.fxml");
    }
	
    @FXML
    protected void onChuyenHoKhauClicked() throws SQLException {
    	changeScene("/cnpm/quanlynhankhau/views/ChuyenHoKhau.fxml");
    }
}
