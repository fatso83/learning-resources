package dipresentation.step8_providers;

import java.math.BigDecimal;

import dipresentation.Provider;

public class SettlementCalculator {

	private final Provider<BigDecimal> price;
	private final BigDecimal quantity;
	private final BigDecimal commission;

	SettlementCalculator(Provider<BigDecimal> price, BigDecimal quantity, BigDecimal commission) {
		this.price = price;
		this.quantity = quantity;
		this.commission = commission;
	}
	
	public BigDecimal getSettlementAmount() {
		BigDecimal marketValue = price.get().multiply(quantity);
		BigDecimal settlementAmount = marketValue.add(commission);
		return settlementAmount;
	}

}
