package IserviceDAO;


import java.sql.Date;

import Entities.*;

public interface IDAOGererNouveauEmp {
	boolean ajouter(Emprunt emprunt);
	boolean  modifierDateEmp(int idEmpt, Date nvDateEmp);
	boolean  modifierDateRet(int idEmpt, Date nvDateRet);
	boolean  modifieridExemplaire(int idEmpt, int nvIDExemplaire);
	boolean  modifieridEtudiant(int idEmpt,int nbIDEtudiant);
	boolean supprimer(int idEmprunt);


}
