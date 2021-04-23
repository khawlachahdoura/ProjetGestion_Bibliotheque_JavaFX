package Business;

import Entities.Exemplaire;
import Entities.Livre;
import IserviceDAO.IDAOGererLivre;

public class DaoGererLivreMock implements IDAOGererLivre{

	@Override
	public boolean ajouter(Livre arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAuteur(String arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateISBN(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTheme(String arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTitre(String arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public boolean ajouterexemplaire(Exemplaire exemplaire) {
		// TODO Auto-generated method stub
		return false;
	}

}
