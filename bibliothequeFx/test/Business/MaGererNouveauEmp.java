package Business;

import Entities.Emprunt;
import Entities.Livre;
import IserviceDAO.IDAOGererLivre;
import IserviceDAO.IDAOGererNouveauEmp;

public class MaGererNouveauEmp {
	private IDAOGererNouveauEmp idaoGererNouveauEmp;

	public MaGererNouveauEmp(DaoGererNouveauEmpMock iGererEmp) {
		
		this.idaoGererNouveauEmp = iGererEmp;
	}
	
	public boolean ajouter(Emprunt emprunt) {

		if (idaoGererNouveauEmp.ajouter(emprunt)) {
			return true;
		}
		return false;

	}
	
	public boolean supprimer(int idEmprunt) {
		if (idaoGererNouveauEmp.supprimer(idEmprunt)) {
			return true;
		}
		return false;
	}

	
	
	
}
