package dipresentation;

public abstract class ApplicationWrapper {

	public ApplicationWrapper() {
		throw new UnsupportedOperationException("Could not initialize application");
	}
	
	public abstract void execute(String[] args);
	
}
