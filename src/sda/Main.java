package sda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static sda.Utils.nanoToMilliSeconds;
import static sda.Utils.nanoToSeconds;
import static sda.Utils.randomPesel;

public class Main {

    static Random random = new Random();

    public static void main(String[] args) {
        PatientRegistry registry = new PatientRegistryUsingArray();
//        PatientRegistry registry = new PatientRegistryUsingHashMap();

        int n = 10000000;
        System.out.println("Will now add " + n + " random patients to registry");
        addRandomPatients(registry, 10000000);
        System.out.println("done");

        System.out.println("There are " + registry.getPatientsCount() + " patients in the registry.");

        List<String> toBeFound = IntStream.range(1, 100).mapToObj(x -> randomPesel()).collect(Collectors.toList());

        System.out.println("start");
        long start = System.nanoTime();
        get100PatientsByPesel(registry, toBeFound);
        long end = System.nanoTime();
        long elapsedNanoSeconds = end - start;
        String message = String.format("%dns %fms %fs",
                elapsedNanoSeconds,
                nanoToMilliSeconds(elapsedNanoSeconds),
                nanoToSeconds(elapsedNanoSeconds));
        System.out.println(message);
    }

    private static void addRandomPatients(PatientRegistry registry, int count) {
        for (int i = 0; i < count; i++) {
            Patient patient = new Patient();
            patient.Name = "John Doe";
            patient.Pesel = randomPesel();
            registry.add(patient);
        }
    }

    private static void get100PatientsByPesel(PatientRegistry registry, List<String> pesels) {
        for (String pesel : pesels) {
            Optional<Patient> patientByPesel = registry.getPatientByPesel(pesel);
            if (patientByPesel.isPresent()) {
                System.out.print("f");
            } else {
                System.out.print("n");
            }
        }
        System.out.println();
    }
}

