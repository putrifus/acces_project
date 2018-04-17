package personnel;

import java.util.ArrayList;

import bdd.DAOManager;
import javafx.collections.ObservableList;

public class EployeDAO extends DAOManager<Employe> {

	@Override
	public StringBuffer find(StringBuffer strb) {
		return null;
	}

	@Override
	public Employe create() {
		return null;
	}

	@Override
	public Employe update(Employe obj) {
		return null;
	}

	@Override
	public void delete(Employe obj) {
		//toto
		System.out.println("toto");

	}

	@Override
	public ObservableList<Employe> importation() {
		return null;
	}

}
