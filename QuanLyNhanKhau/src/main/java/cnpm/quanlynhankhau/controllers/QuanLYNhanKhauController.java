package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.services.NhanKhauService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class QuanLYNhanKhauController extends EdgeController implements Initializable{
    public Pane pnlNhanKhau;
    public TextField tfTimKiem;
    public TableView<NhanKhau> tvNhanKhau;
    public TableColumn<NhanKhau, String> colID;
    public TableColumn<NhanKhau, String> colHoTen;
    public TableColumn<NhanKhau, String> colNgaySinh;
    public TableColumn<NhanKhau, Boolean> colGioiTinh;
    public TableColumn<NhanKhau, String> colNoiOHienTai;

    public void onThemMoiClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(QuanLyNhanKhauApplication.class.getResource("/cnpm/quanlynhankhau/views/Them_moi_nhan_khau.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        QuanLyNhanKhauApplication.MAIN_STAGE.setScene(scene);
    }

    public void onDKTamVangClicked(ActionEvent event) {
//        FXMLLoader loader = new FXMLLoader(QuanLyNhanKhauApplication.class.getResource("/cnpm/quanlynhankhau/views/Dang-ky-tam-vang.fxml"));
//        Scene scene = null;
//        try {
//            scene = new Scene(loader.load());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        QuanLyNhanKhauApplication.MAIN_STAGE.setScene(scene);
    }

    public void onDKTamTruClicked(ActionEvent event) {
    }

    public void onKhaiTuClicked(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colID.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("soNhanKhau"));
        colHoTen.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("ten"));
        colNgaySinh.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("ngaySinh"));
//        colGioiTinh.setCellValueFactory(isMale -> new SimpleStringProperty(diaDiemStringCellDataFeatures.getValue().toString()));
        colNoiOHienTai.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("diaChiHienTai"));
        List<NhanKhau> nk = null;
        try {
            nk = NhanKhauService.findNhanKhau(5, "Hai Ba Trung, Ha Noi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ObservableList<NhanKhau> ls = FXCollections.observableList(nk);
        tvNhanKhau.setItems(ls);
    }
}
