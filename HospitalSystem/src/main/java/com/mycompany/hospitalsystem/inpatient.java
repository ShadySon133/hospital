
package com.mycompany.hospitalsystem;

/**
 *
 * @author Shady
 */
public class inpatient extends Patients {
    private int bedNumber;
    private int wardNumber;
    // this is a constructor {Gemini}
    public inpatient(int id, String firstName, String lastName, int age,String gender, String medicalCon,int wardNumber,int bedNumber)
    {
        super(id,firstName,lastName,age,gender,medicalCon,PatientCategory.Inpatient);
        
        this.bedNumber = bedNumber;
        this.wardNumber = wardNumber;
        
    }
    // getters and setters
    public int getWardNumber()
    {
        return wardNumber; 
    }
        public void setWardNumber(int wardNummber)
        {
            this.wardNumber = wardNumber;
        }
    
    public void setBedNumber(int bedNumber)
    {
        this.bedNumber = bedNumber;
    }
    
    public int getBedNumber()
    {
        return bedNumber;
    }
    @Override
    public void displayDetails() {
        System.out.println("Patient ID: " + getpatientId());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Condition: " + getMedicalCondition());
        System.out.println("Category: " + getCategory());
        System.out.println("Ward Number: " + wardNumber);
        System.out.println("Bed Number: " + bedNumber);
    }
}


