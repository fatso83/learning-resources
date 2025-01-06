package dipresentation.step5_thinharness;

import dipresentation.ApplicationWrapper;

public class TradingApplication extends ApplicationWrapper {

	@Override
	public void execute(String[] args) {
		BookingService booking = new BookingService(args);
		booking.buy();
	}

}
