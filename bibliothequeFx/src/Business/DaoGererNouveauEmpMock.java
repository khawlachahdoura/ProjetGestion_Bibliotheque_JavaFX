package Business;

import java.sql.Date;

import Entities.Emprunt;
import IserviceDAO.IDAOGererLivre;
import IserviceDAO.IDAOGererNouveauEmp;

public class DaoGererNouveauEmpMock  implements IDAOGererNouveauEmp {

	@Override
	public boolean ajouter(Emprunt emprunt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifierDateEmp(int idEmpt, Date nvDateEmp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifierDateRet(int idEmpt, Date nvDateRet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifieridExemplaire(int idEmpt, int nvIDExemplaire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifieridEtudiant(int idEmpt, int nbIDEtudiant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(int idEmprunt) {
		// TODO Auto-generated method stub
		return false;
	}

}
