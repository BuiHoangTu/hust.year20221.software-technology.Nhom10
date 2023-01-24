package cnpm.quanlynhankhau.models;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
//    @Test
//    void getNhanKhau() throws SQLException {
//        Database x = new Database();
//        x.getNhanKhau(5,"Hà Nội");
//    }

	@Test
	void login() throws SQLException {
		assertFalse(Database.login(null, null) > 0);
		assertFalse(Database.login("wrong", "wrong") > 0);
		assertTrue(Database.login("admin", "1") > 0);
	}
}