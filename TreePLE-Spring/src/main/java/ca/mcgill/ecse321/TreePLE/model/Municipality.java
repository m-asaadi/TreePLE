/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse321.TreePLE.model;
import java.util.*;

// line 34 "../../../../../TreePLE.ump"
public class Municipality
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum MunicipalityName { Montreal, Laval, Anjou, AhuntsicCartierville, LeSudOuest, LIlleBizadSaintGenevieve, MercierHochelagaMaisonneuve, MontrealNord, PierrefondsRoxboro, RiviereDesPrairiesPointeAuxTrembles, Rosemont, VilleraySaintMichel, CoteDesNeiges, Lachine, LaSalle, LePlateau, Outremont, Verdun, VilleMarie }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Municipality Attributes
  private MunicipalityName municipalityName;

  //Municipality Associations
  private List<Tree> trees;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Municipality()
  {
    trees = new ArrayList<Tree>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMunicipalityName(MunicipalityName aMunicipalityName)
  {
    boolean wasSet = false;
    municipalityName = aMunicipalityName;
    wasSet = true;
    return wasSet;
  }

  public MunicipalityName getMunicipalityName()
  {
    return municipalityName;
  }

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

  public static int minimumNumberOfTrees()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Tree addTree(double aHeight, double aDiameter, double aLongitude, double aLatitude)
  {
    return new Tree(aHeight, aDiameter, aLongitude, aLatitude, this);
  }

  public boolean addTree(Tree aTree)
  {
    boolean wasAdded = false;
    if (trees.contains(aTree)) { return false; }
    Municipality existingMunicipality = aTree.getMunicipality();
    boolean isNewMunicipality = existingMunicipality != null && !this.equals(existingMunicipality);
    if (isNewMunicipality)
    {
      aTree.setMunicipality(this);
    }
    else
    {
      trees.add(aTree);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTree(Tree aTree)
  {
    boolean wasRemoved = false;
    //Unable to remove aTree, as it must always have a municipality
    if (!this.equals(aTree.getMunicipality()))
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

  public void delete()
  {
    for(int i=trees.size(); i > 0; i--)
    {
      Tree aTree = trees.get(i - 1);
      aTree.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "municipalityName" + "=" + (getMunicipalityName() != null ? !getMunicipalityName().equals(this)  ? getMunicipalityName().toString().replaceAll("  ","    ") : "this" : "null");
  }
}