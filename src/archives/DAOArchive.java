package archives;

import bdd.DAOManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAOArchive extends DAOManager<Archive> {
	private static DAOArchive bd = new DAOArchive();
	private ObservableList<Archive> ol = FXCollections.observableArrayList();

	private DAOArchive() {
	}

	public static DAOArchive BadgeDAOsingleton() {
		return bd;
	}

	@Override
	public StringBuffer find(StringBuffer strb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Archive create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Archive update(Archive obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Archive obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public ObservableList<Archive> importation() {

		return null;
	}

}
