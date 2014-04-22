package filters;

public class NotNullFilter extends Filter {
	@Override
	public Object filter(String objectToFilter) {
		if (objectToFilter == null) {
			return new ExceptionHandler(
					"Wystapil blad podczas przesylania parametrow, prosze sprobuj jeszcze raz");
		}
		if(nextFilter != null)
			return nextFilter.filter(objectToFilter);
		return objectToFilter;
	}
}
