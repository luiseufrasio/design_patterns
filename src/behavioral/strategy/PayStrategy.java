package behavioral.strategy;
/**
 * Common interface for all strategies
 */ 
public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}