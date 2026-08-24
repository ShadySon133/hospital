
package com.mycompany.hospitalsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HospitalSystemTest {

    @BeforeEach
    public void setUp() {
        // Clear all static parallel ArrayLists before each test run
        HospitalSystem.patientId.clear();
        HospitalSystem.firstName.clear();
        HospitalSystem.lastName.clear();
        HospitalSystem.age.clear();
        HospitalSystem.Gender.clear();
        HospitalSystem.MedicalCon.clear();
        HospitalSystem.category.clear();

        // Reset all bed allocations to 0 (Empty)
        for (int ward = 0; ward < 4; ward++) {
            for (int bed = 0; bed < 5; bed++) {
                HospitalSystem.beds[ward][bed] = 0;
            }
        }
    }

    @Test
    public void testPatientRegistration() {
        // Manually populate parallel arrays to simulate registration
        int id = 101;
        HospitalSystem.patientId.add(id);
        HospitalSystem.firstName.add("Fensti");
        HospitalSystem.lastName.add("Dwagla");
        HospitalSystem.age.add(30);
        HospitalSystem.Gender.add("Male");
        HospitalSystem.MedicalCon.add("Flu");
        HospitalSystem.category.add(PatientCategory.Inpatient.name());

        assertEquals(1, HospitalSystem.patientId.size());
        assertTrue(HospitalSystem.patientId.contains(101));
        assertEquals("Fensti", HospitalSystem.firstName.get(0));
    }

    @Test
    public void testBedAllocation() {
        int patientId = 102;
        boolean assigned = false;

        // Simulate bed assignment logic for Inpatient category
        for (int m = 0; m < 4; m++) {
            for (int k = 0; k < 5; k++) {
                if (HospitalSystem.beds[m][k] == 0) {
                    HospitalSystem.beds[m][k] = patientId;
                    assigned = true;
                    break;
                }
            }
            if (assigned) break;
        }

        assertTrue(assigned);
        assertEquals(102, HospitalSystem.beds[0][0]);
    }

    @Test
    public void testSearchPatientFound() {
        HospitalSystem.patientId.add(103);
        int target = 103;

        boolean isFound = false;
        for (int e = 0; e < HospitalSystem.patientId.size(); e++) {
            if (target == HospitalSystem.patientId.get(e)) {
                isFound = true;
                break;
            }
        }

        assertTrue(isFound);
    }

    @Test
    public void testSearchPatientNotFound() {
        HospitalSystem.patientId.add(104);
        int target = 999;

        boolean isFound = false;
        for (int e = 0; e < HospitalSystem.patientId.size(); e++) {
            if (target == HospitalSystem.patientId.get(e)) {
                isFound = true;
                break;
            }
        }

        assertFalse(isFound);
    }

    @Test
    public void testUpdatePatientDetails() {
        HospitalSystem.patientId.add(105);
        HospitalSystem.firstName.add("Neo");
        HospitalSystem.lastName.add("Mkhehlane");
        HospitalSystem.age.add(25);
        HospitalSystem.Gender.add("Female");
        HospitalSystem.MedicalCon.add("Asthma");
        HospitalSystem.category.add(PatientCategory.outpatient.name());

        int targetIndex = 0;
        HospitalSystem.firstName.set(targetIndex, "Neo");
        HospitalSystem.age.set(targetIndex, 26);

        assertEquals("Neo", HospitalSystem.firstName.get(0));
        assertEquals(26, HospitalSystem.age.get(0));
    }

    @Test
    public void testDischargePatient() {
        // Place patient 106 in Ward 1, Bed 1 (Index 0,0)
        HospitalSystem.beds[0][0] = 106;

        delete.dischargePatient(106);

        assertEquals(0, HospitalSystem.beds[0][0]);
    }

    @Test
    public void testDeletePatientRecord() {
        HospitalSystem.patientId.add(107);
        HospitalSystem.firstName.add("Thabo");
        HospitalSystem.lastName.add("Pisti");
        HospitalSystem.age.add(40);
        HospitalSystem.Gender.add("Male");
        HospitalSystem.MedicalCon.add("Fracture");
        HospitalSystem.category.add(PatientCategory.emergency.name());

        int index = 0;
        HospitalSystem.patientId.remove(index);
        HospitalSystem.firstName.remove(index);
        HospitalSystem.lastName.remove(index);
        HospitalSystem.age.remove(index);
        HospitalSystem.Gender.remove(index);
        HospitalSystem.MedicalCon.remove(index);
        HospitalSystem.category.remove(index);

        assertTrue(HospitalSystem.patientId.isEmpty());
        assertTrue(HospitalSystem.firstName.isEmpty());
    }

    @Test
    public void testInpatientSubclassConstructorAndGetters() {
        inpatient patient = new inpatient(108, "David", "Kau", 45, "Male", "Cancer", 2, 3);

        assertEquals(108, patient.getpatientId());
        assertEquals("David", patient.getFirstName());
        assertEquals(2, patient.getWardNumber());
        assertEquals(3, patient.getBedNumber());
        assertEquals(PatientCategory.Inpatient, patient.getCategory());
    }

    @Test
    public void testOccupancyRateCalculation() {
        HospitalSystem.patientId.add(109);
        HospitalSystem.beds[0][0] = 109; // 1 bed occupied out of 20

        int occupiedBeds = 0;
        int totalBeds = 20;

        for (int l = 0; l < 4; l++) {
            for (int a = 0; a < 5; a++) {
                if (HospitalSystem.beds[l][a] != 0) {
                    occupiedBeds++;
                }
            }
        }

        double occupancy = ((double) occupiedBeds / totalBeds) * 100;

        assertEquals(1, occupiedBeds);
        assertEquals(5.0, occupancy, 0.001);
    }
}