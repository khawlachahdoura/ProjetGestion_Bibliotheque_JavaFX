package Business;

import Entities.Exemplaire;
import Entities.Livre;
import IserviceDAO.IDAOGererLivre;

public class DaoGererLivreMock implements IDAOGererLivre{

	@Override
	public boolean ajouter(Livre arg0) {
		if(arg0.getISBN()==0&&arg0.getAuteur()==null&&arg0.getTheme()==null&&arg0.getTitre()==null){
			System.out.println("ça marche le test return False,null input !");
			return false;
			}
		else {
			System.out.println("livre non null test unitaire doit être rouge !");
		return true;}
			
	}

	@Override
	public boolean supprimer(int arg0) {
		
		if (arg0==0){
			System.out.println("id null, test unitaire doit être vert !");
		return false;
		}else
			System.out.println("id non null test unitaire doit être rouge !");
			return true;
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
