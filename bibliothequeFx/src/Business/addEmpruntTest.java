package Business;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.javafx.scene.control.skin.ComboBoxPopupControl.FakeFocusTextField;

import ImpDAO.ImpDAOGererNouveauEmp;
import IserviceDAO.IDAOGererNouveauEmp;
import junit.framework.Assert;

public class addEmpruntTest {
	private ImpDAOGererNouveauEmp impDAOGererNouveauEmp;

	@Test
	public void test() {
		//FakeimpdaogérerEmp FGE=new FakeimpdaogérerEmp();
		GererNouveauEmprunt GE= new GererNouveauEmprunt(impDAOGererNouveauEmp);
		boolean result=GE.addEmprunt(null);
		assertFalse(result);
	}

}
