package dipresentation.step9_scopes;

import dipresentation.Provider;
import dipresentation.ScopeCache;

public class ApplicationScope {

	private final String[] args;

	private final ScopeCache<MarketClient> marketClientCache = new ScopeCache<MarketClient>();

	public ApplicationScope(String[] args) {
		this.args = args;
	}

	public String[] getArgs() {
		return args;
	}

	public MarketClient getMarketClient(Provider<MarketClient> freshMarketClientProvider) {
		return marketClientCache.get(freshMarketClientProvider);
	}

}
