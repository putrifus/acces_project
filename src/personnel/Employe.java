package personnel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Employe {
	private SimpleStringProperty _identite;
	private SimpleIntegerProperty _idB;
	private SimpleStringProperty _grp;
	private SimpleStringProperty _arret;

	public String get_identite() {
		return _identite.get();
	}

	public Integer get_idB() {
		return _idB.get();
	}

	public String get_grp() {
		return _grp.get();
	}

	public String get_arret() {
		return _arret.get();
	}
}
