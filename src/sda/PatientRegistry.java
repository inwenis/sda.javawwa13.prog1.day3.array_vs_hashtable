package sda;

import java.util.*;

public class PatientRegistry {
//    private List<Patient> patients = new ArrayList<>();
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
//        for (Patient patient : patients) {
//            if (patient.Pesel.equals(pesel)) {
//                System.out.println("found " + patient);
//
//            }
//        }
//        return Optional.empty();
    }

    public int getPatientsCount() {
        return patients.size();
    }
}
