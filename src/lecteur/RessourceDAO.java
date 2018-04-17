package lecteur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import badge.Badge;
import badge.BadgeDAO;
import bdd.DAOManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RessourceDAO extends DAOManager<Ressource> {
	private static RessourceDAO rd = new RessourceDAO();
	private ObservableList<Ressource> ol = FXCollections.observableArrayList();

	private RessourceDAO() {
	}

	public static RessourceDAO RessourceDAOsingleton() {
		return rd;
	}

	@Override
	public StringBuffer find(StringBuffer strb) {
		// recherche
		return null;
	}

	@Override
	public Ressource create() {
		// créer une ressource
		return null;
	}

	@Override
	public void delete(Ressource obj) {
		// verrouille une ressource
		try {
			PreparedStatement stm = this.connect.prepareStatement("UPDATE acces.ressources SET bloquer = true where idRessource = ?");
			stm.setString(1, obj.get_id());
			stm.executeUpdate();
			for (int i = 0; i < ol.size(); i++) {
				if (ol.get(i).get_id().equals(obj.get_id()))
						ol.get(i).lockRessource();
			}
			//obj.lockRessource();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Ressource update(Ressource obj) {
		// afecte un grp a une ressource
		return null;
	}

	@Override
	public ObservableList<Ressource> importation() {
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM acces.ressources");
			while (result.next()) {
				Ressource r = new Ressource(result.getString(1), result.getString(2),result.getString(3), result.getBoolean(4),
						result.getBoolean(5), result.getBoolean(6), result.getBoolean(7), result.getBoolean(8));
				ol.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("pb importation ressource");
		}
		return ol;
	}

}
