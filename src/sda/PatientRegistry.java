package sda;

import java.util.ArrayList;
import java.util.List;

public class PatientRegistry {
    List<Patient> patients = new ArrayList<>();

    public void add(Patient patient) {
        patients.add(patient);
    }

    public Patient getPatientByPesel(String pesel) {
        for (Patient patient : patients) {
            if (patient.Pesel.equals(pesel)) {
                System.out.println("found " + patient);
                return patient;
            }
        }
        return null;
    }
}
