package cnpm.quanlynhankhau.application;

import cnpm.quanlynhankhau.models.DiaChi;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class QuanLyNhanKhauApplication extends Application {
    public static final DiaChi CO_SO_HIEN_TAI = new DiaChi("Hà Nội", "Hai Bà Trưng", "Đại Cồ Việt", "1", "Trụ Sở Quản Lý Nhân Khẩu Bách Khoa");

    @Override
    public void start(Stage stage){
        FXMLLoader fxmlLoader = new FXMLLoader(QuanLyNhanKhauApplication.class.getResource("/cnpm/quanlynhankhau/views/Login-view.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Image icon = new Image(" "); /*path to icon */

        stage.setTitle("Quản Lý Nhân Khẩu");
        //stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
