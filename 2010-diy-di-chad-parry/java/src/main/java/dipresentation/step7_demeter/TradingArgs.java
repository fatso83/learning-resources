package dipresentation.step7_demeter;

import java.math.BigDecimal;

public class TradingArgs {

	private final String[] args;
	
	public TradingArgs(String[] args) {
		this.args = args;
	}

	public String getAccountKey() {
		return args[0];
	}

	public String getSymbol() {
		return args[1];
	}

	public BigDecimal getQuantity() {
		return new BigDecimal(args[2]);
	}
	
	public BigDecimal getCommission() {
		return new BigDecimal(args[3]);
	}

}
