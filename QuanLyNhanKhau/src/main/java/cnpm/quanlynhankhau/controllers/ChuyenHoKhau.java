package cnpm.quanlynhankhau.controllers;

import java.io.IOException;
import java.sql.SQLException;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class ChuyenHoKhau {
	@FXML
    private TextField tfMaHoKhau;
	@FXML
    private TextField tfMaHoKhauDuocChon;
	@FXML
    private TextField tfChuHo;
	@FXML
    private TextField tfMaKhuVuc;
	@FXML
    private TextField tfDiaChiHienTai;
	@FXML
    private TextField tfDiaChiChuyenDen;
	@FXML
    private TextField tfLyDo;
	@FXML
    private TableView tvHoKhau;

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
