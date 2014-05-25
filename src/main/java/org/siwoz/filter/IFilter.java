package org.siwoz.filter;

import java.util.Collection;

public interface IFilter<T> {

	Collection<T> doFilter(Collection<T> input);
}
