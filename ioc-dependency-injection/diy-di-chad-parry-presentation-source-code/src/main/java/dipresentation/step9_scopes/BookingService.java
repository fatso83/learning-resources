package dipresentation.step9_scopes;

import java.math.BigDecimal;

import dipresentation.Account;
import dipresentation.Provider;

public class BookingService {

	private final Account firmAccount;
	private final Account customerAccount;
	private final Trade trade;
	private final Provider<BigDecimal> settlementAmount;

	BookingService(Account firmAccount, Account customerAccount,
			Trade trade, Provider<BigDecimal> settlementAmount) {
		this.firmAccount = firmAccount;
		this.customerAccount = customerAccount;
		this.trade = trade;
		this.settlementAmount = settlementAmount;
	}
	
	public void buy() {
		customerAccount.transferCash(settlementAmount.get(), firmAccount);
		firmAccount.transferSecurity(trade.getSymbol(), trade.getQuantity(), customerAccount);
	}
	
}

