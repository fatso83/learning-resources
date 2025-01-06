package dipresentation.step8_providers;

import java.math.BigDecimal;
import java.util.Map;

public class MarketClient {

	private final Map<String, BigDecimal> cachedPrices;
	
	MarketClient(Map<String, BigDecimal> cachedPrices) {
		this.cachedPrices = cachedPrices;
	}

	public BigDecimal getPrice(String symbol) {
		return cachedPrices.get(symbol);
	}
	
}
