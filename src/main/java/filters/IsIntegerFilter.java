package filters;

public class IsIntegerFilter extends Filter {
	@Override
	public Object filter(String objectToFilter) {
		try {
			Integer.parseInt(objectToFilter);
			if (nextFilter != null)
				return nextFilter.filter(objectToFilter);
			return objectToFilter;
		} catch (NumberFormatException er) {
			return new ExceptionHandler("Podany ciag znakow nie jest liczba!");
		}
	}
}
