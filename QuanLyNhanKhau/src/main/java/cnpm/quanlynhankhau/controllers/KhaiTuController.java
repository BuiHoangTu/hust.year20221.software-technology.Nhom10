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
    public TextField tfIDNguoiKhai;

    public void onXacNhanClicked(ActionEvent event) throws SQLException {
        if(NhanKhauService.getNhanKhau(tfIDNguoiMat.getText()) == null || NhanKhauService.getNhanKhau(tfIDNguoiMat.getText()).getLyDoXoa() != null ){
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Khai tử không thành công");
            alert1.setContentText("Nhân khẩu số " + tfIDNguoiMat.getText() + " không tồn tại hoặc đã mất");
            alert1.show();
            return;
        }
        if (NhanKhauService.getNhanKhau(tfIDNguoiKhai.getText()) == null || NhanKhauService.getNhanKhau(tfIDNguoiKhai.getText()).getLyDoXoa() != null){
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Khai tử không thành công");
            alert1.setContentText("Nhân khẩu số " + tfIDNguoiKhai.getText() + " không tồn tại hoặc đã mất");
            alert1.show();
            return;
        }
        NhanKhauService.khaiTu(NhanKhauService.getNhanKhau(tfIDNguoiMat.getText()),NhanKhauService.getNhanKhau(tfIDNguoiKhai.getText()),dpNgayMat.getValue(),tfLyDoMat.getText());
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

    public void onCheckNguoiMatClicked(ActionEvent event) throws SQLException {
        if(NhanKhauService.getNhanKhau(tfIDNguoiMat.getText()) == null || NhanKhauService.getNhanKhau(tfIDNguoiMat.getText()).getLyDoXoa() != null ){
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Khai tử không thành công");
            alert1.setContentText("Nhân khẩu số " + tfIDNguoiMat.getText() + " không tồn tại hoặc đã mất");
            alert1.show();
        }else{
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setContentText(NhanKhauService.getNhanKhau(tfIDNguoiMat.getText()).toString());
            alert1.show();
        }
    }

    public void onCheckNguoiKhaiClicked(ActionEvent event) throws SQLException {
        if (NhanKhauService.getNhanKhau(tfIDNguoiKhai.getText()) == null || NhanKhauService.getNhanKhau(tfIDNguoiKhai.getText()).getLyDoXoa() != null){
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Khai tử không thành công");
            alert1.setContentText("Nhân khẩu số " + tfIDNguoiKhai.getText() + " không tồn tại hoặc đã mất");
            alert1.show();
        }else{
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setContentText(NhanKhauService.getNhanKhau(tfIDNguoiKhai.getText()).toString());
            alert1.show();
        }
    }
}
