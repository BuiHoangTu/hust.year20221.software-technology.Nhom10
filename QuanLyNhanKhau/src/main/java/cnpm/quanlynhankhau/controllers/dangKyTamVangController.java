package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.models.DiaChi;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.services.ChungMinhThuService;
import cnpm.quanlynhankhau.services.NhanKhauService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class dangKyTamVangController extends ChangeSceneControllers {

    public TextField tfCMND;
    public TextField tfMaGiayTamVang;
    public TextField tfNoiTamTru;
    public DatePicker dpTuNgay;
    public DatePicker dpDenNgay;
    public TextArea taLyDo;

    public void onCheckClicked(ActionEvent event) throws SQLException {
        if (ChungMinhThuService.getNhanKhau(tfCMND.getText()) == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Nhân khẩu không tồn tại");
            alert.show();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(ChungMinhThuService.getNhanKhau(tfCMND.getText()).toString());
            alert.show();
        }
    }

    public void onHuyClicked(ActionEvent event) {
        changeScene("/cnpm/quanlynhankhau/views/QuanLyNhanKhau.fxml");
    }

    public void onXacNhanClicked(ActionEvent event) throws SQLException {
        if (ChungMinhThuService.getNhanKhau(tfCMND.getText()) == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Nhân khẩu không tồn tại");
            alert.show();
            return;
        }
        NhanKhau x = ChungMinhThuService.getNhanKhau(tfCMND.getText());
        x.addTamTruVang(DiaChi.parse(tfNoiTamTru.getText()),dpTuNgay.getValue(),dpDenNgay.getValue(),taLyDo.getText(),DiaChi.parse(""));
        tfMaGiayTamVang.setDisable(false);
        tfMaGiayTamVang.setText(x.getTamTruVangs().get(x.getTamTruVangs().size()-1).getMaTamTruVang());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Đăng ký tạm vắng thành công");
        alert.show();


    }
}
