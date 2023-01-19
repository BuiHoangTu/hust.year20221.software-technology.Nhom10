package cnpm.quanlynhankhau.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ChungMinhThuTest {

    @Test
    void lamCMT() throws SQLException {
        Image img = new Image("C:\\Users\\Admin\\NMCNPM.20221-Nhom10\\src\\main\\resources\\imageEx\\R.png");
        ImageView v = new ImageView(img);
        ChungMinhThu cmt = new ChungMinhThu();
        DiaChi diaChi = new DiaChi("Hanoi", "TX", "HBT", "120","");
        cmt.lamCMT(img, diaChi);
    }
}