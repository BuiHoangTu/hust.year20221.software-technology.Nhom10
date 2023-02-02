package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.services.Database;
import cnpm.quanlynhankhau.services.NhanKhauService;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class TrangChinhControllers extends EdgeController implements Initializable {
    public Pane pnlTrangChu;
    public Label lblNhanKhauNum;
    public Label lblHoKhauNum;
    public Label lblTamTruNum;
    public Label lblTamVangNum;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<NhanKhau> numNK = null;
        try {
            numNK = NhanKhauService.findNhanKhau(5, "Hai Bà Trưng, Ha Noi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        lblNhanKhauNum.setText(String.valueOf(numNK.size()));

    }
}
