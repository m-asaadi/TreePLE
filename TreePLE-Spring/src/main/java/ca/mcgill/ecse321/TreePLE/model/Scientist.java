/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse321.TreePLE.model;
import java.util.*;

// line 61 "../../../../../TreePLE.ump"
public class Scientist extends Role
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Scientist Attributes
  private String role;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Scientist()
  {
    super();
    role = "expert";
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRole(String aRole)
  {
    boolean wasSet = false;
    role = aRole;
    wasSet = true;
    return wasSet;
  }

  public String getRole()
  {
    return role;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "role" + ":" + getRole()+ "]";
  }
}