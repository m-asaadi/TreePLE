/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse321.TreePLE.model;
import java.util.Date;
import java.util.*;

// line 73 "../../../../../TreePLE.ump"
public class Report
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Report Attributes
  private double canopy;
  private int carbonSequestration;
  private double bioDiversityIndex;
  private Date date;

  //Report Associations
  private List<Tree> treesForReport;
  private Forecast forecast;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Report(double aCanopy, int aCarbonSequestration, double aBioDiversityIndex, Date aDate, Forecast aForecast)
  {
    canopy = aCanopy;
    carbonSequestration = aCarbonSequestration;
    bioDiversityIndex = aBioDiversityIndex;
    date = aDate;
    treesForReport = new ArrayList<Tree>();
    boolean didAddForecast = setForecast(aForecast);
    if (!didAddForecast)
    {
      throw new RuntimeException("Unable to create report due to forecast");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCanopy(double aCanopy)
  {
    boolean wasSet = false;
    canopy = aCanopy;
    wasSet = true;
    return wasSet;
  }

  public boolean setCarbonSequestration(int aCarbonSequestration)
  {
    boolean wasSet = false;
    carbonSequestration = aCarbonSequestration;
    wasSet = true;
    return wasSet;
  }

  public boolean setBioDiversityIndex(double aBioDiversityIndex)
  {
    boolean wasSet = false;
    bioDiversityIndex = aBioDiversityIndex;
    wasSet = true;
    return wasSet;
  }

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public double getCanopy()
  {
    return canopy;
  }

  public int getCarbonSequestration()
  {
    return carbonSequestration;
  }

  public double getBioDiversityIndex()
  {
    return bioDiversityIndex;
  }

  public Date getDate()
  {
    return date;
  }

  public Tree getTreesForReport(int index)
  {
    Tree aTreesForReport = treesForReport.get(index);
    return aTreesForReport;
  }

  public List<Tree> getTreesForReport()
  {
    List<Tree> newTreesForReport = Collections.unmodifiableList(treesForReport);
    return newTreesForReport;
  }

  public int numberOfTreesForReport()
  {
    int number = treesForReport.size();
    return number;
  }

  public boolean hasTreesForReport()
  {
    boolean has = treesForReport.size() > 0;
    return has;
  }

  public int indexOfTreesForReport(Tree aTreesForReport)
  {
    int index = treesForReport.indexOf(aTreesForReport);
    return index;
  }

  public Forecast getForecast()
  {
    return forecast;
  }

  public static int minimumNumberOfTreesForReport()
  {
    return 0;
  }

  public boolean addTreesForReport(Tree aTreesForReport)
  {
    boolean wasAdded = false;
    if (treesForReport.contains(aTreesForReport)) { return false; }
    treesForReport.add(aTreesForReport);
    if (aTreesForReport.indexOfReport(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTreesForReport.addReport(this);
      if (!wasAdded)
      {
        treesForReport.remove(aTreesForReport);
      }
    }
    return wasAdded;
  }

  public boolean removeTreesForReport(Tree aTreesForReport)
  {
    boolean wasRemoved = false;
    if (!treesForReport.contains(aTreesForReport))
    {
      return wasRemoved;
    }

    int oldIndex = treesForReport.indexOf(aTreesForReport);
    treesForReport.remove(oldIndex);
    if (aTreesForReport.indexOfReport(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTreesForReport.removeReport(this);
      if (!wasRemoved)
      {
        treesForReport.add(oldIndex,aTreesForReport);
      }
    }
    return wasRemoved;
  }

  public boolean addTreesForReportAt(Tree aTreesForReport, int index)
  {  
    boolean wasAdded = false;
    if(addTreesForReport(aTreesForReport))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTreesForReport()) { index = numberOfTreesForReport() - 1; }
      treesForReport.remove(aTreesForReport);
      treesForReport.add(index, aTreesForReport);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTreesForReportAt(Tree aTreesForReport, int index)
  {
    boolean wasAdded = false;
    if(treesForReport.contains(aTreesForReport))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTreesForReport()) { index = numberOfTreesForReport() - 1; }
      treesForReport.remove(aTreesForReport);
      treesForReport.add(index, aTreesForReport);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTreesForReportAt(aTreesForReport, index);
    }
    return wasAdded;
  }

  public boolean setForecast(Forecast aForecast)
  {
    boolean wasSet = false;
    if (aForecast == null)
    {
      return wasSet;
    }

    Forecast existingForecast = forecast;
    forecast = aForecast;
    if (existingForecast != null && !existingForecast.equals(aForecast))
    {
      existingForecast.removeReport(this);
    }
    forecast.addReport(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Tree> copyOfTreesForReport = new ArrayList<Tree>(treesForReport);
    treesForReport.clear();
    for(Tree aTreesForReport : copyOfTreesForReport)
    {
      aTreesForReport.removeReport(this);
    }
    Forecast placeholderForecast = forecast;
    this.forecast = null;
    if(placeholderForecast != null)
    {
      placeholderForecast.removeReport(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "canopy" + ":" + getCanopy()+ "," +
            "carbonSequestration" + ":" + getCarbonSequestration()+ "," +
            "bioDiversityIndex" + ":" + getBioDiversityIndex()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "forecast = "+(getForecast()!=null?Integer.toHexString(System.identityHashCode(getForecast())):"null");
  }
}