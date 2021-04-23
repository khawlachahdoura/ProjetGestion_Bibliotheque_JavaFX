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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	BorderPane root = new BorderPane();
	GererLivre gLivre = new GererLivre(new ImpDAOGererLivre());
	@Override
	public void start(Stage primaryStage) {
		 primaryStage.setTitle("Gestion Bibliothèque");
		 
		try {
			Parent root = FXMLLoader.load(getClass().getResource("vue.fxml"));
			
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			//menu();
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	Controller c1=new Controller(root);
	private Button ajoutlivre = new Button("Ajouter Livre");
	public void AjouterLivre(){
		

			GridPane gridPane = new GridPane();

			gridPane.setPadding(new Insets(70, 70, 70, 70));
			gridPane.setHgap(10);
			gridPane.setVgap(10);

			
	       BorderPane border =new BorderPane();
	       Button btnadd = new Button("Ajouter");
	       Button btnaddexemp = new Button("Ajouter un exemplaire");

			Label nom = new Label("Ajouter un livre :");
			nom.setStyle("-fx-alignment: CENTER;-fx-focus-color: violet;"); 
			nom.setFont(new Font("Arial", 20));
			nom.setTextFill(Color.VIOLET);
			gridPane.add(nom, 0, 0);

			Label isbn = new Label("ISBN : ");
			
			final TextField txtisbn = new TextField();
			

			isbn.setStyle("-fx-alignment: CENTER;"); 
			isbn.setFont(new Font("Arial", 15));
			Label titre = new Label("Titre : ");
			final TextField txttitre = new TextField();
			titre.setStyle("-fx-alignment: CENTER;"); 
			titre.setFont(new Font("Arial", 15));
			Label theme = new Label("Theme : ");
			final TextField txttheme = new TextField();
			
			theme.setStyle("-fx-alignment: CENTER;"); 
			theme.setFont(new Font("Arial", 15));
			Label auteur = new Label("Auteur : ");
			final TextField txtauteur = new TextField();
			auteur.setStyle("-fx-alignment: CENTER;"); 
			auteur.setFont(new Font("Arial", 15));
			Label codeexemplaire = new Label("Code exemplaire : ");
			final TextField txtcode = new TextField();
			codeexemplaire.setStyle("-fx-alignment: CENTER;"); 
			codeexemplaire.setFont(new Font("Arial", 15));

			Button btnajouter = new Button("Ajouter");
			final Label lblMessage = new Label();
			Label ajouterexp = new Label("Ajouter un exemplaire pour ce livre :");
			ajouterexp.setStyle("-fx-alignment: CENTER;-fx-focus-color: violet;"); 
			ajouterexp.setFont(new Font("Arial", 20));
			ajouterexp.setTextFill(Color.VIOLET);
			final Label lblMessage1 = new Label();
			gridPane.add(ajouterexp, 0, 6);
			gridPane.add(lblMessage1, 1, 8);
			gridPane.add(codeexemplaire, 0, 7);
			gridPane.add(txtcode, 1, 7);
			
			gridPane.add(btnajouter, 0, 5);
			gridPane.add(btnaddexemp, 0,8);
			gridPane.add(lblMessage, 1, 5);
			
			gridPane.add(isbn, 0, 1);
			gridPane.add(txtisbn, 1,1);
			gridPane.add(titre, 0, 2);
			gridPane.add(txttitre, 1, 2);
			gridPane.add(theme, 0, 3);
			gridPane.add(txttheme, 1, 4);
			gridPane.add(auteur, 0, 4);
			gridPane.add(txtauteur, 1, 3);
			
			btnajouter.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					//String checkUser = txtUserName.getText().toString();
					int isbn=Integer.parseInt(txtisbn.getText());
					String titre= txttitre.getText();
					String theme= txttheme.getText();
					String auteur= txtauteur.getText();
					
					
					Livre livre = new Livre(isbn, titre, theme, auteur);

					boolean test = gLivre.addLivre(livre);
					if (test) {
						lblMessage.setText("livre ajouté avec succé");
						lblMessage.setTextFill(Color.GREEN);
						//creerTableViewLivre();

					} else {
						lblMessage.setText("Erreur ");
						lblMessage.setTextFill(Color.RED);
					}
					
				}
			});

			btnaddexemp.setOnAction(new EventHandler<ActionEvent>() {
				
				public void handle(ActionEvent event) {

					int isbn=Integer.parseInt(txtisbn.getText());
					String titre= txttitre.getText();
					String theme= txttheme.getText();
					String auteur= txtauteur.getText();
					int code=Integer.parseInt(txtcode.getText());
					
					Livre livre = new Livre(isbn, titre, theme, auteur);
	                Exemplaire exemplaire= new Exemplaire(isbn,titre,theme,auteur,code);
					boolean test = gLivre.ajouterexemplaire(exemplaire);
					if (test) {
						lblMessage.setText("exemplaire ajouté avec succé");
						lblMessage.setTextFill(Color.GREEN);
						//creerTableViewLivre();

					} else {
						lblMessage1.setText("erreur ");
						lblMessage1.setTextFill(Color.RED);
					}
					
				}
			});
			root.setCenter(gridPane);

			
		
		
		System.out.println("Menu affiché avec succée");
	} 
	
	
	/*public void menu(){
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
		*/
	
	public static void main(String[] args) {
		launch(args);
	}
}
