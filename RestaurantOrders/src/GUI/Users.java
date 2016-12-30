package GUI;
import java.io.FileWriter;
import java.io.IOException;

public class Users {
	public Users(String username, String password) throws IOException {
		FileWriter fw1 = new FileWriter(".\\files\\users\\username.txt");
		FileWriter fw2 = new FileWriter(".\\files\\users\\password.txt");
		fw1.write(username);
		fw2.write(password);
		fw1.close();
		fw2.close();
	}
}