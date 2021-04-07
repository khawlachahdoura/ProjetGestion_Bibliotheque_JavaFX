package view;

import Entities.Emprunt;
import Entities.Etudiant;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ViewEmprunt {
	public VBox EmpruntView(Emprunt e) {
		VBox vbox = new VBox();
		Label DateEmprunt,dateE,DateRetour, dateR, idExemplaire,idEx, idEtudiant,idEt,etatlabel,etat;
		DateEmprunt = new Label("Date Emprunt : ");
		dateE = new Label(" "+ e.getDate_E());
		idExemplaire = new Label("code Exemplaire : ");
		idEx = new Label(" "+e.getIdExemplaire());
		idEtudiant = new Label("Code Etudiant :");
		idEt = new Label(" "+e.getIdEtudiant());
		DateRetour = new Label("Date Retour:");
		dateR = new Label(" "+e.getDate_RE());
		etatlabel = new Label("Etat:");
		etat = new Label(" "+e.getEtat());
		css(DateEmprunt,dateE,DateRetour, dateR, idExemplaire,idEx, idEtudiant,idEt,etatlabel,etat, vbox);
		vbox.getChildren().addAll(DateEmprunt,dateE,DateRetour, dateR, idExemplaire,idEx, idEtudiant,idEt,etatlabel,etat);
		return vbox;
	}

	@SuppressWarnings("static-access")
	private void css(Label DateEmprunt, Label dateE, Label DateRetour, Label dateR, Label idExemplaire, Label idEx,
			Label idEtudiant, Label idEt,Label etatlabel,Label etat,VBox vbox) {
		vbox.setMargin(dateE, new Insets(80, 0, 0, 40));
		dateE.setStyle("-fx-alignment: CENTER;"); 
		dateE.setFont(new Font("Arial", 15));
		vbox.setMargin(dateR, new Insets(20, 0, 0, 40));
		dateR.setStyle("-fx-alignment: CENTER;");
		dateR.setFont(new Font("Arial", 15));
		vbox.setMargin(idEx, new Insets(20, 0, 0, 40));
		idEx.setStyle("-fx-alignment: CENTER;");
		idEx.setFont(new Font("Arial", 15));
		vbox.setMargin(idEt, new Insets(20, 0, 0, 40));
		idEt.setStyle("-fx-alignment: CENTER;");
		idEt.setFont(new Font("Arial", 15));
		vbox.setMargin(etat, new Insets(80, 0, 0, 40));
		etat.setStyle("-fx-alignment: CENTER;"); 
		etat.setFont(new Font("Arial", 15));
		vbox.setMargin(DateEmprunt, new Insets(20, 0, 0, 40));
		DateEmprunt.setStyle("-fx-alignment: CENTER;"); 
		DateEmprunt.setFont(new Font("Arial", 15));
		vbox.setMargin(DateRetour, new Insets(20, 0, 0, 40));
		DateRetour.setStyle("-fx-alignment: CENTER;"); 
		DateRetour.setFont(new Font("Arial", 15));
		vbox.setMargin(idExemplaire, new Insets(20, 0, 0, 40));
		idExemplaire.setStyle("-fx-alignment: CENTER;"); 
		idExemplaire.setFont(new Font("Arial", 15));
		vbox.setMargin(idEtudiant, new Insets(20, 0, 0, 40));
		idEtudiant.setStyle("-fx-alignment: CENTER;"); 
		idEtudiant.setFont(new Font("Arial", 15));
		vbox.setMargin(etatlabel, new Insets(20, 0, 0, 40));
		etatlabel.setStyle("-fx-alignment: CENTER;"); 
		etatlabel.setFont(new Font("Arial", 15));
	}

	

}
