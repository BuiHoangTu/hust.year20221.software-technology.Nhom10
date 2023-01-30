package cnpm.quanlynhankhau.controllers;

import java.io.IOException;
import java.sql.SQLException;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import cnpm.quanlynhankhau.models.Database;
import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.models.NhanKhau;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private ComboBox cbChuHoMoi;
	
	@FXML
	TableView<NhanKhau> tvHoKhau;
	TableColumn<NhanKhau, String> tcMaHoKhau;
	TableColumn<NhanKhau, String> tcChuHo;
	TableColumn<NhanKhau, String> tcDiaChi;
	
	@FXML
    private TableView tvThanhVien;
	private TableColumn tcHoTen;
	private TableColumn tcNgaySinh;
	private TableColumn tcQuanHeVoiChuHo;
	
	@FXML
    private ListView lvThanhVienHoMoi;
	
	private ObservableList<NhanKhau> nhanKhauHienTai;
	
	@FXML
	private void init() throws SQLException {
		
		// 
		
		// TableView HoKhau
		nhanKhauHienTai = FXCollections.observableArrayList(Database.getHoKhau(tfMaHoKhau.getText()).getThanhViens());
	    tvHoKhau = new TableView<>(nhanKhauHienTai);
	    
		tcMaHoKhau = new TableColumn<>("Mã hộ khẩu");
		tcMaHoKhau.setCellValueFactory(new PropertyValueFactory<>("")); // Lấy trong Class vidu HoKhau.chuHo lấy hoàn toàn kiểu dữ liệu
		tcMaHoKhau.setMinWidth(20);
		tcMaHoKhau.prefWidthProperty().bind(tvHoKhau.widthProperty().multiply(0.3));
		
		tcChuHo = new TableColumn<>("Họ tên chủ hộ");
		tcChuHo.setCellValueFactory(new PropertyValueFactory<>(Database.getHoKhau(tfMaHoKhau.getText()).getChuHo().getTen()));
		tcChuHo.setMinWidth(20);
		tcChuHo.prefWidthProperty().bind(tvHoKhau.widthProperty().multiply(0.3));
		
		tcDiaChi = new TableColumn<>("Địa chỉ");
		tcDiaChi.setCellValueFactory(new PropertyValueFactory<>(Database.getHoKhau(tfMaHoKhau.getText()).getDiaChi().toString()));
		tcDiaChi.setMinWidth(20);
		tcDiaChi.prefWidthProperty().bind(tvHoKhau.widthProperty().multiply(0.4));
		
		// TableView ThanhVien

	}
	
	@FXML
    protected void onInsertClicked() {
        
    }
	
	@FXML
    protected void onRemoveClicked() {
        return;
    }
	
    @FXML
    protected void onHuyClicked() {
        return;
    }
    
    @FXML
    protected void onXacNhanClicked() {
        
    }
}
