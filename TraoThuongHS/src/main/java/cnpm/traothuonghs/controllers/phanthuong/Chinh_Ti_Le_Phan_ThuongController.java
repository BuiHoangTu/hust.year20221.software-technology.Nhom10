package cnpm.traothuonghs.controllers.phanthuong;

import cnpm.traothuonghs.controllers.BaseLeftController;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Chinh_Ti_Le_Phan_ThuongController extends BaseLeftController {
    // ComboBox Danh hiệu
    @FXML
    private ComboBox cbDanhHieu;

    // TextField Chỉnh tỉ lệ
    @FXML
    private TextField tfSoVo;
    @FXML
    private TextField tfGiaVo;

    // Label Thông tin có sẵn của tỉ lệ phần thưởng
    @FXML
    private Label lbHSGioi;
    @FXML
    private Label lbSoVoGioi;
    @FXML
    private Label lbHSKha;
    @FXML
    private Label lbSoVoKha;

    // Button
    @FXML
    protected void onLuuClicked() {

    }
}
