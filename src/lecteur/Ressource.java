package lecteur;

public class Ressource {
	private String _id, _nom;
	private /* Type */ String _t;
	private Boolean _grp1, _grp2, _grp3, _grp4, _bloque;

	public Ressource() {
	}

	public Ressource(String str, String t,String nom, Boolean grp1, Boolean grp2, Boolean grp3, Boolean grp4, Boolean b) {
		_id = str;
		_t = t;
		set_nom(nom);
		_grp1 = grp1;
		_grp2 = grp2;
		_grp3 = grp3;
		_grp4 = grp4;
		_bloque = b;
	}

	public void lockRessource() {
		_bloque = true;
	}

	public void unlockRessource() {
		_bloque = false;
	}

	public String get_id() {
		return _id;
	}

	public String get_t() {
		return _t;
	}

	public String get_nom() {
		return _nom;
	}

	public void set_nom(String _nom) {
		this._nom = _nom;
	}

	public Boolean get_bloque() {
		return _bloque;
	}

	public Boolean get_grp1() {
		return _grp1;
	}

	public Boolean get_grp2() {
		return _grp2;
	}

	public Boolean get_grp3() {
		return _grp3;
	}

	public Boolean get_grp4() {
		return _grp4;
	}

	public String toString() {
		return String.format("id:%s type:%s lock:%b  group 1:%b 2:%b 3:%b 4:%b", _id, _t, _bloque, _grp1, _grp2, _grp3,
				_grp4);
	}
}
