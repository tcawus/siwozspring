package filters;


public abstract class FilterChain {
	Filter firstFilter;
	Object result;

	public void validate(String input) {
		result = firstFilter.filter(input);
	}

	public boolean isError() {
		if (result instanceof ExceptionHandler) {
			return true;
		}
		return false;
	}

	public String getErrorMessage() {
		return ((ExceptionHandler) result).getMessage();
	}

	public String getOutput() {
		return (String) result;
	}
}
