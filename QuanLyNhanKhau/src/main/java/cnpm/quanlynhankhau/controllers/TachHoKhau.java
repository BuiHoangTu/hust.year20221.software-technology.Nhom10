package cnpm.quanlynhankhau.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import cnpm.quanlynhankhau.models.Database;
import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.models.DiaChi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class TachHoKhau {
	@FXML
    private TextField tfMaHoKhau;
	@FXML
    private TextField tfChuHo;
	@FXML
    private TextField tfMaKhuVucMoi;
	@FXML
    private TextField tfDiaChiMoi;
	@FXML
    private TextField tfMaHoKhauMoi;
	@FXML
    private ComboBox cbChuHoMoi;
	
	@FXML
	private ObservableList<HoKhau> hoKhauDaTimThay = FXCollections.observableArrayList();
	
	@FXML
	TableView<HoKhau> tvHoKhau;
	
	@FXML
	TableColumn<HoKhau, String> tcMaHoKhau;
	
	@FXML
	TableColumn<HoKhau, HoKhau> tcChuHo;
	
	@FXML
	TableColumn<HoKhau, DiaChi> tcDiaChi;
	
	@FXML
	private ObservableList<NhanKhau> nhanKhauHienTai = FXCollections.observableArrayList();
	
	@FXML
    private TableView<NhanKhau> tvThanhVien;
	
	@FXML
	private TableColumn<NhanKhau, String> tcHoTen;
	
	@FXML
	private TableColumn<NhanKhau, LocalDate> tcNgaySinh;
	
	@FXML
	private TableColumn<NhanKhau, String> tcQuanHeVoiChuHo;
	
	@FXML
    private ListView lvThanhVienHoMoi;
	
	
	
	@FXML
	private void initialize() throws SQLException {
		// TableView ThanhVien
		nhanKhauHienTai.addAll(Database.findNhanKhau(1, tfMaHoKhau.getText()));
		tvThanhVien.setItems(nhanKhauHienTai);
	    
		tcHoTen.setCellValueFactory(new PropertyValueFactory<>("ten"));
		tcHoTen.setMinWidth(20);
		tcHoTen.prefWidthProperty().bind(tvThanhVien.widthProperty().multiply(0.3));
		
		tcNgaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
		tcNgaySinh.setMinWidth(20);
		tcNgaySinh.prefWidthProperty().bind(tvThanhVien.widthProperty().multiply(0.3));
		
		tcQuanHeVoiChuHo.setCellValueFactory(new PropertyValueFactory<>("")); // TODO : chưa có trường quan hệ với chủ hộ
		tcQuanHeVoiChuHo.setMinWidth(20);
		tcQuanHeVoiChuHo.prefWidthProperty().bind(tvThanhVien.widthProperty().multiply(0.4));
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
    	ObservableList<HoKhau> currentTableData = tvHoKhau.getItems();
    	String currentHoKhau = tfMaHoKhau.getText();
    	
    	// TODO : Sử dụng findHoKhau() và taoHoKhau() để hoàn thành
    }

    @FXML
    void rowClickedHoKhau(MouseEvent event) {
        HoKhau clickedHoKhau = tvHoKhau.getSelectionModel().getSelectedItem();
        tcMaHoKhau.setText(String.valueOf(clickedHoKhau.getSoHoKhau()));
        tcChuHo.setText(String.valueOf(clickedHoKhau.getChuHo().getTen()));
        tcDiaChi.setText(String.valueOf(clickedHoKhau.getDiaChi().toString()));
    }
    
    @FXML
    void rowClickedThanhVien(MouseEvent event) {
        HoKhau clickedThanhVien = tvHoKhau.getSelectionModel().getSelectedItem();
        tfChuHo.setText(String.valueOf(clickedThanhVien.getSoHoKhau()));
        tcChuHo.setText(String.valueOf(clickedThanhVien.getChuHo().getTen()));
        tcDiaChi.setText(String.valueOf(clickedThanhVien.getDiaChi().toString()));
    }
    
    // TableView HoKhau
    @FXML
    private void setupTableViewHoKhau() throws SQLException{
        tvHoKhau.getItems().addAll(Database.findHoKhau(tfMaHoKhau.getText()));
        
        tcMaHoKhau.setCellValueFactory(new PropertyValueFactory<>("soHoKhau"));
		tcMaHoKhau.setMinWidth(20);
		tcMaHoKhau.prefWidthProperty().bind(tvHoKhau.widthProperty().multiply(0.3));
		
		tcChuHo.setCellValueFactory(new PropertyValueFactory<>("chuHo.getTen()"));
		tcChuHo.setMinWidth(20);
		tcChuHo.prefWidthProperty().bind(tvHoKhau.widthProperty().multiply(0.3));
		
		tcDiaChi.setCellValueFactory(new PropertyValueFactory<>("diaChi.toString()")); 
		tcDiaChi.setMinWidth(20);
		tcDiaChi.prefWidthProperty().bind(tvHoKhau.widthProperty().multiply(0.4));
    }
    
    // TableView ThanhVien
    private void setupTableViewThanhVien() throws SQLException{
        tvThanhVien.getItems().addAll(Database.findHoKhau(tfMaHoKhau.getText()).get(0).getThanhViens());
    }
}
