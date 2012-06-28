package forscene.exceptions;

public class IDAlreadyPresentException extends Exception {
	private static final long serialVersionUID = 7211991940336337436L;

	public IDAlreadyPresentException() {
		System.err.print("ID is already present. (change name) \n");		
	}
}
