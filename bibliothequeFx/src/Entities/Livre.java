package Entities;

public class Livre {
	private int ISBN;
	private String titre;
	private String auteur;
	private String theme;
	

	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	@Override
	public String toString() {
		return "Livre [ISBN=" + ISBN + ", titre=" + titre + ", auteur=" + auteur + ", theme=" + theme + "]";
	}
	public Livre(int iSBN, String titre, String auteur, String theme) {
		super();
		ISBN = iSBN;
		this.titre = titre;
		this.auteur = auteur;
		this.theme = theme;
	}

}
