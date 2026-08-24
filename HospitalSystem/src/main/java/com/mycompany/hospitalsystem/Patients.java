

package com.mycompany.hospitalsystem;

import static com.mycompany.hospitalsystem.updateExistingPatient.Shady;
import java.util.Scanner;

/**
 *
 * @author Shady
 */
// Enum
public class Patients {
    private int patientId;
    private String firstName;
    private String lastName;
    private int age;
     private String gender;
      private String medicalCon;
       private PatientCategory category;
       
    public Patients(int id, String firstName, String lastName, int age,String gender, String medicalCon, PatientCategory category)
    {
        this.patientId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.medicalCon = medicalCon;
        this.category = category;
    }
    
    public int getpatientId() { return patientId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getMedicalCondition() { return medicalCon; }
    public PatientCategory getCategory() { return category; }
    
    
     static Scanner scanner = new Scanner(System.in);

    public static void details() {
        if (HospitalSystem.answer == 1) {
            System.out.println("Start with details");
        }
        
        System.out.print("Enter patient ID:");
        int patient1 = scanner.nextInt();
        scanner.nextLine();
        
        if (HospitalSystem.patientId.contains(patient1)) {
            System.out.println("Patient is in the system.");
            return;
        }
       HospitalSystem.patientId.add(patient1);
        
        // First name of the patient
        System.out.print("Enter First name: ");
        HospitalSystem.firstName.add(scanner.nextLine());

        // Last name of the patient
        System.out.print("Enter Last name: ");
       HospitalSystem.lastName.add(scanner.nextLine());

        // Age
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        HospitalSystem.age.add(age);

        // Gender of the patient
        System.out.print("Enter Gender: ");
        HospitalSystem.Gender.add(scanner.nextLine());
        
        System.out.print("Enter Medical condition: ");
       HospitalSystem.MedicalCon.add(scanner.nextLine());

        // Category selection with Enum matching
        System.out.print("Are they inpatient, outpatient or emergency: ");
        String categoryAnswer = scanner.nextLine().trim();
        
        PatientCategory catEnum;
        if (categoryAnswer.equalsIgnoreCase("inpatient")) {
            catEnum = PatientCategory.Inpatient;
        } else if (categoryAnswer.equalsIgnoreCase("outpatient")) {
            catEnum = PatientCategory.outpatient;
        } else {
            catEnum = PatientCategory.emergency;
        }

        // Add enum name to Hospital category array
        HospitalSystem.category.add(catEnum.name());

        // Check if the patient is Inpatient
        if (catEnum == PatientCategory.Inpatient) {
            boolean assign = false;

            // Searching through the array for an empty bed
            for (int m = 0; m < 4; m++) {
                for (int k = 0; k < 5; k++) {
                    if (HospitalSystem.beds[m][k] == 0) {
                        // Assigning a bed to a patientId
                        HospitalSystem.beds[m][k] = patient1;
                        System.out.println("Bed allocated: Ward " + (m + 1) + ", Bed " + (k + 1));
                        assign = true;
                        break;
                    }
                }
                if (assign) break;
            }

            if (!assign) {
                System.out.println("No empty beds available ");
            }
        }
    }

    public static void displayPatient() {
        if (HospitalSystem.answer == 5) {
            System.out.println("Here are all the patients in the system ");
            
            if (HospitalSystem.patientId.isEmpty()) {
                System.out.println("There are no patients stored as of yet ");
                return;
            }
            
            for (int o = 0; o < HospitalSystem.patientId.size(); o++) {
                System.out.println("Patient: " + (o + 1));
                System.out.println("Patient Id: " + HospitalSystem.patientId.get(o));
                System.out.println("Patient Name: " + HospitalSystem.firstName.get(o));
                System.out.println("Age: " + HospitalSystem.age.get(o));
                System.out.println("Patient Gender: " + HospitalSystem.Gender.get(o));
                System.out.println("Patient condition: " + HospitalSystem.MedicalCon.get(o));
                System.out.println("Patient Category: " + HospitalSystem.category.get(o));
                System.out.println();
            }
        }
    }
    public void displayDetails() {
    System.out.println("Patient ID: " + patientId);
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("Age: " + age);
    System.out.println("Gender: " + gender);
    System.out.println("Condition: " + medicalCon);
    System.out.println("Category: " + category);
}
}

    
    
