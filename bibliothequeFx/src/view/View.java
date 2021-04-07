package view;

import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

import Entities.Emprunt;
import Entities.Etudiant;
import Entities.Livre;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class View {
	
	public ViewEmprunt ve = new ViewEmprunt();
	public ViewEtudiant vet = new ViewEtudiant();
	public ViewLivre veLivre = new ViewLivre();
	public Map<String, MenuItem> listMenuItem = (Map<String, MenuItem>) new HashMap<String, MenuItem>();
	public Map<String, Button> listButtons = (Map<String, Button>) new HashMap<String, Button>();

	public void getMenu(BorderPane border) {
		MenuBar menuBar = new MenuBar();
		border.setTop(menuBar);
		Menu option = new Menu("Option");
		MenuItem profile = new MenuItem("Profile");
		Menu examen = new Menu("Examen");
		MenuItem passExam = new MenuItem("Passer Examen");
		Menu hist = new Menu("Historique");
		examen.getItems().addAll(passExam, hist);
		MenuItem score = new MenuItem("Score");
		MenuItem date = new MenuItem("Date");
		hist.getItems().addAll(score, date);
		option.getItems().add(profile);
		menuBar.getMenus().add(option);
		menuBar.getMenus().add(examen);
		((HashMap<String, MenuItem>) listMenuItem).put("profile", profile);
		((HashMap<String, MenuItem>) listMenuItem).put("passExam", passExam);
		((HashMap<String, MenuItem>) listMenuItem).put("score", score);
		((HashMap<String, MenuItem>) listMenuItem).put("date", date);
	}

	

	public void EmpruntView(BorderPane border, Emprunt e) {
		border.setCenter(ve.EmpruntView(e));
		border.setRight(null);
		border.setLeft(null);
	}

	public void getVeiwEtudiant(BorderPane border, Etudiant e) {
		border.setCenter(vet.getEtudiant(e, border));
		border.setRight(null);
		border.setLeft(null);
	}
	
	public void getVeiwLivre(BorderPane border, Livre l) {
		border.setCenter(veLivre.getlivre(l, border));
		border.setRight(null);
		border.setLeft(null);
	}

}
