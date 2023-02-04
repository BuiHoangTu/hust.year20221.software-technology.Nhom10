package cnpm.quanlynhankhau.controllers;

import java.io.IOException;
import java.sql.SQLException;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class TachHoKhau {
    public TableView tbThanhVien;
    public TextField tfChuHo;
    public TextField tfMaKhuVuc;
    public TextField tfDiaChi;
    public TextField tfMaHoKhauMoi;
    public TextField tfChuHoMoi;
    public TextField tfMaHoKhau;
    public TableView tvHoKhau;
    public ListView lvThanhVienHoMoi;


    public void OnRemoveClicked(ActionEvent event) {
    }

    public void OnInsertClicked(ActionEvent event) {
    }

    public void OnHuyClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(QuanLyNhanKhauApplication.class.getResource("/cnpm/quanlynhankhau/views/QuanLyHoKhau.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        QuanLyNhanKhauApplication.MAIN_STAGE.setScene(scene);
    }

    public void OnXacNhanClicked(ActionEvent event) {
    }
}
