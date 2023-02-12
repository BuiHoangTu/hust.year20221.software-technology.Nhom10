package cnpm.traothuonghs.controllers.hocsinh;

import cnpm.traothuonghs.controllers.BaseLeftController;
import cnpm.traothuonghs.models.HocSinh;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class QuanLyHocSinhController extends BaseLeftController {

    public TableColumn<HocSinh, String> colTenHocSinh;
    public TableColumn<HocSinh, String> colPhuHuynh;
    public TableColumn<HocSinh, String> colNgaySinh;
    public TableColumn<HocSinh, String> colTruong;
    public TableColumn<HocSinh, String> colLop;
    public TableView<HocSinh> tvHocSinh;
    public CheckBox chbTen;
    public CheckBox chbDotPhat;
    public CheckBox chbDiaChi;
    public TextField tfTimKiem;

    @FXML
    private void initialize() {

    }

    public void onTimKiemClicked(ActionEvent event) {
        //Tìm học sinh theo checkBox và textField từ database
    }

    public void onThemHocSinhClicked(ActionEvent event) {
        //changeScene();
    }

    public void onChinhSuaHocSinhClicked(ActionEvent event) {
        //changeScene();
    }

    public void onXemThongTinClicked(ActionEvent event) {
        //changeScene();
    }
}
