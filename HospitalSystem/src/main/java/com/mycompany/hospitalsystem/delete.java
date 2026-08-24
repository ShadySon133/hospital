
package com.mycompany.hospitalsystem;

import java.util.Scanner;

/**
 *
 * @author Shady
 */
public class delete {
    public static Scanner Shady = new Scanner(System.in);
    
    public static void deletePatient()
    {
        
             if (HospitalSystem.answer == 4)
    {
        System.out.print("which patient would you like to delete,enter patient Id: ");
        int target = Shady.nextInt();
        Shady.nextLine();
        
        // im going to serch for the id 
        Boolean isFound = false; 
        for (int y = 0; y < HospitalSystem.patientId.size(); y++)
                        if (HospitalSystem.patientId.get(y) == target)
        {
            isFound = true;
            // since teh system has to delete and discharge i thought i would add them together. so here i want to give you the options
            System.out.println("1.Would you like to discharge the Patient?");
             System.out.println("2.Would you like to delete the patient");
            int choice = Shady.nextInt();
             Shady.nextLine();
             
             if (choice == 1 ) 
             {
                 dischargePatient(target);
             } else if (choice == 2 ) {
                 dischargePatient(target);// discharge first and then delete
            // now the the deleting part {Gemini} 
            HospitalSystem.patientId.remove(y); 
            HospitalSystem.firstName.remove(y); 
            HospitalSystem.lastName.remove(y); 
            HospitalSystem.age.remove(y); 
            HospitalSystem.Gender.remove(y); 
            HospitalSystem.MedicalCon.remove(y);
            HospitalSystem.category.remove(y); 
            
            System.out.print("Patient Id has been deleted");
            break;
        }
        if (!isFound)
        {
            System.out.print("Patient Id not in system"); 
             System.out.println();
        }
    }
    }
    }
    public static void dischargePatient(int target)
    {
        boolean bedFound = false;
         // now im going to search through the array 
         for (int h = 0; h < 4; h++) 
         {
             for (int e = 0; e < 5; e++) 
             {
                 if (HospitalSystem.beds[h][e] == target)
                 {
                     HospitalSystem.beds[h][e] = 0;
                      System.out.println("Patient Id:" + target + "is Discharged from ward " + (h+1) + "Bed" + (e + 1));
                      bedFound = true;
                      break;
                 }
                 if (bedFound)
                     break;
             }
             if (!bedFound)
             {
                  System.out.println("Patient" + target +"not in the system. ");
             }
         }
        
    }
}
