package behavioral.observer;

import java.util.logging.*;

public class ObserverMain {
    
    private static Logger logger = Logger.getLogger(ObserverMain.class.getName());

    public static void main(String[] args) {
        Editor editor = new Editor();
        
        editor.events.subscribe("open", 
            new LogOpenListener("/path/to/log/file.txt"));
            
        editor.events.subscribe("save", 
            new LogOpenListener("/path/to/log/file.txt"));
            
        editor.events.subscribe("save", 
            new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }
}