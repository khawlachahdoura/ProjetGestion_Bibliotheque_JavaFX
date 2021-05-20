package Entities;

public class Exemplaire extends Livre {

	
public int code;
public int idExemplaire;
	
	public Exemplaire(int idExemplaire,int iSBN, String titre, String auteur,String theme,int code ) {
		super(iSBN, titre, auteur,theme);
		this.code=code;
		this.idExemplaire=idExemplaire;
		// TODO Auto-generated constructor stub
	}
	public int getCodeExemplaire() {
		return code;
	}
	public void setCodeExemplaire(int codeExemplaire) {
		this.code = codeExemplaire;
	}
	@Override
	public String toString() {
		return "Exemplaire [codeExemplaire=" + code + "]";
	}

}
