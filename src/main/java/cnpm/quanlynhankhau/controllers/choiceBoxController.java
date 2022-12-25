package cnpm.quanlynhankhau.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class choiceBoxController implements Initializable {

    @FXML
    private ChoiceBox<String> yourGender;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        yourGender.getItems().addAll("Nam", "Nu");
    }

}
