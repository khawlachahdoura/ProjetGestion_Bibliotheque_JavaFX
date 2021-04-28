package Entities;

public class Etudiant {
	public int idEtudiant;
	public int codeEtudiant;
	public String nom;
	public String prenom;
	public String groupe;
	public Etudiant(int idEtudiant,int codeEtudiant, String nom, String prenom, String groupe) {
		super();
		this.idEtudiant = idEtudiant;
		this.codeEtudiant = codeEtudiant;
		this.nom = nom;
		this.prenom = prenom;
		this.groupe = groupe;
	}
	public int getCodeEtudiant() {
		return codeEtudiant;
	}
	public void setCodeEtudiant(int codeEtudiant) {
		this.codeEtudiant = codeEtudiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getGroupe() {
		return groupe;
	}
	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
	@Override
	public String toString() {
		return "Etudiant [codeEtudiant=" + codeEtudiant + ", nom=" + nom + ", prenom=" + prenom + ", groupe=" + groupe
				+ "]";
	}
	
	
}
