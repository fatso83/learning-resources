package dipresentation;

import java.math.BigDecimal;

public class Account {

	public static Account getCustomerAccount(String accountKey) {
		throw new UnsupportedOperationException("Could not locate customer account");
	}
	
	public static Account getFirmAccount() {
		throw new UnsupportedOperationException("Could not locate firm account");
	}

	public void transferSecurity(String symbol, BigDecimal quantity, Account destinationAccount) {
		throw new UnsupportedOperationException("Could not transfer security");
	}

	public void transferCash(BigDecimal amount, Account destinationAccount) {
		throw new UnsupportedOperationException("Could not transfer cash");
	}

}
