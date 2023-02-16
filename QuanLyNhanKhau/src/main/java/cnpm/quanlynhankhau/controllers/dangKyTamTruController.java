package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.models.ChungMinhThu;
import cnpm.quanlynhankhau.models.TamTruVang;
import cnpm.quanlynhankhau.services.ChungMinhThuService;
import cnpm.quanlynhankhau.services.TamTruVangService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class dangKyTamTruController extends ChangeSceneControllers{
    public TextField tfCMND;
    public TextField tfMaGiayTamVang;
    public TextField tfNoiTamTru;
    public DatePicker dpTuNgay;
    public DatePicker dpDenNgay;
    public TextArea taLyDo;

    @FXML
    private void initialize() throws SQLException {
        tfCMND.setDisable(true);
        tfNoiTamTru.setDisable(true);
        dpTuNgay.setDisable(true);
        dpDenNgay.setDisable(true);
        taLyDo.setDisable(true);
    }

    public void onHuyClicked(ActionEvent event) {
        changeScene("/cnpm/quanlynhankhau/views/QuanLyNhanKhau.fxml");
    }

    public void onXacNhanClicked(ActionEvent event) throws SQLException {
        if(tfMaGiayTamVang.getText().length() < 12){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Mã tạm vắng sai định dạng (12 ký tự, VD:000000000050), mời nhập lại");
            alert.show();
        }else {
            TamTruVangService.xacNhanTamTruVang(tfMaGiayTamVang.getText());
            TamTruVang x = TamTruVangService.getTamTruVang(tfMaGiayTamVang.getText());
            ChungMinhThu cmt = ChungMinhThuService.getCMT(tfMaGiayTamVang.getText());
            tfCMND.setText(cmt.getSoCMT());
            tfNoiTamTru.setText(x.getDcTamTru().toString());
            dpTuNgay.setValue(x.getTuNgay());
            dpDenNgay.setValue(x.getDenNgay());
            taLyDo.setText(x.getLyDo());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Đăng ký tạm trú thành công");
            alert.show();
        }
    }
}
