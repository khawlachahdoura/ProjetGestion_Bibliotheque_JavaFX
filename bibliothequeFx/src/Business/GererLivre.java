package Business;

import Entities.Livre;

import ImpDAO1.ImpDAOGererLivre;
import IserviceDAO.IDAOGererLivre;

public class GererLivre {

	 
	private IDAOGererLivre iDaoGererLivre;
	public GererLivre(ImpDAOGererLivre iGererLivre) {

		iDaoGererLivre = iGererLivre;

	}
	
	
	

	public boolean addLivre(Livre livre) {

		if (iDaoGererLivre.ajouter(livre)) {
			return true;
		}
		return false;

	}

	public boolean updateISBN(int nISBN,int aISBN) {

		if (iDaoGererLivre.updateISBN(nISBN,aISBN)) {
			return true;
		}
		return false;

	}
	
	
	public boolean updateTitre(String titre, int aISBN) {

		if (iDaoGererLivre.updateTitre(titre,aISBN)) {
			return true;
		}
		return false;

	}
	
	
	public boolean updateTheme(String theme, int aISBN) {

		if (iDaoGererLivre.updateTheme(theme, aISBN)) {
			return true;
		}
		return false;

	}
	
	
	public boolean updateAuteur(String auteur, int aISBN) {

		if (iDaoGererLivre.updateAuteur(auteur, aISBN)) {
			return true;
		}
		return false;

	}
	
	
	

	public boolean deleteLivre(int isbn) {

		if (iDaoGererLivre.supprimer(isbn)) {
			return true;
		}
		return false;

	}
}