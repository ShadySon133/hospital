
package com.mycompany.hospitalsystem;


import java.util.Scanner;

/**
 *
 * @author Shady
 */
public class Search {
    
     public static int answer;
     public static Scanner Shady = new Scanner(System.in);
     

      public static void SearchPatient()
      {
          // after you press 2 at the menu, you are going to come here
           if (HospitalSystem.answer == 2)
           {
               System.out.print("Which patient would you like to see, enter Patient Id: ");
           
           // this is the part that going to search for the values you put in {Bro code}
           int target = Shady.nextInt();
           boolean isFound = false;
           
           for (int e = 0; e < HospitalSystem.patientId.size();e++)
           {
               if (target == HospitalSystem.patientId.get(e))
               {
                   System.out.println("Patient in the system");
                   isFound = true;
                   break;
               }
           }
          if (!isFound) 
          {
               System.out.println("Patientis not in the system");

          }
      }
}
}
