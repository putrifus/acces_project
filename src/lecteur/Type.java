package lecteur;

public enum Type {
	PORTE("porte"), BARIERE("bariere"), IMPRIMANTE("imprimante");

	private String _strType;

	private Type(String str) {
		this._strType = str;
	}

	public String get_strType() {
		return _strType;
	}
}
