package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.models.DiaChi;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.services.ChungMinhThuService;
import cnpm.quanlynhankhau.services.NhanKhauService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ThemMoiNhanKhauController extends ChangeSceneControllers {
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
    public ComboBox<String> cbGioiTinh;

    @FXML
    private void initialize() {
        cbGioiTinh.getItems().addAll("Nam","Nữ");
    }
    public void onHuyClicked(ActionEvent event) {
        changeScene("/cnpm/quanlynhankhau/views/QuanLyNhanKhau.fxml");
    }

    public void onTaoClicked(ActionEvent event) throws SQLException {
        boolean gender = true;
        if(cbGioiTinh.getValue().equals("Nam")){
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thêm nhân khẩu thành công");
        alert.setContentText(NhanKhauService.getNhanKhau(x.getSoNhanKhau()).toString());
        alert.show();
    }
}
