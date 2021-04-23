package Business;

import static org.junit.Assert.*;



import org.junit.Test;

import Entities.Livre;
import IserviceDAO.IDAOGererLivre;
import junit.framework.Assert;

public class GererLivreTest {

	@Test
	public void addlivre_null_returnsFalse() {
		Livre livre=new Livre(0, null, null, null);
		DaoGererLivreMock idoGL = new DaoGererLivreMock();
		MaGererLivre GL = new MaGererLivre(idoGL);
		boolean result=GL.addLivre(livre);
		assertFalse(result);
		
	}

}
