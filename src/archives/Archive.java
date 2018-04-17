package archives;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Archive {
	private SimpleStringProperty _date, _identite, _autorisation;
	private SimpleIntegerProperty _idBadge, _idRess;

	public Archive(String a, String z, String e, int r, int t) {
		_date = new SimpleStringProperty(a);
		_identite = new SimpleStringProperty(z);
		_autorisation = new SimpleStringProperty(e);
		_idBadge = new SimpleIntegerProperty(r);
		_idRess = new SimpleIntegerProperty(t);
	}
}
