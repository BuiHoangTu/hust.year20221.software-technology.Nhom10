package cnpm.traothuonghs.controllers.hocsinh;

import cnpm.traothuonghs.controllers.BaseLeftController;
import cnpm.traothuonghs.models.HocSinh;
import cnpm.traothuonghs.services.HocSinhService;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.sql.SQLException;

public class QuanLyHocSinhController extends BaseLeftController {

    public TableColumn<HocSinh, String> colTenHocSinh;
    public TableColumn<HocSinh, String> colPhuHuynh;
    public TableColumn<HocSinh, String> colNgaySinh;
    public TableColumn<HocSinh, String> colTruong;
    public TableColumn<HocSinh, String> colLop;
    public TableView<HocSinh> tvHocSinh;
    public CheckBox chbTen;
    public CheckBox chbDotPhat;
    public CheckBox chbDiaChi;
    public TextField tfTimKiem;

    @FXML
    private void initialize() throws SQLException {
        colTenHocSinh.setCellValueFactory(new PropertyValueFactory<HocSinh, String>("ten"));
        colPhuHuynh.setCellValueFactory(new PropertyValueFactory<HocSinh, String>("phuHuynh"));
        colNgaySinh.setCellValueFactory(new PropertyValueFactory<HocSinh, String>("ngaySinh"));
        colTruong.setCellValueFactory(new PropertyValueFactory<HocSinh,String>("truongHoc"));

        ObservableList<HocSinh> ls = FXCollections.observableList(HocSinhService.findHocSinh(1, "1"));
        tvHocSinh.setItems(ls);
    }

    public void onTimKiemClicked(ActionEvent event) {
        //Tìm học sinh theo checkBox và textField từ database
    }

    public void onThemHocSinhClicked(ActionEvent event) {
        //changeScene();
    }

    public void onChinhSuaHocSinhClicked(ActionEvent event) {
        //changeScene();
    }

    public void onXemThongTinClicked(ActionEvent event) {
        //changeScene();
    }
}
