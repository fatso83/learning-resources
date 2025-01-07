package dipresentation.step7_demeter;

import dipresentation.ApplicationWrapper;

public class TradingApplication extends ApplicationWrapper {

	@Override
	public void execute(String[] args) {
		BookingService booking = TradingInjector.injectBookingService(args);
		booking.buy();
	}

}
