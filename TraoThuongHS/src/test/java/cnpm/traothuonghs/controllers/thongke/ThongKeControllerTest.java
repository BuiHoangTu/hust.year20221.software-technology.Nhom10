package cnpm.traothuonghs.controllers.thongke;

import cnpm.traothuonghs.application.TraoThuongHSApplication;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ThongKeControllerTest {

	@Test
	void onExportClicked() throws IOException {
		String home = System.getProperty("user.home");
		File applicationFolder = new File(home, "Trao Thưởng Học Sinh");
		if (!applicationFolder.exists()) applicationFolder.mkdir();
		// make file
		var today = LocalDateTime.now();
		File applicationFile = new File(applicationFolder, today + " Test.txt");
		applicationFile.createNewFile();

		BufferedWriter writer = new BufferedWriter(new FileWriter(applicationFile));
		writer.write("strhg\n");
		writer.write("more");

		writer.close();
	}
}