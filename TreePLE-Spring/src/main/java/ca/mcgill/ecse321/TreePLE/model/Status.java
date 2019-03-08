/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse321.TreePLE.model;
import java.util.Date;

// line 39 "../../../../../TreePLE.ump"
public class Status
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum TreeState { Planted, Diseased, ToBeCut, Cut }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Status Attributes
  private TreeState treeState;
  private Date date;

  //Status Associations
  private Tree tree;
  private Person person;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Status(Date aDate, Tree aTree, Person aPerson)
  {
    date = aDate;
    boolean didAddTree = setTree(aTree);
    if (!didAddTree)
    {
      throw new RuntimeException("Unable to create status due to tree");
    }
    boolean didAddPerson = setPerson(aPerson);
    if (!didAddPerson)
    {
      throw new RuntimeException("Unable to create status due to person");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTreeState(TreeState aTreeState)
  {
    boolean wasSet = false;
    treeState = aTreeState;
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

  public TreeState getTreeState()
  {
    return treeState;
  }

  public Date getDate()
  {
    return date;
  }

  public Tree getTree()
  {
    return tree;
  }

  public Person getPerson()
  {
    return person;
  }

  public boolean setTree(Tree aTree)
  {
    boolean wasSet = false;
    if (aTree == null)
    {
      return wasSet;
    }

    Tree existingTree = tree;
    tree = aTree;
    if (existingTree != null && !existingTree.equals(aTree))
    {
      existingTree.removeStatus(this);
    }
    tree.addStatus(this);
    wasSet = true;
    return wasSet;
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
      existingPerson.removeStatus(this);
    }
    person.addStatus(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Tree placeholderTree = tree;
    this.tree = null;
    if(placeholderTree != null)
    {
      placeholderTree.removeStatus(this);
    }
    Person placeholderPerson = person;
    this.person = null;
    if(placeholderPerson != null)
    {
      placeholderPerson.removeStatus(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "treeState" + "=" + (getTreeState() != null ? !getTreeState().equals(this)  ? getTreeState().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "tree = "+(getTree()!=null?Integer.toHexString(System.identityHashCode(getTree())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "person = "+(getPerson()!=null?Integer.toHexString(System.identityHashCode(getPerson())):"null");
  }
}