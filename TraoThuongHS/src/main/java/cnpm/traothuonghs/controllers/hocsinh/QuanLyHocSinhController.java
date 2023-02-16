package cnpm.traothuonghs.controllers.hocsinh;

import cnpm.traothuonghs.controllers.BaseLeftController;
import cnpm.traothuonghs.models.HocSinh;
import cnpm.traothuonghs.services.HocSinhService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuanLyHocSinhController extends BaseLeftController {

    public TableColumn<HocSinh, String> colTenHocSinh;
    public TableColumn<HocSinh, String> colPhuHuynh;
    public TableColumn<HocSinh, String> colNgaySinh;
    public TableColumn<HocSinh, String> colTruong;
    public TableView<HocSinh> tvHocSinh;
    private String idHocSinhDuocChon;
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

        List<HocSinh> lsHS = new ArrayList<>();
        int n = HocSinhService.getSoHocSinh();
        for(int i = 1; i <= n; i++){
            lsHS.add(HocSinhService.getHocSinh(1, String.valueOf(i)));
        }

        ObservableList<HocSinh> ls = FXCollections.observableList(lsHS);
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
        Chinh_Sua_Hoc_SinhController.idHocSinh = idHocSinhDuocChon;
        changeScene("/cnpm/traothuonghs/views/hocsinh/Chinh_Sua_Hoc_Sinh.fxml");
    }

    @FXML
    void rowClickedHocSinh(MouseEvent event) throws SQLException {
        HocSinh clickedHocSinh = tvHocSinh.getSelectionModel().getSelectedItem();
        idHocSinhDuocChon = clickedHocSinh.getId();
    }

    public void onXemThongTinClicked(ActionEvent event) {
        //changeScene();
        Chi_Tiet_Hoc_SinhController.idHocSinh = idHocSinhDuocChon;
        changeScene("/cnpm/traothuonghs/views/hocsinh/Chi_Tiet_Hoc_Sinh.fxml");
    }
}
