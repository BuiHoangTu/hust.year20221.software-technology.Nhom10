package cnpm.quanlynhankhau.controllers;

import java.sql.SQLException;

import cnpm.quanlynhankhau.services.HoKhauService;
import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.models.DiaChi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ChuyenHoKhau {
	@FXML
    private TextField tfMaHoKhau;
	@FXML
    private TextField tfMaHoKhauDuocChon;
	@FXML
    private TextField tfChuHo;
	@FXML
    private TextField tfMaKhuVuc;
	@FXML
    private TextField tfDiaChiHienTai;
	@FXML
    private TextField tfDiaChiChuyenDen;
	@FXML
    private TextField tfLyDo;
	
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
	
	@FXML
    void rowClickedHoKhau(MouseEvent event) throws SQLException {
        HoKhau clickedHoKhau = tvHoKhau.getSelectionModel().getSelectedItem();
        tfMaHoKhauDuocChon.setText(String.valueOf(clickedHoKhau.getSoHoKhau()));
        tfChuHo.setText(String.valueOf(clickedHoKhau.getChuHo()));
        tfMaKhuVuc.setText(String.valueOf(clickedHoKhau.getMaKhuVuc()));
        tfDiaChiHienTai.setText(clickedHoKhau.getDiaChi().toString());
    }
	
    @FXML
    protected void onHuyClicked() {
        // TODO : Hàm j đó Quay lại menu trước đó
    }
    
    @FXML
    protected void onXacNhanClicked() throws SQLException {
    	HoKhau tmp = HoKhauService.getHoKhau(tfMaHoKhauDuocChon.getText());
    	tmp.setDiaChi(DiaChi.parse(tfDiaChiChuyenDen.getText()));
    	tmp.commit();
    }
}
