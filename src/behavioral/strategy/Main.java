package behavioral.strategy;

import java.io.*;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.*;

/**
 * World first console e-commerce application.
 */
public class Main {
	public static Map<Integer, Integer> priceOnProducts = new HashMap<>();
	public static Console console = System.console();
	private static Order order = new Order();
	private static PayStrategy strategy;

	private static Logger logger = System.getLogger(Main.class.getName());

	static {
		priceOnProducts.put(1, 2200);
		priceOnProducts.put(2, 1850);
		priceOnProducts.put(3, 1100);
		priceOnProducts.put(4, 890);
	}

	public static void main(String[] args) throws IOException {
		while (!order.isClosed()) {
			int cost;

			String continueChoice;
			do {
				String select = "Select a product:" + "\n" + "1 - Mother board" + "\n" + "2 - CPU" + "\n" + "3 - HDD"
						+ "\n" + "4 - Memory" + "\n";
				int choice = Integer.parseInt(console.readLine(select));
				cost = priceOnProducts.get(choice);

				int count = Integer.parseInt(console.readLine("Count: "));
				order.setTotalCost(cost * count);

				continueChoice = console.readLine("You wish to continue selection? Y/N: ");
			} while (continueChoice.equalsIgnoreCase("Y"));

			if (strategy == null) {
				String select = "Select a Payment Method" + "\n" + "1 - PalPay" + "\n" + "2 - Credit Card";
				String paymentMethod = console.readLine(select);

				// Client creates different strategies based on input from user,
				// application configuration, etc.
				if (paymentMethod.equals("1")) {
					strategy = new PayByPayPal();
				} else if (paymentMethod.equals("2")) {
					strategy = new PayByCreditCard();
				}

				// Order object delegates gathering payment data to strategy
				// object, since only strategies know what data they need to
				// process a payment.
				order.processOrder(strategy);
			}

			logger.log(Level.INFO, "Pay " + Order.getTotalCost() + " units or Continue shopping?  P/C: ");
			String proceed = console.readLine();
			if (proceed.equalsIgnoreCase("P")) {
				// Finally, strategy handles the payment.
				if (strategy.pay(Order.getTotalCost())) {
					logger.log(Level.INFO, "Payment has succeeded");
				} else {
					logger.log(Level.INFO, "FAIL! Check your data");
				}
				order.setClosed();
			}
		}
	}
}