package dipresentation.step9_scopes;

import java.math.BigDecimal;
import java.util.Map;

import dipresentation.Account;
import dipresentation.MarketService;
import dipresentation.Provider;

public class TradingInjector {

	public static String[] injectArgs(ApplicationScope applicationScope) {
		return applicationScope.getArgs();
	}

	public static MarketClient injectMarketClient(ApplicationScope applicationScope) {
		return applicationScope.getMarketClient(injectFreshMarketClientProvider());
	}

	public static Provider<MarketClient> injectFreshMarketClientProvider() {
		return new Provider<MarketClient>() {
			public MarketClient get() {
				return injectFreshMarketClient();
			}
		};
	}

	public static MarketClient injectFreshMarketClient() {
		return new MarketClient(injectMarketPrices());
	}

	public static Map<String, BigDecimal> injectMarketPrices() {
		return MarketService.fetchPrices();
	}

	public static TradingArgs injectTradingArgs(ApplicationScope applicationScope) {
		return new TradingArgs(injectArgs(applicationScope));
	}

	public static String injectSymbol(ApplicationScope applicationScope) {
		return injectTradingArgs(applicationScope).getSymbol();
	}

	public static BigDecimal injectQuantity(ApplicationScope applicationScope) {
		return injectTradingArgs(applicationScope).getQuantity();
	}

	public static BigDecimal injectCommission(ApplicationScope applicationScope) {
		return injectTradingArgs(applicationScope).getCommission();
	}

	public static String injectAccountKey(ApplicationScope applicationScope) {
		return injectTradingArgs(applicationScope).getAccountKey();
	}
	
	public static Trade injectTrade(ApplicationScope applicationScope) {
		return new Trade(injectSymbol(applicationScope), injectQuantity(applicationScope));
	}
	
	public static Account injectCustomerAccount(ApplicationScope applicationScope) {
		return Account.getCustomerAccount(injectAccountKey(applicationScope));
	}
	
	public static Account injectFirmAccount() {
		return Account.getFirmAccount();
	}
		
	public static BookingService injectBookingService(ApplicationScope applicationScope) {
		return new BookingService(
				injectFirmAccount(),
				injectCustomerAccount(applicationScope),
				injectTrade(applicationScope),
				injectSettlementAmountProvider(applicationScope));
	}
	
	public static Provider<BigDecimal> injectSettlementAmountProvider(
			final ApplicationScope applicationScope) {
		return new Provider<BigDecimal>() {
			public BigDecimal get() {
				return injectSettlementAmount(applicationScope);
			}
		};
	}
	
	public static BigDecimal injectSettlementAmount(ApplicationScope applicationScope) {
		return injectSettlementCalculator(applicationScope).getSettlementAmount();
	}
	
	public static SettlementCalculator injectSettlementCalculator(ApplicationScope applicationScope) {
		return new SettlementCalculator(
				injectPriceProvider(applicationScope),
				injectQuantity(applicationScope),
				injectCommission(applicationScope));
	}
	
	public static Provider<BigDecimal> injectPriceProvider(
			final ApplicationScope applicationScope) {
		return new Provider<BigDecimal>() {
			public BigDecimal get() {
				return injectPrice(applicationScope);
			}
		};
	}
	
	public static BigDecimal injectPrice(ApplicationScope applicationScope) {
		return injectMarketClient(applicationScope).getPrice(injectSymbol(applicationScope));
	}

}
