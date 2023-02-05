package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import cnpm.quanlynhankhau.models.DiaChi;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.services.ChungMinhThuService;
import cnpm.quanlynhankhau.services.NhanKhauService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ThemMoiNhanKhauController implements Initializable {
    public TextField tfHoTen;
    public TextField tfNguyenQuan;
    public TextField tfDanToc;
    public TextField tfCMND;
    public TextField tfNoiThuongTru;
    public TextField tfTrinhDoHocVan;
    public TextField tfTrinhDoNgoaiNgu;
    public TextField tfNgheNghiep;
    public TextField tfBietDanh;
    public TextField tfTonGiao;
    public TextField tfQuoctich;
    public TextField tfHoChieu;
    public TextField tfDiaChiHienTai;
    public TextField tfTrinhDoChuyenMon;
    public TextField tfBietTiengDanToc;
    public TextField tfNoiLamViec;
    public DatePicker dpBirth;
    public ComboBox cbGioiTinh;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO set comboBox Gioi Tinh
        cbGioiTinh.getItems().addAll("Nam","Nu");
    }
    public void onHuyClicked(ActionEvent event) {
        //TODO
        FXMLLoader loader = new FXMLLoader(QuanLyNhanKhauApplication.class.getResource("/cnpm/quanlynhankhau/views/QuanLyNhanKhau.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        QuanLyNhanKhauApplication.MAIN_STAGE.setScene(scene);
    }

    public void onTaoClicked(ActionEvent event) throws SQLException {
        Boolean gender = true;
        if(cbGioiTinh.getValue().equals("Nam")){
            gender = true;
        }else {
            gender = false;
        }
        NhanKhau x = NhanKhauService.taoNhanKhau(
                tfHoTen.getText(),
                tfBietDanh.getText(),
                tfTonGiao.getText(),
                gender,
                DiaChi.parse(tfNoiThuongTru.getText()),
                dpBirth.getValue(),
                DiaChi.parse(tfNguyenQuan.getText()),
                DiaChi.parse(tfNguyenQuan.getText()),
                tfDanToc.getText(),
                tfHoChieu.getText(),
                DiaChi.parse(tfDiaChiHienTai.getText()),
                tfTrinhDoChuyenMon.getText(),
                tfTrinhDoHocVan.getText(),
                tfTrinhDoNgoaiNgu.getText(),
                tfNgheNghiep.getText(),
                DiaChi.parse(tfNoiLamViec.getText()),
                null,
                null,
                null,
                null,
                ChungMinhThuService.getChungMinhThu(tfCMND.getText())
        );
        //TODO tao pop-up lay thong
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thêm nhân khẩu thành công");
        alert.setContentText(NhanKhauService.getNhanKhau(x.getSoNhanKhau()).toString());
        alert.show();
    }
}
