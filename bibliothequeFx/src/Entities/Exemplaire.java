package Entities;

public class Exemplaire extends Livre {

	
public int codeExemplaire;
	
	public Exemplaire(int iSBN, String titre, String auteur,String theme,int codeExemplaire ) {
		super(iSBN, titre, auteur,theme);
		this.codeExemplaire=codeExemplaire;
		// TODO Auto-generated constructor stub
	}
	public int getCodeExemplaire() {
		return codeExemplaire;
	}
	public void setCodeExemplaire(int codeExemplaire) {
		this.codeExemplaire = codeExemplaire;
	}
	@Override
	public String toString() {
		return "Exemplaire [codeExemplaire=" + codeExemplaire + "]";
	}

}
