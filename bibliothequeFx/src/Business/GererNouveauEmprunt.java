package Business;

import java.sql.Date;

import Entities.Emprunt;
import ImpDAO1.ImpDAOGererNouveauEmp;
import IserviceDAO.IDAOGererNouveauEmp;

public class GererNouveauEmprunt {

	private IDAOGererNouveauEmp iDaoGererNouveauEmp;

 
	public GererNouveauEmprunt(ImpDAOGererNouveauEmp impDAOGererNouveauEmp) {

		iDaoGererNouveauEmp = impDAOGererNouveauEmp;

	}

	public boolean addEmprunt(Emprunt emprunt) {

		if (iDaoGererNouveauEmp.ajouter(emprunt)) {
			return true;
		}
		return false;

	}
	 
	public boolean modifierDateEmp(int idEmpt, Date nvDateEmp) {

		if (iDaoGererNouveauEmp.modifierDateEmp( idEmpt,  nvDateEmp)) {
			return true;
		}
		return false;

	}
	
	public boolean modifierDateRet(int idEmpt, Date nvDateRet) {

		if (iDaoGererNouveauEmp.modifierDateRet( idEmpt,  nvDateRet)) {
			return true;
		}
		return false;

	}
	
	
	public boolean modifieridExemplaire(int idEmpt, int nvIDExemplaire) {
		if (iDaoGererNouveauEmp.modifieridExemplaire( idEmpt,  nvIDExemplaire)) {
			return true;
		}
		 
		return false;

	}
	
	public boolean modifieridEtudiant(int idEmpt,int nbIDEtudiant) {
		if (iDaoGererNouveauEmp.modifieridEtudiant( idEmpt, nbIDEtudiant)) {
			return true;
		}
		 
		return false;

	}

	public boolean deleteEmprunt(int idEmprunt) {

		if (iDaoGererNouveauEmp.supprimer( idEmprunt)) {
			return true;
		}
		return false;

	}

}