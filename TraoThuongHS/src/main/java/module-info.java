module cnpm.traothuonghs {
	requires javafx.controls;
	requires javafx.fxml;
	requires cnpm.quanlynhankhau;
	requires com.google.common;
	requires java.sql;


	exports cnpm.traothuonghs.models;
	opens cnpm.traothuonghs.models to javafx.fxml;

}