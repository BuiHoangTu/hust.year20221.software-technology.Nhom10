package cnpm.quanlynhankhau.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import cnpm.quanlynhankhau.services.HoKhauService;
import cnpm.quanlynhankhau.services.NhanKhauService;
import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import cnpm.quanlynhankhau.models.DiaChi;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class TachHoKhau {	
	@FXML
    private TextField tfMaHoKhau;
	@FXML
    private TextField tfChuHo;
	@FXML
    private TextField tfMaKhuVucMoi;
	@FXML
    private TextField tfDiaChiMoi;
	
	// ComboBox
	@FXML
	private ObservableList<String> cacThanhVienConLai = FXCollections.observableArrayList();
	
	@FXML
    private ComboBox cbChuHoMoi;
	
	// TableView HoKhau
	
	String idHoKhau;
	
	@FXML
	private ObservableList<HoKhau> hoKhauDaTimThay = FXCollections.observableArrayList();
	
	@FXML
	private TableView<HoKhau> tvHoKhau;
	
	@FXML
	private TableColumn<HoKhau, String> tcMaHoKhau;
	
	@FXML
	private TableColumn<HoKhau, String> tcChuHo;
	
	@FXML
	private TableColumn<HoKhau, DiaChi> tcDiaChi;
	
	
	// TableView ThanhVien
	
	NhanKhau ThanhVienDuocChon;
	
	private ObservableList<NhanKhau> thanhVienCuCuaHo = FXCollections.observableArrayList();
	private ObservableList<NhanKhau> thanhVienMoiCuaHo = FXCollections.observableArrayList();
	
	@FXML
    private TableView<NhanKhau> tvThanhVien;
	
	@FXML
	private TableColumn<NhanKhau, String> tcHoTen;
	
	@FXML
	private TableColumn<NhanKhau, String> tcNgaySinh;
	
	@FXML
	private TableColumn<NhanKhau, String> tcQuanHeVoiChuHo;
	
	// ListView
	@FXML
    private ListView<String> lvThanhVienHoMoi;
	
	private List<NhanKhau> thanhVienHoMoi = new ArrayList<NhanKhau>();
	
	@FXML
	private void initialize() throws SQLException { 		
		// Set TableView HoKhau
		tcMaHoKhau.setCellValueFactory(new PropertyValueFactory<HoKhau, String>("soHoKhau"));
	    tcMaHoKhau.setMinWidth(20);
	    tcMaHoKhau.prefWidthProperty().bind(tvHoKhau.widthProperty().multiply(0.3));
	      
	    tcChuHo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HoKhau,String>, ObservableValue<String>>() {	
			@Override
			public ObservableValue<String> call(CellDataFeatures<HoKhau, String> arg0) {
				return new SimpleStringProperty(arg0.getValue().getChuHo().getTen());
			}
		});
	    tcChuHo.setMinWidth(20);
	    tcChuHo.prefWidthProperty().bind(tvHoKhau.widthProperty().multiply(0.3));
	      
	    tcDiaChi.setCellValueFactory(new PropertyValueFactory<HoKhau, DiaChi>("diaChi"));
	    tcDiaChi.setMinWidth(20);
	    tcDiaChi.prefWidthProperty().bind(tvHoKhau.widthProperty().multiply(0.4));
	      
	    try{
	    	hoKhauDaTimThay.addAll(HoKhauService.findHoKhau(3, "Quận Hai Bà Trưng"));
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	    tvHoKhau.setItems(hoKhauDaTimThay);
	      
	    // Set TableView ThanhVien
	    tcHoTen.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("ten"));
	    tcHoTen.setMinWidth(20);
	    tcHoTen.prefWidthProperty().bind(tvThanhVien.widthProperty().multiply(0.45));
			
	    tcNgaySinh.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("ngaySinh"));
	    tcNgaySinh.setMinWidth(20);
	    tcNgaySinh.prefWidthProperty().bind(tvThanhVien.widthProperty().multiply(0.25));
			
		tcQuanHeVoiChuHo.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>(null));
		tcQuanHeVoiChuHo.setMinWidth(20);
		tcQuanHeVoiChuHo.prefWidthProperty().bind(tvThanhVien.widthProperty().multiply(0.3));
		
		tvThanhVien.setItems(thanhVienCuCuaHo);
		
		// Set ComboBox ChuHoMoi
		cbChuHoMoi.setItems(cacThanhVienConLai);
	}
	
	// TableView HoKhau
    @FXML
    void setupTableViewHoKhau() throws SQLException{
    	if (!tfMaHoKhau.getText().equals("")) {
    		hoKhauDaTimThay.clear();
	    	hoKhauDaTimThay.addAll(HoKhauService.findHoKhau(1, tfMaHoKhau.getText()));
    	} else {
    		hoKhauDaTimThay.clear();
    		hoKhauDaTimThay.addAll(HoKhauService.findHoKhau(3, "Quận Hai Bà Trưng"));
    	}
    }
    
    // TableView ThanhVien
    void setupTableViewThanhVien(HoKhau hoKhau) throws SQLException{
    	if (tfMaHoKhau.getText().equals("")) {
    		thanhVienCuCuaHo.clear();
	    	thanhVienCuCuaHo.addAll(hoKhau.getThanhViens());
    	}
    }
	
	@FXML
    protected void onInsertClicked() {
		lvThanhVienHoMoi.getItems().add(ThanhVienDuocChon.getTen());
		thanhVienHoMoi.add(ThanhVienDuocChon);
		thanhVienCuCuaHo.remove(ThanhVienDuocChon);
    }
	
	@FXML
    protected void onRemoveClicked() {
		int selectedID = lvThanhVienHoMoi.getSelectionModel().getSelectedIndex();
        lvThanhVienHoMoi.getItems().remove(selectedID);
        thanhVienCuCuaHo.add(thanhVienHoMoi.get(selectedID));
        thanhVienHoMoi.remove(selectedID);
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
    	if (tfMaKhuVucMoi.getText().equals("") || tfDiaChiMoi.getText().equals("") || lvThanhVienHoMoi.getItems().size() == 0 || cbChuHoMoi.getValue() == null) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Chưa nhập các trường cần thiết");
            String str = "";
            if (tfMaKhuVucMoi.getText().equals("")) str = str + "\n	Mã khu vực mới";
            if (tfDiaChiMoi.getText().equals("")) str = str + "\n	Địa chỉ mới";
            if (lvThanhVienHoMoi.getItems().size() == 0) str = str + "\n	Danh sách thành viên hộ mới";
            if (cbChuHoMoi.getValue() == null) str = str + "\n	Chủ hộ mới";
            alert.setContentText("Các trường : " + str + "\nđang còn trống");
            alert.show();
    	} else {
    		HoKhau tmp = HoKhauService.findHoKhau(1, idHoKhau).get(0);
	    	for (String str : lvThanhVienHoMoi.getItems()) {
	    		tmp.xoaThanhVien(NhanKhauService.findNhanKhau(3, str).get(0));
	    	}
	    	
	    	// Thêm nhân khẩu mới vào một hộ mới
	    	tmp = HoKhauService.taoHoKhau(NhanKhauService.findNhanKhau(3, cbChuHoMoi.getValue().toString()).get(0).getSoNhanKhau(), tfMaKhuVucMoi.getText(), tfDiaChiMoi.getText());
	    	for (String str : lvThanhVienHoMoi.getItems()) {
	    		tmp.themThanhVien(NhanKhauService.findNhanKhau(3, str).get(0), null);
	    	}
	    	
	    	// Trở về scene trước đó
	    	FXMLLoader loader = new FXMLLoader(QuanLyNhanKhauApplication.class.getResource("/cnpm/quanlynhankhau/views/QuanLyHoKhau.fxml"));
			Scene scene = null;
			try {
				scene = new Scene(loader.load());
			} catch (IOException e) {
				e.printStackTrace();
			}
			QuanLyNhanKhauApplication.MAIN_STAGE.setScene(scene);
    	}
    }

    @FXML
    void rowClickedHoKhau(MouseEvent event) throws SQLException {
        HoKhau clickedHoKhau = tvHoKhau.getSelectionModel().getSelectedItem();
        tfChuHo.setText(clickedHoKhau.getChuHo().getTen());
        
        cacThanhVienConLai.clear();
        for (NhanKhau nk : clickedHoKhau.getThanhViens()) {
        	if (nk.getSoNhanKhau() != clickedHoKhau.getChuHo().getSoNhanKhau()) {
        		cacThanhVienConLai.add(nk.getTen());
        	}
        }
        
        idHoKhau = clickedHoKhau.getSoHoKhau();
        lvThanhVienHoMoi.getItems().clear();
        setupTableViewThanhVien(clickedHoKhau);
    }
    
    @FXML
    void rowClickedThanhVien(MouseEvent event) {
        NhanKhau clickedThanhVien = tvThanhVien.getSelectionModel().getSelectedItem();
        ThanhVienDuocChon = clickedThanhVien;
    }
    
    void addChuHo() {
    	
    }
}
