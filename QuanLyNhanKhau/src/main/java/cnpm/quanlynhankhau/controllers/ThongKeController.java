package cnpm.quanlynhankhau.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import cnpm.quanlynhankhau.models.DiaChi;
import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.services.HoKhauService;
import cnpm.quanlynhankhau.services.NhanKhauService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ThongKe extends EdgeController {
	
	private static final String DELIMITER = ",";
	private static final String LINE_SEPARATOR = "\n";
	
	@FXML
    private TextField tfTuoiTu;
	@FXML
    private TextField tfTuoiDen;
	@FXML
    private TextField tfNamTu;
	@FXML
    private TextField tfNamDen;
	
	// ComboBox
	@FXML
    private ComboBox<String> cbGioiTinh;
	
	@FXML
    private ComboBox<String> cbTinhTrang;
	
	// TableView nhanKhau
	@FXML
	private ObservableList<NhanKhau> nhanKhau = FXCollections.observableArrayList();
	
	@FXML
	private TableView<NhanKhau> tvNhanKhau;
		
	@FXML
	private TableColumn<NhanKhau, String> tcID;
	
	@FXML
	private TableColumn<NhanKhau, String> tcHoTen;
		
	@FXML
	private TableColumn<NhanKhau, String> tcNgaySinh;
		
	@FXML
	private TableColumn<NhanKhau, String> tcGioiTinh;
	
	@FXML
	private TableColumn<NhanKhau, String> tcDiaChi;

	@FXML
	public void initialize() throws SQLException {
		// ComboBox filter
		cbGioiTinh.setItems(FXCollections.observableArrayList("Toàn bộ", "Nam", "Nữ"));
		cbTinhTrang.setItems(FXCollections.observableArrayList("Toàn bộ", "Tạm vắng/Tạm trú"));
		
		// TableView HoKhau
		tcID.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("soNhanKhau"));
	    tcID.setMinWidth(20);
	    tcID.prefWidthProperty().bind(tvNhanKhau.widthProperty().multiply(0.1));
	      
	    tcHoTen.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("ten"));
	    tcHoTen.setMinWidth(20);
	    tcHoTen.prefWidthProperty().bind(tvNhanKhau.widthProperty().multiply(0.2));
	      
	    tcNgaySinh.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("ngaySinh"));
	    tcNgaySinh.setMinWidth(20);
	    tcNgaySinh.prefWidthProperty().bind(tvNhanKhau.widthProperty().multiply(0.2));
	    
	    tcGioiTinh.setCellValueFactory(nhanKhauStringCellDataFeatures -> new SimpleStringProperty(nhanKhauStringCellDataFeatures.getValue().isMale() ? "Nam" : "Nữ"));
	    tcGioiTinh.setMinWidth(20);
	    tcGioiTinh.prefWidthProperty().bind(tvNhanKhau.widthProperty().multiply(0.1));
	    
	    tcDiaChi.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("diaChiHienTai"));
	    tcDiaChi.setMinWidth(20);
	    tcDiaChi.prefWidthProperty().bind(tvNhanKhau.widthProperty().multiply(0.4));
	      
        try {
            nhanKhau.addAll(NhanKhauService.findNhanKhau(5, "Quận Hai Bà Trưng, Hà Nội", null));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	    tvNhanKhau.setItems(nhanKhau);
	}
	
	@FXML	
    protected void onShowClicked() throws SQLException {
		nhanKhau.clear();
		nhanKhau.addAll(NhanKhauService.thongKeNhanKhau(tfTuoiTu.getText(), tfTuoiDen.getText(), cbGioiTinh.getValue(), cbTinhTrang.getValue(), tfNamTu.getText(), tfNamDen.getText()));
    }
	
	@FXML
    protected void onExportClicked() throws FileNotFoundException {
		List<String> headers = new ArrayList<String>();
		
		headers.add("ID");
		headers.add("Ho ten");
		headers.add("Ngay sinh");
		headers.add("Gioi tính");
		headers.add("Dia chi");
		
		File file = new File("src\\main\\resources\\cnpm\\quanlynhankhau\\data\\Ngay_gio_tao_file.csv");
		try(PrintWriter writer = new PrintWriter(file)) {
			// write header
			writer.write(writeHeader(headers));
			
			// write body
			writer.write(writeBody(nhanKhau));
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
    }
	
	private static String writeHeader(List<String> headers) {
		StringBuilder result = new StringBuilder();
		headers.stream().forEach(item -> result.append(item).append(DELIMITER));
		result.append(LINE_SEPARATOR);
		return result.toString();
	}
	
	private static String writeBody(ObservableList<NhanKhau> nhanKhau) {
		StringBuilder result = new StringBuilder();
		nhanKhau.stream().forEach(item -> 
					result.append(item.getSoNhanKhau()).append(DELIMITER)
					.append(item.getTen()).append(DELIMITER)
					.append(item.getNgaySinh()).append(DELIMITER)
					.append(item.isMale()).append(DELIMITER)
					.append(item.getDiaChiHienTai()).append(LINE_SEPARATOR));
		
		return result.toString();
	}
	
}
