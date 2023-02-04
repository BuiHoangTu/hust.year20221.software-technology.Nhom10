package cnpm.quanlynhankhau.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import cnpm.quanlynhankhau.services.HoKhauService;
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

public class ChuyenHoKhau extends ChangeSceneControllers {
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
	private TableColumn<HoKhau, String> tcChuHo;
	
	@FXML
	private TableColumn<HoKhau, DiaChi> tcDiaChi;

	@FXML
	private void initialize() throws SQLException { 		
		// get HoKhau Test
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
	    
	}
	
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
	
	@FXML
    void rowClickedHoKhau(MouseEvent event) throws SQLException {
        HoKhau clickedHoKhau = tvHoKhau.getSelectionModel().getSelectedItem();
        tfMaHoKhauDuocChon.setText(String.valueOf(clickedHoKhau.getSoHoKhau()));
        tfChuHo.setText(String.valueOf(clickedHoKhau.getChuHo().getTen()));
        tfMaKhuVuc.setText(String.valueOf(clickedHoKhau.getMaKhuVuc()));
        tfDiaChiHienTai.setText(clickedHoKhau.getDiaChi().toString());
    }
	
    @FXML
    protected void onHuyClicked() {
    	changeScene("/cnpm/quanlynhankhau/views/QuanLyHoKhau.fxml");
    }
    
    @FXML
    protected void onXacNhanClicked() throws SQLException {
    	if (tfDiaChiChuyenDen.getText().equals("") || tfLyDo.getText().equals("")) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Chưa nhập các trường cần thiết");
            String str = "";
            if (tfDiaChiChuyenDen.getText().equals("")) str = str + "\n	Địa chỉ mới";
            if (tfLyDo.getText().equals("")) str = str + "\n	Lý do";
            alert.setContentText("Các trường : " + str + "\nđang còn trống");
            alert.show();
    	} else {
	    	HoKhau tmp = HoKhauService.findHoKhau(1, tfMaHoKhauDuocChon.getText()).get(0);
	    	tmp.setDiaChi(DiaChi.parse(tfDiaChiChuyenDen.getText()));
	    	tmp.commit();
	    	
	    	// Chuyển về scene trước đó
			changeScene("/cnpm/quanlynhankhau/views/QuanLyHoKhau.fxml");
    	}
    }
}
