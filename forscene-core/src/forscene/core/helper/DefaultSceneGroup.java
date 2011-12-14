package forscene.core.helper;

import java.util.ArrayList;

import forscene.core.entities.AbstractScene;
import forscene.core.entities.AbstractSceneGroup;

public class DefaultSceneGroup extends AbstractSceneGroup{
	private static AbstractSceneGroup instance = null;
	
	private DefaultSceneGroup() {
		super();
	}
	
	@Override
	public ArrayList<AbstractScene> build() {		
		return getScenes();
	}
	
	public static AbstractSceneGroup getInstance()
	{
		if (instance != null ) return instance;
		instance = new AbstractSceneGroup() {
			
			@Override
			public ArrayList<AbstractScene> build() {
				return getScenes();
			}
		};
		return instance;
	}

}
