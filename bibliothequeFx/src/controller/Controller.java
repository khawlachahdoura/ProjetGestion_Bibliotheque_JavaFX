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
import Entities.Exemplaire;
import Entities.Livre;
import ImpDAO1.ImpDAOGererLivre;
import ImpDAO1.ImpDAOGererNouveauEmp;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Callback;
import view.View;

public class Controller {
	static GererNouveauEmprunt gEmprunt = new GererNouveauEmprunt(new ImpDAOGererNouveauEmp());
	GererLivre gLivre = new GererLivre(new ImpDAOGererLivre());
	private BorderPane root;
	static boolean test = true;
	static int val;
	static Scanner sc = new Scanner(System.in);

	public Controller(BorderPane root) {
		this.root = root;
	}

	public void creerTableViewLivre() {

		TableView<Livre> tableView = new TableView<>();
		List<Emprunt> l = new ArrayList<>();
		l = ImpDAOGererNouveauEmp.affichelist2();

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
		/////
		/*
		 * TableColumn<Livre, String> titre1 = new TableColumn<Livre,
		 * String>("Titre"); titre1.setCellValueFactory( new
		 * PropertyValueFactory<Livre, String>("titre"));
		 * titre1.setCellFactory(TextFieldTableCell.forTableColumn());
		 * titre1.setOnEditCommit( new
		 * EventHandler<TableColumn.CellEditEvent<Livre, String>>() {
		 * 
		 * @Override public void handle(TableColumn.CellEditEvent<Livre, String>
		 * t) { String titr = t.getTableColumn().getText();
		 * gLivre.updateTitre(titr, ISBN); ((Livre)
		 * t.getTableView().getItems().get(t.getTablePosition().getRow())).
		 * setTitre(t.getNewValue()); } }
		 * 
		 * );
		 */
		////
		/*
		 * ISBN.setCellValueFactory( new PropertyValueFactory<Livre,
		 * Integer>("ISBN"));
		 * 
		 * ISBN.setCellFactory(TextFieldTableCell.forTableColumn());;
		 * ISBN.setOnEditCommit( new
		 * EventHandler<TableColumn.CellEditEvent<Livre, Integer>>() {
		 * 
		 * @Override public void handle(TableColumn.CellEditEvent<Livre,
		 * Integer> t) {
		 * 
		 * ((Livre) t.getTableView().getItems().get(
		 * t.getTablePosition().getRow()) ).setISBN(t.getNewValue()); } } );
		 * 
		 * 
		 */
		////
		root.setCenter(tableView);

	}

	public void creerTableViewEmprunt() {

		TableView<Emprunt> tableView = new TableView<>();
		TableView<Button> tableView1 = new TableView<>();
		List<Emprunt> l = new ArrayList<>();
		l = ImpDAOGererNouveauEmp.affichelist2();

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
		for (int i = 0; i <= list.size(); i++) {

		}
		root.setCenter(tableView);

	}

	public static ObservableList<Livre> getListLivre() {

		List<Livre> l = new ArrayList<>();
		l = ImpDAOGererNouveauEmp.affichelist3();

		ObservableList<Livre> liste = FXCollections.observableArrayList(l);
		return liste;

	}

	public static ObservableList<Emprunt> getListEmprunt() {
		List<Emprunt> l = new ArrayList<>();
		l = ImpDAOGererNouveauEmp.affichelist2();

		ObservableList<Emprunt> liste = FXCollections.observableArrayList(l);
		return liste;

	}

	public static ObservableList<Etudiant> getListEtudiant() {

		List<Etudiant> l = new ArrayList<>();
		l = ImpDAOGererNouveauEmp.affichelist1();

		ObservableList<Etudiant> liste = FXCollections.observableArrayList(l);
		return liste;

	}

	public void creerTableViewEtudiant() {

		TableView<Etudiant> tableView = new TableView<>();
		ArrayList<Etudiant> l = new ArrayList<>();
		l = ImpDAOGererNouveauEmp.affichelist1();
		TableColumn<Etudiant, Integer> id = new TableColumn<Etudiant, Integer>("idEtudiant");
		TableColumn<Etudiant, Integer> codeEtudiant = new TableColumn<Etudiant, Integer>("codeEtudiant");
		TableColumn<Etudiant, String> nom = new TableColumn<Etudiant, String>("nom");
		TableColumn<Etudiant, String> prenom = new TableColumn<Etudiant, String>("prenom");
		TableColumn<Etudiant, Integer> groupe = new TableColumn<Etudiant, Integer>("groupe");

		// lien entre colonnnes et tableview
		tableView.getColumns().addAll(id,codeEtudiant, nom, prenom, groupe);
		// lien entre champ de la classe Joueur avec la colonne nomCol
		id.setCellValueFactory(new PropertyValueFactory<>("idEtudiant"));
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

		BorderPane border = new BorderPane();
		Button btnadd = new Button("Ajouter");

		Label nom = new Label("Ajouter un Emprunt :");
		nom.setStyle("-fx-alignment: CENTER;-fx-focus-color: violet;");
		nom.setFont(new Font("Arial", 25));
		nom.setTextFill(Color.VIOLET);
		gridPane.add(nom, 0, 0);

		Label dateemp = new Label("Date Emprunt : ");

		final DatePicker datePicker = new DatePicker();
		datePicker.getValue();
		dateemp.setStyle("-fx-alignment: CENTER;");
		dateemp.setFont(new Font("Arial", 15));

		Label dateR = new Label("Date de retour : ");
		dateR.setStyle("-fx-alignment: CENTER;");
		dateR.setFont(new Font("Arial", 15));

		final DatePicker datePicker_r = new DatePicker();
		datePicker_r.getValue();

		Label idExemplaire = new Label("Code Exemplaire : ");
		final TextField txtidExemp = new TextField();
		idExemplaire.setStyle("-fx-alignment: CENTER;");
		idExemplaire.setFont(new Font("Arial", 15));
		Label idEtudiant = new Label("Code Etudiant : ");
		final TextField txtidEtudiant = new TextField();

		idEtudiant.setStyle("-fx-alignment: CENTER;");
		idEtudiant.setFont(new Font("Arial", 15));
		Button btnVerifier = new Button("V�rifier");
		final Label lblMessage = new Label();

		gridPane.add(btnVerifier, 0, 5);
		gridPane.add(lblMessage, 1, 5);

		gridPane.add(dateemp, 0, 1);
		gridPane.add(datePicker, 1, 1);

		gridPane.add(dateR, 0, 2);
		gridPane.add(datePicker_r, 1, 2);
		gridPane.add(idExemplaire, 0, 3);
		gridPane.add(txtidExemp, 1, 3);
		gridPane.add(idEtudiant, 0, 4);
		gridPane.add(txtidEtudiant, 1, 4);

		btnVerifier.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				// String checkUser = txtUserName.getText().toString();
				int idex = Integer.parseInt(txtidExemp.getText());
				int idetd = Integer.parseInt(txtidEtudiant.getText());
				LocalDate date = datePicker.getValue();
				// DatePicker date= datePicker;
				LocalDate date1 = datePicker.getValue();
				Date date2 = Date.valueOf(date);
				Date date3 = Date.valueOf(date1);
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

			}
		});

		root.setCenter(gridPane);
	}
	
	//update emprunt
	public void modifierEmprunt() {

		GridPane gridPane = new GridPane();

		gridPane.setPadding(new Insets(70, 70, 70, 70));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		BorderPane border = new BorderPane();
		Button btnadd = new Button("Ajouter");

		Label nom = new Label("Modifier un Emprunt :");
		nom.setStyle("-fx-alignment: CENTER;-fx-focus-color: violet;");
		nom.setFont(new Font("Arial", 25));
		nom.setTextFill(Color.VIOLET);
		gridPane.add(nom, 0, 0);

		Label dateemp = new Label("Date Emprunt : ");

		final DatePicker datePicker = new DatePicker();
		datePicker.getValue();
		dateemp.setStyle("-fx-alignment: CENTER;");
		dateemp.setFont(new Font("Arial", 15));

		Label dateR = new Label("Date de retour : ");
		dateR.setStyle("-fx-alignment: CENTER;");
		dateR.setFont(new Font("Arial", 15));

		final DatePicker datePicker_r = new DatePicker();
		datePicker_r.getValue();

		Label idExemplaire = new Label("Code Exemplaire : ");
		final TextField txtidExemp = new TextField();
		idExemplaire.setStyle("-fx-alignment: CENTER;");
		idExemplaire.setFont(new Font("Arial", 15));
		Label idEtudiant = new Label("Code Etudiant : ");
		final TextField txtidEtudiant = new TextField();

		idEtudiant.setStyle("-fx-alignment: CENTER;");
		idEtudiant.setFont(new Font("Arial", 15));
		Button btnVerifier = new Button("V�rifier");
		final Label lblMessage = new Label();

		gridPane.add(btnVerifier, 0, 5);
		gridPane.add(lblMessage, 1, 5);

		gridPane.add(dateemp, 0, 1);
		gridPane.add(datePicker, 1, 1);

		gridPane.add(dateR, 0, 2);
		gridPane.add(datePicker_r, 1, 2);
		gridPane.add(idExemplaire, 0, 3);
		gridPane.add(txtidExemp, 1, 3);
		gridPane.add(idEtudiant, 0, 4);
		gridPane.add(txtidEtudiant, 1, 4);

		btnVerifier.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				// String checkUser = txtUserName.getText().toString();
				int idex = Integer.parseInt(txtidExemp.getText());
				int idetd = Integer.parseInt(txtidEtudiant.getText());
				LocalDate date = datePicker.getValue();
				// DatePicker date= datePicker;
				LocalDate date1 = datePicker.getValue();
				Date date2 = Date.valueOf(date);
				Date date3 = Date.valueOf(date1);
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

			}
		});

		root.setCenter(gridPane);
	}

	Button btnaddL = new Button("Ajouter");

	public void ajoutLivre() {

		GridPane gridPane = new GridPane();

		gridPane.setPadding(new Insets(70, 70, 70, 70));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		BorderPane border = new BorderPane();
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
		gridPane.add(btnaddexemp, 0, 8);
		gridPane.add(lblMessage, 1, 5);

		gridPane.add(isbn, 0, 1);
		gridPane.add(txtisbn, 1, 1);
		gridPane.add(titre, 0, 2);
		gridPane.add(txttitre, 1, 2);
		gridPane.add(theme, 0, 3);
		gridPane.add(txttheme, 1, 4);
		gridPane.add(auteur, 0, 4);
		gridPane.add(txtauteur, 1, 3);

		btnajouter.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				// String checkUser = txtUserName.getText().toString();
				int isbn = Integer.parseInt(txtisbn.getText());
				String titre = txttitre.getText();
				String theme = txttheme.getText();
				String auteur = txtauteur.getText();

				Livre livre = new Livre(isbn, titre, theme, auteur);

				boolean test = gLivre.addLivre(livre);
				if (test) {
					lblMessage.setText("livre ajout� avec succ�");
					lblMessage.setTextFill(Color.GREEN);
					// creerTableViewLivre();

				} else {
					lblMessage.setText("Erreur ");
					lblMessage.setTextFill(Color.RED);
				}

			}
		});

		btnaddexemp.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				int isbn = Integer.parseInt(txtisbn.getText());
				String titre = txttitre.getText();
				String theme = txttheme.getText();
				String auteur = txtauteur.getText();
				int code = Integer.parseInt(txtcode.getText());

				Livre livre = new Livre(isbn, titre, theme, auteur);
				Exemplaire exemplaire = new Exemplaire(isbn, titre, theme, auteur, code);
				boolean test = gLivre.ajouterexemplaire(exemplaire);
				if (test) {
					lblMessage.setText("exemplaire ajout� avec succ�");
					lblMessage.setTextFill(Color.GREEN);
					// creerTableViewLivre();

				} else {
					lblMessage1.setText("erreur ");
					lblMessage1.setTextFill(Color.RED);
				}

			}
		});
		root.setCenter(gridPane);
	}

	public void supprimerlivre() {
		GridPane gridPane = new GridPane();

		gridPane.setPadding(new Insets(70, 70, 70, 70));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		Label nom = new Label("Supprimer un livre :");
		nom.setStyle("-fx-alignment: CENTER;-fx-focus-color: violet;");
		nom.setFont(new Font("Arial", 20));
		nom.setTextFill(Color.VIOLET);
		gridPane.add(nom, 0, 0);

		Label isbn = new Label("ISBN :");
		isbn.setStyle("-fx-alignment: CENTER;");
		isbn.setFont(new Font("Arial", 15));
		final TextField txtisbn = new TextField();

		gridPane.add(isbn, 0, 1);
		gridPane.add(txtisbn, 1, 1);
		Button btnsupp = new Button("Supprimer");
		final Label lblmsgsup = new Label();

		gridPane.add(btnsupp, 2, 1);
		gridPane.add(lblmsgsup, 1, 2);

		btnsupp.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				int isbn = Integer.parseInt(txtisbn.getText());
				boolean test = gLivre.deleteLivre(isbn);
				if (test) {
					lblmsgsup.setText("livre supprim� ");
					lblmsgsup.setTextFill(Color.GREEN);

				} else {
					lblmsgsup.setText("Erreur ");
					lblmsgsup.setTextFill(Color.RED);
				}

			}
		});
		root.setCenter(gridPane);
	}

	public void supprimerEmprunt() {
		GridPane gridPane = new GridPane();

		gridPane.setPadding(new Insets(70, 70, 70, 70));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		Label nom = new Label("Supprimer Emprunt :");
		nom.setStyle("-fx-alignment: CENTER;-fx-focus-color: violet;");
		nom.setFont(new Font("Arial", 20));
		nom.setTextFill(Color.VIOLET);
		gridPane.add(nom, 0, 0);

		Label id = new Label("id Emprunt :");
		id.setStyle("-fx-alignment: CENTER;");
		id.setFont(new Font("Arial", 15));
		final TextField txtisbn = new TextField();

		gridPane.add(id, 0, 1);
		gridPane.add(txtisbn, 1, 1);
		Button btnsupp = new Button("Supprimer");
		final Label lblmsgsup = new Label();

		gridPane.add(btnsupp, 2, 1);
		gridPane.add(lblmsgsup, 1, 2);

		btnsupp.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				int id = Integer.parseInt(txtisbn.getText());
				boolean test = gEmprunt.deleteEmprunt(id);
				if (test) {
					lblmsgsup.setText("Emprunt supprim� ");
					lblmsgsup.setTextFill(Color.GREEN);

				} else {
					lblmsgsup.setText("Erreur ");
					lblmsgsup.setTextFill(Color.RED);
				}

			}
		});
		root.setCenter(gridPane);
	}

}
