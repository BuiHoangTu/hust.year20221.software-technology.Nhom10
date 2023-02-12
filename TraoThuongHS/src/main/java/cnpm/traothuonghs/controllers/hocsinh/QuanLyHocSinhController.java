package cnpm.traothuonghs.controllers.hocsinh;

import cnpm.traothuonghs.controllers.BaseLeftController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class QuanLyHocSinhController extends BaseLeftController {

    public TableColumn colTenHocSinh;
    public TableColumn colPhuHuynh;
    public TableColumn colNgaySinh;
    public TableColumn colTruong;
    public TableColumn colLop;
    public TableView tvHocSinh;
    public CheckBox chbTen;
    public CheckBox chbDotPhat;
    public CheckBox chbDiaChi;
    public TextField tfTimKiem;

    @FXML
    private void initialize() {
        //Lấy dữ liệu trong database đưa vào bảng
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
