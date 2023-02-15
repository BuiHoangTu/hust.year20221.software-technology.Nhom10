package cnpm.traothuonghs.controllers.hocsinh;

import cnpm.traothuonghs.controllers.ChangeSceneControllers;
import cnpm.traothuonghs.controllers.IFlushableController;
import cnpm.traothuonghs.models.HocSinh;
import cnpm.traothuonghs.services.HocSinhService;
import cnpm.traothuonghs.services.PhanThuongService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ThemHocSinhController extends ChangeSceneControllers implements IFlushableController {
    public TextField tfTenHocSinh;
    public TextField tfLop;
    public TextField tfDanhHieu;
    public TextField tfMaHoKhau;
    public TextField tfTenPhuHuynh;
    public DatePicker dpNgaySinh;
    public ComboBox cbTruong;
    public TextField tfDotPhatThuong;

    @Override
    public void flush_data() {

    }

    @FXML
    public void initialize(){
        cbTruong.getItems().addAll(HocSinh.tenCacTruongHoc);
    }

    public void onHuyClicked(ActionEvent event) {
        changeScene("/cnpm/traothuonghs/views/Quan-ly-hoc-sinh.fxml");
    }

    public void onXacNhanClicked(ActionEvent event) throws SQLException {
        //Thêm học sinh vào database
        HocSinhService.themHocSinh(tfTenHocSinh.getText(), tfTenPhuHuynh.getText(), dpNgaySinh.getValue(), cbTruong.getValue().toString(), tfLop.getText(), tfMaHoKhau.getText(), tfDanhHieu.getText(),tfDotPhatThuong.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Đã được thêm thành công");
        alert.show();
    }
}
