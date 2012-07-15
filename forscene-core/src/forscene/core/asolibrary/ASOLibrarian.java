package forscene.core.asolibrary;

//TODO: NOT TESTED ... NOT USED
public class ASOLibrarian{
	private ASOLibrary library;
	private static ASOLibrarian instance;
	
	private ASOLibrarian(){
		library = ASOLibrary.getInstance();
	}
	
	public static ASOLibrarian getInstance()
	{
		if (instance == null) instance = new ASOLibrarian();
		return instance;
	}
}
