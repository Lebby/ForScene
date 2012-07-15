package forscene.core.asolibrary;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import forscene.core.entities.AbstractSceneObject;
import forscene.system.ISceneObject;

//TODO: NOT TESTED ... NOT USED
public class ASOLibrary {
	private Set<ASOType> types;
	private LinkedList<AbstractSceneObject> objects;
	
	private static ASOLibrary instance = null;
	
	private ASOLibrary()
	{		
	}
	
	public static ASOLibrary getInstance()
	{
		if (instance == null) instance = new ASOLibrary();
		return instance;
	}
	
	public ISceneObject getObjectByName(String name)
	{
		for (Iterator iterator = objects.iterator(); iterator.hasNext();) {
			ISceneObject value = (ISceneObject) iterator.next();
			if (value.getName() == name) return value;			
		}
		return null;
	}
	
	/*
	public AbstractSceneObject getObjectByID(long ID)
	{
		for (Iterator iterator = objects.iterator(); iterator.hasNext();) {
			AbstractSceneObject value = (AbstractSceneObject) iterator.next();
			if (value.getID() == ID) return value;			
		}
		return null;
	}*/
	
	public ISceneObject[] getObjectsByType(String type)
	{
		LinkedList<AbstractSceneObject> tmp = new LinkedList<AbstractSceneObject>();
		for (Iterator iterator = objects.iterator(); iterator.hasNext();) {
			AbstractSceneObject value = (AbstractSceneObject) iterator.next();
			if (value.getType() == type) tmp.add(value);			
		}
		return null;
	}

	public Set<ASOType> getTypes() {
		return types;
	}

	public void setTypes(Set<ASOType> types) {
		this.types = types;
	}
	
	public LinkedList<AbstractSceneObject> getObjects() {
		return objects;
	}

	public void setObjects(LinkedList<AbstractSceneObject> objects) {
		this.objects = objects;
	}

}