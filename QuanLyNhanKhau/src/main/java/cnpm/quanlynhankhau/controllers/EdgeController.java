package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public abstract class EdgeController {
	public void onTrangChuClicked(ActionEvent event) {
		changeScene("/cnpm/quanlynhankhau/views/Trang_chinh.fxml");
	}

	public void onNhanKhauClicked(ActionEvent event) {
		changeScene("/cnpm/quanlynhankhau/views/QuanLyNhanKhau.fxml");
	}

	public void onHoKhauClicked(ActionEvent event) {
		changeScene("/cnpm/quanlynhankhau/views/QuanLyHoKhau.fxml");
	}

	public void onThongKeClicked(ActionEvent event) {
		changeScene("/cnpm/quanlynhankhau/views/ThongKe.fxml");
	}

	public void onAddClicked(ActionEvent event){changeScene("/cnpm/quanlynhankhau/views/ThemMoiHoKhau.fxml");
	}
	public void onSuaClicked(ActionEvent event){changeScene("/cnpm/quanlynhankhau/views/ThemThanhVien.fxml");
	}

	private void changeScene(String fxLink) {
		FXMLLoader loader = new FXMLLoader(QuanLyNhanKhauApplication.class.getResource(fxLink));
		Scene scene = null;
		try {
			scene = new Scene(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		QuanLyNhanKhauApplication.MAIN_STAGE.setScene(scene);
	}
}
