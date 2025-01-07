package dipresentation;

public class ScopeCache<T> {

	private T cache = null;
	
	public synchronized T get(Provider<? extends T> freshProvider) {
		if (cache == null) {
			cache = freshProvider.get();
		}
		return cache;
	}
	
}
