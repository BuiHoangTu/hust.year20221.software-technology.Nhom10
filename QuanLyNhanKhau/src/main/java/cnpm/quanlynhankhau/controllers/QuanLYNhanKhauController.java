package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.services.NhanKhauService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class QuanLYNhanKhauController extends EdgeController implements Initializable{
    public Pane pnlNhanKhau;
    public TextField tfTimKiem;
    public TableView<NhanKhau> tvNhanKhau;
    public TableColumn<NhanKhau, String> colID;
    public TableColumn<NhanKhau, String> colHoTen;
    public TableColumn<NhanKhau, String> colNgaySinh;
    public TableColumn<NhanKhau, String> colGioiTinh;
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
        FXMLLoader loader = new FXMLLoader(QuanLyNhanKhauApplication.class.getResource("/cnpm/quanlynhankhau/views/Dang-ky-tam-vang.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        QuanLyNhanKhauApplication.MAIN_STAGE.setScene(scene);
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
        colGioiTinh.setCellValueFactory(nhanKhauStringCellDataFeatures -> new SimpleStringProperty(nhanKhauStringCellDataFeatures.getValue().isMale() ? "Nam" : "Nu"));
        colNoiOHienTai.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("diaChiHienTai"));
        List<NhanKhau> nk = null;
        try {
            nk = NhanKhauService.findNhanKhau(5, "Quận Hai Bà Trưng, Hà Nội");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ObservableList<NhanKhau> ls = FXCollections.observableList(nk);
        tvNhanKhau.setItems(ls);

        FilteredList<NhanKhau> filter = new FilteredList<>(ls, b->true);

        tfTimKiem.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(NhanKhau -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }

                String keywrd = newValue.toLowerCase();
                if(NhanKhau.getSoNhanKhau().toLowerCase().contains(keywrd)){
                    return true;
                } else if (NhanKhau.getTen().toLowerCase().contains(keywrd)) {
                    return true;
                } else if (NhanKhau.getNgaySinh().toString().contains(keywrd)) {
                    return true;
                } else if (NhanKhau.getDiaChiHienTai().toString().toLowerCase().contains(keywrd)) {
                    return true;
//                }else if(){
//                    return true;
                }else
                    return false;
            });
        });

        SortedList<NhanKhau> sorted = new SortedList<>(filter);

        sorted.comparatorProperty().bind(tvNhanKhau.comparatorProperty());

        tvNhanKhau.setItems(sorted);
    }
}
