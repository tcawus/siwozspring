package filters;

public abstract class Filter {

	public abstract Object filter(String objectToFilter);
	
	Filter nextFilter;
	
	public void setNext(Filter filter) {
		nextFilter = filter;
	}
}
