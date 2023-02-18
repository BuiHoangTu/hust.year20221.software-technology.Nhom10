package cnpm.traothuonghs.controllers.hocsinh;

import cnpm.traothuonghs.controllers.BaseLeftController;
import cnpm.traothuonghs.models.HocSinh;
import cnpm.traothuonghs.models.PhanThuong;
import cnpm.traothuonghs.services.HocSinhService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuanLyHocSinhController extends BaseLeftController {

    public TableColumn<HocSinh, String> colTenHocSinh;
    public TableColumn<HocSinh, String> colPhuHuynh;
    public TableColumn<HocSinh, String> colNgaySinh;
    public TableColumn<HocSinh, String> colTruong;
    public TableColumn<HocSinh, String> colLop;
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
        colLop.setCellValueFactory(hocSinhStringCellDataFeatures -> {
			var cacPhanThuong = hocSinhStringCellDataFeatures.getValue().getCacPhanThuong();
			try {
				return new SimpleStringProperty(cacPhanThuong.get(cacPhanThuong.size() - 1).getLop());
			} catch (IndexOutOfBoundsException e) {
				return new SimpleStringProperty("Không rõ");
			}
		});

        List<HocSinh> lsHS = new ArrayList<>();
        for(int i = 1; i <= 200; i++){
            if(HocSinhService.getHocSinh(1, String.valueOf(i)) != null){
                lsHS.add(HocSinhService.getHocSinh(1, String.valueOf(i)));
            }
        }

        ObservableList<HocSinh> ls = FXCollections.observableList(lsHS);
        tvHocSinh.setItems(ls);
    }

    public void onTimKiemClicked(ActionEvent event) throws SQLException {
        //Tìm học sinh theo checkBox và textField từ database
        if(chbTen.isSelected()){
            ObservableList<HocSinh> ls = FXCollections.observableList(HocSinhService.findHocSinh(2, tfTimKiem.getText()));
            tvHocSinh.getItems().clear();
            tvHocSinh.getItems().addAll(ls);
        }

        if(chbDotPhat.isSelected()){
            List<HocSinh> ls = new ArrayList<>();
            for (int i =1; i <= 200; i++){
                if(HocSinhService.getHocSinh(1, String.valueOf(i)) != null){
                    List<PhanThuong> lisPT = HocSinhService.getHocSinh(1, String.valueOf(i)).getCacPhanThuong();
                    for (PhanThuong x : lisPT){
                        if(x.getTenDotPhatThuong().toLowerCase().contains(tfTimKiem.getText().toLowerCase())){
                            ls.add(HocSinhService.getHocSinh(1, String.valueOf(i)));
                        }
                    }
                }
            }
            tvHocSinh.getItems().clear();
            tvHocSinh.getItems().addAll(ls);
        }

        if (chbDiaChi.isSelected()){
            ObservableList<HocSinh> ls = FXCollections.observableList(HocSinhService.findHocSinh(3, tfTimKiem.getText()));
            tvHocSinh.getItems().clear();
            tvHocSinh.getItems().addAll(ls);
        }

    }

    public void onThemHocSinhClicked() {
        changeScene("/cnpm/traothuonghs/views/hocsinh/Them-hoc-sinh.fxml");
    }

    public void onChinhSuaHocSinhClicked() {
        //changeScene();
        if(idHocSinhDuocChon == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Chưa chọn học sinh nào !");
            alert.show();
        }else {
            ChinhSuaHocSinhController.idHocSinh = idHocSinhDuocChon;
            changeScene("/cnpm/traothuonghs/views/hocsinh/Chinh_Sua_Hoc_Sinh.fxml");
        }
    }

    @FXML
    void rowClickedHocSinh() {
        HocSinh clickedHocSinh = tvHocSinh.getSelectionModel().getSelectedItem();
        idHocSinhDuocChon = clickedHocSinh.getId();
    }

    public void onXemThongTinClicked() {
        //changeScene();
        if(idHocSinhDuocChon == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Chưa chọn học sinh nào !");
            alert.show();
        }else{
            ChiTietHocSinhController.idHocSinh = idHocSinhDuocChon;
            changeScene("/cnpm/traothuonghs/views/hocsinh/Chi_Tiet_Hoc_Sinh.fxml");
        }
    }
}
