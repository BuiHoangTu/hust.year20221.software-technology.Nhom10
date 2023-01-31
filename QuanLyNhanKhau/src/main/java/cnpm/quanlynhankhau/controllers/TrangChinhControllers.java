package cnpm.quanlynhankhau.controllers;

import cnpm.quanlynhankhau.models.Database;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrangChinhControllers extends EdgeController{
    public Pane pnlTrangChu;
    public Label lblNhanKhauNum;
    public Label lblHoKhauNum;
    public Label lblTamTruNum;
    public Label lblTamVangNum;

    private void initialize() throws SQLException {
//        PreparedStatement nhanKhauNum = Database.getConnection().prepareStatement("Select COUNT(maNhanKhau) from quan_ly_nhan_khau.nhan_khau");
//        ResultSet num = nhanKhauNum.executeQuery();
//        num.next();
//        lblNhanKhauNum.setText(num.getString(1));
//
//        PreparedStatement hoKhauNum = Database.getConnection().prepareStatement("Select COUNT(maHoKhau) from quan_ly_nhan_khau.ho_khau");
//        num = hoKhauNum.executeQuery();
//        num.next();
//        lblHoKhauNum.setText(num.getString(1));
    }


}
