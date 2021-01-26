package behavioral.template_method;
import java.io.Console;

public class Main {
    
    public static void main(String... args) {
        SocialNetwork network = null;        
        
        Console console = System.console();
        String userName = console.readLine("Input user name:\n|>");
        String password = new String(console.readPassword("Input password:\n|>"));

        // Enter the message.
        String message = console.readLine("Input message:\n|>");

        String options = "\nChoose social network for posting message.\n1 - Facebook\n2 - Twitter\n|>";
        int choice = Integer.parseInt(console.readLine(options));

        // Create proper network object and send the message.
        if (choice == 1) {
            network = new Facebook(userName, password);
        } else if (choice == 2) {
            network = new Twitter(userName, password);
        }

        network.post(message);
    }
    
}