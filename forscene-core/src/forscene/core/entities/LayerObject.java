package forscene.core.entities;

import playn.core.Layer;

public interface LayerObject<T extends Layer> {
	T getRoot();
	void setRoot(T root);
}
