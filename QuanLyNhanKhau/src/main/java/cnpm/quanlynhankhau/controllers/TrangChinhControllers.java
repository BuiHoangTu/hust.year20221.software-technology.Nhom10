package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.services.HoKhauService;
import cnpm.quanlynhankhau.services.NhanKhauService;
import cnpm.quanlynhankhau.services.TamTruVangService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class TrangChinhControllers extends EdgeController {
    public Pane pnlTrangChu;
    public Label lblNhanKhauNum;
    public Label lblHoKhauNum;
    public Label lblTamTruNum;
    public Label lblTamVangNum;

    @FXML
    public void initialize() throws SQLException {
        List<NhanKhau> numNK;
        try {
            numNK = NhanKhauService.findNhanKhau(5, "Hai Bà Trưng, Hà Nội", null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        lblNhanKhauNum.setText(String.valueOf(numNK.size()));

        List<HoKhau> numHK;
        try{
            numHK = HoKhauService.findHoKhau(3, "Hai Bà Trưng, Hà Nội");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        lblHoKhauNum.setText(String.valueOf(numHK.size()));

        lblTamTruNum.setText(String.valueOf(TamTruVangService.getSoTamTru()));
        lblTamVangNum.setText(String.valueOf(TamTruVangService.getSoTamVang()));
    }

    @Override
    public void onTrangChuClicked(ActionEvent event) {
        super.onTrangChuClicked(event);
        List<NhanKhau> numNK;
        try {
            numNK = NhanKhauService.findNhanKhau(5, "Hai Bà Trưng, Hà Nội", null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        lblNhanKhauNum.setText(String.valueOf(numNK.size()));
        List<HoKhau> numHK;
        try{
            numHK = HoKhauService.findHoKhau(3, "Hai Bà Trưng, Hà Nội");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        lblHoKhauNum.setText(String.valueOf(numHK.size()));
    }
}
