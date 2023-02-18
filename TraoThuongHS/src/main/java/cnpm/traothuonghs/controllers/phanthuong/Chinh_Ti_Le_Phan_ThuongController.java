package cnpm.traothuonghs.controllers.phanthuong;

import cnpm.quanlynhankhau.models.NhanKhau;
import cnpm.traothuonghs.controllers.BaseLeftController;
import cnpm.traothuonghs.models.HocSinh;
import cnpm.traothuonghs.services.HocSinhService;
import cnpm.traothuonghs.services.TinhThuongService;
import javafx.beans.Observable;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Chinh_Ti_Le_Phan_ThuongController extends BaseLeftController {
    // ComboBox Danh hiệu
    @FXML
    private ComboBox cbDanhHieu;

    // TextField Chỉnh tỉ lệ
    @FXML
    private TextField tfThemPT;
    @FXML
    private TextField tfSoVo;
    @FXML
    private TextField tfGiaVo;

    // TextArea Thông tin thưởng
    @FXML
    private TextArea taTTThuong;

    // Service
    private TinhThuongService tinhThuong = new TinhThuongService(LocalDate.now());
    private Map<String, Integer> tiLeThuong = new TinhThuongService(LocalDate.now()).getMapTyLeThuong();
    private ObservableList<String> danhHieu = FXCollections.observableList(new ArrayList<>(tiLeThuong.keySet()));
    private ObservableList<String> thongTinThayDoi = FXCollections.observableArrayList();
    private String themMoi = "";

    private String xoaDi = "";
    private List<String> thayDoi = new ArrayList<String>();

    // Temp info
    private String danhHieuTamThoi = "";
    private int count = 0;

    // Function thiết lập thông tin thưởng
    private void setThongTinThuong() {
        StringBuilder TTThuong = new StringBuilder("Thông tin tỉ lệ thưởng hiện tại\n\n");
        for (String str : tiLeThuong.keySet()) {
            TTThuong.append("- Tên phần thưởng : ").append(str).append("\n  + Số lượng vở thưởng : ").append(tiLeThuong.get(str)).append("\n\n");
        }
        TTThuong.append("- Giá một cuốn vở : ").append(tinhThuong.getGiaVo());
        taTTThuong.setText(TTThuong.toString());
    }

    // initiallize
    @FXML
    private void initialize() throws SQLException {
        // SetItems cho ComboBox danhHieu
        cbDanhHieu.setItems(danhHieu);

        // TextArea Thông tin thưởng
        setThongTinThuong();
    }

    // Button
    @FXML
    protected void onRemovePTClicked() {
        xoaDi = xoaDi + "\nXóa danh mục phần thưởng : " + cbDanhHieu.getValue() + "\n";

        tiLeThuong.remove(cbDanhHieu.getValue());
        danhHieu.remove(cbDanhHieu.getValue());

        setThongTinThuong();
    }

    @FXML
    protected void onAddPTClicked() {
        if (tfSoVo.getText().equals("") || tfThemPT.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Chưa nhập các trường cần thiết");
            String str = "";
            if (tfThemPT.getText().equals("")) str = str + "\n        Tên phần thưởng cần thêm";
            if (tfSoVo.getText().equals("")) str = str + "\n	Số vở";
            alert.setContentText("Các trường : " + str + "\nđang còn trống");
            alert.show();
        } else {
            tiLeThuong.put(tfThemPT.getText(), Integer.valueOf(tfSoVo.getText()));
            danhHieu.add(tfThemPT.getText());

            setThongTinThuong();

            themMoi = themMoi + "\nThêm danh mục phần thưởng : " + tfThemPT.getText() + "\n    - Số lượng vở thưởng : " + tfSoVo.getText() + "\n";

//            cbDanhHieu.getSelectionModel().select(tfThemPT.getText());
            tfThemPT.setText("");
            tfSoVo.setText("");
        }
    }

    @FXML
    protected void onLuuClicked() throws SQLException {
        if (tfSoVo.getText().equals("")) {
            TinhThuongService.chinhTyLe(tiLeThuong);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thay đổi tỉ lệ phần thưởng");
            String str = "";
            for (String tmp : thayDoi) {
                str += tmp;
            }
            str += themMoi;
            str += xoaDi;
            if (!tfGiaVo.getText().equals("")) {
                str += "- Giá một cuốn vở : " + tinhThuong.getGiaVo() + " -> " + tfGiaVo.getText() + "\n";
                TinhThuongService.chinhGiaVo(Integer.valueOf(tfGiaVo.getText()));
                TinhThuongService.giaVo = Integer.valueOf(tfGiaVo.getText());
                tfGiaVo.setText("");

                setThongTinThuong();
            }
            alert.setContentText("Các mục đã chỉnh sửa: " + str + "\n");
            alert.show();

            TinhThuongService.mapTyLeThuong = tiLeThuong;
        } else {
            thayDoi.add(count,"\nTên phần thưởng thay đổi : " + danhHieuTamThoi + "\n    - Số lượng vở thưởng : " + tinhThuong.getPhanThuong(danhHieuTamThoi) + " -> " + tfSoVo.getText() + "\n");
            count = (count + 1) % tiLeThuong.size();

            tiLeThuong.put(danhHieuTamThoi, Integer.valueOf(tfSoVo.getText()));

            setThongTinThuong();

            tfSoVo.setText("");
            danhHieuTamThoi = cbDanhHieu.getValue().toString();

            // Lưu thông tin
            TinhThuongService.chinhTyLe(tiLeThuong);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thay đổi tỉ lệ phần thưởng");
            String str = "";
            for (String tmp : thayDoi) {
                str += tmp;
            }
            str += themMoi;
            str += xoaDi;
            if (!tfGiaVo.getText().equals("")) {
                str += "- Giá một cuốn vở : " + tinhThuong.getGiaVo() + " -> " + tfGiaVo.getText() + "\n";
                TinhThuongService.chinhGiaVo(Integer.valueOf(tfGiaVo.getText()));
                TinhThuongService.giaVo = Integer.valueOf(tfGiaVo.getText());
                tfGiaVo.setText("");

                setThongTinThuong();
            }
            alert.setContentText("Các mục đã chỉnh sửa: " + str + "\n");
            alert.show();

            TinhThuongService.mapTyLeThuong = tiLeThuong;
        }
    }

    @FXML
    void onChangedText() { // Chưa chạy được
        if (!tfSoVo.getText().equals("") && !danhHieuTamThoi.equals("")) {
            thayDoi.add(count,"\nTên phần thưởng thay đổi : " + danhHieuTamThoi + "\n    - Số lượng vở thưởng : " + tinhThuong.getPhanThuong(danhHieuTamThoi) + " -> " + tfSoVo.getText() + "\n");
            count = (count + 1) % tiLeThuong.size();

            tiLeThuong.put(danhHieuTamThoi, Integer.valueOf(tfSoVo.getText()));

            setThongTinThuong();

            tfSoVo.setText("");
            danhHieuTamThoi = cbDanhHieu.getValue().toString();
        } else if (danhHieuTamThoi.equals("")) {
            danhHieuTamThoi = cbDanhHieu.getValue().toString();
        }
    }
}
