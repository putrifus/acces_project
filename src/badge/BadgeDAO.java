package badge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bdd.DAOManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BadgeDAO extends DAOManager<Badge> {
	private static BadgeDAO bd = new BadgeDAO();
	private ObservableList<Badge> ol = FXCollections.observableArrayList();

	private BadgeDAO() {
	}

	public static BadgeDAO BadgeDAOsingleton() {
		return bd;
	}

	private int generateId() {
		int id = 0;

		while (id < 100000 || id > 999999)
			id = (int) (Math.random() * 1000000 - 1);
		return id;
	}

	@Override
	public Badge create() {
		// genere un badge d'id random
		int id = generateId();
		System.out.println(id);

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT id FROM badge where id = " + id);
			if (result.next())
				create();
			PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO badge VALUES(?, ?)");
			prepare.setInt(1, id);
			prepare.setBoolean(2, false);
			prepare.executeUpdate();
			Badge b = new Badge(id, false);
			ol.add(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Badge b = new Badge(id, false);
		return b;
	}

	@Override
	public void delete(Badge b) {
		/* on désactive définitivement le badge pas de retour possible */
		try {
			PreparedStatement prepare = this.connect
					.prepareStatement("UPDATE acces.badge SET bloquer=1 where id=" + b.get_id());
			prepare.setBoolean(2, true);
			// prepare.setDate(3, null);
			prepare.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public StringBuffer find(StringBuffer strb) {
		// n'existe pas pour un badge
		return null;
	}

	@Override
	public Badge update(Badge obj) {
		// ajoute un arret de travail jusqu'à une date donnée
		return null;
	}

	@Override
	public ObservableList<Badge> importation() {
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM acces.badge");
			while (result.next()) {
				Badge b = new Badge(result.getInt(1), result.getBoolean(2));
				ol.add(b);
			}
		} catch (SQLException e) {
			System.out.println("pb importation badge");
		}
		return ol;
	}
}
