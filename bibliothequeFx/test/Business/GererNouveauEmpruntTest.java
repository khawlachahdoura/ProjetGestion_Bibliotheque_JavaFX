package Business;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Entities.Emprunt;
import Entities.Livre;

public class GererNouveauEmpruntTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaddEmprunt_null_returnsFalse() {
		Emprunt emprunt=new Emprunt(0, 0,0, null, null,0);
		DaoGererNouveauEmpMock idoGE = new DaoGererNouveauEmpMock();
		MaGererNouveauEmp GE = new MaGererNouveauEmp(idoGE);
		boolean result=GE.ajouter(emprunt);
		assertFalse(result);
	}

	@Test
	public void testdeleteEmprunt_idnull_returnsFalse() {
		DaoGererNouveauEmpMock idoGE = new DaoGererNouveauEmpMock();
		MaGererNouveauEmp GE = new MaGererNouveauEmp(idoGE);
		boolean result=GE.supprimer(0);
		assertFalse(result);
	}

}
