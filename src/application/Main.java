package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Acces");
		this.primaryStage.getIcons().add(new Image("iconesecu.png"));
		initRootLayout();
		showVue();
	}

	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("app.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showVue() {
		try {
			// Load la vue
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("gui.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();
			// Gui_controller gc = loader.getController();
			// c est l'instance du Gui_controller de notre fxml

			// Set vue into the root layout.
			rootLayout.setCenter(personOverview);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
		// System.out.println(LocalDateTime.now());
	}
}
