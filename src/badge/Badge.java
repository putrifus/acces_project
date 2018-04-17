package badge;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Badge {
	private SimpleIntegerProperty _id;
	private SimpleBooleanProperty _bloquer;

	public Badge() {
	}

	public Badge(int id, Boolean lc) {
		_id = new SimpleIntegerProperty(id);
		_bloquer = new SimpleBooleanProperty(lc);
	}

	public int get_id() {
		return _id.get();
	}
	
	public boolean get_bloquer() {
		return _bloquer.get();
	}

	public void set_lock() {
		_bloquer = new SimpleBooleanProperty(true);
	}

	public Boolean equals(Badge b) {
		if (this._id.get() == b._id.get())
			return true;
		else
			return false;
	}
}
