package cnpm.traothuonghs.controllers.hocsinh;

import cnpm.traothuonghs.controllers.ChangeSceneControllers;
import cnpm.traothuonghs.controllers.IFlushableController;
import cnpm.traothuonghs.models.HocSinh;
import cnpm.traothuonghs.services.HocSinhService;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.time.LocalDate;

public class ThemHocSinhController extends ChangeSceneControllers implements IFlushableController {
    public TextField tfTenHocSinh;
    public TextField tfLop;
    public TextField tfDanhHieu;
    public TextField tfMaHoKhau;
    public TextField tfTenPhuHuynh;
    public DatePicker dpNgaySinh;
    public ComboBox cbTruong;

    @Override
    public void flush_data() {

    }

    public void onHuyClicked(ActionEvent event) {
        //changeScene();
    }

    public void onXacNhanClicked(ActionEvent event) throws SQLException {
        //Thêm học sinh vào database
        HocSinhService.themHocSinh(tfTenHocSinh.getText(), tfTenPhuHuynh.getText(), dpNgaySinh.getValue(), cbTruong.getValue().toString(), tfLop.getText(), tfMaHoKhau.getText(), tfDanhHieu.getText(), null);

    }
}
