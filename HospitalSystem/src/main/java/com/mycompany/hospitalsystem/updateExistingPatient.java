
package com.mycompany.hospitalsystem;

import java.util.Scanner;

/**
 *
 * @author Shady
 */

 
public class updateExistingPatient {
     public static Scanner Shady = new Scanner(System.in);

    // this method will help with updating the patients in the arrays
    public static void Renew()
    {
        if (HospitalSystem.answer == 3)
                {
                    System.out.print("Which Patient ID would you like to fix? ");
                    int target = Shady.nextInt();
                    // i added this because if i dont, there would be space between this question and the next thing that im going to print out.
                    Shady.nextLine();
                    
                    // This is where the updating happens {Gemini}
                    boolean isFound = false;
                    for (int n = 0; n < HospitalSystem.patientId.size(); n++)
                        if (HospitalSystem.patientId.get(n) == target)
                        {
                            isFound = true;
                            System.out.print("Patient ID is found");
                            
                            System.out.print("Enter new first name: ");
                            HospitalSystem.firstName.set(n,Shady.nextLine());
                            
                              // last name of the patient
                            System.out.print("Enter Last name: ");
                             HospitalSystem.lastName.set(n,Shady.nextLine());
    
                             //age 
                             System.out.print("Enter age: ");
                             HospitalSystem.age.set(n,Shady.nextInt());
                             Shady.nextLine();
                               
                             // Gender of the patient 
                            System.out.print("Enter Gender: ");
                             HospitalSystem.Gender.set(n, Shady.nextLine());
        
                             // medical condition of the patient
                            System.out.print("Enter Medical condition: ");
                            HospitalSystem.MedicalCon.set(n, Shady.nextLine());
      
                             System.out.print("Are they inpatient,outpatient or Emergency: ");
                              HospitalSystem.category.set(n,Shady.nextLine());
                            break;
                        }
                    if (!isFound)
                    {
                         System.out.print("Patient Id not found");
                        System.out.println();
                    }
                    
                }
       
    }
    
}
