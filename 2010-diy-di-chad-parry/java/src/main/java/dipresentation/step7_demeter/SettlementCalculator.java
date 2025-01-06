package dipresentation.step7_demeter;

import java.math.BigDecimal;

public class SettlementCalculator {

	private final BigDecimal price;
	private final BigDecimal quantity;
	private final BigDecimal commission;

	SettlementCalculator(BigDecimal price, BigDecimal quantity, BigDecimal commission) {
		this.price = price;
		this.quantity = quantity;
		this.commission = commission;
	}
	
	public BigDecimal getSettlementAmount() {
		BigDecimal marketValue = price.multiply(quantity);
		BigDecimal settlementAmount = marketValue.add(commission);
		return settlementAmount;
	}

}
