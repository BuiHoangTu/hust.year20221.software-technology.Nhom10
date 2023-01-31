package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.models.ChungMinhThu;
import cnpm.quanlynhankhau.models.DiaChi;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.services.NhanKhauService;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ThemMoiNhanKhauController {
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

    private void initialize() {
        //TODO set comboBox Gioi Tinh
        cbGioiTinh.getItems().addAll("Nam","Nu");
    }
    public void onHuyClicked(ActionEvent event) {
        //TODO
    }

    public void onTaoClicked(ActionEvent event) throws SQLException {
        NhanKhau x = NhanKhauService.taoNhanKhau(
                tfHoTen.getText(),
                tfBietDanh.getText(),
                tfTonGiao.getText(),
                false,
                DiaChi.parse(tfNoiThuongTru.getText()),
                dpBirth.getValue(),
                null,
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
                ChungMinhThu.getChungMinhThu(tfCMND.getText())
        );
        System.out.println(x.getTen() + " " + x.getDiaChiHienTai());
        //TODO tao pop-up lay thong
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Them Nhan Khau Thanh Cong");
        alert.setContentText("Nhan khau so: " + x.getSoNhanKhau() + "\nTen: " + x.getTen() + "\nSong tai: " + x.getDiaChiHienTai() + "\nDa duoc them thanh cong");
        alert.show();
    }
}
