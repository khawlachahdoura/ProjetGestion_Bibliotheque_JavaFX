package controller;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;


import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import Business.GererLivre;
import Business.GererNouveauEmprunt;
import Entities.Emprunt;
import Entities.Etudiant;
import Entities.Livre;
import ImpDAO1.ImpDAOGererLivre;
import ImpDAO1.ImpDAOGererNouveauEmp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.DAOEtudiant;
import view.View;

public class Controller {
	static GererNouveauEmprunt gEmprunt = new GererNouveauEmprunt(new ImpDAOGererNouveauEmp());
	GererLivre gLivre = new GererLivre(new ImpDAOGererLivre());
	private BorderPane root;
	static boolean test = true;
	static int val;
	static Scanner sc = new Scanner(System.in);
View view= new View();
	public Controller(BorderPane root) {
		this.root = root;
	}

	
	public void creerTableViewLivre() {

		TableView<Livre> tableView = new TableView<>();
		List<Emprunt> l = new ArrayList<>();
		l = DAOEtudiant.affichelist2();

		TableColumn<Livre, Integer> ISBN = new TableColumn<Livre, Integer>("ISBN");
		TableColumn<Livre, String> titre = new TableColumn<Livre, String>("Titre");
		TableColumn<Livre, String> auteur = new TableColumn<Livre, String>("Theme");
		TableColumn<Livre, String> theme = new TableColumn<Livre, String>("Auteur");

		tableView.getColumns().addAll(ISBN, titre, auteur, theme);

		ISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
		titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
		auteur.setCellValueFactory(new PropertyValueFactory<>("auteur"));
		theme.setCellValueFactory(new PropertyValueFactory<>("theme"));

		ObservableList<Livre> list = getListLivre();
		tableView.setItems(list);
		root.setCenter(tableView);

	}

	public void creerTableViewEmprunt() {

		TableView<Emprunt> tableView = new TableView<>();
		List<Emprunt> l = new ArrayList<>();
		l = DAOEtudiant.affichelist2();

		TableColumn<Emprunt, Integer> idCol = new TableColumn<Emprunt, Integer>("idEmpt");
		TableColumn<Emprunt, Date> DateEmprunt = new TableColumn<Emprunt, Date>("DateEmprunt");
		TableColumn<Emprunt, Date> DateRetour = new TableColumn<Emprunt, Date>("DateRetour");
		TableColumn<Emprunt, Integer> idExemplaire = new TableColumn<Emprunt, Integer>("idExemplaire");
		TableColumn<Emprunt, Integer> idEtudiant = new TableColumn<Emprunt, Integer>("idEtudiant");
		TableColumn<Emprunt, Integer> etat = new TableColumn<Emprunt, Integer>("etat");

		tableView.getColumns().addAll(idExemplaire, idEtudiant, DateEmprunt, DateRetour, etat);

		idCol.setCellValueFactory(new PropertyValueFactory<>("idEmprunt"));
		DateEmprunt.setCellValueFactory(new PropertyValueFactory<>("date_E"));
		DateRetour.setCellValueFactory(new PropertyValueFactory<>("date_RE"));
		idExemplaire.setCellValueFactory(new PropertyValueFactory<>("idExemplaire"));
		idEtudiant.setCellValueFactory(new PropertyValueFactory<>("idEtudiant"));
		etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
		ObservableList<Emprunt> list = getListEmprunt();
		tableView.setItems(list);
		root.setCenter(tableView);

	}

	public static ObservableList<Livre> getListLivre() {

		List<Livre> l = new ArrayList<>();
		l = DAOEtudiant.affichelist3();

		ObservableList<Livre> liste = FXCollections.observableArrayList(l);
		return liste;

	}

	public static ObservableList<Emprunt> getListEmprunt() {
		List<Emprunt> l = new ArrayList<>();
		l = DAOEtudiant.affichelist2();

		ObservableList<Emprunt> liste = FXCollections.observableArrayList(l);
		return liste;

	}

	public static ObservableList<Etudiant> getListEtudiant() {

		List<Etudiant> l = new ArrayList<>();
		l = DAOEtudiant.affichelist1();

		ObservableList<Etudiant> liste = FXCollections.observableArrayList(l);
		return liste;

	}

	public void creerTableViewEtudiant() {


		TableView<Etudiant> tableView = new TableView<>();
		ArrayList<Etudiant> l = new ArrayList<>();
		l = DAOEtudiant.affichelist1();

		TableColumn<Etudiant, Integer> codeEtudiant = new TableColumn<Etudiant, Integer>("codeEtudiant");
		TableColumn<Etudiant, String> nom = new TableColumn<Etudiant, String>("nom");
		TableColumn<Etudiant, String> prenom = new TableColumn<Etudiant, String>("prenom");
		TableColumn<Etudiant, Integer> groupe = new TableColumn<Etudiant, Integer>("groupe");

		// lien entre colonnnes et tableview
		tableView.getColumns().addAll(codeEtudiant, nom, prenom, groupe);
		// lien entre champ de la classe Joueur avec la colonne nomCol

		codeEtudiant.setCellValueFactory(new PropertyValueFactory<>("codeEtudiant"));
		nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		groupe.setCellValueFactory(new PropertyValueFactory<>("groupe"));

		// importer la liste et associe a la tableview;
		ObservableList<Etudiant> list = getListEtudiant();
		tableView.setItems(list);

		root.setCenter(tableView);

	}

	public void ajoutEmprunt() {


		GridPane gridPane = new GridPane();

		gridPane.setPadding(new Insets(70, 70, 70, 70));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		
BorderPane border =new BorderPane();
Button btnadd = new Button("Ajouter");

		Label nom = new Label("Ajouter un Emprunt :");

		gridPane.add(nom, 0, 0);

		Label dateemp = new Label("DateEmprunt");
		
		final DatePicker datePicker = new DatePicker(); 
       datePicker.getValue();
		

		Label dateR = new Label("Date de retour");
		
	 
		final DatePicker datePicker_r = new DatePicker(); 
		datePicker_r.getValue();
		
		Label idExemplaire = new Label("codeExemplaire");
		final TextField txtidExemp = new TextField();
		
		Label idEtudiant = new Label("codeEtudiant");
		final TextField txtidEtudiant = new TextField();
	

		Button btnVerifier = new Button("Vérifier");
		final Label lblMessage = new Label();

		gridPane.add(btnVerifier, 0, 5);
		gridPane.add(lblMessage, 1, 5);
		
		gridPane.add(dateemp, 0, 1);
		gridPane.add(datePicker, 1,1);
		

		gridPane.add(dateR, 0, 2);
		gridPane.add(datePicker_r, 1, 2);
		gridPane.add(idExemplaire, 0, 3);
		gridPane.add(txtidExemp, 1, 3);
		gridPane.add(idEtudiant, 0, 4);
		gridPane.add(txtidEtudiant, 1, 4);
		
				btnVerifier.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				//String checkUser = txtUserName.getText().toString();
				int idex=Integer.parseInt(txtidExemp.getText());
				int idetd= Integer.parseInt(txtidEtudiant.getText());
				LocalDate date = datePicker.getValue();
			 //DatePicker date= datePicker;
				LocalDate date1 = datePicker.getValue();
				Date date2 = Date.valueOf(date );
				Date date3 = Date.valueOf(date1 );
				Emprunt emprunt = new Emprunt(idex, idetd, date2, date3, 0);
				boolean test = gEmprunt.addEmprunt(emprunt);
				if (test) {
					lblMessage.setText("Entrer");
					lblMessage.setTextFill(Color.GREEN);
					// c1.creerTableViewEmprunt();

				} else {
					lblMessage.setText("il n' y pas un exemplaire pour ce livre pour l'emprunte ");
					lblMessage.setTextFill(Color.RED);
				}
				//txtUserName.setText("");
				// pf.setText("");
			}
		});



		root.setCenter(gridPane);
	}
	
	public void ajoutLivre() {


		GridPane gridPane = new GridPane();

		gridPane.setPadding(new Insets(70, 70, 70, 70));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		
BorderPane border =new BorderPane();
Button btnadd = new Button("Ajouter");

		Label nom = new Label("Ajouter un livre :");

		gridPane.add(nom, 0, 0);

		Label isbn = new Label("ISBN : ");
		
		final TextField txtisbn = new TextField();
		

		Label titre = new Label("Titre : ");
		final TextField txttitre = new TextField();
		
		Label theme = new Label("Theme : ");
		final TextField txttheme = new TextField();
		
		Label auteur = new Label("Auteur : ");
		final TextField txtauteur = new TextField();
	

		Button btnajouter = new Button("Ajouter");
		final Label lblMessage = new Label();

		gridPane.add(btnajouter, 0, 5);
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
					lblMessage.setText("Entrer");
					lblMessage.setTextFill(Color.GREEN);
					creerTableViewLivre();

				} else {
					lblMessage.setText("il n' y pas un exemplaire pour ce livre pour l'emprunte ");
					lblMessage.setTextFill(Color.RED);
				}
				//txtUserName.setText("");
				// pf.setText("");
			}
		});



		root.setCenter(gridPane);
	}

	public void ajouterEmprunt() {

		GridPane gridPane = new GridPane();

		gridPane.setPadding(new Insets(70, 70, 70, 70));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		// Implementing Nodes for GridPane
		Label dateemp = new Label("DateEmprunt");
		final TextField txtUserName = new TextField();
		// Label lblPassword = new Label("Password");

		Label dateR = new Label("Date de retour");
		final TextField txtdateR = new TextField();
		// Label lblPassword = new Label("Password");
		Label idExemplaire = new Label("codeExemplaire");
		final TextField txtidExemp = new TextField();
		// Label lblPassword = new Label("Password");
		Label idEtudiant = new Label("codeEtudiant");
		final TextField txtidEtudiant = new TextField();
		// Label lblPassword = new Label("Password");

		Button btnLogin = new Button("Vérifier");
		final Label lblMessage = new Label();

		gridPane.add(btnLogin, 5, 1);
		gridPane.add(lblMessage, 1, 5);
		// Adding Nodes to GridPane layout
		gridPane.add(dateemp, 0, 0);
		gridPane.add(txtUserName, 1, 0);
		// gridPane.add(lblPassword, 0, 1);

		gridPane.add(dateR, 2, 1);
		gridPane.add(txtdateR, 1, 2);
		gridPane.add(idExemplaire, 3, 1);
		gridPane.add(txtidExemp, 1, 3);
		gridPane.add(idEtudiant, 4, 1);
		gridPane.add(txtidEtudiant, 1, 4);
		

	}

	

}
