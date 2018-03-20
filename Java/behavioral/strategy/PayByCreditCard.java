import java.io.*;
import java.util.*;
import java.util.logging.*;

public class PayByCreditCard  implements PayStrategy {
    private final Console console = System.console();
    private CreditCard card;
    
    private static Logger logger = Logger.getLogger(PayByCreditCard.class.getName());
    
    /**
     * Collect customer's data.
     */
    @Override
    public void collectPaymentDetails() {
        String number = console.readLine("Enter card number:\n|>");
        String date = console.readLine("Enter date 'mm/yy':\n|>");
        String cvv = console.readLine("Enter cvv code:\n|>");
        
        card = new CreditCard(number, date, cvv);
    }

    /**
     * After card validation we can charge customer's credit card.
     */
    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent()) {
            logger.info("Paying " + paymentAmount + " using Credit Card");
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        } else {
            return false;
        }
    }

    private boolean cardIsPresent() {
        return card != null;
    }
}

class CreditCard {
    private int amount;
    private String number;
    private String date;
    private String cvv;

    public CreditCard(String number, String date, String cvv) {
        this.amount = 100_000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}