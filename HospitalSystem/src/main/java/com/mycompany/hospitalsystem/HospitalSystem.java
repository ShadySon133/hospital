package com.mycompany.hospitalsystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Fenstey
 */
public class HospitalSystem {

    public static int answer;
    public static ArrayList<Integer> patientId = new ArrayList<>();
    public static ArrayList<String> firstName = new ArrayList<>();
    public static ArrayList<String> lastName = new ArrayList<>();
    public static ArrayList<Integer> age = new ArrayList<>();
    public static ArrayList<String> Gender = new ArrayList<>();
    public static ArrayList<String> MedicalCon = new ArrayList<>();
    public static ArrayList<String> category = new ArrayList<>();

    public static int[][] beds = new int[4][5];

    public static void main(String[] args) {
        menu();
        Patients.details();
        Search.SearchPatient();
        updateExistingPatient.Renew();
        delete.deletePatient();
    }

    public static void menu() {
        Scanner Shady = new Scanner(System.in);
        do {
            System.out.println("Hello User, Welcome to the Medicare system");
            System.out.println("1. Would you like to register?");
            System.out.println("2. Search for a patient using their Patient id: ");
            System.out.println("3. Update an existing patient's details");
            System.out.println("4. Delete a patient");
            System.out.println("5. Display all registered patients");
            System.out.println("6. Display Ward");
            System.out.println("7. Display report");
             System.out.println("0. Press to exit");

            System.out.print("What would you like to do: ");
            answer = Shady.nextInt();
            Shady.nextLine();
            if (answer == 1) {
                Patients.details();
            }
            if (answer == 2) {
                Search.SearchPatient();
            }
            if (answer == 3) {
               updateExistingPatient.Renew();
            }
            if (answer == 4) {
                delete.deletePatient();
            }
            if (answer == 5) {
                Patients.displayPatient();
            }
            if (answer == 6) {
                displayBeds();
            }
            if (answer == 7) {  
                report.detailReport();
            }
        }  while (answer > 0);
    }

    public static void displayBeds() {
        System.out.println("Hospital wards and beds");

        for (int ward = 0; ward < 4; ward++) {
            for (int bed = 0; bed < 5; bed++) {
                int patientId = HospitalSystem.beds[ward][bed];

                if (patientId == 0) {
                    System.out.print("[Empty]\t");
                } else {
                    System.out.print("[ID: " + patientId + "]\t");
                }
            }
            System.out.println();
        }
    }
}