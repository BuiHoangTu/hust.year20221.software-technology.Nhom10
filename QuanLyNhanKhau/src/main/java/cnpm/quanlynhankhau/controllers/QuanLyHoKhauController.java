package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.services.HoKhauService;
import cnpm.quanlynhankhau.services.NhanKhauService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class QuanLyHoKhauController extends EdgeController implements Initializable {

    public TextField tfMaHoKhau;
    public TableView tvHoKhau;
    public TableColumn colMaHoKhau;
    public TableColumn colChuHo;
    public TableColumn colDiaChi;

    public void onThemMoiHoKhauClicked(ActionEvent event) {
    }

    public void onTachHoKhauClicked(ActionEvent event) {
    }

    public void onChuyenHoKhauClicked(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        colMaHoKhau.setCellValueFactory(new PropertyValueFactory<HoKhau, String>("soHoKhau"));
//        colDiaChi.setCellValueFactory(new PropertyValueFactory<HoKhau, String>("diaChi"));
//        List<HoKhau> hk;
//        try{
//            hk = HoKhauService.findHoKhau("1");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        ObservableList<HoKhau> ls = FXCollections.observableList(hk);
//        tvHoKhau.setItems(ls);
    }
}
