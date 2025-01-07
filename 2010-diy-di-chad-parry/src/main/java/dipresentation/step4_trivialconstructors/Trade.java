package dipresentation.step4_trivialconstructors;

import java.math.BigDecimal;

public class Trade {

	private final String symbol;
	private final BigDecimal quantity;
	
	public Trade(String symbol, BigDecimal quantity) {
		this.symbol = symbol;
		this.quantity = quantity;
	}

	public String getSymbol() {
		return symbol;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}
	
}
