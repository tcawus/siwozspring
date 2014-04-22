package filters;


public class InsertFilterChain extends FilterChain {

	public InsertFilterChain() {
		NotNullFilter notNullFilter = new NotNullFilter();
		notNullFilter.setNext(new IsIntegerFilter());
		firstFilter = notNullFilter;
	}
}
