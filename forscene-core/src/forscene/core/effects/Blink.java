package forscene.core.effects;

import forscene.core.entities.AbstractEffect;

public class Blink extends AbstractEffect{

	@Override
	public void goNext() {
		if (this.getRoot().alpha() == 0f )
		this.getRoot().setAlpha(1);
		else this.getRoot().setAlpha(0);
		//this.redraw();
		
	}

	@Override
	public void run() {
		goNext();		
	}

	

}
