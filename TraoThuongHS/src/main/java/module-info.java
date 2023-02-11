module cnpm.traothuonghs {
	requires javafx.controls;
	requires javafx.fxml;
	requires cnpm.quanlynhankhau;
	requires java.sql;


	exports cnpm.traothuonghs.models;
	opens cnpm.traothuonghs.models to javafx.fxml;
	exports cnpm.traothuonghs.controllers;
	opens cnpm.traothuonghs.controllers to javafx.fxml;
	exports cnpm.traothuonghs.application;
	opens cnpm.traothuonghs.application to javafx.fxml;
	exports cnpm.traothuonghs.services;
	opens cnpm.traothuonghs.services to javafx.fxml;
}