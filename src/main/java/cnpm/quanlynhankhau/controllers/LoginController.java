package cnpm.quanlynhankhau.controllers;

import models.Database;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String sUserName = tfUserName.getText();
        String sPasswd = tfPasswd.getText();

        Connection connection = Database.getConnection();
        PreparedStatement statement;
        try{
            statement = connection.prepareStatement("Select ID from Users "
                    + "where Users.Name = ? and Users.Passwd = ?");
            statement.setString(1, sUserName);
            statement.setString(2, sPasswd);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                int userID = resultSet.getInt("UID");

                // change view
//                FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("Home-view.fxml"));
//                Scene scene;
//                try {
//                    scene = new Scene(fxmlLoader.load());
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                Stage stage =  (Stage) tfUserName.getScene().getWindow();
//
//                stage.setScene(scene);
//                stage.show();
            } else {
                lWarning.setVisible(true);
            }

        }catch (SQLException e) {

        }
    }


    @FXML
    protected void onClickToSignup() {
        // change view
//        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("SignUp-view.fxml"));
//        Scene scene;
//        try {
//            scene = new Scene(fxmlLoader.load());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Stage stage =  (Stage) tfUserName.getScene().getWindow();
//
//        stage.setScene(scene);
//        stage.show();
    }
}
