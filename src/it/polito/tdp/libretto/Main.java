package it.polito.tdp.libretto;
	
import it.polito.libretto.model.Model;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//creazione oggetto esplicito senza utilizzare il metodo statico load() 
			FXMLLoader loader=new FXMLLoader(getClass().getResource("Libretto.fxml"));
			//invocazione del metodo "reale" sull'oggetto
			BorderPane root = (BorderPane)loader.load();
			
			//chiedere al loader l'istanza dell'oggetto di tipo controller creato
			LibrettoController controller=loader.getController();
			//creazione modello
			Model model=new Model();
			//indicazione al controller del modello da utilizzare
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
