package forscene.core.entities;

import playn.core.PlayN;
import forscene.core.asolibrary.ASOType;


public class ObjectID implements  Comparable<ObjectID> {	
	private long ID;
	private AbstractSceneObject instance;
	private ASOType type;
	
	public ObjectID(AbstractSceneObject instance)
	{
		this.instance = instance;
		
	}
	
	public String getName() {
		return instance.getName();
	}
	
	public void setName(String name) {
		instance.setName(name);
	}	
	
	public AbstractSceneObject getInstance() {
		return instance;
	}
	
	public void setInstance(AbstractSceneObject instance) {
		this.instance = instance;
	}
	
	public String getType()
	{
		return type.getType();
	}

	public int compareTo(ObjectID arg0) {
		PlayN.log().debug("ObjectIDCompare : " + this.getName() + " " + arg0.getName());
		return this.getName().compareTo(arg0.getName());		
	}	
	
}