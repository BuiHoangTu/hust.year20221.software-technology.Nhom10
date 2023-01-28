package cnpm.quanlynhankhau.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ChooseFunctionController {
    @FXML
    private Button marker;


    private void changeView(String viewName) {
        FXMLLoader fxmlLoader = new FXMLLoader(ChooseFunctionController.class.getResource(viewName));
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
    protected void clickButton() {
        changeView("Your-view.fxml");
    }
}
