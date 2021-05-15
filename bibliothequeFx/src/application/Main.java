package application;

import java.io.File;
import java.net.URISyntaxException;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
	
public void Accueil() throws URISyntaxException{
	Image image = new Image(getClass().getResource("/image.png").toURI().toString());
	
		ImageView imageView=new ImageView();
		imageView.setImage(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		
		Image image1 = new Image(getClass().getResource("/images.png").toURI().toString());
		
		ImageView imageView1=new ImageView();
		imageView1.setImage(image1);
		imageView1.setFitHeight(30);
		imageView1.setFitWidth(30);
		
		Image image2 = new Image(getClass().getResource("/image1.png").toURI().toString());
		
		ImageView imageView2=new ImageView();
		imageView2.setImage(image2);
		imageView2.setFitHeight(30);
		imageView2.setFitWidth(30);
		
		Image image3 = new Image(getClass().getResource("/image2.png").toURI().toString());
		
		ImageView imageView3=new ImageView();
		imageView3.setImage(image3);
		imageView3.setFitHeight(30);
		imageView3.setFitWidth(30);
		
		Image image4 = new Image(getClass().getResource("/image3.png").toURI().toString());
		
		ImageView imageView4=new ImageView();
		imageView4.setImage(image4);
		imageView4.setFitHeight(30);
		imageView4.setFitWidth(30);
		BorderPane bord =new BorderPane();
		VBox vBox=new VBox();
		 Button ajoutliv = new Button("Ajouter Livre");
		 ajoutliv.setMaxSize(142, 142);
		 ajoutliv.setMinSize(100, 100);
		 ajoutliv.setStyle("-fx-focus-color: transparent;  -fx-background-insets: 0, 1, 2; -fx-background-radius: 5, 4, 3;");
		 ajoutliv.setGraphic(imageView);
		 Button ajoutemp = new Button("Ajouter Emprunt");
		 ajoutemp.setMaxSize(142, 142);
		 ajoutemp.setMinSize(100, 100);
		 ajoutemp.setStyle("-fx-focus-color: transparent;  -fx-background-insets: 0, 1, 2; -fx-background-radius: 5, 4, 3;");
		 ajoutemp.setGraphic(imageView2);
		 Button listLiv = new Button("Liste des Livre");
		 listLiv.setMaxSize(142, 142);
		 listLiv.setMinSize(100, 100);
		 listLiv.setStyle("-fx-focus-color: transparent;  -fx-background-insets: 0, 1, 2; -fx-background-radius: 5, 4, 3;");
		 listLiv.setGraphic(imageView3);
		 Button listEmp = new Button("Liste des Emprunts");
		 listEmp.setMaxSize(142, 142);
		 listEmp.setMinSize(100, 100);
		 listEmp.setStyle("-fx-focus-color: transparent;  -fx-background-insets: 0, 1, 2; -fx-background-radius: 5, 4, 3;");
		 
		 listEmp.setGraphic(imageView1);
		 Button listEtud = new Button("Liste des Etudiants");
		 listEtud.setMaxSize(142, 142);
		 listEtud.setMinSize(100, 100);
		 listEtud.setStyle("-fx-focus-color: transparent;  -fx-background-insets: 0, 1, 2; -fx-background-radius: 5, 4, 3;");
		 listEtud.setGraphic(imageView4);
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
			menu();
		bord.setRight(vBox);
		
		root.setCenter(bord);
		System.out.println("Bienvenue ");
	}
	
	
	public void menu(){
		Menu fichier =new Menu("Accueil");
		MenuItem Accueil=new MenuItem("Retour à la page d'accueil");
		MenuItem deconnecte=new MenuItem("Se Déconnecté");
		
		Menu Fichier =new Menu("Fichier");
		MenuItem editerlv=new MenuItem("Editer Livre");
		MenuItem editerEmp=new MenuItem("Editer Emprunt");
		MenuItem suppLv=new MenuItem("Supprimer livre");
		MenuItem suppEmp=new MenuItem("Supprimer Emprunt");
		
		Menu help =new Menu("Aide");
		
		
		Fichier.getItems().addAll(editerlv,editerEmp,suppLv,suppEmp);
		fichier.getItems().addAll(Accueil);
		Controller c1=new Controller(root);
		
		
		
		
		
		Accueil.setOnAction((e->{
			try {
				Accueil();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}));
		suppLv.setOnAction((e->{
			c1.supprimerlivre();

		}));
		suppEmp.setOnAction((e->{
			c1.supprimerEmprunt();

		}));
		editerEmp.setOnAction((e->{
			c1.modifierEmprunt();

		}));
		editerlv.setOnAction((e->{
			c1.ModifierLivre();

		}));

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fichier, Fichier, help);
		root.setTop(menuBar);

		System.out.println("Bienvenue dans notre application");

	}

	public static void main(String[] args) {
		launch(args);
	}
}
