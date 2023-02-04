package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.models.DiaChi;
import cnpm.quanlynhankhau.models.HoKhau;
import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.quanlynhankhau.models.ThanhVienCuaHo;
import cnpm.quanlynhankhau.services.Database;
import cnpm.quanlynhankhau.services.HoKhauService;
import cnpm.quanlynhankhau.services.NhanKhauService;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ThemMoiHoKhauController extends EdgeController {
    @FXML
    public Label lblMaHoKhau;
    @FXML
    public TextField tfMaKhuVuc;
    @FXML
    public TextField tfDiaChi;
    @FXML
    private TextField tfQuanHeVoiChuHo;
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
    @FXML
    private Button btnThemThanhVien;
    @FXML
    private ChoiceBox<NhanKhau> listThanhVien;
    private NhanKhau selected;
    private HoKhau created;
    private ThanhVienCuaHo thanhVienSelected;
    public static int getI() {
        return i;
    }

    public static int i;
    ObservableList<ThanhVienCuaHo> ThanhVienCuaHo = FXCollections.observableArrayList();
    @FXML
    private void initialize() throws SQLException{
        TableView.TableViewSelectionModel selectionModel = tvThanhVien.getSelectionModel();
        for (i=13; HoKhauService.getHoKhau(String.format("%d", i)) != null ; i++){
        }
        lblMaHoKhau.setText(String.format("%d",i));
        colHoTen.setCellValueFactory(new PropertyValueFactory<ThanhVienCuaHo, String>("hoTen"));
        colNgaySinh.setCellValueFactory(new PropertyValueFactory<ThanhVienCuaHo, String>("ngaySinh"));
        colQuanHeVoiChuHo.setCellValueFactory(new PropertyValueFactory<ThanhVienCuaHo, String>("quanHeVoiChuHo"));
        Luu.setDisable(false);
        Them.setDisable(true);
        listThanhVien.setDisable(true);
        btnThemThanhVien.setDisable(true);
        for (int j = 26; NhanKhauService.getNhanKhau(String.format("%d", j)) != null; j++) {
            PreparedStatement statement = Database.getConnection().prepareStatement("""
                        select * from quan_ly_nhan_khau.thanh_vien_cua_ho
                        where thanh_vien_cua_ho.idNhanKhau=?
                    """);
            statement.setString(1, String.format("%d", j));
            ResultSet res = statement.executeQuery();
            if (!res.next()) {
                listThanhVien.getItems().addAll(NhanKhauService.getNhanKhau(String.format("%d", j)));
            }
        }

        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        ObservableList<ThanhVienCuaHo> selectedItems =
                selectionModel.getSelectedItems();

        selectedItems.addListener(
                new ListChangeListener<ThanhVienCuaHo>() {
                    @Override
                    public void onChanged(
                            Change<? extends ThanhVienCuaHo> change) {
                        //System.out.println("Selection changed: " + change.getList());
                        //lblStatus.setText(change.getList().get(0).getTen());
                        thanhVienSelected = change.getList().get(0);
                    }
                });

    }
    public void onChonClicked(ActionEvent actionEvent) throws SQLException{
        created.setChuHo(NhanKhauService.getNhanKhau(thanhVienSelected.getMaNhanKhau()));
        created.commit();
        int index = ThanhVienCuaHo.indexOf(thanhVienSelected);
        thanhVienSelected.setQuanHeVoiChuHo("Chủ hộ");
        ThanhVienCuaHo.set(index, thanhVienSelected);
    }


    public void onLuuClicked(ActionEvent actionEvent) throws SQLException {
        created = new HoKhau(String.format("%d",i), null, tfMaKhuVuc.getText(), DiaChi.parse(tfDiaChi.getText()), LocalDate.now());
        HoKhauService.taoHoKhau(null, tfMaKhuVuc.getText(), tfDiaChi.getText());
        Luu.setDisable(true);
        Them.setDisable(false);
        btnThemThanhVien.setDisable(false);
        listThanhVien.setDisable(false);
        listThanhVien.setOnAction(this::getThanhVien);
    }

    public void onXoaClicked(ActionEvent actionEvent){

    }
    public void onThemThanhVienClicked(ActionEvent actionEvent) throws SQLException{
        if (tfQuanHeVoiChuHo.getText() != null){
            created.themThanhVien(selected, tfQuanHeVoiChuHo.getText());
        }
        ThanhVienCuaHo.add(new ThanhVienCuaHo(selected.getTen(),tfQuanHeVoiChuHo.getText(),selected.getNgaySinh(),selected.getSoNhanKhau()));
        tvThanhVien.setItems(ThanhVienCuaHo);
    }
    public void getThanhVien(ActionEvent actionEvent){
        this.selected = listThanhVien.getValue();
    }
}
