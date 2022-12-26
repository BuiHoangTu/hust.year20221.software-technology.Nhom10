package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.models.Database;
import cnpm.quanlynhankhau.models.NhanKhau;
import javafx.beans.property.*;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.net.ssl.SSLContext;

public class TKNHController implements Initializable {
    @FXML protected TableView<NhanKhau> TB ;
    @FXML TableColumn<NhanKhau, String> NK_ID_column;
    @FXML TableColumn<NhanKhau, String> NK_name_column;
    @FXML TableColumn<NhanKhau, String> NK_gender_column;
    @FXML TableColumn<NhanKhau, String> NK_Dantoc_column;
    @FXML TableColumn<NhanKhau, String> NK_NamSinh_column;
    @FXML TableColumn<NhanKhau, String> NK_noiSinh_column;
    @FXML TableColumn<NhanKhau, String> NK_NguyenQuan_column;
    @FXML TableColumn<NhanKhau, String> NK_DiaChiHienNay_column;
    @FXML TableColumn<NhanKhau, String> NK_NoiThuongTru_column;
    @FXML TableColumn<NhanKhau, String> NK_TrinhDoHV_column;
    @FXML TableColumn<NhanKhau, String> NK_TrinhDoChuyenMon_column;
    @FXML TableColumn<NhanKhau, String> NK_NgheNghiep_column;
    @FXML TableColumn<NhanKhau, String> NK_NoiLamViec_column;
    @FXML TableColumn<NhanKhau, String> NK_TrinhDoNgoaiNgu_column;
    @FXML Button search;
    @FXML Button BackButton;
    private ObservableList<NhanKhau> data ;
    private Database database;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        database = new Database();
    }

    @FXML
    public void searchID(ActionEvent event) throws SQLException {
        Connection conn = database.getConnection();
        data = FXCollections.observableArrayList();

        ResultSet rs = conn.createStatement().executeQuery("Select ID,hoTen,gioiTinh,danToc,namSinh,noiSinh,nguyenQuan,diaChiHienNay,noiThuongTru,trinhDoHocVan,trinhDoChuyenMon,ngheNghiep,noiLamViec,trinhDoNgoaiNgu from quan_ly_nhan_khau.nhan_khau");

        while(rs.next()){
            data.add(new NhanKhau(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14)));
        }

        NK_ID_column.setCellValueFactory(new PropertyValueFactory<>("NK_ID"));
        NK_name_column.setCellValueFactory(new PropertyValueFactory<>("NK_name"));
        NK_gender_column.setCellValueFactory((new PropertyValueFactory<>("NK_gender")));
        NK_Dantoc_column.setCellValueFactory(new PropertyValueFactory<>("NK_danToc"));
        NK_NamSinh_column.setCellValueFactory(new PropertyValueFactory<>("NK_NamSinh"));
        NK_noiSinh_column.setCellValueFactory(new PropertyValueFactory<>("NK_noiSinh"));
        NK_NguyenQuan_column.setCellValueFactory(new PropertyValueFactory<>("NK_NguyenQuan"));
        NK_DiaChiHienNay_column.setCellValueFactory(new PropertyValueFactory<>("NK_DiaChiHienNay"));
        NK_NoiThuongTru_column.setCellValueFactory(new PropertyValueFactory<>("NK_NoiThuongTru"));
        NK_TrinhDoHV_column.setCellValueFactory(new PropertyValueFactory<>("NK_TrinhDoHV"));
        NK_TrinhDoChuyenMon_column.setCellValueFactory(new PropertyValueFactory<>("NK_TrinhDoChuyenMon"));
        NK_NgheNghiep_column.setCellValueFactory(new PropertyValueFactory<>("NK_ngheNghiep"));
        NK_NoiLamViec_column.setCellValueFactory(new PropertyValueFactory<>("NK_noiLamViec"));
        NK_TrinhDoNgoaiNgu_column.setCellValueFactory(new PropertyValueFactory<>("NK_trinhDoNgoaiNgu"));

        TB.setItems(null);
        TB.setItems(data);
    }
    @FXML
    void BackController(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/cnpm/quanlynhankhau/ChooseFunction-view.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage =  (Stage) BackButton.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}
