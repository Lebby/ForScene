package forscene.core.asolibrary;

//TODO: NOT TESTED ... NOT USED
public class ASOLibrarian{
	private Library library;
	private static ASOLibrarian instance;
	
	private ASOLibrarian(){
		library = Library.getInstance();
	}
	
	public static ASOLibrarian getInstance()
	{
		if (instance == null) instance = new ASOLibrarian();
		return instance;
	}
}
