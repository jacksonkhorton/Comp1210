import java.util.ArrayList;
import java.text.DecimalFormat;
/**
 *this program will establish a class used to print a formatted output
 *based on inputs.
 *@author Jackson Horton
 *@version February 8 2019
 */
public class PentagonalPyramid {
 //instance variables
   private String label    = "";
   private double baseEdge = 0.0;
   private double height   = 0.0;
  
  /**
   *establish constructor.
   *@param labelIn is a string for the label name
   *@param baseIn is a measurement of the base
   *@param heightIn is a measurement of the height
   */
   public PentagonalPyramid(String labelIn, double baseIn, double heightIn) {
      setLabel(labelIn);
      setBaseEdge(baseIn);
      setHeight(heightIn);
   }
   
   /**
    *method for setting label.
    *@param labelIn is a string for label name
    *@return isSetLabel is a boolean for label
    */
   public boolean setLabel(String labelIn) {
      //String setLabel = labelIn;
      boolean isSetLabel = false;
      if (labelIn != null) {
         label = labelIn;
         isSetLabel = true;
      }
      return isSetLabel;
   }
         
   /**
    *method for setting base.
    *@param baseIn is a measurement of the base
    *@return isSetBase is a boolean for base
    */
   public boolean setBaseEdge(double baseIn) {
      boolean isSetBase = false;
      if (baseIn > 0) {
         baseEdge  = baseIn;
         isSetBase = true;
      }
      return isSetBase;
   } 
   
   /**
    *method for setting height.
    *@param heightIn is a measurement of the height
    *@return isSetHeight is a boolean for height
    */
   public boolean setHeight(double heightIn) {
      boolean isSetHeight = false;
      if (heightIn > 0) {
         height    = heightIn;
         isSetHeight = true; 
      }
      return isSetHeight;
   }
         
   /**
    *method for returning the label value.
    *@return label
    */
   public String getLabel() {
      return label;
   }
   
   /**
    *method for returning base value.
    *@return baseEdge
    */
   public double getBaseEdge() {
      return baseEdge;
   }
   
   /**
    *method for returning height value.
    *@return height
    */
   public double getHeight() {
      return height; 
   }
   /**method for calculating surface area.
    *@return double value for surface area
    */
   public double surfaceArea() {
      return (5.0 / 4.0) * Math.tan(Math.toRadians(54)) * Math.pow(baseEdge, 2) 
         + 5 * (baseEdge / 2) * Math.sqrt(Math.pow(height, 2)
         + Math.pow((baseEdge * Math.tan(Math.toRadians(54))) / 2, 2));
   }
         
    /**
     *method for calculating volume.
     *@return double value for volume
     */
   public double volume() {
      return (5.0 / 12.0) * Math.tan(Math.toRadians(54)) * height
         * (Math.pow(baseEdge, 2));
   }
 
 /**
  *method for printing formatted output.
  *@return string of output
  */
   public String toString() {
      DecimalFormat deForm = new DecimalFormat("#,##0.0######");
      return "PentagonalPyramid \"" + label.trim() + "\" with"
         + " base edge = " + baseEdge + " and height = " + height
         + " units has: " 
         + "\n\tsurface area = " + deForm.format(surfaceArea()) 
         + " square units"
         + "\n\tvolume = " + deForm.format(volume())
         + " cubic units";
   }
        
}
