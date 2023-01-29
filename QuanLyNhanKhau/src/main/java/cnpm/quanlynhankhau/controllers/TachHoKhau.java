package cnpm.quanlynhankhau.controllers;

import java.io.IOException;
import java.sql.SQLException;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class TachHoKhau {
	@FXML
    private TextField tfMaHoKhau;
	@FXML
    private TextField tfChuHo;
	@FXML
    private TextField tfMaKhuVuc;
	@FXML
    private TextField tfDiaChi;
	@FXML
    private TextField tfMaHoKhauMoi;
	@FXML
    private TextField tfChuHoMoi;
	@FXML
    private TableView tvHoKhau;
	@FXML
    private TableView tvThanhVien;
	@FXML
    private ListView lvThanhVienHoMoi;

	@FXML
	private void init() {
		// TODO : thêm vào các ComboBox
	}
	
	@FXML
    protected void onInsertClicked() {
        
    }
	
	@FXML
    protected void onRemoveClicked() {
        
    }
	
    @FXML
    protected void onHuyClicked() {
        
    }
    
    @FXML
    protected void onXacNhanClicked() {
        
    }
}
