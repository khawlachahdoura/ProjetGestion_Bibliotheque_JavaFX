package application;

import Business.GererLivre;
import Entities.Exemplaire;
import Entities.Livre;
import ImpDAO1.ImpDAOGererLivre;
import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import view.View;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application {
	View view = new View();
	BorderPane root = new BorderPane();
	GererLivre gLivre = new GererLivre(new ImpDAOGererLivre());

	@Override
	public void start(Stage primaryStage) {

		 primaryStage.setTitle("Gestion Bibliothèque");
		 

		primaryStage.setTitle("Gestion Biblioth�que");


		try {
			// Parent root =
			// FXMLLoader.load(getClass().getResource("vue.fxml"));

			Scene scene = new Scene(root, 800, 525);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			Accueil();
			menu();
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Controller c1=new Controller(root);
public void Accueil(){
	//Image image = new Image("images:téléchargement(1).png");
		ImageView imageView=new ImageView();
		//imageView.setImage(image);
		BorderPane bord =new BorderPane();
		VBox vBox=new VBox();
		 Button ajoutliv = new Button("Ajouter Livre");
		 ajoutliv.setMaxSize(142, 142);
		 ajoutliv.setMinSize(100, 100);
		 ajoutliv.setStyle("-fx-focus-color: transparent;  -fx-background-insets: 0, 1, 2; -fx-background-radius: 5, 4, 3;");
		// ajoutliv.setGraphic(imageView);
		 Button ajoutemp = new Button("Ajouter Emprunt");
		 ajoutemp.setMaxSize(142, 142);
		 ajoutemp.setMinSize(100, 100);
		 ajoutemp.setStyle("-fx-focus-color: transparent;  -fx-background-insets: 0, 1, 2; -fx-background-radius: 5, 4, 3;");
		 Button listLiv = new Button("Liste des Livre");
		 listLiv.setMaxSize(142, 142);
		 listLiv.setMinSize(100, 100);
		 listLiv.setStyle("-fx-focus-color: transparent;  -fx-background-insets: 0, 1, 2; -fx-background-radius: 5, 4, 3;");
		 Button listEmp = new Button("Liste des Emprunts");
		 listEmp.setMaxSize(142, 142);
		 listEmp.setMinSize(100, 100);
		 listEmp.setStyle("-fx-focus-color: transparent;  -fx-background-insets: 0, 1, 2; -fx-background-radius: 5, 4, 3;");
		 Button listEtud = new Button("Liste des Etudiants");
		 listEtud.setMaxSize(142, 142);
		 listEtud.setMinSize(100, 100);
		 listEtud.setStyle("-fx-focus-color: transparent;  -fx-background-insets: 0, 1, 2; -fx-background-radius: 5, 4, 3;");
		 vBox.getChildren().add(ajoutliv);
		 vBox.getChildren().add(ajoutemp);
		 vBox.getChildren().add(listLiv);
		 vBox.getChildren().add(listEmp);
		 vBox.getChildren().add(listEtud);
		

		 listEmp.setOnAction((e->{
				c1.creerTableViewEmprunt();
				
			}));
		 ajoutemp.setOnAction((e->{
				c1.ajoutEmprunt();
				
			}));
			
			ajoutliv.setOnAction((e->{
				c1.ajoutLivre();
				
			}));
			
			listLiv.setOnAction((e->{
				c1.creerTableViewLivre();
				
			}));
			
			listEtud.setOnAction((e->{
				c1.creerTableViewEtudiant();
				
			}));
		bord.setRight(vBox);
		
		root.setCenter(bord);
		System.out.println("Bienvenue ");
	}
	
	
	public void menu(){
		Menu fichier =new Menu("Accueil");
		MenuItem Accueil=new MenuItem("Retour à la page d'accueil");
		
		Menu Fichier =new Menu("Fichier");
		MenuItem editer=new MenuItem("Editer");
		MenuItem supp=new MenuItem("Supprimer");
		
		Menu help =new Menu("Aide");
		
		
		Fichier.getItems().addAll(editer,supp);
		fichier.getItems().addAll(Accueil);
		Controller c1=new Controller(root);
		
		
		
		
		Accueil.setOnAction((e->{
			Accueil();
			

	//Controller c1 = new Controller(root);

	/*public void Accueil() {
		// Image image = new Image("images/t�l�chargement(1).png");
		ImageView imageView = new ImageView();
		// imageView.setImage(image);
		BorderPane bord = new BorderPane();
		VBox vBox = new VBox();
		Button ajoutliv = new Button("Ajouter Livre");
		ajoutliv.setMaxSize(142, 142);
		ajoutliv.setMinSize(100, 100);
		ajoutliv.setStyle(
				"-fx-focus-color: transparent;  -fx-background-insets: 0, 1, 2; -fx-background-radius: 5, 4, 3;");
		// ajoutliv.setGraphic(imageView);
		Button ajoutemp = new Button("Ajouter Emprunt");
		ajoutemp.setMaxSize(142, 142);
		ajoutemp.setMinSize(100, 100);
		ajoutemp.setStyle(
				"-fx-focus-color: transparent;  -fx-background-insets: 0, 1, 2; -fx-background-radius: 5, 4, 3;");
		Button listLiv = new Button("Liste des Livre");
		listLiv.setMaxSize(142, 142);
		listLiv.setMinSize(100, 100);
		listLiv.setStyle(
				"-fx-focus-color: transparent;  -fx-background-insets: 0, 1, 2; -fx-background-radius: 5, 4, 3;");
		Button listEmp = new Button("Liste des Emprunts");
		listEmp.setMaxSize(142, 142);
		listEmp.setMinSize(100, 100);
		listEmp.setStyle(
				"-fx-focus-color: transparent;  -fx-background-insets: 0, 1, 2; -fx-background-radius: 5, 4, 3;");
		Button listEtud = new Button("Liste des Etudiants");
		listEtud.setMaxSize(142, 142);
		listEtud.setMinSize(100, 100);
		listEtud.setStyle(
				"-fx-focus-color: transparent;  -fx-background-insets: 0, 1, 2; -fx-background-radius: 5, 4, 3;");
		vBox.getChildren().add(ajoutliv);
		vBox.getChildren().add(ajoutemp);
		vBox.getChildren().add(listLiv);
		vBox.getChildren().add(listEmp);
		vBox.getChildren().add(listEtud);

		listEmp.setOnAction((e -> {
			c1.creerTableViewEmprunt();


		}));
		ajoutemp.setOnAction((e -> {
			c1.ajoutEmprunt();

		}));

		ajoutliv.setOnAction((e -> {
			c1.ajoutLivre();

		}));

		listLiv.setOnAction((e -> {
			c1.creerTableViewLivre();

		}));

		listEtud.setOnAction((e -> {
			c1.creerTableViewEtudiant();

		}));
		bord.setRight(vBox);

		root.setCenter(bord);

	}

	/*public void menu() {
		Menu fichier = new Menu("Accueil");
		MenuItem Accueil = new MenuItem("Retour � la page d'accueil");

		Menu Fichier = new Menu("Fichier");
		MenuItem editer = new MenuItem("Editer");
		MenuItem supp = new MenuItem("Supprimer un Emprunt");
		MenuItem supplivr = new MenuItem("Supprimer un livre");
		Menu help = new Menu("Aide");

		Fichier.getItems().addAll(editer, supp, supplivr);
		fichier.getItems().addAll(Accueil);
		Controller c1 = new Controller(root);

		supplivr.setOnAction((e -> {
			c1.supprimerlivre();

		}));
		supp.setOnAction((e -> {
			c1.supprimerEmprunt();

		}));

		Accueil.setOnAction((e -> {
			Accueil();*/

		}));

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fichier, Fichier, help);
		root.setTop(menuBar);
		System.out.println("Menu affiché avec succée");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
