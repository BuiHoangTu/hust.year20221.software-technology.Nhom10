package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public abstract class ChangeSceneControllers {
	protected void changeScene(String fxLink) {
		changeScene(fxLink, null);
	}
	protected void changeScene(String fxLink, Object controller) {
		FXMLLoader loader = new FXMLLoader(QuanLyNhanKhauApplication.class.getResource(fxLink));
		if (controller != null) loader.setController(controller);
		Scene scene = null;
		try {
			scene = new Scene(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		QuanLyNhanKhauApplication.MAIN_STAGE.setScene(scene);
	}
}
