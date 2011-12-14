package forscene.core.LoopController;

public class ObjectID<T> {
	private String name="";
	private long ID;
	private T instance;
	private ASOType type;
	
	private ObjectID()
	{}
	
	public ObjectID(T instance)
	{
		this.instance = instance;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getID() {
		return ID;
	}
	
	public void setID(long iD) {
		ID = iD;
	}
	
	public T getInstance() {
		return instance;
	}
	
	public void setInstance(T instance) {
		this.instance = instance;
	}
	
	public String getType()
	{
		return type.getType();
	}
	
}