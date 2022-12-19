package cnpm.quanlynhankhau.models;

import java.sql.Date;

public class NhanKhau {
    private String name;
    private String nickname;
    private String religion;
    private String CMND;
    private boolean isMale;
    private Address DCThuongTru = new Address();
    private Date birthday;
}
