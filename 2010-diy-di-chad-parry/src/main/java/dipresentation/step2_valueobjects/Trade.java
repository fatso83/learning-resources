package dipresentation.step2_valueobjects;

import java.math.BigDecimal;

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
	
}
