import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 *This program creates a menu that runs other methods.
 *@author Jackson Horton
 *@version Feb 26 2019
 */
public class PentagonalPyramidListMenuApp {
 
 /**
 *method creates menu used to drive the other methods.
 *@param args Command line args not used.
 *@throws FileNotFoundException if the file cannot be opened.
 */
   public static void main(String[] args) throws FileNotFoundException {
      String pListName = "no list name";
      ArrayList<PentagonalPyramid> userList = new ArrayList<PentagonalPyramid>();
      PentagonalPyramidList userPList = new PentagonalPyramidList(pListName, userList);
      String fileName = "no file name";
      
      String label    = "";
      double baseEdge = 0, height = 0;
      String code = "";
      
      Scanner scan = new Scanner(System.in);
      System.out.println("PentagonalPyramid List System Menu\n"
          + "R - Read File and Create PentagonalPyramid List\n"
          + "P - Print PentagonalPyramid List\n"
          + "S - Print Summary\n"
          + "A - Add PentagonalPyramid\n"
          + "D - Delete PentagonalPyramid\n"
          + "F - Find PentagonalPyramid\n"
          + "E - Edit PentagonalPyramid\n"
          + "Q - Quit");
          
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         code = scan.nextLine();
         if (code.length() == 0) { 
            continue;
         }
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         switch(codeChar) {
            case 'R': // Read file create list
               System.out.print("\tFile name: ");
               fileName = scan.nextLine();
               userPList = userPList.readFile(fileName);
               System.out.println("\tFile read in and "
                               + "PentagonalPyramid List created\n");
               break;
               
            case 'P': //print list
               System.out.println(userPList);
               break;
           
            case 'S': //Print summary
               System.out.println(userPList.summaryInfo());
               break;
           
            case 'A': //Add PentagonalPyramid
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               System.out.print("\tBase Edge: ");
               baseEdge = Double.parseDouble(scan.nextLine());
               System.out.print("\tHeight: ");
               height = Double.parseDouble(scan.nextLine());
               
               userPList.addPentagonalPyramid(label, baseEdge, height);
               System.out.println("\t*** PentagonalPyramid added ***");
               break;
            
            case 'D': //Delete PentagonalPyramid
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               System.out.print("\tBase Edge: ");
               baseEdge = Double.parseDouble(scan.nextLine());
               System.out.print("\tHeight: ");
               height = Double.parseDouble(scan.nextLine());
               
               if (userPList.deletePentagonalPyramid(label, baseEdge, height)) {
                  System.out.println("\t\"" + label + "\" deleted");
               }
               
               else {
                  System.out.println("\t\"" + label + "\" not found");
               }
               break;
               
            case 'F': //Find PentagonalPyramid
               break;
           
            case 'E': //Edit PentagonalPyramid
               break;
            
            case 'Q': //Quit menu
               System.out.println("\t*** invalid code ***");
            
            default: //no match
               break;
            
         }
       
       
      } while (!code.equalsIgnoreCase("Q"));
    
   }
}
                  
               
               
               
