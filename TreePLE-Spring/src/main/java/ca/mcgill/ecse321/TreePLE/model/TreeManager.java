/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse321.TreePLE.model;
import java.util.*;
import java.sql.Date;

// line 3 "../../../../../TreePLE.ump"
public class TreeManager
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TreeManager Associations
  private List<Tree> trees;
  private List<Person> person;
  private List<Report> reports;
  private List<Municipality> municipality;
  private List<Forecast> forecast;
  private List<Status> statuses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TreeManager()
  {
    trees = new ArrayList<Tree>();
    person = new ArrayList<Person>();
    reports = new ArrayList<Report>();
    municipality = new ArrayList<Municipality>();
    forecast = new ArrayList<Forecast>();
    statuses = new ArrayList<Status>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Tree getTree(int index)
  {
    Tree aTree = trees.get(index);
    return aTree;
  }

  public List<Tree> getTrees()
  {
    List<Tree> newTrees = Collections.unmodifiableList(trees);
    return newTrees;
  }

  public int numberOfTrees()
  {
    int number = trees.size();
    return number;
  }

  public boolean hasTrees()
  {
    boolean has = trees.size() > 0;
    return has;
  }

  public int indexOfTree(Tree aTree)
  {
    int index = trees.indexOf(aTree);
    return index;
  }

  public Person getPerson(int index)
  {
    Person aPerson = person.get(index);
    return aPerson;
  }

  public List<Person> getPerson()
  {
    List<Person> newPerson = Collections.unmodifiableList(person);
    return newPerson;
  }

  public int numberOfPerson()
  {
    int number = person.size();
    return number;
  }

  public boolean hasPerson()
  {
    boolean has = person.size() > 0;
    return has;
  }

  public int indexOfPerson(Person aPerson)
  {
    int index = person.indexOf(aPerson);
    return index;
  }

  public Report getReport(int index)
  {
    Report aReport = reports.get(index);
    return aReport;
  }

  public List<Report> getReports()
  {
    List<Report> newReports = Collections.unmodifiableList(reports);
    return newReports;
  }

  public int numberOfReports()
  {
    int number = reports.size();
    return number;
  }

  public boolean hasReports()
  {
    boolean has = reports.size() > 0;
    return has;
  }

  public int indexOfReport(Report aReport)
  {
    int index = reports.indexOf(aReport);
    return index;
  }

  public Municipality getMunicipality(int index)
  {
    Municipality aMunicipality = municipality.get(index);
    return aMunicipality;
  }

  public List<Municipality> getMunicipality()
  {
    List<Municipality> newMunicipality = Collections.unmodifiableList(municipality);
    return newMunicipality;
  }

  public int numberOfMunicipality()
  {
    int number = municipality.size();
    return number;
  }

  public boolean hasMunicipality()
  {
    boolean has = municipality.size() > 0;
    return has;
  }

  public int indexOfMunicipality(Municipality aMunicipality)
  {
    int index = municipality.indexOf(aMunicipality);
    return index;
  }

  public Forecast getForecast(int index)
  {
    Forecast aForecast = forecast.get(index);
    return aForecast;
  }

  public List<Forecast> getForecast()
  {
    List<Forecast> newForecast = Collections.unmodifiableList(forecast);
    return newForecast;
  }

  public int numberOfForecast()
  {
    int number = forecast.size();
    return number;
  }

  public boolean hasForecast()
  {
    boolean has = forecast.size() > 0;
    return has;
  }

  public int indexOfForecast(Forecast aForecast)
  {
    int index = forecast.indexOf(aForecast);
    return index;
  }

  public Status getStatus(int index)
  {
    Status aStatus = statuses.get(index);
    return aStatus;
  }

  public List<Status> getStatuses()
  {
    List<Status> newStatuses = Collections.unmodifiableList(statuses);
    return newStatuses;
  }

  public int numberOfStatuses()
  {
    int number = statuses.size();
    return number;
  }

  public boolean hasStatuses()
  {
    boolean has = statuses.size() > 0;
    return has;
  }

  public int indexOfStatus(Status aStatus)
  {
    int index = statuses.indexOf(aStatus);
    return index;
  }

  public static int minimumNumberOfTrees()
  {
    return 0;
  }

  public boolean addTree(Tree aTree)
  {
    boolean wasAdded = false;
    if (trees.contains(aTree)) { return false; }
    trees.add(aTree);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTree(Tree aTree)
  {
    boolean wasRemoved = false;
    if (trees.contains(aTree))
    {
      trees.remove(aTree);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTreeAt(Tree aTree, int index)
  {  
    boolean wasAdded = false;
    if(addTree(aTree))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTrees()) { index = numberOfTrees() - 1; }
      trees.remove(aTree);
      trees.add(index, aTree);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTreeAt(Tree aTree, int index)
  {
    boolean wasAdded = false;
    if(trees.contains(aTree))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTrees()) { index = numberOfTrees() - 1; }
      trees.remove(aTree);
      trees.add(index, aTree);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTreeAt(aTree, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfPerson()
  {
    return 0;
  }

  public boolean addPerson(Person aPerson)
  {
    boolean wasAdded = false;
    if (person.contains(aPerson)) { return false; }
    person.add(aPerson);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePerson(Person aPerson)
  {
    boolean wasRemoved = false;
    if (person.contains(aPerson))
    {
      person.remove(aPerson);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPersonAt(Person aPerson, int index)
  {  
    boolean wasAdded = false;
    if(addPerson(aPerson))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPerson()) { index = numberOfPerson() - 1; }
      person.remove(aPerson);
      person.add(index, aPerson);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePersonAt(Person aPerson, int index)
  {
    boolean wasAdded = false;
    if(person.contains(aPerson))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPerson()) { index = numberOfPerson() - 1; }
      person.remove(aPerson);
      person.add(index, aPerson);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPersonAt(aPerson, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfReports()
  {
    return 0;
  }

  public boolean addReport(Report aReport)
  {
    boolean wasAdded = false;
    if (reports.contains(aReport)) { return false; }
    reports.add(aReport);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeReport(Report aReport)
  {
    boolean wasRemoved = false;
    if (reports.contains(aReport))
    {
      reports.remove(aReport);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addReportAt(Report aReport, int index)
  {  
    boolean wasAdded = false;
    if(addReport(aReport))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReports()) { index = numberOfReports() - 1; }
      reports.remove(aReport);
      reports.add(index, aReport);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveReportAt(Report aReport, int index)
  {
    boolean wasAdded = false;
    if(reports.contains(aReport))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReports()) { index = numberOfReports() - 1; }
      reports.remove(aReport);
      reports.add(index, aReport);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addReportAt(aReport, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfMunicipality()
  {
    return 0;
  }

  public boolean addMunicipality(Municipality aMunicipality)
  {
    boolean wasAdded = false;
    if (municipality.contains(aMunicipality)) { return false; }
    municipality.add(aMunicipality);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMunicipality(Municipality aMunicipality)
  {
    boolean wasRemoved = false;
    if (municipality.contains(aMunicipality))
    {
      municipality.remove(aMunicipality);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addMunicipalityAt(Municipality aMunicipality, int index)
  {  
    boolean wasAdded = false;
    if(addMunicipality(aMunicipality))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMunicipality()) { index = numberOfMunicipality() - 1; }
      municipality.remove(aMunicipality);
      municipality.add(index, aMunicipality);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMunicipalityAt(Municipality aMunicipality, int index)
  {
    boolean wasAdded = false;
    if(municipality.contains(aMunicipality))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMunicipality()) { index = numberOfMunicipality() - 1; }
      municipality.remove(aMunicipality);
      municipality.add(index, aMunicipality);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMunicipalityAt(aMunicipality, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfForecast()
  {
    return 0;
  }

  public boolean addForecast(Forecast aForecast)
  {
    boolean wasAdded = false;
    if (forecast.contains(aForecast)) { return false; }
    forecast.add(aForecast);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeForecast(Forecast aForecast)
  {
    boolean wasRemoved = false;
    if (forecast.contains(aForecast))
    {
      forecast.remove(aForecast);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addForecastAt(Forecast aForecast, int index)
  {  
    boolean wasAdded = false;
    if(addForecast(aForecast))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfForecast()) { index = numberOfForecast() - 1; }
      forecast.remove(aForecast);
      forecast.add(index, aForecast);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveForecastAt(Forecast aForecast, int index)
  {
    boolean wasAdded = false;
    if(forecast.contains(aForecast))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfForecast()) { index = numberOfForecast() - 1; }
      forecast.remove(aForecast);
      forecast.add(index, aForecast);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addForecastAt(aForecast, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfStatuses()
  {
    return 0;
  }

  public boolean addStatus(Status aStatus)
  {
    boolean wasAdded = false;
    if (statuses.contains(aStatus)) { return false; }
    statuses.add(aStatus);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStatus(Status aStatus)
  {
    boolean wasRemoved = false;
    if (statuses.contains(aStatus))
    {
      statuses.remove(aStatus);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addStatusAt(Status aStatus, int index)
  {  
    boolean wasAdded = false;
    if(addStatus(aStatus))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStatuses()) { index = numberOfStatuses() - 1; }
      statuses.remove(aStatus);
      statuses.add(index, aStatus);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStatusAt(Status aStatus, int index)
  {
    boolean wasAdded = false;
    if(statuses.contains(aStatus))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStatuses()) { index = numberOfStatuses() - 1; }
      statuses.remove(aStatus);
      statuses.add(index, aStatus);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStatusAt(aStatus, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    trees.clear();
    person.clear();
    reports.clear();
    municipality.clear();
    forecast.clear();
    statuses.clear();
  }

}