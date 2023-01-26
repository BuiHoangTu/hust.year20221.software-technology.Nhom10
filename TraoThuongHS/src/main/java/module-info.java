module cnpm.traothuonghs {
	requires javafx.controls;
	requires javafx.fxml;
	requires cnpm.quanlynhankhau;


	opens cnpm.traothuonghs.models to javafx.fxml;
	exports cnpm.traothuonghs.models;
}