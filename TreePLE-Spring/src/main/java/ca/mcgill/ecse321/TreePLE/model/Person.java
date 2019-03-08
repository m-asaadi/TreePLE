/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse321.TreePLE.model;
import java.util.*;
import java.sql.Date;

// line 47 "../../../../../TreePLE.ump"
public class Person
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Level { LocalCitizen, RemarkableCitizen, ExceptionalCitizen, PerfectCitizen }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String name;
  private int treesPlanted;
  private int treesCut;
  private Level level;

  //Person Associations
  private List<Status> status;
  private Role roles;
  private List<Forecast> forecasts;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person(String aName)
  {
    name = aName;
    resetTreesPlanted();
    resetTreesCut();
    resetLevel();
    status = new ArrayList<Status>();
    forecasts = new ArrayList<Forecast>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setTreesPlanted(int aTreesPlanted)
  {
    boolean wasSet = false;
    treesPlanted = aTreesPlanted;
    wasSet = true;
    return wasSet;
  }

  public boolean resetTreesPlanted()
  {
    boolean wasReset = false;
    treesPlanted = getDefaultTreesPlanted();
    wasReset = true;
    return wasReset;
  }

  public boolean setTreesCut(int aTreesCut)
  {
    boolean wasSet = false;
    treesCut = aTreesCut;
    wasSet = true;
    return wasSet;
  }

  public boolean resetTreesCut()
  {
    boolean wasReset = false;
    treesCut = getDefaultTreesCut();
    wasReset = true;
    return wasReset;
  }

  public boolean setLevel(Level aLevel)
  {
    boolean wasSet = false;
    level = aLevel;
    wasSet = true;
    return wasSet;
  }

  public boolean resetLevel()
  {
    boolean wasReset = false;
    level = getDefaultLevel();
    wasReset = true;
    return wasReset;
  }

  public String getName()
  {
    return name;
  }

  public int getTreesPlanted()
  {
    return treesPlanted;
  }

  public int getDefaultTreesPlanted()
  {
    return 0;
  }

  public int getTreesCut()
  {
    return treesCut;
  }

  public int getDefaultTreesCut()
  {
    return 0;
  }

  public Level getLevel()
  {
    return level;
  }

  public Level getDefaultLevel()
  {
    return Level.LocalCitizen;
  }

  public Status getStatus(int index)
  {
    Status aStatus = status.get(index);
    return aStatus;
  }

  public List<Status> getStatus()
  {
    List<Status> newStatus = Collections.unmodifiableList(status);
    return newStatus;
  }

  public int numberOfStatus()
  {
    int number = status.size();
    return number;
  }

  public boolean hasStatus()
  {
    boolean has = status.size() > 0;
    return has;
  }

  public int indexOfStatus(Status aStatus)
  {
    int index = status.indexOf(aStatus);
    return index;
  }

  public Role getRoles()
  {
    return roles;
  }

  public boolean hasRoles()
  {
    boolean has = roles != null;
    return has;
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

  public static int minimumNumberOfStatus()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Status addStatus(Date aDate, Tree aTree)
  {
    return new Status(aDate, aTree, this);
  }

  public boolean addStatus(Status aStatus)
  {
    boolean wasAdded = false;
    if (status.contains(aStatus)) { return false; }
    Person existingPerson = aStatus.getPerson();
    boolean isNewPerson = existingPerson != null && !this.equals(existingPerson);
    if (isNewPerson)
    {
      aStatus.setPerson(this);
    }
    else
    {
      status.add(aStatus);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStatus(Status aStatus)
  {
    boolean wasRemoved = false;
    //Unable to remove aStatus, as it must always have a person
    if (!this.equals(aStatus.getPerson()))
    {
      status.remove(aStatus);
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
      if(index > numberOfStatus()) { index = numberOfStatus() - 1; }
      status.remove(aStatus);
      status.add(index, aStatus);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStatusAt(Status aStatus, int index)
  {
    boolean wasAdded = false;
    if(status.contains(aStatus))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStatus()) { index = numberOfStatus() - 1; }
      status.remove(aStatus);
      status.add(index, aStatus);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStatusAt(aStatus, index);
    }
    return wasAdded;
  }

  public boolean setRoles(Role aRoles)
  {
    boolean wasSet = false;
    Role existingRoles = roles;
    roles = aRoles;
    if (existingRoles != null && !existingRoles.equals(aRoles))
    {
      existingRoles.removePerson(this);
    }
    if (aRoles != null)
    {
      aRoles.addPerson(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfForecasts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Forecast addForecast()
  {
    return new Forecast(this);
  }

  public boolean addForecast(Forecast aForecast)
  {
    boolean wasAdded = false;
    if (forecasts.contains(aForecast)) { return false; }
    Person existingPerson = aForecast.getPerson();
    boolean isNewPerson = existingPerson != null && !this.equals(existingPerson);
    if (isNewPerson)
    {
      aForecast.setPerson(this);
    }
    else
    {
      forecasts.add(aForecast);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeForecast(Forecast aForecast)
  {
    boolean wasRemoved = false;
    //Unable to remove aForecast, as it must always have a person
    if (!this.equals(aForecast.getPerson()))
    {
      forecasts.remove(aForecast);
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
    for(int i=status.size(); i > 0; i--)
    {
      Status aStatus = status.get(i - 1);
      aStatus.delete();
    }
    if (roles != null)
    {
      Role placeholderRoles = roles;
      this.roles = null;
      placeholderRoles.removePerson(this);
    }
    for(int i=forecasts.size(); i > 0; i--)
    {
      Forecast aForecast = forecasts.get(i - 1);
      aForecast.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "treesPlanted" + ":" + getTreesPlanted()+ "," +
            "treesCut" + ":" + getTreesCut()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "level" + "=" + (getLevel() != null ? !getLevel().equals(this)  ? getLevel().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "roles = "+(getRoles()!=null?Integer.toHexString(System.identityHashCode(getRoles())):"null");
  }
}