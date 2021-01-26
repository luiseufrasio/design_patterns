package behavioral.observer;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class Main {

	private static Logger logger = System.getLogger(Main.class.getName());

	public static void main(String[] args) {
		Editor editor = new Editor();

		editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));

		editor.events.subscribe("save", new LogOpenListener("/path/to/log/file.txt"));

		editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

		try {
			editor.openFile("test.txt");
			editor.saveFile();
		} catch (Exception e) {
			logger.log(Level.ERROR, e.getMessage());
		}
	}
}