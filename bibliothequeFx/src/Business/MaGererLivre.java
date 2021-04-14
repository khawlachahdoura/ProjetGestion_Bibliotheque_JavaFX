package Business;

import Entities.Livre;
import ImpDAO1.ImpDAOGererLivre;
import IserviceDAO.IDAOGererLivre;

public class MaGererLivre {

	private IDAOGererLivre iDaoGererLivre;
	public MaGererLivre(DaoGererLivreMock iGererLivre) {

		iDaoGererLivre = iGererLivre;

	}
	
	public boolean addLivre(Livre livre) {

		if (iDaoGererLivre.ajouter(livre)) {
			return true;
		}
		return false;

	}
}
