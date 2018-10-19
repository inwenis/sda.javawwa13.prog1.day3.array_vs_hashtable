package sda;

import java.util.*;

public class PatientRegistryUsingHashMap implements PatientRegistry {
    private Map<String, Patient> patients = new HashMap<>();

    public void add(Patient patient) {
        patients.put(patient.Pesel, patient);
    }

    public Optional<Patient> getPatientByPesel(String pesel) {
        if(patients.containsKey(pesel)) {
            return Optional.of(patients.get(pesel));
        } else {
            return Optional.empty();
        }
    }

    public int getPatientsCount() {
        return patients.size();
    }
}
