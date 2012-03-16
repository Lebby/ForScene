
package ${package}.scenes;

import forscene.core.entities.AbstractScene;
import forscene.exceptions.IDAlreadyPresentException;
import forscene.exceptions.NoNameException;
import ${package}.objects.PlayNDefaultBackground;

// Simple scene that load an object ... 
public class FirstScene extends AbstractScene{

	@Override
	public void build() {
		try {
			addSceneObject((new PlayNDefaultBackground()));
		} catch (NoNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IDAlreadyPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}

	@Override
	public void updateState() {
		//this is a static scene ... then nothing to update!				
	}
	

}
 