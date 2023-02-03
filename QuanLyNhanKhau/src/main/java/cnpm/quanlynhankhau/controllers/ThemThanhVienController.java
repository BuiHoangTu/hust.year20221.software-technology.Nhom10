package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.services.Database;
import cnpm.quanlynhankhau.services.HoKhauService;
import cnpm.quanlynhankhau.services.NhanKhauService;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThemThanhVienController extends EdgeController {

    @FXML
    private TableColumn<NhanKhau, String> colMaNhanKhau;

    @FXML
    private TableColumn<NhanKhau, String> colNgaySinh;

    @FXML
    private TableColumn<NhanKhau, String> colHoTen;

    @FXML
    private TextField tfQuanHeVoiChuHo;

    @FXML
    private TableView<NhanKhau> tvThanhVien;
    @FXML
    Label lblStatus;

    NhanKhau selected;

    ObservableList<NhanKhau>List = FXCollections.observableArrayList();
    int maHK;

    @FXML
    public void initialize() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tvThanhVien.getSelectionModel();
        for (maHK = 13; HoKhauService.getHoKhau(String.format("%d", maHK)) != null; maHK++) {
        }

        for (int i = 26; NhanKhauService.getNhanKhau(String.format("%d", i)) != null; i++) {
            PreparedStatement statement = Database.getConnection().prepareStatement("""
                        select * from quan_ly_nhan_khau.thanh_vien_cua_ho
                        where thanh_vien_cua_ho.idNhanKhau=?
                    """);
            statement.setString(1, String.format("%d", i));
            ResultSet res = statement.executeQuery();
            if (!res.next()) {
                List.add(NhanKhauService.getNhanKhau(String.format("%d", i)));
            }
        }
        colMaNhanKhau.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("soNhanKhau"));
        colHoTen.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("ten"));
        colNgaySinh.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("ngaySinh"));
        tvThanhVien.setItems(List);
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        ObservableList<NhanKhau> selectedItems =
                selectionModel.getSelectedItems();

        selectedItems.addListener(
                new ListChangeListener<NhanKhau>() {
                    @Override
                    public void onChanged(
                            Change<? extends NhanKhau> change) {
                        //System.out.println("Selection changed: " + change.getList());
                        lblStatus.setText(change.getList().get(0).getTen());
                        selected = change.getList().get(0);
                    }
                });
    }

    public void onThemClicked(ActionEvent actionEvent) throws SQLException{
        if ((selected != null) && (tfQuanHeVoiChuHo.getText()!=null)) {
            HoKhauService.getHoKhau(String.format("%d", maHK - 1)).themThanhVien(selected, tfQuanHeVoiChuHo.getText());
        }
    }
}
