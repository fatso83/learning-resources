package dipresentation.step4_trivialconstructors;

import java.math.BigDecimal;
import java.util.Map;

import dipresentation.MarketService;

public class MarketClient {

	private static MarketClient instance = null;
	
	public static MarketClient getInstance() {
		if (instance == null)
			instance = new MarketClient();
		return instance;
	}

	private final Map<String, BigDecimal> cachedPrices;
	
	MarketClient(Map<String, BigDecimal> cachedPrices) {
		this.cachedPrices = cachedPrices;
	}

	private MarketClient() {
		this(MarketService.fetchPrices());
	}

	public BigDecimal getPrice(String symbol) {
		return cachedPrices.get(symbol);
	}
	
}
