package cnpm.quanlynhankhau.utilities;

import cnpm.quanlynhankhau.application.QuanLyNhanKhauApplication;
import cnpm.quanlynhankhau.controllers.ChangeSceneControllers;
import cnpm.quanlynhankhau.models.NhanKhau;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Callable;

public class DoubleClickCallBack<S extends NhanKhau> extends ChangeSceneControllers implements Callback<TableView<S>, TableRow<S>> {
	private Callable action;

//	public DoubleClickCallBack() {
//		super();
//	}
	public DoubleClickCallBack(Callable action){
		super();
		this.action = action;
	}

	@Override
	public TableRow<S> call(TableView<S> tv) {
		TableRow<S> row = new TableRow<>();
		row.setOnMouseClicked(
				(mouseEvent) -> {
					if (mouseEvent.getClickCount() == 2) {
						try {
							action.call();
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					}
				}
		);
		return row;
	}
}
