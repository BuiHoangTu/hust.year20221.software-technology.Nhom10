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
    private TextField tfChuHoMoi;
	
	// TableView HoKhau
	@FXML
	private ObservableList<HoKhau> hoKhauDaTimThay = FXCollections.observableArrayList();
	
	@FXML
	private TableView<HoKhau> tvHoKhau;
	
	@FXML
	private TableColumn<HoKhau, String> tcMaHoKhau;
	
	@FXML
	private TableColumn<HoKhau, HoKhau> tcChuHo;
	
	@FXML
	private TableColumn<HoKhau, DiaChi> tcDiaChi;
	
	
	// TableView ThanhVien
	@FXML
    private TableView<NhanKhau> tvThanhVien;
	
	@FXML
	private TableColumn<NhanKhau, String> tcHoTen;
	
	@FXML
	private TableColumn<NhanKhau, LocalDate> tcNgaySinh;
	
	@FXML
	private TableColumn<NhanKhau, String> tcQuanHeVoiChuHo;
	
	@FXML
    private ListView<String> lvThanhVienHoMoi;
	
	@FXML
	private void initialize() throws SQLException { 		
		// get hết nhân khẩu khu vực Hà nội
		hoKhauDaTimThay.addAll(HoKhauService.findHoKhau("Hà Nội"));
        tvHoKhau.getItems().addAll(hoKhauDaTimThay);
        
        tcMaHoKhau.setCellValueFactory(new PropertyValueFactory<>("soHoKhau"));
		tcMaHoKhau.setMinWidth(20);
		tcMaHoKhau.prefWidthProperty().bind(tvHoKhau.widthProperty().multiply(0.3));
		
		tcChuHo.setCellValueFactory(new PropertyValueFactory<>("chuHo"));
		tcChuHo.setMinWidth(20);
		tcChuHo.prefWidthProperty().bind(tvHoKhau.widthProperty().multiply(0.3));
		
		tcDiaChi.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
		tcDiaChi.setMinWidth(20);
		tcDiaChi.prefWidthProperty().bind(tvHoKhau.widthProperty().multiply(0.4));
	}
	
	// TableView HoKhau
    @FXML
    void setupTableViewHoKhau() throws SQLException{
    	hoKhauDaTimThay.addAll(HoKhauService.findHoKhau(tfMaHoKhau.getText()));
        tvHoKhau.getItems().addAll(hoKhauDaTimThay);
        
        tcMaHoKhau.setCellValueFactory(new PropertyValueFactory<>("soHoKhau"));
		tcMaHoKhau.setMinWidth(20);
		tcMaHoKhau.prefWidthProperty().bind(tvHoKhau.widthProperty().multiply(0.3));
		
		tcChuHo.setCellValueFactory(new PropertyValueFactory<>("chuHo"));
		tcChuHo.setMinWidth(20);
		tcChuHo.prefWidthProperty().bind(tvHoKhau.widthProperty().multiply(0.3));
		
		tcDiaChi.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
		tcDiaChi.setMinWidth(20);
		tcDiaChi.prefWidthProperty().bind(tvHoKhau.widthProperty().multiply(0.4));
    }
    
    // TableView ThanhVien
    void setupTableViewThanhVien(HoKhau hoKhau) throws SQLException{
        tvThanhVien.getItems().addAll(hoKhau.getThanhViens());
        
        tcHoTen.setCellValueFactory(new PropertyValueFactory<>("ten"));
		tcHoTen.setMinWidth(20);
		tcHoTen.prefWidthProperty().bind(tvThanhVien.widthProperty().multiply(0.3));
		
		tcNgaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
		tcNgaySinh.setMinWidth(20);
		tcNgaySinh.prefWidthProperty().bind(tvThanhVien.widthProperty().multiply(0.3));
		
		tcQuanHeVoiChuHo.setCellValueFactory(new PropertyValueFactory<>(null));
		tcQuanHeVoiChuHo.setMinWidth(20);
		tcQuanHeVoiChuHo.prefWidthProperty().bind(tvThanhVien.widthProperty().multiply(0.4));
    }
	
	@FXML
    protected void onInsertClicked() {
		lvThanhVienHoMoi.getItems().add(tcHoTen.getText());
    }
	
	@FXML
    protected void onRemoveClicked() {
		int selectedID = lvThanhVienHoMoi.getSelectionModel().getSelectedIndex();
        lvThanhVienHoMoi.getItems().remove(selectedID);
    }
	
    @FXML
    protected void onHuyClicked() {
        // TODO : Hàm j đó Quay lại menu trước đó
    	FXMLLoader loader = new FXMLLoader(QuanLyNhanKhauApplication.class.getResource("/cnpm/quanlynhankhau/views/QuanLyHoKhau.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		QuanLyNhanKhauApplication.MAIN_STAGE.setScene(scene);
    }
    
    @FXML
    protected void onXacNhanClicked() throws SQLException {
    	/* Tìm hộ khẩu và lấy danh sách thành viên
    	 * Dùng vòng for để tìm trong ListView HoMoi để xóa khỏi nhân khẩu cũ
    	 */
    	HoKhau tmp = HoKhauService.getHoKhau(tfMaHoKhau.getText());
    	for (String str : lvThanhVienHoMoi.getItems()) {
    		tmp.xoaThanhVien(NhanKhauService.findNhanKhau(3, str).get(0));
    	}
    	
    	// Thêm nhân khẩu mới vào một hộ mới
    	tmp = HoKhauService.taoHoKhau(tfMaHoKhauMoi.getText(), tfMaKhuVucMoi.getText(), tfDiaChiMoi.getText());
    	for (String str : lvThanhVienHoMoi.getItems()) {
    		tmp.themThanhVien(NhanKhauService.findNhanKhau(3, str).get(0), null);
    	}
    	
    }

    @FXML
    void rowClickedHoKhau(MouseEvent event) throws SQLException {
        HoKhau clickedHoKhau = tvHoKhau.getSelectionModel().getSelectedItem();
        tfChuHo.setText(clickedHoKhau.getChuHo().getTen());
        
        setupTableViewThanhVien(clickedHoKhau);
    }
    
    @FXML
    void rowClickedThanhVien(MouseEvent event) {
        NhanKhau clickedThanhVien = tvThanhVien.getSelectionModel().getSelectedItem();
        tcHoTen.setText(clickedThanhVien.getTen());
        tcNgaySinh.setText(clickedThanhVien.getNgaySinh().toString());
        tcQuanHeVoiChuHo.setText("");
    }
    
    
}
