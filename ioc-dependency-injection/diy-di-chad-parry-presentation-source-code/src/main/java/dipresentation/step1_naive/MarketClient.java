package dipresentation.step1_naive;

import java.math.BigDecimal;
import java.util.Map;

import dipresentation.MarketService;

public class MarketClient {

	private static final MarketClient instance = new MarketClient();
	
	public static MarketClient getInstance() {
		return instance;
	}

	private final Map<String, BigDecimal> cachedPrices;
	
	private MarketClient() {
		cachedPrices = MarketService.fetchPrices();
	}

	public BigDecimal getPrice(String symbol) {
		return cachedPrices.get(symbol);
	}
	
}
