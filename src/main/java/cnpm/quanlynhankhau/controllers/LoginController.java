package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import cnpm.quanlynhankhau.models.Database;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField tfUserName;
    @FXML
    private TextField tfPasswd;
    @FXML
    private Label lWarning;

    public LoginController() {
    }

    @FXML
    protected void onClickConfirmLogin() {
        try {
            int uID = Database.login(tfUserName.getText(), tfPasswd.getText());
            if (uID >= 0) {
				QuanLyNhanKhauApplication.USER = uID;
                FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/cnpm/quanlynhankhau/views/ChooseFunction-view.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                QuanLyNhanKhauApplication.MAIN_STAGE.setScene(scene);
            } else {
                lWarning.setVisible(true);
                lWarning.setText("Your account or password is wrong!");
            }
        } catch (SQLException e) {
            lWarning.setVisible(true);
            lWarning.setText("Server Error! Please wait a minute and re-try");
        }
    }
}
