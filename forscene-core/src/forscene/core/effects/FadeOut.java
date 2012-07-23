/*
 * 
 */
package forscene.core.effects;

// TODO: Auto-generated Javadoc
/**
 * The Class FadeOut.
 */
public class FadeOut extends FadeIn{
	
	/**
	 * Instantiates a new fade out.
	 */
	public FadeOut() {
		setStep(-0.1f);
		setStartAlpha(1f);
		setEndAlpha(0);
		setCurrentAlpha(getStartAlpha());
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.effects.FadeIn#goNext()
	 */
	@Override
	public void goNext() {		
		this.getRoot().setAlpha(getCurrentAlpha());
		if (getCurrentAlpha() == getEndAlpha()) this.stop();
		else
			setCurrentAlpha(getCurrentAlpha()+getStep());		
	}

	

}
