package forscene.core.entities;

import playn.core.AbstractSound;
import playn.core.Image;
import playn.core.PlayN;
import playn.core.ResourceCallback;
import playn.core.Sound;

public class Resource<T> implements Comparable<T>
	{
		private ResourceState state = ResourceState.TOLOAD;
		private T _res;
		private ResourceCallback<T> _resCB;
		
		public void load()
		{			
			/*_resCB = new ResourceCallback<T>() {
			    
				@Override
				public void done(T resource) {
			    	PlayN.log().debug("Image Loaded");
			    	_done();			    
			    }
				
			    
				@Override
			    public void error(Throwable err) {
			      PlayN.log().error("Failed to load paddle image", err);
			      _error();			      
			    }
			};*/
			
			if (_res instanceof Image)
			{
				((Image)(_res)).addCallback((ResourceCallback<? super Image>) new ResourceCallback<T>() {
					public void done(T resource) {
						PlayN.log().debug("Resource" + resource +" Loaded");
						_done();
						};
					public void error(Throwable err) {
						PlayN.log().debug("Resource load error: " + err);
						_error();						
					}
				});
			}
			
			if ((_res instanceof Sound) ||  (_res instanceof AbstractSound))
			{
				((Sound)(_res)).addCallback((ResourceCallback<? super Sound>) new ResourceCallback<T>() {
					public void done(T resource) {
						PlayN.log().debug("Resource" + resource +" Loaded");
						_done();
					};
						
					public void error(Throwable err) {
						PlayN.log().debug("Resource load error: " + err);
						_error();						
					}
				});
			}
						
		}
		
		public void setResource(T resource)
		{
			_res = resource;
		}
		
			
		private void _done()
		{
			state = ResourceState.DONE;
			ResourceManager.getInstance().addDone(this);
		}
		
		private void _error()
		{
			state = ResourceState.ERROR;
			ResourceManager.getInstance().addError(this);
		}

		public int compareTo(T o) {
			if (_res == o) return 0;
			else return 1;
		}
	}