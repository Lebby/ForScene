/*
 * 
 */
package forscene.core.objects;

import java.util.ArrayList;

import forscene.core.entities.AbstractScene;
import forscene.core.entities.AbstractSceneGroup;

// TODO: Auto-generated Javadoc
/**
 * The Class DefaultSceneGroup.
 */
public class DefaultSceneGroup extends AbstractSceneGroup{
	
	/** The instance. */
	private static AbstractSceneGroup instance = null;
	
	/**
	 * Instantiates a new default scene group.
	 */
	private DefaultSceneGroup() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.AbstractSceneGroup#build()
	 */
	@Override
	public ArrayList<AbstractScene> build() {		
		return getScenes();
	}
	
	/**
	 * Gets the single instance of DefaultSceneGroup.
	 *
	 * @return single instance of DefaultSceneGroup
	 */
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
