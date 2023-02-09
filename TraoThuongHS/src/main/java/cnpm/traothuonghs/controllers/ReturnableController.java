package cnpm.traothuonghs.controllers;

import cnpm.traothuonghs.application.TraoThuongHSApplication;
import javafx.scene.Scene;

public abstract class ReturnableController {
	private Scene previousScene;

	public ReturnableController(Scene previousScene) {
		this.previousScene = previousScene;
	}

	protected void previous() {
		TraoThuongHSApplication.MAIN_STAGE.setScene(previousScene);
	}
}
