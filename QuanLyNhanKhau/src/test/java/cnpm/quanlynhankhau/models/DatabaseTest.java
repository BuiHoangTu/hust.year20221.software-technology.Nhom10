
	@Test
	void login() throws SQLException {
		assertFalse(Database.login(null, null) > 0);
		assertFalse(Database.login("wrong", "wrong") > 0);
		assertTrue(Database.login("admin", "1") > 0);
	}
}