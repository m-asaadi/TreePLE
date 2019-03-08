/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse321.TreePLE.model;
import java.util.*;
import java.sql.Date;

// line 14 "../../../../../TreePLE.ump"
public class Tree
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum TreeSpecies { Willow, RedMaple, LobollyPine, Sweetgum, DouglasFir, QuackingAspen, SugarMaple, Balsamfir, FloweringDogwood, LodgepolePine, WhiteOak }
  public enum LandType { Residential, Institutional, Park, Municipal }

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextTreeID = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Tree Attributes
  private TreeSpecies treeSpecies;
  private double height;
  private double diameter;
  private double longitude;
  private double latitude;
  private LandType landType;

  //Autounique Attributes
  private int treeID;

  //Tree Associations
  private List<Status> statuses;
  private Municipality municipality;
  private Status currentStatus;
  private List<Report> reports;
  private List<Forecast> forecasts;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Tree(double aHeight, double aDiameter, double aLongitude, double aLatitude, Municipality aMunicipality)
  {
    height = aHeight;
    diameter = aDiameter;
    longitude = aLongitude;
    latitude = aLatitude;
    treeID = nextTreeID++;
    statuses = new ArrayList<Status>();
    boolean didAddMunicipality = setMunicipality(aMunicipality);
    if (!didAddMunicipality)
    {
      throw new RuntimeException("Unable to create tree due to municipality");
    }
    reports = new ArrayList<Report>();
    forecasts = new ArrayList<Forecast>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTreeSpecies(TreeSpecies aTreeSpecies)
  {
    boolean wasSet = false;
    treeSpecies = aTreeSpecies;
    wasSet = true;
    return wasSet;
  }

  public boolean setHeight(double aHeight)
  {
    boolean wasSet = false;
    height = aHeight;
    wasSet = true;
    return wasSet;
  }

  public boolean setDiameter(double aDiameter)
  {
    boolean wasSet = false;
    diameter = aDiameter;
    wasSet = true;
    return wasSet;
  }

  public boolean setLongitude(double aLongitude)
  {
    boolean wasSet = false;
    longitude = aLongitude;
    wasSet = true;
    return wasSet;
  }

  public boolean setLatitude(double aLatitude)
  {
    boolean wasSet = false;
    latitude = aLatitude;
    wasSet = true;
    return wasSet;
  }

  public boolean setLandType(LandType aLandType)
  {
    boolean wasSet = false;
    landType = aLandType;
    wasSet = true;
    return wasSet;
  }

  public TreeSpecies getTreeSpecies()
  {
    return treeSpecies;
  }

  /**
   * enum TreeSpecies {Willow}
   * lazy TreeSpecies treeSpecies;
   */
  public double getHeight()
  {
    return height;
  }

  public double getDiameter()
  {
    return diameter;
  }

  public double getLongitude()
  {
    return longitude;
  }

  public double getLatitude()
  {
    return latitude;
  }

  public LandType getLandType()
  {
    return landType;
  }

  public int getTreeID()
  {
    return treeID;
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

  public Municipality getMunicipality()
  {
    return municipality;
  }

  public Status getCurrentStatus()
  {
    return currentStatus;
  }

  public boolean hasCurrentStatus()
  {
    boolean has = currentStatus != null;
    return has;
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

  public Forecast getForecast(int index)
  {
    Forecast aForecast = forecasts.get(index);
    return aForecast;
  }

  public List<Forecast> getForecasts()
  {
    List<Forecast> newForecasts = Collections.unmodifiableList(forecasts);
    return newForecasts;
  }

  public int numberOfForecasts()
  {
    int number = forecasts.size();
    return number;
  }

  public boolean hasForecasts()
  {
    boolean has = forecasts.size() > 0;
    return has;
  }

  public int indexOfForecast(Forecast aForecast)
  {
    int index = forecasts.indexOf(aForecast);
    return index;
  }

  public static int minimumNumberOfStatuses()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Status addStatus(Date aDate, Person aPerson)
  {
    return new Status(aDate, this, aPerson);
  }

  public boolean addStatus(Status aStatus)
  {
    boolean wasAdded = false;
    if (statuses.contains(aStatus)) { return false; }
    Tree existingTree = aStatus.getTree();
    boolean isNewTree = existingTree != null && !this.equals(existingTree);
    if (isNewTree)
    {
      aStatus.setTree(this);
    }
    else
    {
      statuses.add(aStatus);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStatus(Status aStatus)
  {
    boolean wasRemoved = false;
    //Unable to remove aStatus, as it must always have a tree
    if (!this.equals(aStatus.getTree()))
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

  public boolean setMunicipality(Municipality aMunicipality)
  {
    boolean wasSet = false;
    if (aMunicipality == null)
    {
      return wasSet;
    }

    Municipality existingMunicipality = municipality;
    municipality = aMunicipality;
    if (existingMunicipality != null && !existingMunicipality.equals(aMunicipality))
    {
      existingMunicipality.removeTree(this);
    }
    municipality.addTree(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentStatus(Status aNewCurrentStatus)
  {
    boolean wasSet = false;
    currentStatus = aNewCurrentStatus;
    wasSet = true;
    return wasSet;
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
    if (aReport.indexOfTreesForReport(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aReport.addTreesForReport(this);
      if (!wasAdded)
      {
        reports.remove(aReport);
      }
    }
    return wasAdded;
  }

  public boolean removeReport(Report aReport)
  {
    boolean wasRemoved = false;
    if (!reports.contains(aReport))
    {
      return wasRemoved;
    }

    int oldIndex = reports.indexOf(aReport);
    reports.remove(oldIndex);
    if (aReport.indexOfTreesForReport(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aReport.removeTreesForReport(this);
      if (!wasRemoved)
      {
        reports.add(oldIndex,aReport);
      }
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

  public static int minimumNumberOfForecasts()
  {
    return 0;
  }

  public boolean addForecast(Forecast aForecast)
  {
    boolean wasAdded = false;
    if (forecasts.contains(aForecast)) { return false; }
    if (forecasts.contains(aForecast)) { return false; }
    if (forecasts.contains(aForecast)) { return false; }
    forecasts.add(aForecast);
    if (aForecast.indexOfCurrentTree(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aForecast.addCurrentTree(this);
      if (!wasAdded)
      {
        forecasts.remove(aForecast);
      }
    }
    return wasAdded;
  }

  public boolean removeForecast(Forecast aForecast)
  {
    boolean wasRemoved = false;
    if (!forecasts.contains(aForecast))
    {
      return wasRemoved;
    }

    int oldIndex = forecasts.indexOf(aForecast);
    forecasts.remove(oldIndex);
    if (aForecast.indexOfCurrentTree(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aForecast.removeCurrentTree(this);
      if (!wasRemoved)
      {
        forecasts.add(oldIndex,aForecast);
      }
    }
    return wasRemoved;
  }

  public boolean addForecastAt(Forecast aForecast, int index)
  {  
    boolean wasAdded = false;
    if(addForecast(aForecast))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfForecasts()) { index = numberOfForecasts() - 1; }
      forecasts.remove(aForecast);
      forecasts.add(index, aForecast);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveForecastAt(Forecast aForecast, int index)
  {
    boolean wasAdded = false;
    if(forecasts.contains(aForecast))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfForecasts()) { index = numberOfForecasts() - 1; }
      forecasts.remove(aForecast);
      forecasts.add(index, aForecast);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addForecastAt(aForecast, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=statuses.size(); i > 0; i--)
    {
      Status aStatus = statuses.get(i - 1);
      aStatus.delete();
    }
    Municipality placeholderMunicipality = municipality;
    this.municipality = null;
    if(placeholderMunicipality != null)
    {
      placeholderMunicipality.removeTree(this);
    }
    currentStatus = null;
    ArrayList<Report> copyOfReports = new ArrayList<Report>(reports);
    reports.clear();
    for(Report aReport : copyOfReports)
    {
      aReport.removeTreesForReport(this);
    }
    ArrayList<Forecast> copyOfForecasts = new ArrayList<Forecast>(forecasts);
    forecasts.clear();
    for(Forecast aForecast : copyOfForecasts)
    {
      aForecast.removeCurrentTree(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "treeID" + ":" + getTreeID()+ "," +
            "height" + ":" + getHeight()+ "," +
            "diameter" + ":" + getDiameter()+ "," +
            "longitude" + ":" + getLongitude()+ "," +
            "latitude" + ":" + getLatitude()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "treeSpecies" + "=" + (getTreeSpecies() != null ? !getTreeSpecies().equals(this)  ? getTreeSpecies().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "landType" + "=" + (getLandType() != null ? !getLandType().equals(this)  ? getLandType().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "municipality = "+(getMunicipality()!=null?Integer.toHexString(System.identityHashCode(getMunicipality())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "currentStatus = "+(getCurrentStatus()!=null?Integer.toHexString(System.identityHashCode(getCurrentStatus())):"null");
  }
}