package dipresentation.step2_valueobjects;

import java.math.BigDecimal;

import dipresentation.Account;

public class BookingService {

	public static void buy(Account customerAccount, Trade trade, BigDecimal commission) {
		MarketClient market = MarketClient.getInstance();
		BigDecimal price = market.getPrice(trade.getSymbol());
		BigDecimal marketValue = price.multiply(trade.getQuantity());
		BigDecimal settlementAmount = marketValue.add(commission);
		Account firmAccount = Account.getFirmAccount();
		customerAccount.transferCash(settlementAmount, firmAccount);
		firmAccount.transferSecurity(trade.getSymbol(), trade.getQuantity(), customerAccount);
	}
	
}
