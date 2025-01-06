package dipresentation.step6_injector;

import dipresentation.ApplicationWrapper;

public class TradingApplication extends ApplicationWrapper {

	@Override
	public void execute(String[] args) {
		BookingService booking = TradingInjector.injectBookingService(args);
		booking.buy();
	}

}
