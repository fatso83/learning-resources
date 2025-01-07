package dipresentation.step9_scopes;

import dipresentation.ApplicationWrapper;

public class TradingApplication extends ApplicationWrapper {

	@Override
	public void execute(String[] args) {
		ApplicationScope applicationScope = new ApplicationScope(args);
		BookingService booking = TradingInjector.injectBookingService(applicationScope);
		booking.buy();
	}

}
