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
