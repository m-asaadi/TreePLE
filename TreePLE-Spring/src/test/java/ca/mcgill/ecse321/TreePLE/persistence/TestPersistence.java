package ca.mcgill.ecse321.TreePLE.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.mcgill.ecse321.TreePLE.model.Municipality;
import ca.mcgill.ecse321.TreePLE.model.Municipality.MunicipalityName;
import ca.mcgill.ecse321.TreePLE.model.Tree;
import ca.mcgill.ecse321.TreePLE.model.TreeManager;
import ca.mcgill.ecse321.TreePLE.model.Status;


public class TestPersistence {

	private TreeManager tm;
	
	@Before
	public void setUp() throws Exception {
		tm = new TreeManager();
	
		
		// create Municipality	
		Municipality municipality1 = new Municipality();
		municipality1.setMunicipalityName(MunicipalityName.Montreal);
		Municipality municipality2 = new Municipality();
		municipality2.setMunicipalityName(MunicipalityName.Laval);
				
		//create Tree
		Tree tree1 = new Tree(12, 23, 34, 34, municipality1);
		Tree tree2 = new Tree(34, 24, 26, 34, municipality2);
			
		// manage trees
		tm.addTree(tree1);
		tm.addTree(tree2);
		tm.addMunicipality(municipality1);
		tm.addMunicipality(municipality2);
		

		//create survey
		
	
		//create Forecast

		//create SystemDate
	
	}

	@After
	public void tearDown() throws Exception {
		tm.delete();
	}

	@Test
	public void test() {
		// initialize model file
	    PersistenceXStream.initializeModelManager("output"+File.separator+"data.xml");
	    // save model that is loaded during test setup
	    if (!PersistenceXStream.saveToXMLwithXStream(tm))
	        fail("Could not save file.");

	    // clear the model in memory
	    tm.delete();
	    assertEquals(0, tm.getTrees().size());

	    // load model
	    tm = (TreeManager) PersistenceXStream.loadFromXMLwithXStream();
	    if (tm == null)
	        fail("Could not load file.");

	    // check event
	    assertEquals(2, tm.getTrees().size());
	    assertEquals(12, tm.getTree(0).getHeight(), 0);
	    assertEquals(23, tm.getTree(0).getDiameter(), 0);
	    assertEquals(34, tm.getTree(0).getLongitude(), 0);
	    assertEquals(34, tm.getTree(0).getLatitude(), 0);
	    assertEquals(MunicipalityName.Montreal, tm.getTree(0).getMunicipality().getMunicipalityName());
	    assertEquals(34, tm.getTree(1).getHeight(), 0);
	    assertEquals(24, tm.getTree(1).getDiameter(), 0);
	    assertEquals(26, tm.getTree(1).getLongitude(), 0);
	    assertEquals(34, tm.getTree(1).getLatitude(), 0);
	    assertEquals(MunicipalityName.Laval, tm.getTree(1).getMunicipality().getMunicipalityName());
	    
	}
}


