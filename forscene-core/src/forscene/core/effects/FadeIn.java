package forscene.core.effects;

import forscene.core.entities.AbstractEffect;

public class FadeIn extends AbstractEffect{
	private boolean init=false;
	private float startAlpha =0f;
	private float currentAlpha = startAlpha;
	private float endAlpha =1f;
	private float step = 0.1f;

	@Override
	public void build() {
		super.build();
		this.getRoot().setAlpha(getStartAlpha());
	}
	@Override
	public void goNext() {		
		this.getRoot().setAlpha(currentAlpha);
		if (currentAlpha >= endAlpha) this.stop();
		else
		currentAlpha+=step;
	}

	@Override
	public void run() {
		if (init == false)
		{
			init= true;
			currentAlpha=startAlpha;
		}
		goNext();		
	}

	/**
	 * @return the startAlpha
	 */
	public float getStartAlpha() {
		return startAlpha;
	}

	/**
	 * @param startAlpha the startAlpha to set
	 */
	public void setStartAlpha(float startAlpha) {
		this.startAlpha = startAlpha;
	}

	/**
	 * @return the endAlpha
	 */
	public float getEndAlpha() {
		return endAlpha;
	}

	/**
	 * @param endAlpha the endAlpha to set
	 */
	public void setEndAlpha(float endAlpha) {
		this.endAlpha = endAlpha;
	}

	/**
	 * @return the step
	 */
	public float getStep() {
		return step;
	}

	/**
	 * @param step the step to set
	 */
	public void setStep(float step) {
		this.step = step;
	}
	
	
	public float getCurrentAlpha()
	{
		return currentAlpha;
	}
	
	protected void setCurrentAlpha(float f) {
		this.currentAlpha = f;
		
	}

}
