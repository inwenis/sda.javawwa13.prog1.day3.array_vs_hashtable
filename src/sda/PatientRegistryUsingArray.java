package sda;

import java.util.*;

public class PatientRegistryUsingArray implements PatientRegistry {
    private List<Patient> patients = new ArrayList<>();

    public void add(Patient patient) {
        patients.add(patient);
    }

    public Optional<Patient> getPatientByPesel(String pesel) {
        for (Patient patient : patients) {
            if (patient.Pesel.equals(pesel)) {
                System.out.println("found " + patient);

            }
        }
        return Optional.empty();
    }

    public int getPatientsCount() {
        return patients.size();
    }
}
