package cnpm.quanlynhankhau.application;

import cnpm.quanlynhankhau.models.DiaChi;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuanLyNhanKhauApplication extends Application {
    public static final DiaChi CO_SO_HIEN_TAI = new DiaChi("Hà Nội", "Hai Bà Trưng", "Đại Cồ Việt", "1", "Trụ Sở Quản Lý Nhân Khẩu Bách Khoa");
    public static int USER;
    public static Stage MAIN_STAGE;
	private static final List<Stage> secondaryStages = new ArrayList<>();

    @Override
    public void start(Stage stage){
        FXMLLoader fxmlLoader = new FXMLLoader(QuanLyNhanKhauApplication.class.getResource("/cnpm/quanlynhankhau/views/Login-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Image icon = new Image(" "); /*path to icon */

        stage.setTitle("Quản Lý Nhân Khẩu");
        //stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();

        MAIN_STAGE = stage;
		MAIN_STAGE.setOnCloseRequest(ev -> {
			for (var secondaryStage : secondaryStages) {
				secondaryStage.close();
			}
		});
    }

    public static void main(String[] args) {
        launch();
    }

	public static void addSecondaryStage(Stage stage) {
		secondaryStages.add(stage);
	}
}
