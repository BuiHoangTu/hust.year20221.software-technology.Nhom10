package cnpm.traothuonghs.controllers.hocsinh;

import cnpm.traothuonghs.controllers.ChangeSceneControllers;
import cnpm.traothuonghs.controllers.IFlushableController;
import cnpm.traothuonghs.models.HocSinh;
import cnpm.traothuonghs.services.HocSinhService;
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

    public void onHuyClicked() {
        changeScene("/cnpm/traothuonghs/views/hocsinh/Quan-ly-hoc-sinh.fxml");
    }

    public void onXacNhanClicked() throws SQLException {
        //Thêm học sinh vào database
        if(tfTenHocSinh.getText().equals("")|| tfLop.getText().equals("") || tfTenPhuHuynh.getText().equals("") || tfDanhHieu.getText().equals("") || tfMaHoKhau.getText().equals("") || tfDotPhatThuong.getText().equals("") || cbTruong.getValue().toString().equals("") || dpNgaySinh.getValue().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Thông tin không đầy đử, mời bổ sung thêm");
            alert.show();
            return;
        }
        HocSinhService.themHocSinh(tfTenHocSinh.getText(), tfTenPhuHuynh.getText(), dpNgaySinh.getValue(), cbTruong.getValue().toString(), tfLop.getText(), tfMaHoKhau.getText(), tfDanhHieu.getText(),tfDotPhatThuong.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Học sinh: " + tfTenHocSinh.getText() + "\nSinh ngày: " + dpNgaySinh.getValue() + "\nHọc trường: " + cbTruong.getValue().toString() + "\nLớp: " + tfLop.getText() + "\nĐã được thêm thành công");
        alert.show();
    }
}
