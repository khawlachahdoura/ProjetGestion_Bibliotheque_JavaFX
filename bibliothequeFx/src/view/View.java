package view;

import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

import Entities.Emprunt;
import Entities.Etudiant;
import Entities.Livre;
import controller.Controller;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class View {
	
	public ViewEmprunt ve = new ViewEmprunt();
	public ViewEtudiant vet = new ViewEtudiant();
	public ViewLivre veLivre = new ViewLivre();
	BorderPane root = new BorderPane();
	
	Controller c1=new Controller(root);
public void Accueil(){
		
		BorderPane bord =new BorderPane();
		VBox vBox=new VBox();
		 Button ajoutliv = new Button("Ajouter Livre");
		 ajoutliv.setMaxSize(142, 142);
		 ajoutliv.setMinSize(100, 100);
		 ajoutliv.setStyle("-fx-focus-color: transparent;  -fx-background-insets: 0, 1, 2; -fx-background-radius: 5, 4, 3;");
		 
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
		
	}
/*public void EmpruntView(BorderPane border, Emprunt e) {
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
*/
}
