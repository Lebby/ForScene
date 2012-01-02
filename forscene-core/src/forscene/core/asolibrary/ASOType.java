package forscene.core.asolibrary;

public class ASOType {
	private String type="";
	private boolean unique=false;
	
	private ASOType()
	{		
	}
	
	public ASOType(String type)
	{
		this.type=type;
	}
	
	public String getType() {
		return type;
	}

	private void setType(String type) {
		this.type = type;
	}

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}
	
}
