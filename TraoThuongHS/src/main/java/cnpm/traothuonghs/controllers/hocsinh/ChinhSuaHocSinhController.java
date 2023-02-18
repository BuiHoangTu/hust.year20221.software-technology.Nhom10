package cnpm.traothuonghs.controllers.hocsinh;

import cnpm.quanlynhankhau.models.DiaChi;
import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.services.HoKhauService;
import cnpm.traothuonghs.controllers.BaseLeftController;
import cnpm.traothuonghs.models.HocSinh;
import cnpm.traothuonghs.models.PhanThuong;
import cnpm.traothuonghs.services.HocSinhService;
import cnpm.traothuonghs.services.PhanThuongService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.time.LocalDate;

public class ChinhSuaHocSinhController extends BaseLeftController {
    public static String idHocSinh = null;

    // Label Thông tin cũ
    @FXML
    private Label lbTenCu;
    @FXML
    private Label lbNgaySinhCu;
    @FXML
    private Label lbTruongCu;
    @FXML
    private Label lbDanhHieuCu;
    @FXML
    private Label lbMaHoKhauCu;
    @FXML
    private Label lbPhuHuynhCu;

    // TextField Thông tin mới
    @FXML
    private TextField tfTen;
    @FXML
    private TextField tfNgaySinh;
    @FXML
    private TextField tfTruong;
    @FXML
    private TextField tfDanhHieu;
    @FXML
    private TextField tfMaHoKhau;
    @FXML
    private TextField tfPhuHuynh;

    @FXML
    private void initialize() throws SQLException {
        // Set Label thông tin cũ
        HocSinh hocSinh = HocSinhService.getHocSinh(1, idHocSinh);
        lbTenCu.setText(hocSinh.getTen());
        lbNgaySinhCu.setText(hocSinh.getNgaySinh().toString());
        lbDanhHieuCu.setText(PhanThuongService.getThuong(idHocSinh).get(0).getDanhHieu());
        lbMaHoKhauCu.setText(hocSinh.getMaHoKhau());
        lbTruongCu.setText(hocSinh.getTruongHoc());
        lbPhuHuynhCu.setText(hocSinh.getPhuHuynh());
    }

    // Button
    @FXML
    protected void onHuyClicked() {
        changeScene("/cnpm/traothuonghs/views/hocsinh/Quan-ly-hoc-sinh.fxml");
    }

    @FXML
    protected void onXacNhanClicked() throws SQLException {
        if (tfTen.getText().equals("") || tfNgaySinh.getText().equals("") || tfTruong.getText().equals("") || tfDanhHieu.getText().equals("") || tfMaHoKhau.getText().equals("") || tfPhuHuynh.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Chưa nhập các trường cần thiết");
            String str = "";
            if (tfTen.getText().equals("")) tfTen.setText(lbTenCu.getText());
            if (tfNgaySinh.getText().equals("")) tfNgaySinh.setText(lbNgaySinhCu.getText());
            if (tfTruong.getText().equals("")) tfTruong.setText(lbTruongCu.getText());
            if (tfDanhHieu.getText().equals("")) tfDanhHieu.setText(lbDanhHieuCu.getText());
            if (tfMaHoKhau.getText().equals("")) tfMaHoKhau.setText(lbMaHoKhauCu.getText());
            if (tfPhuHuynh.getText().equals("")) tfPhuHuynh.setText(lbPhuHuynhCu.getText());
        }
            HocSinh tmp = HocSinhService.getHocSinh(1, idHocSinh);
            tmp = new HocSinh(idHocSinh, tfTen.getText(), LocalDate.parse(tfNgaySinh.getText()), tfTruong.getText(), tfMaHoKhau.getText(), tfPhuHuynh.getText());
            tmp.change(tfTen.getText(), LocalDate.parse(tfNgaySinh.getText()), tfTruong.getText(), tfMaHoKhau.getText(), tfPhuHuynh.getText());

            PhanThuong tmp1 = PhanThuongService.getThuong(idHocSinh).get(0);
            tmp1.setDanhHieu(tfDanhHieu.getText());
            tmp1.change(null, null, tfDanhHieu.getText(), null);

            // Chuyển về scene trước đó
            changeScene("/cnpm/traothuonghs/views/hocsinh/Quan-ly-hoc-sinh.fxml");
    }

}
