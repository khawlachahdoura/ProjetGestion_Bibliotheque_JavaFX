package application;
	
import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	BorderPane root = new BorderPane();
	@Override
	public void start(Stage primaryStage) {
		 primaryStage.setTitle("Gestion Bibliothèque");
		 
		try {
			//BorderPane root = new BorderPane();
			Scene scene = new Scene(root,700,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			menu();
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void menu(){
		Menu chap =new Menu("Etudiant");
		MenuItem liste=new MenuItem("Liste des étudiants");
		
		Menu livre =new Menu("Livres");
		MenuItem ajoutlivre=new MenuItem("Ajouter un livre");
		MenuItem listelivre=new MenuItem("Liste des livres");
		
		MenuItem quiter=new MenuItem("Quiter l'application");
		
		chap.getItems().addAll(liste);
		livre.getItems().addAll(ajoutlivre,listelivre);
		
		Controller c1=new Controller(root);
		Menu exam= new Menu("Emprunt");
		MenuItem listeexam=new MenuItem("Liste des emprunts");
		MenuItem ajoutEmprunt=new MenuItem("Ajouter un nouveau Emprunt");
		
		exam.getItems().addAll(listeexam,ajoutEmprunt);
		
		listeexam.setOnAction((e->{
			c1.creerTableViewEmprunt();
			
		}));
		ajoutEmprunt.setOnAction((e->{
			c1.ajoutEmprunt();
			
		}));
		
		ajoutlivre.setOnAction((e->{
			c1.ajoutLivre();
			
		}));
		
		listelivre.setOnAction((e->{
			c1.creerTableViewLivre();
			
		}));
		
		liste.setOnAction((e->{
			c1.creerTableViewEtudiant();
			
		}));
		Menu importer= new Menu("Importer et Exporter");
		

		MenuItem alimenterBD=new MenuItem("Alimenter la base de données");
		MenuItem exporter=new MenuItem("Exporter les livres");
		
		
		importer.getItems().addAll(alimenterBD,exporter);
		alimenterBD.setOnAction((e->{
			
			
		}));
		exporter.setOnAction((e->{
			
		}));
		
		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(chap,livre,exam);
		root.setTop(menuBar);
		System.out.println("Menu affiché avec succée");
	}
		
	
	public static void main(String[] args) {
		launch(args);
	}
}
