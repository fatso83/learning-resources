package dipresentation.step1_naive;

import java.math.BigDecimal;

import dipresentation.Account;

public class Trade {

	private String symbol;
	private BigDecimal quantity;
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public BigDecimal getQuantity() {
		return quantity;
	}
	
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	
	public void buy(Account customerAccount, BigDecimal commission) {
		MarketClient market = MarketClient.getInstance();
		BigDecimal price = market.getPrice(symbol);
		BigDecimal marketValue = price.multiply(quantity);
		BigDecimal settlementAmount = marketValue.add(commission);
		Account firmAccount = Account.getFirmAccount();
		customerAccount.transferCash(settlementAmount, firmAccount);
		firmAccount.transferSecurity(symbol, quantity, customerAccount);
	}
	
}
