package cnpm.traothuonghs.controllers;

import cnpm.traothuonghs.models.PhanThuong;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Chi_Tiet_Hoc_SinhController extends EdgeController {
    // Label Thông tin học sinh
    @FXML
    private Label lbID;
    @FXML
    private Label lbTen;
    @FXML
    private Label lbTruong;
    @FXML
    private Label lbLop;
    @FXML
    private Label lbDiaChi;
    @FXML
    private Label lbMaHoKhau;
    @FXML
    private Label lbPhuHuynh;

    // TableView Danh sách phần thưởng cá nhân
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

    // Button
    @FXML
    protected void onChinhSuaClicked() {

    }
    @FXML
    protected void onHSTruocDoClicked() {

    }

    @FXML
    protected void onHSTiepTheoClicked() {

    }

}
