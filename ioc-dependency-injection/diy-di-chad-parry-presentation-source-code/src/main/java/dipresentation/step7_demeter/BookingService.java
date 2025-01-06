package dipresentation.step7_demeter;

import java.math.BigDecimal;

import dipresentation.Account;

public class BookingService {

	private final Account firmAccount;
	private final Account customerAccount;
	private final Trade trade;
	private final BigDecimal settlementAmount;

	BookingService(Account firmAccount, Account customerAccount,
			Trade trade, BigDecimal settlementAmount) {
		this.firmAccount = firmAccount;
		this.customerAccount = customerAccount;
		this.trade = trade;
		this.settlementAmount = settlementAmount;
	}
	
	public void buy() {
		customerAccount.transferCash(settlementAmount, firmAccount);
		firmAccount.transferSecurity(trade.getSymbol(), trade.getQuantity(), customerAccount);
	}
	
}
