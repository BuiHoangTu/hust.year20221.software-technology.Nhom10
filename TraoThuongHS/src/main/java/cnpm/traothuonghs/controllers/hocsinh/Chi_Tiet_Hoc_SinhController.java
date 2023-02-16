package cnpm.traothuonghs.controllers.hocsinh;

import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.services.HoKhauService;
import cnpm.traothuonghs.controllers.BaseLeftController;
import cnpm.traothuonghs.models.HocSinh;
import cnpm.traothuonghs.models.PhanThuong;
import cnpm.traothuonghs.services.HocSinhService;
import cnpm.traothuonghs.services.PhanThuongService;
import cnpm.traothuonghs.services.TinhThuongService;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.sql.SQLException;
import java.time.LocalDate;

public class Chi_Tiet_Hoc_SinhController extends BaseLeftController {

    public static String idHocSinh = null;

    // Label Thông tin học sinh
    @FXML
    private Label lbID;
    @FXML
    private Label lbTen;
    @FXML
    private Label lbTruong;
    @FXML
    private Label lbMaHoKhau;
    @FXML
    private Label lbPhuHuynh;

    // TableView Danh sách phần thưởng cá nhân
    private ObservableList<PhanThuong> danhSachThuong = FXCollections.observableArrayList();
    @FXML
    private TableView<PhanThuong> tvDanhSachThuong;
    @FXML
    private TableColumn<PhanThuong, String> tcDanhHieu;
    @FXML
    private TableColumn<PhanThuong, String> tcLop;
    @FXML
    private TableColumn<PhanThuong, String> tcNgayNhan;
    @FXML
    private TableColumn<PhanThuong, String> tcSoVo;

    @FXML
    private void initialize() throws SQLException {
        // Set Label thông tin học sinh
        lbID.setText(idHocSinh);
        HocSinh hocSinh = HocSinhService.getHocSinh(1, lbID.getText());
        lbTen.setText(hocSinh.getTen());
        lbTruong.setText(hocSinh.getTruongHoc());
        lbMaHoKhau.setText(hocSinh.getMaHoKhau());
        lbPhuHuynh.setText(hocSinh.getPhuHuynh());

        // Set TableView ThanhVien
        tcDanhHieu.setCellValueFactory(new PropertyValueFactory<PhanThuong, String>("danhHieu"));
        tcDanhHieu.setMinWidth(20);
        tcDanhHieu.prefWidthProperty().bind(tvDanhSachThuong.widthProperty().multiply(0.3));

        tcLop.setCellValueFactory(new PropertyValueFactory<PhanThuong, String>("lop"));
        tcLop.setMinWidth(20);
        tcLop.prefWidthProperty().bind(tvDanhSachThuong.widthProperty().multiply(0.3));

        tcNgayNhan.setCellValueFactory(new PropertyValueFactory<PhanThuong, String>("ngayPhatThuong"));
        tcNgayNhan.setMinWidth(20);
        tcNgayNhan.prefWidthProperty().bind(tvDanhSachThuong.widthProperty().multiply(0.2));

//        tcSoVo.setCellValueFactory(new PropertyValueFactory<PhanThuong, String>(null));
        tcSoVo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PhanThuong, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PhanThuong, String> arg0) {
                return new SimpleStringProperty(String.valueOf(arg0.getValue().getSoVo()));
            }
        });
        tcSoVo.setMinWidth(20);
        tcSoVo.prefWidthProperty().bind(tvDanhSachThuong.widthProperty().multiply(0.2));

        try{
            danhSachThuong.addAll(PhanThuongService.findPhanThuongHS(idHocSinh));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tvDanhSachThuong.setItems(danhSachThuong);
    }

    // Button
    @FXML
    protected void onChinhSuaClicked() {
        Chinh_Sua_Hoc_SinhController.idHocSinh = idHocSinh;
        changeScene("/cnpm/traothuonghs/views/hocsinh/Chinh_Sua_Hoc_Sinh.fxml");
    }
    @FXML
    protected void onQuayLaiClicked() {
        changeScene("/cnpm/traothuonghs/views/hocsinh/Quan-ly-hoc-sinh.fxml");
    }

}
