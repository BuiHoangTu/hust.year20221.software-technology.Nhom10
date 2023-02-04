package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.models.ThanhVienCuaHo;
import cnpm.quanlynhankhau.services.Database;
import cnpm.quanlynhankhau.services.HoKhauService;
import cnpm.quanlynhankhau.services.NhanKhauService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ThemMoiHoKhauController extends ChangeSceneControllers {
    @FXML
    public Label lblMaHoKhau;
    @FXML
    public TextField tfMaKhuVuc;
    @FXML
    public TextField tfDiaChi;
    @FXML
    public TextField tfChuHo;
    @FXML
    public TableView<ThanhVienCuaHo> tvThanhVien;
    @FXML
    private TableColumn<ThanhVienCuaHo, String> colHoTen;
    @FXML
    private TableColumn<ThanhVienCuaHo, String> colNgaySinh;
    @FXML
    private TableColumn<ThanhVienCuaHo, String> colQuanHeVoiChuHo;
    @FXML
    private Button Luu;
    @FXML
    private Button Them;
    public static int i;
    ObservableList<ThanhVienCuaHo> ThanhVienCuaHo = FXCollections.observableArrayList();
    @FXML
    private void initialize() throws SQLException{

        lblMaHoKhau.setText(String.format("%d",i));
        colHoTen.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        colNgaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        colQuanHeVoiChuHo.setCellValueFactory(new PropertyValueFactory<>("quanHeVoiChuHo"));
        Luu.setDisable(false);
        Them.setDisable(true);
    }
    public void onChonClicked(ActionEvent actionEvent) {
    }


    public void onLuuClicked(ActionEvent actionEvent) throws SQLException {
        PreparedStatement subStatement = Database.getConnection().prepareStatement("""
                SELECT maNhanKhau, namSinh FROM quan_ly_nhan_khau.nhan_khau
                WHERE hoTen like ?
                """);
        subStatement.setString(1, "%" +tfChuHo.getText() + "%");
        ResultSet res = subStatement.executeQuery();
        String maHK = " ";
        LocalDate ngaySinh = LocalDate.now();
        if (res.next()){
            maHK = res.getString("maNhanKhau");
            ngaySinh = LocalDate.parse(res.getString("namSinh"));
            HoKhauService.taoHoKhau(maHK, tfMaKhuVuc.getText(), tfDiaChi.getText());
        }
        ThanhVienCuaHo.add(new ThanhVienCuaHo(tfChuHo.getText(), "Chủ Hộ", ngaySinh, maHK));
        tvThanhVien.setItems(ThanhVienCuaHo);
        Luu.setDisable(true);
        Them.setDisable(false);
    }

    public void onXoaClicked(ActionEvent actionEvent){
    }


	public void onSuaClicked(ActionEvent event) {
	}

	public void onHoKhauClicked(ActionEvent event) {
	}
}
