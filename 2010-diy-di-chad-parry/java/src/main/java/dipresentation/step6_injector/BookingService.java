package dipresentation.step6_injector;

import java.math.BigDecimal;

import dipresentation.Account;

public class BookingService {

	private final MarketClient market;
	private final Account firmAccount;
	private final Account customerAccount;
	private final Trade trade;
	private final BigDecimal commission;

	BookingService(MarketClient market, Account firmAccount,
			Account customerAccount, Trade trade, BigDecimal commission) {
		this.market = market;
		this.firmAccount = firmAccount;
		this.customerAccount = customerAccount;
		this.trade = trade;
		this.commission = commission;
	}
	
	public void buy() {
		BigDecimal price = market.getPrice(trade.getSymbol());
		BigDecimal marketValue = price.multiply(trade.getQuantity());
		BigDecimal settlementAmount = marketValue.add(commission);
		customerAccount.transferCash(settlementAmount, firmAccount);
		firmAccount.transferSecurity(trade.getSymbol(), trade.getQuantity(), customerAccount);
	}
	
}
