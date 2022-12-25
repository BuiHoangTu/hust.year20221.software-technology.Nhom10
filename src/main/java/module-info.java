module cnpm.quanlynhankhau {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens cnpm.quanlynhankhau to javafx.fxml;
    exports cnpm.quanlynhankhau.application;
    opens cnpm.quanlynhankhau.application to javafx.fxml;
    exports cnpm.quanlynhankhau.controllers;
    opens cnpm.quanlynhankhau.controllers to javafx.fxml;
    exports cnpm.quanlynhankhau.models;
    opens cnpm.quanlynhankhau.models to javafx.fxml;
}