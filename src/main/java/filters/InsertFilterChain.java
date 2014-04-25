package filters;

import filters.abstracts.FilterChain;
import filters.elements.IsIntegerFilter;
import filters.elements.NotNullFilter;


public class InsertFilterChain extends FilterChain {

	public InsertFilterChain() {
		NotNullFilter notNullFilter = new NotNullFilter();
		notNullFilter.setNext(new IsIntegerFilter());
		firstFilter = notNullFilter;
	}
}
