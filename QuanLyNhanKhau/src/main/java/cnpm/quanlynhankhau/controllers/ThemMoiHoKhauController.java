package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class ThemMoiHoKhauController {
    public void onChonClicked(ActionEvent event) {
    }

    public void onSuaClicked(ActionEvent event) {
    }

    public void onLuuClicked(ActionEvent event) {
    }

    public void onHuyClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(QuanLyNhanKhauApplication.class.getResource("/cnpm/quanlynhankhau/views/QuanLyHoKhau.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        QuanLyNhanKhauApplication.MAIN_STAGE.setScene(scene);
    }
}
