package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.services.NhanKhauService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ThongKe extends EdgeController implements Initializable {
    public TextField tfTuoiTu;
    public TextField tfTuoiDen;
    public TextField tfNamTu;
    public TextField tfNamDen;
    public TableView<NhanKhau> tvNhanKhau;
    public TableColumn<NhanKhau, String> colID;
    public TableColumn<NhanKhau, String> colHoTen;
    public TableColumn<NhanKhau, String> colNgaySinh;
    public TableColumn<NhanKhau, String> colGioiTinh;
    public TableColumn<NhanKhau, String> colDiaChiHienNay;
    @FXML
    private ComboBox cbGioiTinh;
	@FXML
    private ComboBox cbTinhTrang;
	@FXML
    private TextField tfAgeFrom;
	@FXML
    private TextField tfAgeUntil;
	@FXML
    private TextField tfYearFrom;
	@FXML
    private TextField tfYearUntil;
	@FXML
    private TableView tvThanhVien;

	@FXML
    protected void onShowClicked() {
        
    }
	
	@FXML
    protected void onExportClicked() {
        
    }
	
    @FXML
    protected void onHuyClicked() {
        
    }
    
    @FXML
    protected void onXacNhanClicked() {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colID.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("soNhanKhau"));
        colHoTen.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("ten"));
        colNgaySinh.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("ngaySinh"));
        colGioiTinh.setCellValueFactory(nhanKhauStringCellDataFeatures -> new SimpleStringProperty(nhanKhauStringCellDataFeatures.getValue().isMale() ? "Nam" : "Nữ"));
        colDiaChiHienNay.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("diaChiHienTai"));
        List<NhanKhau> nk = null;
        try {
            nk = NhanKhauService.findNhanKhau(5, "Quận Hai Bà Trưng, Hà Nội");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ObservableList<NhanKhau> ls = FXCollections.observableList(nk);
        tvNhanKhau.setItems(ls);
    }
}
