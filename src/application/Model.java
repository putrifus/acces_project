package application;

import badge.Badge;
import badge.BadgeDAO;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lecteur.Ressource;
import lecteur.RessourceDAO;

public class Model {
	private BadgeDAO bdao = BadgeDAO.BadgeDAOsingleton();

	public Model() {
	}

	public void genererBadge() {
		bdao.create();
	}

	public void setBadge(TableView<Badge> tabB, TableColumn<Badge, Integer> idB, TableColumn<Badge, Boolean> blockB) {
		idB = new TableColumn<Badge, Integer>("ID BADGE");
		blockB = new TableColumn<Badge, Boolean>("LOCK");

		tabB.setItems(BadgeDAO.BadgeDAOsingleton().importation());
		idB.setCellValueFactory(new PropertyValueFactory<Badge, Integer>("_id"));
		blockB.setCellValueFactory(new PropertyValueFactory<Badge, Boolean>("_bloquer"));
		tabB.getColumns().clear();
		tabB.getColumns().add(idB);
		tabB.getColumns().add(blockB);
	}

	public void setRessource(TableView<Ressource> tabR, TableColumn<Ressource, String> idR,
			TableColumn<Ressource, String> typeR, TableColumn<Ressource, String> nomR,
			TableColumn<Ressource, Boolean> lockR, TableColumn<Ressource, String> grp1R,
			TableColumn<Ressource, String> grp2R, TableColumn<Ressource, String> grp3R,
			TableColumn<Ressource, String> grp4R) {

		idR = new TableColumn<Ressource, String>("ID RESSOURCE");
		typeR = new TableColumn<Ressource, String>("TYPE");
		nomR = new TableColumn<Ressource, String>("NOM");
		lockR = new TableColumn<Ressource, Boolean>("LOCK");
		grp1R = new TableColumn<Ressource, String>("GROUP 1");
		grp2R = new TableColumn<Ressource, String>("GROUP 2");
		grp3R = new TableColumn<Ressource, String>("GROUP 3");
		grp4R = new TableColumn<Ressource, String>("GROUP 4");

		tabR.setItems(RessourceDAO.RessourceDAOsingleton().importation());
		idR.setCellValueFactory(new PropertyValueFactory<Ressource, String>("_id"));
		typeR.setCellValueFactory(new PropertyValueFactory<Ressource, String>("_t"));
		nomR.setCellValueFactory(new PropertyValueFactory<Ressource, String>("_nom"));
		grp1R.setCellValueFactory(new PropertyValueFactory<Ressource, String>("_grp1"));
		grp2R.setCellValueFactory(new PropertyValueFactory<Ressource, String>("_grp2"));
		grp3R.setCellValueFactory(new PropertyValueFactory<Ressource, String>("_grp3"));
		grp4R.setCellValueFactory(new PropertyValueFactory<Ressource, String>("_grp4"));
		lockR.setCellValueFactory(new PropertyValueFactory<Ressource, Boolean>("_bloque"));

		tabR.getColumns().clear();
		tabR.getColumns().add(idR);
		tabR.getColumns().add(typeR);
		tabR.getColumns().add(nomR);
		tabR.getColumns().add(grp1R);
		tabR.getColumns().add(grp2R);
		tabR.getColumns().add(grp3R);
		tabR.getColumns().add(grp4R);
		tabR.getColumns().add(lockR);
	}

	public void lockR(Ressource sI) {
		RessourceDAO.RessourceDAOsingleton().delete(sI);
	}

}
