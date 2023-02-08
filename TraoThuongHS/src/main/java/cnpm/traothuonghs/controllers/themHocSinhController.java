package cnpm.traothuonghs.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class themHocSinhController extends ChangeSceneControllers implements IFlushableController{
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

    public void onXacNhanClicked(ActionEvent event) {
        //Thêm học sinh vào database
    }
}
