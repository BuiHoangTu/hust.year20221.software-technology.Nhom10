package cnpm.quanlynhankhau.controllers;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.services.NhanKhauService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ThongKe {
	@FXML
    private ComboBox<String> cbGioiTinh;
	@FXML
    private ComboBox<String> cbTinhTrang;
	@FXML
    private TextField tfTuoiTu;
	@FXML
    private TextField tfTuoiDen;
	@FXML
    private TextField tfNamTu;
	@FXML
    private TextField tfNamDen;
	
	@FXML
	private ObservableList<HoKhau> nhanKhau = FXCollections.observableArrayList();
	
	@FXML
    private TableView<NhanKhau> tvNhanKhau;

	@FXML
	public void initialize() {
		cbGioiTinh.setItems(FXCollections.observableArrayList("Toàn bộ", "Nam", "Nữ", "Khác"));
		cbTinhTrang.setItems(FXCollections.observableArrayList("Toàn bộ", "Tạm vắng/Tạm trú"));
	}
	
	@FXML
    protected void onShowClicked() throws SQLException {
        
		List<NhanKhau> nhanKhauDaTimThay = new ArrayList<NhanKhau>();
		if (cbGioiTinh.getValue() != "Toàn bộ") {
			nhanKhauDaTimThay = NhanKhauService.findNhanKhau(1, cbGioiTinh.getValue());
			// TODO : Tạo thêm findNhanKhau theo giới tính
		} 
		if (cbTinhTrang.getValue() != "Toàn bộ") {
			if (nhanKhauDaTimThay.size() == 0) {
				nhanKhauDaTimThay = NhanKhauService.findNhanKhau(1, cbTinhTrang.getValue());
				// TODO : Tạo thêm findNhanKhau theo giới tính
			} else {
				for (NhanKhau nhanKhau : nhanKhauDaTimThay) {
					LocalDate tuNgay = nhanKhau.getTamTruVangs().get(nhanKhau.getTamTruVangs().size()-1).getTuNgay();
					LocalDate denNgay = nhanKhau.getTamTruVangs().get(nhanKhau.getTamTruVangs().size()-1).getDenNgay();
					if (LocalDate.now().compareTo(tuNgay) < 0 || LocalDate.now().compareTo(denNgay) > 0) {
						nhanKhauDaTimThay.remove(nhanKhau);
					}
				}
			}
		}
		if (tfTuoiTu.getText() != "" || tfTuoiDen.getText() != "") {
			if (tfTuoiTu.getText() != "") {
				for (NhanKhau nhanKhau : nhanKhauDaTimThay) {
					int tuoi = LocalDate.now().getYear() - nhanKhau.getNgaySinh().getYear();
					if (tuoi < Integer.parseInt(tfTuoiTu.getText())) {
						nhanKhauDaTimThay.remove(nhanKhau);
					}
				}
			}
			if (tfTuoiDen.getText() != "") {
				for (NhanKhau nhanKhau : nhanKhauDaTimThay) {
					int tuoi = LocalDate.now().getYear() - nhanKhau.getNgaySinh().getYear();
					if (tuoi > Integer.parseInt(tfTuoiDen.getText())) {
						nhanKhauDaTimThay.remove(nhanKhau);
					}
				}
			}
		}
		// TODO : Năm từ đâu ???????? Năm j mới đươc
		// Ngày tạo
    }
	
	@FXML
    protected void onExportClicked() {
        // TODO : làm xuất file
		// csv
    }
}
