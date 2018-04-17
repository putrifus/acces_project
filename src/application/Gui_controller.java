package application;

import java.util.ResourceBundle;

import badge.Badge;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lecteur.Ressource;
import personnel.Employe;

public class Gui_controller {
	// private HashSet<Badge> bdlist;
	// private HashSet<Employe> emplist;
	// private HashSet<Ressource> rslist;
	private Model m = new Model();
	private Badge b = new Badge();
	private Employe e = new Employe();
	private Ressource r = new Ressource();

	@FXML
	private ResourceBundle resources;

	@FXML
	private Tab vue, bdg, emp, arch;

	@FXML
	private Button generer, bloquerR;

	@FXML
	private TableView<Badge> tabB;

	@FXML
	private TableColumn<Badge, Integer> idB;

	@FXML
	private TableColumn<Badge, Boolean> blockB;

	@FXML
	private TableView<Ressource> tabR;

	@FXML
	private TableColumn<Ressource, String> idR, typeR, nomR, grp1R, grp2R, grp3R, grp4R;

	@FXML
	private TableColumn<Ressource, Boolean> lockR;

	public Gui_controller() {
	}

	@FXML
	private void initialize() {
		m.setBadge(tabB, idB, blockB);
		m.setRessource(tabR, idR, typeR, nomR, lockR, grp1R, grp2R, grp3R, grp4R);
	}

	public void generer() {
		m.genererBadge();
	}

	public void bloquerBadge() {

	}

	public void bloquerRessource() {
		m.lockR(tabR.getSelectionModel().getSelectedItem());
	}
}
