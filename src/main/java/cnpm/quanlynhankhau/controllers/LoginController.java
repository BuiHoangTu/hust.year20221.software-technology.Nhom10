package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.models.Database;

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
        String sqlquery = """
                    SELECT * FROM quan_ly_nhan_khau.users u 
                    WHERE u.userName = ? AND u.passwd = ?  
                    """;
        String sUserName = tfUserName.getText();
        String sPasswd = tfPasswd.getText();

        Connection connection = Database.getConnection();
        PreparedStatement statement;
        try{
            statement = connection.prepareStatement(sqlquery);
            statement.setString(1, sUserName);
            statement.setString(2, sPasswd);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                int userID = resultSet.getInt("ID");

                // change view
                FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("ChooseFunction-view.fxml"));
                Scene scene;
                try {
                    scene = new Scene(fxmlLoader.load());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage =  (Stage) tfUserName.getScene().getWindow();

                stage.setScene(scene);
                stage.show();
            } else {
                lWarning.setVisible(true);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
