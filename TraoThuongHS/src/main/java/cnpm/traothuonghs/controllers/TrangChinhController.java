package cnpm.traothuonghs.controllers;

import cnpm.traothuonghs.services.HocSinhService;
import cnpm.traothuonghs.services.PhanThuongService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class TrangChinhController extends BaseLeftController{
    public Label lblHocSinhNum;
    public Label lblPhanThuongTraoNum;
    public Label lblPhanThuongConNum;

    @FXML
    private void initialize() throws SQLException {
        lblHocSinhNum.setText(String.valueOf(HocSinhService.getSoHocSinh()));
        lblPhanThuongTraoNum.setText(String.valueOf(PhanThuongService.getVoDaPhat()));
        lblPhanThuongConNum.setText(String.valueOf(PhanThuongService.getVoChuaPhat()));
    }
}
