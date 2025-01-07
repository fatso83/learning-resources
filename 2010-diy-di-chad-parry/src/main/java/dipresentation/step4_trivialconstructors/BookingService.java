package dipresentation.step4_trivialconstructors;

import java.math.BigDecimal;

import dipresentation.Account;

public class BookingService {

	private final MarketClient market;
	private final Account firmAccount;

	BookingService(MarketClient market, Account firmAccount) {
		this.market = market;
		this.firmAccount = firmAccount;
	}
	
	public BookingService() {
		this(MarketClient.getInstance(), Account.getFirmAccount());
	}
	
	public void buy(Account customerAccount, Trade trade, BigDecimal commission) {
		BigDecimal price = market.getPrice(trade.getSymbol());
		BigDecimal marketValue = price.multiply(trade.getQuantity());
		BigDecimal settlementAmount = marketValue.add(commission);
		customerAccount.transferCash(settlementAmount, firmAccount);
		firmAccount.transferSecurity(trade.getSymbol(), trade.getQuantity(), customerAccount);
	}
	
}
