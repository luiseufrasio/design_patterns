package behavioral.strategy;
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class PayByPayPal implements PayStrategy {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final Console console = System.console();
    private String email;
    private String password;
    private boolean signedIn;
    
    private Logger logger = Logger.getLogger(PayByPayPal.class.getName());
    
    static {
        DATA_BASE.put("luis123", "luis.eufrasio@gmail.com");
        DATA_BASE.put("ana456", "ana.claris@gmail.com");
    }
    
    /**
     * Collect customer's data.
     */
    @Override
    public void collectPaymentDetails() {
        while (!signedIn) {
            email = console.readLine("Enter user email:\n|>");
            password = new String(console.readPassword("Enter password:\n|>"));
            if (verify()) {
                logger.info("Data verification was successful");
            } else {
                logger.info("Wrong email or password!");
            }
        }
    }

    /**
     * Save customer data for future shopping attempts.
     */
    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            logger.info("Paying " + paymentAmount + " using PayPal");
            return true;
        } else {
            return false;
        }
    }

    private boolean verify() {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }
    
    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}