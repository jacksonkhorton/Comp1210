import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 *@author Jackson Horton
 *@version Feb 26 2019
 */
public class PentagonalPyramidList {
   //instance variables
   private String listName = "";
   private ArrayList<PentagonalPyramid> pList;
  /**
   *Accepts a paramter for list and name.
   *@param listNameIn for a name input
   *@param pListIn for the list of PentPyra objects
   */
   public PentagonalPyramidList(String listNameIn,
                    ArrayList<PentagonalPyramid> pListIn) {
      listName = listNameIn;
      pList    = pListIn;
   }
  /**
   *Returns string representing name of list.
   *@return listName for the name 
   */
   public String getName() {
      return listName;
   }
  /**
   *Tests the number of objects in the list.
   *@return pList.size() for the size of the list
   */ 
   public int numberOfPentagonalPyramids() {
      return pList.size();
   }
  /**
   *Finds the toal surface area for all objects in list.
   *@return totalA for the total surface area
   */    
   public double totalSurfaceArea() {
      double totalA = 0.0;
      int j = 0;
      while (j < pList.size()) {
         totalA += pList.get(j).surfaceArea();
         j++;
      }
      return totalA;
   }
  /**
   *Finds the total volume for all objects in list.
   *@return totalV for the total volume 
   */  
   public double totalVolume() {
      double totalV = 0.0;
      int j = 0;
      while (j < pList.size()) {
         totalV += pList.get(j).volume();
         j++;
      }
      return totalV;
   }
  /**
   *Finds the average surface area across all objects in list.
   *@return averageA for the average surface area
   */   
   public double averageSurfaceArea() {
      double averageA = 0;
      double averageASum = 0;
      int j = 1;
      
      if (pList.size() == 0) {
         return 0.0;
      }
      averageASum = pList.get(j).surfaceArea();
      while (j < pList.size()) {
         averageASum += pList.get(j).surfaceArea();
         j++;
      }
      
      averageA = totalSurfaceArea() / (pList.size());
      return averageA;
   }

  /**
   *Finds the average volume across all objects in list.
   *@return averageV for the average volume
   */
   public double averageVolume() {
      double averageV;
      double averageVSum;
      int j = 1;
      
      if (pList.size() == 0) {
         return 0.0;
      }
      averageVSum = pList.get(j).volume();
      while (j < pList.size()) {
         averageVSum += pList.get(j).volume();
         j++;
      }
      
      averageV = totalVolume() / (pList.size());
      return averageV;
   }
   
  /**
   *Formats list of objects into a string.
   *@return output is this string output
   */ 
   public String toString() {
      int j = 0;
      String output = listName + "\n";
      
      while (j < pList.size()) {
         output += "\n" + pList.get(j) + "\n";
         j++;
      }
      return output;
      
   }
    
  /**
   *Prints all info as a summary to be called outside class.
   *@return summary for all of the info
   */
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String summary = "";
      summary += "----- Summary for " + getName() + " -----"; 
      summary += "\nNumber of PentagonalPyramid: " 
                  + numberOfPentagonalPyramids();
      summary += "\nTotal Surface Area: " + df.format(totalSurfaceArea()); 
      summary += "\nTotal Volume: "  + df.format(totalVolume());
      summary += "\nAverage Surface Area: "  + df.format(averageSurfaceArea());
      summary += "\nAverage Volume: " + df.format(averageVolume());
      
      return summary;
   }

  /**
   *returns the arraylist of pentagonal pyramid objects
   *@return ArrayList
   */
   public ArrayList<PentagonalPyramid> getlist() {
      return pList;
   } 
 
  /** 
   *reads file and creates an ArrayList of objects.
   *@return PentagonalPyramidList object
   */
   public ArrayList<PentagonalPyramid> readFile(String fileNameIn)
                     throws FileNotFoundException {
      String fileName = fileNameIn;
      Scanner scanFile = new Scanner(new File(fileName));
      
      
      
      listName = scanFile.nextLine();
      
      while (scanFile.hasNext()) {
         String label      = scanFile.nextLine();
         double baseEdge   = Double.parseDouble(scanFile.nextLine());
         double height     = Double.parseDouble(scanFile.nextLine());
         PentagonalPyramid j = new PentagonalPyramid(label, baseEdge, height);
         pList.add(j);
      }
      scanFile.close();
     
         
      
      return pList;
   }
   
   /**
    *Add a pyramid object to the list.
    *@param label1In
    *@param baseEdge1In
    *@param height1In
    */
   public void addPentagonalPyramid(String labelIn, double baseEdgeIn, double heightIn) {
      PentagonalPyramid j = new PentagonalPyramid(labelIn, baseEdgeIn, heightIn);
      pList.add(j);
   }
    
   /**
    *Finds a pyramid object based on label.
    *@param labelIn for object ID
    *@return Corresponding pentagonal object
    */
   public PentagonalPyramid findPentagonalPyramid(String labelIn) {
      for (PentagonalPyramid j : pList) {
         if (j.getLabel().equalsIgnoreCase(labelIn)) {
            return j;
         }
      }
      return null;
   }
    
   /**
    *deletes a pyramid from the list.
    *@param labelIn
    *@param baseEdgeIn
    *@param heightIn
    *@return true if deleted else return false
    */
   public PentagonalPyramid deletePentagonalPyramid(String labelIn, double baseEdgeIn, double heightIn) {
     
      if (findPentagonalPyramid(labelIn) != null) {
         PentagonalPyramid j = findPentagonalPyramid(labelIn);
         pList.remove(pList.indexOf(findPentagonalPyramid(labelIn)));
         return j;
      }
      else {
         return null;
      }
   }
   
  /**
   *Method edits a pentagonal pyramid object.
   *@param labelIn for an ID, baseEdge, height for measurements
   *@return boolean value based on result
   */
   public boolean editPentagonalPyramid(String labelIn, double baseEdgeIn, double heightIn) {
      boolean result;
      if (findPentagonalPyramid(labelIn) == null) {
         result = false;
      }
      else {
         findPentagonalPyramid(labelIn).setBaseEdge(baseEdgeIn);
         findPentagonalPyramid(labelIn).setHeight(heightIn);
         result = true;
      
      
      }
      
      return result;
   }
      
      
      
}

    
         
      
   
   
   
      
      
   
      
       
    
        
   
   
