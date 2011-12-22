package forscene.core.effects;

import playn.core.PlayN;

public class FadeOut extends FadeIn{
	public FadeOut() {
		setStep(-0.1f);
		setStartAlpha(1f);
		setEndAlpha(0);
		setCurrentAlpha(getStartAlpha());
	}
	
	@Override
	public void goNext() {		
		this.getRoot().setAlpha(getCurrentAlpha());
		if (getCurrentAlpha() == getEndAlpha()) this.stop();
		else
			setCurrentAlpha(getCurrentAlpha()+getStep());		
	}

	

}
