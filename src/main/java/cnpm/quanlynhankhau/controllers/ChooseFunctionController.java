//package cnpm.quanlynhankhau.controllers;
//
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class ChooseFunctionController {
//    @FXML
//    private Button marker;
//
//
//    private void changeView(String viewName) {
//        FXMLLoader fxmlLoader = new FXMLLoader(ChooseFunctionController.class.getResource(viewName));
//        Scene scene;
//        try {
//            scene = new Scene(fxmlLoader.load());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Stage stage =  (Stage) marker.getScene().getWindow();
//
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    @FXML
//    protected void clickButton() {
//        changeView("ChooseFunction-view.fxml");
//    }
//}

package cnpm.quanlynhankhau.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChooseFunctionController {

    @FXML
    private Button marker;

    @FXML private Button TTNK;

    @FXML
    void ChuyenHoController(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/cnpm/quanlynhankhau/TachHo.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage =  (Stage) marker.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void TTNKView(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/cnpm/quanlynhankhau/thongkeNhanKhau.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage =  (Stage) marker.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickButton(MouseEvent event) {

    }
}

