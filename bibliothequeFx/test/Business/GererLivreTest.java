package Business;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Entities.Livre;

public class GererLivreTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("avant");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("après");
	}

	@Test
	public void testaddlivre_null_returnsFalse() {
		Livre livre=new Livre(1, "aa","aa","aa");
		DaoGererLivreMock idoGL = new DaoGererLivreMock();
		MaGererLivre GL = new MaGererLivre(idoGL);
		boolean result=GL.addLivre(new Livre(0,null,null,null));
		assertFalse(result);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

/*	@Test
	public void testdeletelivre_idnull_returnsFalse() {
		DaoGererLivreMock idoGL = new DaoGererLivreMock();
		MaGererLivre GL = new MaGererLivre(idoGL);
		boolean result=GL.deleteLivre(0);
		assertFalse(result);
	}
	*/

}
