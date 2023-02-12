module cnpm.traothuonghs {
	requires javafx.controls;
	requires javafx.fxml;
	requires cnpm.quanlynhankhau;
	requires java.sql;
	requires poi;


	exports cnpm.traothuonghs.models;
	opens cnpm.traothuonghs.models;

	exports cnpm.traothuonghs.application;
	opens cnpm.traothuonghs.application;

	exports cnpm.traothuonghs.controllers;
	opens cnpm.traothuonghs.controllers;

	exports cnpm.traothuonghs.controllers.thongke;
	opens cnpm.traothuonghs.controllers.thongke;
    exports cnpm.traothuonghs.controllers.hocsinh;
    opens cnpm.traothuonghs.controllers.hocsinh;
	exports cnpm.traothuonghs.controllers.phanthuong;
	opens cnpm.traothuonghs.controllers.phanthuong;
}