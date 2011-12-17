package forscene.exceptions;

public class NoNameException extends AbstractSceneObjectException {
	private static final long serialVersionUID = -7964696907646854838L;
	public NoNameException() {		
		System.err.print("Set a name to object by setName() or use a different method \n");
		System.err.print("Name is not setted at ");
	}
}
