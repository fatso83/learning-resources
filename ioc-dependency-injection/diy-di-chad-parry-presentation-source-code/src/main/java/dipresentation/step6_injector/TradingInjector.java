package dipresentation.step6_injector;

import java.math.BigDecimal;
import java.util.Map;

import dipresentation.Account;
import dipresentation.MarketService;

public class TradingInjector {

	private static MarketClient instance = null;
	
	public static Map<String, BigDecimal> injectMarketPrices() {
		return MarketService.fetchPrices();
	}
	
	public static MarketClient injectMarketClient() {
		if (instance == null)
			instance = new MarketClient(injectMarketPrices());
		return instance;
	}

	public static TradingArgs injectTradingArgs(String[] args) {
		return new TradingArgs(args);
	}

	public static String injectSymbol(String[] args) {
		return injectTradingArgs(args).getSymbol();
	}

	public static BigDecimal injectQuantity(String[] args) {
		return injectTradingArgs(args).getQuantity();
	}

	public static BigDecimal injectCommission(String[] args) {
		return injectTradingArgs(args).getCommission();
	}

	public static String injectAccountKey(String[] args) {
		return injectTradingArgs(args).getAccountKey();
	}
	
	public static Trade injectTrade(String[] args) {
		return new Trade(injectSymbol(args), injectQuantity(args));
	}
	
	public static Account injectCustomerAccount(String[] args) {
		return Account.getCustomerAccount(injectAccountKey(args));
	}
	
	public static Account injectFirmAccount() {
		return Account.getFirmAccount();
	}
		
	public static BookingService injectBookingService(String[] args) {
		return new BookingService(
				injectMarketClient(),
				injectFirmAccount(),
				injectCustomerAccount(args),
				injectTrade(args),
				injectCommission(args));
	}
	
}
