module cnpm.traothuonghs {
	requires javafx.controls;
	requires javafx.fxml;


	opens cnpm.traothuonghs to javafx.fxml;
	exports cnpm.traothuonghs;
}