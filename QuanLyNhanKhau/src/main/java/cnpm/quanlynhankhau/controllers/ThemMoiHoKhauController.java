package cnpm.quanlynhankhau.controllers;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import static javafx.application.Application.launch;

public class ThemMoiHoKhauController {
    @FXML
    public TextField tfMaHoKhau;
    public TextField tfDiaChi;
    public TextField tfChuHo;
    public TableView tvThanhVien;
    public TextField tfMaKhuVuc;

    private void initialize(){
        //TODO set
    }
    void onLuuClicked(MouseEvent Event) {
        //Database.taoHoKhau();
    }

    public void onChonClicked(ActionEvent actionEvent) {
    }

    public void onSuaClicked(ActionEvent actionEvent) {
    }

    public void onLuuClicked(ActionEvent actionEvent) {
    }

    public void onHuyClicked(ActionEvent actionEvent) {
    }
}
