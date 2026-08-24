
package com.mycompany.hospitalsystem;

/**
 *
 * @author Shady
 */
public class report {
    
    // in this method ill be displaying the reports 
    public static void detailReport()
    {
         if (HospitalSystem.answer == 7)
         {
             
         
        //here is where im declaring the variables that i will later be displaying
        int totalPatients = HospitalSystem.patientId.size();
        int occupiedBeds = 0;
        int totalBeds = 20;
        
        for (int l = 0; l < 4; l++)
        {
            for (int a = 0; a < 5; a++)
            {
                if (HospitalSystem.beds[l][a] != 0)
                {
                    occupiedBeds++;
                }
            }
        }
       // here ill be calculating the occupancy %
       double occupancy = ((double) occupiedBeds /totalBeds)* 100;
       
       System.out.print("Total Registered patients: " + totalPatients);
       System.out.print("Total occupied beds: " + occupiedBeds);
       System.out.print("Ward occupany rate: "+ occupancy);
    }
}
}
