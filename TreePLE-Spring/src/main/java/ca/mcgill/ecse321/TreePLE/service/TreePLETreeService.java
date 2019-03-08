package ca.mcgill.ecse321.TreePLE.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

//import ca.mcgill.ecse321.TreePLE.controller.RequestParam;
import ca.mcgill.ecse321.TreePLE.model.Forecast;
import ca.mcgill.ecse321.TreePLE.model.Municipality;
import ca.mcgill.ecse321.TreePLE.model.Municipality.MunicipalityName;
import ca.mcgill.ecse321.TreePLE.model.Person;
import ca.mcgill.ecse321.TreePLE.model.Person.Level;
import ca.mcgill.ecse321.TreePLE.model.Report;
import ca.mcgill.ecse321.TreePLE.model.Scientist;
import ca.mcgill.ecse321.TreePLE.model.Status;
import ca.mcgill.ecse321.TreePLE.model.Status.TreeState;
import ca.mcgill.ecse321.TreePLE.model.Tree;
import ca.mcgill.ecse321.TreePLE.model.Tree.LandType;
import ca.mcgill.ecse321.TreePLE.model.Tree.TreeSpecies;
import ca.mcgill.ecse321.TreePLE.model.TreeManager;
import ca.mcgill.ecse321.TreePLE.persistence.PersistenceXStream;

@Service
public class TreePLETreeService {
	private TreeManager tm;
	

		public TreePLETreeService(TreeManager tm)
		{
		  this.tm = tm;
		  Person scientist1= new Person( "John");
		  Person scientist2= new Person("Daniel");
		  Scientist s= new Scientist();
		  scientist1.setRoles(s);
		  Scientist s2= new Scientist();
		  scientist2.setRoles(s2);
		  Municipality m1= new Municipality();
		  m1.setMunicipalityName(MunicipalityName.Montreal);
		  Municipality m2= new Municipality();
		  m2.setMunicipalityName(MunicipalityName.Laval);
		  tm.addMunicipality(m1);
		  tm.addMunicipality(m2);
		  tm.addPerson(scientist1);
		  tm.addPerson(scientist2);
		  
		}
		
		
		
		public Boolean login(String userName, String userRole) throws InvalidInputException {
			List<String> scientists= getAllScientistNames();
			Scientist s= new Scientist();
			if (userRole==s.getRole()){
				if(scientists.contains(userName)) { return true;}
				else { throw new InvalidInputException("this is not a valid Scientist ID.");}
				
			}
			else {
				List<Person> users= listAllUsers();
				  Person user =null;
				  for(Person p : users) {
					  if (p.getName()==userName) { user=p;}
				  }
				  if(user==null) {
					  user= new Person(userName);
				  }
				  
				  return true;
				
			}
			
		}
		
		
		public Report generateReportForForecast(Forecast f) throws InvalidInputException {
	int i=0;
	for(i=0; i<f.getCurrentTrees().size();i++) {
		f.removeCurrentTree(f.getCurrentTree(i));
	}
	for(i=0; i<f.getTreesToBePlanted().size();i++) {
		f.addCurrentTree(f.getTreesToBePlanted(i));
	}
	List<Tree> currentToAdd = new ArrayList<Tree>();
	currentToAdd = getNonCutTreesInList(tm.getTrees());
	for(i=0; i<currentToAdd.size();i++) {
		if(!(f.getTreesToBeCut().contains(currentToAdd.get(i)))){
			f.addCurrentTree(currentToAdd.get(i));}}
	double b=0;
	double c= 0;
	int s=0;
	b= CalculateBioDiversityIndexForTrees(f.getCurrentTrees());
	c= calculateTotalCanopyForTrees(f.getCurrentTrees());
	s= CalculateCarbonSeqPerYear(f.getCurrentTrees());
	Date d= new Date();
	Report r= new Report(c,s,b,d,f);
	for(i=0; i<f.getCurrentTrees().size();i++) {
		r.addTreesForReport(f.getCurrentTree(i));
	}
	return r;
	
		}
		
		
		
		
		public Forecast createNewForecast(String userName) {
			List<Person> users= listAllUsers();
			  Person user =null;
			  for(Person p : users) {
				  if (p.getName()==userName) { user=p;}
			  }
			  if(user==null) {
				  user= new Person(userName);
			  }
			
			Forecast f= new Forecast(user);
			tm.addPerson(user);
			tm.addForecast(f);
			 PersistenceXStream.saveToXMLwithXStream(tm);
			return f;
			
		}
		public String getDescriptionOfForecast(Forecast f) {
			String Description="Planted "+String.valueOf(f.getTreesToBePlanted().size())+"in"+f.getTreesToBePlanted(0).getMunicipality().getMunicipalityName().toString()+f.getTreesToBePlanted(0).getTreeSpecies().toString()+"  and Cut: "+
					String.valueOf(f.getTreesToBeCut().size())+"in"+f.getTreesToBeCut(0).getMunicipality().getMunicipalityName().toString()+f.getTreesToBeCut(0).getTreeSpecies().toString();
			return Description;}
		
		public Forecast PlantTreeForForecast(Forecast f,LandType landtype, TreeSpecies species, double height, double diameter, double longitude, double latitude, MunicipalityName munName, int quantity) throws InvalidInputException{
			 if (species == null  || height ==0 || diameter ==0 || longitude ==0 || latitude ==0 || landtype == null  || munName == null || quantity<=0) {
				    throw new InvalidInputException("Missing information");
				  }
			 double k=0;
			 Municipality m= new Municipality();
			 for(int i=0; i<quantity;i++) {
				  Tree t = new Tree(height, diameter, (longitude+k), (latitude+k), m);
				  Person user= f.getPerson();
				  Date date1= new Date();
				  Status s = new Status(date1,t,user);
				 
				  //change tree status to planted
				  s.setTreeState(TreeState.Planted);
				  t.setCurrentStatus(s);
				  
				  t.addStatus(s);
				  
				
				  
				  //set tree species
				  t.setTreeSpecies(species);
				  
				  //set Landtype
				  t.setLandType(landtype);
				  
				
				  
				  //set municipality
				  t.setMunicipality(m);
				 
				  f.addTreesToBePlanted(t);
				  k=k+0.00001;}
				  tm.addForecast(f);
				  PersistenceXStream.saveToXMLwithXStream(tm);
				  return f ;
				  
				  
		}
		
		
		public List<Tree> getPlantedTrees(){
			List<Tree> ts= new ArrayList <Tree>();
			for (Tree tree: tm.getTrees()) {
				if(tree.getCurrentStatus().getTreeState().equals(TreeState.Planted)) {
				ts.add(tree);}}
				return ts;
				
				}
		
		public Tree getPlantedTreeByLocation( double latitude, double longitude) throws InvalidInputException {
			Tree tn=null;
			for (Tree t : getPlantedTrees()) {
				if (t.getLatitude()==latitude&&t.getLongitude()==longitude) {
					tn=t;
					//return tn;
					break;
				}
			}
			
			 if (tn==null) { throw new InvalidInputException ("no tree exists here");}
			 else {return tn;}
		}
		
		public Tree getTreeByID  (int id) throws InvalidInputException  {
			List<Tree> alltrees= listAllTrees();
			Tree tree= null;
			for (Tree tr : alltrees) {
				if(tr.getTreeID()==id) {
					tree=tr;
					break;
				}
			}
			if (tree == null) { throw new InvalidInputException("Tree doesn't exist");}
			else{return tree;}
		}
		
			
		public Municipality getMunicipalityByName  (MunicipalityName municipalityName) throws InvalidInputException  {
			List<Municipality>allMunicipalities= findAllMunicipalities();
		Municipality mun= null;
		for (Municipality n : allMunicipalities) {
			if(n.getMunicipalityName().equals(municipalityName)) {
				mun=n;
				break;
			}
		}
		
		if (mun==null) { /*Municipality mun2= new Municipality();
			mun2.setMunicipalityName(municipalityName);
		return mun2; */
			throw new InvalidInputException ("municipality does not exist");}
		
		else{return mun;}
	}
		
	
		
		//plant a tree method
		public Tree plantTree(LandType landtype, TreeSpecies species, double height, double diameter, double longitude, double latitude, MunicipalityName munName, String userName) throws InvalidInputException
		{
		  if (species == null  || height ==0 || diameter ==0 || longitude ==0 || latitude ==0 || landtype == null  || munName == null) {
		    throw new InvalidInputException("Missing information");
		  }
		  Municipality municipality= getMunicipalityByName(munName);
		  Tree t = new Tree(height, diameter, longitude, latitude, municipality);
		  List<Person> users= listAllUsers();
		  Person user =null;
		  for(Person p : users) {
			  if (p.getName()==userName) { user=p;}
		  }
		  if(user==null) {
			  user= new Person(userName);
		  }
		  
			  
		  user.setTreesPlanted(user.getTreesPlanted()+1);
		  Date date1= new Date();
		  Status s = new Status(date1,t,user);
		 
		  //change tree status to planted
		  s.setTreeState(TreeState.Planted);
		  t.setCurrentStatus(s);
		  
		  t.addStatus(s);
		  
		
		  
		  //set tree species
		  t.setTreeSpecies(species);
		  
		  //set Landtype
		  t.setLandType(landtype);
		  
		
		  
		  //set municipality
		  t.setMunicipality(municipality);
		  //MunicipalityName name = municipality.getMunicipalityName();
		  //municipality.setMunicipalityName(name);
		  municipality.addTree(t);
		  
		  //add tree to the list
		  tm.addPerson(user);
		  tm.addStatus(s);
		  tm.addTree(t);
		  PersistenceXStream.saveToXMLwithXStream(tm);
		  return t;
		}
		
		//list all trees
		public List<Tree> listAllTrees()
		{
		 
			return tm.getTrees();
		}
		
		public List<Municipality> listAllMunicipalities()
		{
		 
			return tm.getMunicipality();
		}
		
		public List<String>  listAllSpecies()
		{
			List<String>species=new ArrayList<String>();
		
		 for(int i=0;i<Tree.TreeSpecies.values().length;i++) {
			species.add( Tree.TreeSpecies.values()[i].toString());}
		 return species;
		}
		
		public List<String>  listAllStates()
		{
			List<String>states=new ArrayList<String>();
		
		 for(int i=0;i<Status.TreeState.values().length;i++) {
			states.add( Status.TreeState.values()[i].toString());}
		 return states;
		}
		
		public List<Person> listAllUsers()
		{
		 
			return tm.getPerson();
		}
		public List<Tree> getNonCutTreesInList(List<Tree> treeList){
			List<Tree> ts= new ArrayList <Tree>();
			for (Tree tree: treeList) {
				if(!tree.getCurrentStatus().getTreeState().equals(TreeState.Cut)) {
				ts.add(tree);}}
				return ts;
				
				}
			
		
		public double CalculateBioDiversityIndexForTrees(List<Tree> treeList) throws InvalidInputException {
			
			if (treeList==null) { 
				throw new InvalidInputException ("Missing Information");}
			
			List<Tree> ts= new ArrayList <Tree>();
			ts= getNonCutTreesInList(treeList);
			List<TreeSpecies>Species= new ArrayList<TreeSpecies>();
			for (Tree tree: ts) {
				TreeSpecies n= tree.getTreeSpecies();
				if( Species.contains(n)){}
				else { Species.add(n);}
				}
			double numerator= Species.size();
			double denominator=treeList.size();
			double index= numerator/denominator;
			return index;
			
			
				
			}
			
public int CalculateCarbonSeqPerYear(List<Tree> treeList) {
	List<Tree> ts= new ArrayList <Tree>();
	ts= getNonCutTreesInList(treeList);
	return (ts.size()*48);
			
}

public double calculateTotalCanopyForTrees(List<Tree> treeList) throws InvalidInputException {
	
	if (treeList==null) { 
		throw new InvalidInputException ("Missing Information");}
	
	double TotalCanopy=0;
	double area=0;
	List<Tree> ts= new ArrayList <Tree>();
	ts= getNonCutTreesInList(treeList);
	for (Tree tree: ts) {
		area=(3.14)*(tree.getDiameter()*0.5)*(tree.getDiameter()*0.5);
	TotalCanopy=TotalCanopy+area;
			
		}
	return TotalCanopy;
	
}
		
public double calculateCurrentTotalCanopy() throws InvalidInputException {
	
	List<Tree> treeList=listAllTrees();
	List<Tree> ts= new ArrayList <Tree>();
	ts= getNonCutTreesInList(treeList);
	if (treeList==null) { 
		throw new InvalidInputException ("Missing Information");}
	double TotalCanopy=0;
	double  area=0;
	for (Tree tree: ts) {
		area=(3.14)*(tree.getDiameter()*0.5)*(tree.getDiameter()*0.5);
	TotalCanopy=TotalCanopy+area;
			
		}
	return TotalCanopy;
	
}
				
public double CalculateCurrentBioDiversityIndex() {
	List<Tree> treeList= listAllTrees();
	List<Tree> ts= new ArrayList <Tree>();
	ts= getNonCutTreesInList(treeList);
	List<TreeSpecies>Species= new ArrayList<TreeSpecies>();
	for (Tree tree: ts) {
		TreeSpecies n= tree.getTreeSpecies();
		if( Species.contains(n)){}
		else { Species.add(n);}
		}
	double numerator= Species.size();
	double denominator=treeList.size();
	double index= numerator/denominator;
	return index;
		
	}
	
public int CalculateCurrentCarbonSeqPerYear() {
	List<Tree> treeList= listAllTrees();
	List<Tree> ts= new ArrayList <Tree>();
	ts= getNonCutTreesInList(treeList);
return (ts.size()*48);
	
}
		
		
		//get tree by species
		public List <Tree> getTreeBySpecies(TreeSpecies species) throws InvalidInputException {
			List<Tree> alltrees= listAllTrees();
			List<Tree> treesBySpecies = new ArrayList<Tree>();
			
			for (Tree tr : alltrees) {
				if(tr.getTreeSpecies().equals(species)) {
					treesBySpecies.add(tr);
				}
			}
			if (treesBySpecies == null || treesBySpecies.size() ==0) { throw new InvalidInputException("Tree of this species doesn't exist");}
			
			
			else{return treesBySpecies;}
		}
		
		public List <Tree> getTreeByState(TreeState ts) throws InvalidInputException {
			List<Tree> alltrees= listAllTrees();
			List<Tree> treesByState =new ArrayList<Tree>();
			
			for (Tree tr : alltrees) {
				if(tr.getCurrentStatus().getTreeState().equals(ts)) {
					treesByState.add(tr);
				}
			}
			if (treesByState == null || treesByState.size() == 0) { throw new InvalidInputException("Tree of this species doesn't exist");}
			else{return treesByState;}
		}
	
		
		//get tree by municipality
		public List<Tree> getTreeByMunicipality(MunicipalityName municipalityName){
			
		Municipality municipality= new Municipality();
		
			try {
				municipality = getMunicipalityByName(municipalityName);
			} catch (InvalidInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return municipality.getTrees();
			
			
		}
		
		public Municipality getMunicipalityForTree(Tree t) {
			return t.getMunicipality();
		}
		public List<Municipality> findAllMunicipalities()
		{
		  // service stub
			return tm.getMunicipality();
		}
		
		
		
		public Forecast cutDownTreeForForecast(Tree t, Forecast f) throws InvalidInputException{
			if(t==null) {
				throw new InvalidInputException("fill in the missing information");
			}
			
			 
			  //change tree status to planted
			
			  f.addTreesToBeCut(t);
			  PersistenceXStream.saveToXMLwithXStream(tm);
			  return f ;
			  
			  	
			
		}
		
		
		
		public Forecast cutDownTreesinAreaForForecast(double latitude, Forecast f, double longitude, MunicipalityName munName) throws InvalidInputException{
			if(munName==null||f==null) {
				throw new InvalidInputException("fill in the missing information");
			}
			List<Tree> treesInMun=getMunicipalityByName(munName).getTrees();
			double k= 0.09;
			for(Tree t:treesInMun) {
		
			if((Math.abs(t.getLatitude()-latitude)<k)&&(Math.abs(t.getLongitude()-longitude)<k)) {
			  f.addTreesToBeCut(t);}}
			  PersistenceXStream.saveToXMLwithXStream(tm);
			  return f ;
			  
			  	
			
		}
		
		public String pollUserLevel(String userName) throws InvalidInputException {
			Person person= getUserByName(userName);
			int score= person.getTreesPlanted()-person.getTreesCut();
			if (score>=5&&score<10) { person.setLevel(Level.RemarkableCitizen); return("Congratulations, you now have the title of Remarkable Citizen! Keep planting to level up!");}
			if (score>=10&&score<20) { person.setLevel(Level.ExceptionalCitizen); return("Congratulations, you now have the title of Exceptional Citizen! Keep planting to level up!");}
			if (score>=20) { person.setLevel(Level.PerfectCitizen); return("Congratulations, you now have the title of Perfect Citizen!");}				
			else { return (" No earned titles.Keep planting trees to level up!");}
		}
		
		
		public List<String> getAllScientistNames(){
			List<Person> users= listAllUsers();
			List<String> scientists= new ArrayList<String>();
			Scientist s= new Scientist();
			 for(Person p : users) {
				 if (p.getRoles()!=null) {
				  if (p.getRoles().equals(s.getClass())) { 
					scientists.add(p.getName());  
					  

				  }
				 }

			  }
			
			return scientists;
		}
		
		public Person getUserByName(String userName) throws InvalidInputException {
			List<Person> users= listAllUsers();
			  Person user =null;
			  for(Person p : users) {
				  if (p.getName()==userName) { user=p;}
			  }
			  if(user==null) {
				 throw new InvalidInputException("user doesn't exist!");}
			  else {return user;}
			  
		}
		//cut down tree
		public Tree cutDownTree(Tree t, String userName) throws InvalidInputException {
			if((t==null)) {
				throw new InvalidInputException("Please fill in all missing information!")	;
			}
			List<Person> users= listAllUsers();
			  Person user =null;
			  for(Person p : users) {
				  if (p.getName()==userName) { user=p;}
			  }
			  if(user==null) {
				  user= new Person(userName);
			  }
			  user.setTreesCut(user.getTreesCut()+1);
				Date date = new Date();
			  Status s = new Status(date,t,user);
			
		
		
			s.setTreeState(TreeState.Cut);
		
			t.addStatus(s);
			t.setCurrentStatus(s);
			
			tm.addStatus(s);
			PersistenceXStream.saveToXMLwithXStream(tm);
			  
			return t;
			
		}
		//mark as diseased
		
		public Tree MarkTreeAsDiseased(Tree t,String userName) throws InvalidInputException {
			if((t==null)||(userName==null)||(userName.trim().length() == 0)) {
				throw new InvalidInputException("Please fill in all missing information!")	;
			}
			
		
		List<Person> users= listAllUsers();
		  Person user =null;
		  for(Person p : users) {
			  if (p.getName()==userName) { user=p;}
		  }
		  if(user==null) {
			  user= new Person(userName);
		  }
			Date date = new Date();
		  Status s = new Status(date,t,user);
		
	
	
		s.setTreeState(TreeState.Diseased);
	
		t.addStatus(s);
		t.setCurrentStatus(s);
		 tm.addPerson(user);
		tm.addStatus(s);
		PersistenceXStream.saveToXMLwithXStream(tm);
		  
		return t;
		
	}
		
		public Tree MarkTreeToBeCutDown(Tree t, String userName) throws InvalidInputException {
			if((t==null)||(userName==null)||(userName.trim().length() == 0)) {
				throw new InvalidInputException("Please fill in all missing information!")	;
			}
		
		List<Person> users= listAllUsers();
		  Person user =null;
		  for(Person p : users) {
			  if (p.getName()==userName) { user=p;}
		  }
		  if(user==null) {
			  user= new Person(userName);
		  }
			Date date = new Date();
		  Status s = new Status(date,t,user);
		
		 tm.addPerson(user);
	
		s.setTreeState(TreeState.ToBeCut);
	
		t.addStatus(s);
		t.setCurrentStatus(s);
		
		tm.addStatus(s);
		PersistenceXStream.saveToXMLwithXStream(tm);
		  
		return t;
		
	}
		

}
