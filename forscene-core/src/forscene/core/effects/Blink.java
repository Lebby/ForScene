/*
 * 
 */
package forscene.core.effects;

import forscene.core.entities.toTest.AbstractEffect;

// TODO: Auto-generated Javadoc
/**
 * The Class Blink.
 */
public class Blink extends AbstractEffect{

	/* (non-Javadoc)
	 * @see forscene.core.entities.toTest.AbstractAnimation#goNext()
	 */
	@Override
	public void goNext() {
		if (this.getRoot().alpha() == 0f )
		this.getRoot().setAlpha(1);
		else this.getRoot().setAlpha(0);		
	}

	/* (non-Javadoc)
	 * @see forscene.core.entities.toTest.AbstractAnimation#run()
	 */
	@Override
	public void run() {
		goNext();		
	}

	

}
