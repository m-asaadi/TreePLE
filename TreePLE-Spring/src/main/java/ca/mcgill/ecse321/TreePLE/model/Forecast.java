/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse321.TreePLE.model;
import java.util.*;
import java.sql.Date;

// line 86 "../../../../../TreePLE.ump"
public class Forecast
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextFID = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private int fID;

  //Forecast Associations
  private Person person;
  private List<Report> report;
  private List<Tree> treesToBePlanted;
  private List<Tree> treesToBeCut;
  private List<Tree> currentTrees;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Forecast(Person aPerson)
  {
    fID = nextFID++;
    boolean didAddPerson = setPerson(aPerson);
    if (!didAddPerson)
    {
      throw new RuntimeException("Unable to create forecast due to person");
    }
    report = new ArrayList<Report>();
    treesToBePlanted = new ArrayList<Tree>();
    treesToBeCut = new ArrayList<Tree>();
    currentTrees = new ArrayList<Tree>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getFID()
  {
    return fID;
  }

  public Person getPerson()
  {
    return person;
  }

  public Report getReport(int index)
  {
    Report aReport = report.get(index);
    return aReport;
  }

  public List<Report> getReport()
  {
    List<Report> newReport = Collections.unmodifiableList(report);
    return newReport;
  }

  public int numberOfReport()
  {
    int number = report.size();
    return number;
  }

  public boolean hasReport()
  {
    boolean has = report.size() > 0;
    return has;
  }

  public int indexOfReport(Report aReport)
  {
    int index = report.indexOf(aReport);
    return index;
  }

  public Tree getTreesToBePlanted(int index)
  {
    Tree aTreesToBePlanted = treesToBePlanted.get(index);
    return aTreesToBePlanted;
  }

  public List<Tree> getTreesToBePlanted()
  {
    List<Tree> newTreesToBePlanted = Collections.unmodifiableList(treesToBePlanted);
    return newTreesToBePlanted;
  }

  public int numberOfTreesToBePlanted()
  {
    int number = treesToBePlanted.size();
    return number;
  }

  public boolean hasTreesToBePlanted()
  {
    boolean has = treesToBePlanted.size() > 0;
    return has;
  }

  public int indexOfTreesToBePlanted(Tree aTreesToBePlanted)
  {
    int index = treesToBePlanted.indexOf(aTreesToBePlanted);
    return index;
  }

  public Tree getTreesToBeCut(int index)
  {
    Tree aTreesToBeCut = treesToBeCut.get(index);
    return aTreesToBeCut;
  }

  public List<Tree> getTreesToBeCut()
  {
    List<Tree> newTreesToBeCut = Collections.unmodifiableList(treesToBeCut);
    return newTreesToBeCut;
  }

  public int numberOfTreesToBeCut()
  {
    int number = treesToBeCut.size();
    return number;
  }

  public boolean hasTreesToBeCut()
  {
    boolean has = treesToBeCut.size() > 0;
    return has;
  }

  public int indexOfTreesToBeCut(Tree aTreesToBeCut)
  {
    int index = treesToBeCut.indexOf(aTreesToBeCut);
    return index;
  }

  public Tree getCurrentTree(int index)
  {
    Tree aCurrentTree = currentTrees.get(index);
    return aCurrentTree;
  }

  public List<Tree> getCurrentTrees()
  {
    List<Tree> newCurrentTrees = Collections.unmodifiableList(currentTrees);
    return newCurrentTrees;
  }

  public int numberOfCurrentTrees()
  {
    int number = currentTrees.size();
    return number;
  }

  public boolean hasCurrentTrees()
  {
    boolean has = currentTrees.size() > 0;
    return has;
  }

  public int indexOfCurrentTree(Tree aCurrentTree)
  {
    int index = currentTrees.indexOf(aCurrentTree);
    return index;
  }

  public boolean setPerson(Person aPerson)
  {
    boolean wasSet = false;
    if (aPerson == null)
    {
      return wasSet;
    }

    Person existingPerson = person;
    person = aPerson;
    if (existingPerson != null && !existingPerson.equals(aPerson))
    {
      existingPerson.removeForecast(this);
    }
    person.addForecast(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfReport()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Report addReport(double aCanopy, int aCarbonSequestration, double aBioDiversityIndex, Date aDate)
  {
    return new Report(aCanopy, aCarbonSequestration, aBioDiversityIndex, aDate, this);
  }

  public boolean addReport(Report aReport)
  {
    boolean wasAdded = false;
    if (report.contains(aReport)) { return false; }
    Forecast existingForecast = aReport.getForecast();
    boolean isNewForecast = existingForecast != null && !this.equals(existingForecast);
    if (isNewForecast)
    {
      aReport.setForecast(this);
    }
    else
    {
      report.add(aReport);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeReport(Report aReport)
  {
    boolean wasRemoved = false;
    //Unable to remove aReport, as it must always have a forecast
    if (!this.equals(aReport.getForecast()))
    {
      report.remove(aReport);
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
      if(index > numberOfReport()) { index = numberOfReport() - 1; }
      report.remove(aReport);
      report.add(index, aReport);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveReportAt(Report aReport, int index)
  {
    boolean wasAdded = false;
    if(report.contains(aReport))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReport()) { index = numberOfReport() - 1; }
      report.remove(aReport);
      report.add(index, aReport);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addReportAt(aReport, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfTreesToBePlanted()
  {
    return 0;
  }

  public boolean addTreesToBePlanted(Tree aTreesToBePlanted)
  {
    boolean wasAdded = false;
    if (treesToBePlanted.contains(aTreesToBePlanted)) { return false; }
    treesToBePlanted.add(aTreesToBePlanted);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTreesToBePlanted(Tree aTreesToBePlanted)
  {
    boolean wasRemoved = false;
    if (treesToBePlanted.contains(aTreesToBePlanted))
    {
      treesToBePlanted.remove(aTreesToBePlanted);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTreesToBePlantedAt(Tree aTreesToBePlanted, int index)
  {  
    boolean wasAdded = false;
    if(addTreesToBePlanted(aTreesToBePlanted))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTreesToBePlanted()) { index = numberOfTreesToBePlanted() - 1; }
      treesToBePlanted.remove(aTreesToBePlanted);
      treesToBePlanted.add(index, aTreesToBePlanted);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTreesToBePlantedAt(Tree aTreesToBePlanted, int index)
  {
    boolean wasAdded = false;
    if(treesToBePlanted.contains(aTreesToBePlanted))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTreesToBePlanted()) { index = numberOfTreesToBePlanted() - 1; }
      treesToBePlanted.remove(aTreesToBePlanted);
      treesToBePlanted.add(index, aTreesToBePlanted);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTreesToBePlantedAt(aTreesToBePlanted, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfTreesToBeCut()
  {
    return 0;
  }

  public boolean addTreesToBeCut(Tree aTreesToBeCut)
  {
    boolean wasAdded = false;
    if (treesToBeCut.contains(aTreesToBeCut)) { return false; }
    treesToBeCut.add(aTreesToBeCut);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTreesToBeCut(Tree aTreesToBeCut)
  {
    boolean wasRemoved = false;
    if (treesToBeCut.contains(aTreesToBeCut))
    {
      treesToBeCut.remove(aTreesToBeCut);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTreesToBeCutAt(Tree aTreesToBeCut, int index)
  {  
    boolean wasAdded = false;
    if(addTreesToBeCut(aTreesToBeCut))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTreesToBeCut()) { index = numberOfTreesToBeCut() - 1; }
      treesToBeCut.remove(aTreesToBeCut);
      treesToBeCut.add(index, aTreesToBeCut);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTreesToBeCutAt(Tree aTreesToBeCut, int index)
  {
    boolean wasAdded = false;
    if(treesToBeCut.contains(aTreesToBeCut))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTreesToBeCut()) { index = numberOfTreesToBeCut() - 1; }
      treesToBeCut.remove(aTreesToBeCut);
      treesToBeCut.add(index, aTreesToBeCut);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTreesToBeCutAt(aTreesToBeCut, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfCurrentTrees()
  {
    return 0;
  }

  public boolean addCurrentTree(Tree aCurrentTree)
  {
    boolean wasAdded = false;
    if (currentTrees.contains(aCurrentTree)) { return false; }
    currentTrees.add(aCurrentTree);
    if (aCurrentTree.indexOfForecast(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCurrentTree.addForecast(this);
      if (!wasAdded)
      {
        currentTrees.remove(aCurrentTree);
      }
    }
    return wasAdded;
  }

  public boolean removeCurrentTree(Tree aCurrentTree)
  {
    boolean wasRemoved = false;
    if (!currentTrees.contains(aCurrentTree))
    {
      return wasRemoved;
    }

    int oldIndex = currentTrees.indexOf(aCurrentTree);
    currentTrees.remove(oldIndex);
    if (aCurrentTree.indexOfForecast(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCurrentTree.removeForecast(this);
      if (!wasRemoved)
      {
        currentTrees.add(oldIndex,aCurrentTree);
      }
    }
    return wasRemoved;
  }

  public boolean addCurrentTreeAt(Tree aCurrentTree, int index)
  {  
    boolean wasAdded = false;
    if(addCurrentTree(aCurrentTree))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCurrentTrees()) { index = numberOfCurrentTrees() - 1; }
      currentTrees.remove(aCurrentTree);
      currentTrees.add(index, aCurrentTree);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCurrentTreeAt(Tree aCurrentTree, int index)
  {
    boolean wasAdded = false;
    if(currentTrees.contains(aCurrentTree))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCurrentTrees()) { index = numberOfCurrentTrees() - 1; }
      currentTrees.remove(aCurrentTree);
      currentTrees.add(index, aCurrentTree);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCurrentTreeAt(aCurrentTree, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Person placeholderPerson = person;
    this.person = null;
    if(placeholderPerson != null)
    {
      placeholderPerson.removeForecast(this);
    }
    for(int i=report.size(); i > 0; i--)
    {
      Report aReport = report.get(i - 1);
      aReport.delete();
    }
    treesToBePlanted.clear();
    treesToBeCut.clear();
    ArrayList<Tree> copyOfCurrentTrees = new ArrayList<Tree>(currentTrees);
    currentTrees.clear();
    for(Tree aCurrentTree : copyOfCurrentTrees)
    {
      aCurrentTree.removeForecast(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "fID" + ":" + getFID()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "person = "+(getPerson()!=null?Integer.toHexString(System.identityHashCode(getPerson())):"null");
  }
}