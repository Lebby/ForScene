package forscene.system.managers;

import java.util.Map;
import java.util.PriorityQueue;


import org.omg.CosNaming.IstringHelper;

import forscene.core.asolibrary.ASOLibrary;
import forscene.system.entities.Resource;

import playn.core.*;


public class ResourceManager {
	private static ResourceManager instance = null;
	private PriorityQueue<Resource> toLoad;
	private PriorityQueue<Resource> error;
	private PriorityQueue<Resource> done;
	private int retry = 5;
	private boolean ready = false;
	
	private ResourceManager()
	{
		toLoad = new PriorityQueue<Resource>();
		error  = new PriorityQueue<Resource>();
		done   = new PriorityQueue<Resource>(); 
	}
	
	public static ResourceManager getInstance()
	{
		if (instance == null) instance = new ResourceManager();
		return instance;
	}
	
	private void add(Resource res)
	{		
		toLoad.add(res);
		ready=false;
	}
	
	public <T> void load(T resource)
	{
		Resource<T> res = new Resource<T>();
		res.setResource(resource);
		add(res);
	}
	
	public void loadResources()
	{
		while(!toLoad.isEmpty())
		{
			(toLoad.poll()).load();		
		}
		
		int i = retry;
		while(!error.isEmpty() &&(i!=0) )
		{
			(error.poll()).load();
			--i;
		}
		ready=true;
	}
	
	public void addError(Resource resource)
	{
		error.add(resource);
		ready=false;
	}
	
	public void addDone(Resource resource)
	{
		done.add(resource);
	}
	
	public boolean isReady()
	{
		return ready;
	}
		
}
	

