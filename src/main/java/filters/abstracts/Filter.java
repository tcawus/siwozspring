package filters.abstracts;

public abstract class Filter {

	public abstract Object filter(String objectToFilter);
	
	protected Filter nextFilter;
	
	public void setNext(Filter filter) {
		nextFilter = filter;
	}
}
