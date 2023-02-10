module cnpm.traothuonghs {
	requires javafx.controls;
	requires javafx.fxml;
	requires cnpm.quanlynhankhau;
	requires java.sql;
	requires poi;


	exports cnpm.traothuonghs.models;
	opens cnpm.traothuonghs.models to javafx.fxml;

}