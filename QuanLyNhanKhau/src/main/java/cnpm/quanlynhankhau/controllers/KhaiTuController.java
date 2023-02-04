package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import cnpm.quanlynhankhau.services.NhanKhauService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class KhaiTuController {
    public TextField tfIDNguoiMat;
    public DatePicker dpNgayMat;
    public TextArea tfLyDoMat;

    public void onXacNhanClicked(ActionEvent event) throws SQLException {
        NhanKhauService.khaiTu(NhanKhauService.getNhanKhau(tfIDNguoiMat.getText()),dpNgayMat.getValue(),tfLyDoMat.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Khai tử thành công");
        alert.setContentText("Nhân Khẩu đã mất");
        alert.show();
    }

    public void onHuyClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(QuanLyNhanKhauApplication.class.getResource("/cnpm/quanlynhankhau/views/QuanLyNhanKhau.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        QuanLyNhanKhauApplication.MAIN_STAGE.setScene(scene);
    }
}
