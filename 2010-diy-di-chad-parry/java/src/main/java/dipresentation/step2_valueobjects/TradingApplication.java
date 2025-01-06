package dipresentation.step2_valueobjects;

import java.math.BigDecimal;

import dipresentation.Account;
import dipresentation.ApplicationWrapper;

public class TradingApplication extends ApplicationWrapper {

	@Override
	public void execute(String[] args) {
		String accountKey = args[0];
		Account customerAccount = Account.getCustomerAccount(accountKey);
		String symbol = args[1];
		BigDecimal quantity = new BigDecimal(args[2]);
		BigDecimal commission = new BigDecimal(args[3]);
		Trade trade = new Trade();
		trade.setSymbol(symbol);
		trade.setQuantity(quantity);
		BookingService.buy(customerAccount, trade, commission);
	}

}
