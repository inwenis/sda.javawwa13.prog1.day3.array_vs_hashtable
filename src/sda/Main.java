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
        // use PatientRegistryUsingArray to see how long it takes to loop up 100 patients in an array
        // on my PC it takes about 8s to lookup 100 patients in an array of 10000000 (when simulating 1 client)
        // but it takes 70s when doing the same using 10 clients
        PatientRegistry registry = new PatientRegistryUsingArray();

        // use PatientRegistryUsingHashMap to see how long it takes to loop up 100 patients in an HashMap
        // on my PC it takes 0.0009s (less than 1/10th of a ms) to lookup 100 patients in an array of 10000000
        // (when simulating 1 client)
        // it takes 0.01s (~10ms) when doing the same using 10 clients
        // using the correct data structure is important
//        PatientRegistry registry = new PatientRegistryUsingHashMap();

        int n = 10000000;
        System.out.println("Will now add " + n + " random patients to registry");
        addRandomPatients(registry, 10000000);
        System.out.println("done");
        System.out.println("There are " + registry.getPatientsCount() + " patients in the registry.");

        System.out.println("How many clients do you want to simulate?");
        Scanner scanner = new Scanner(System.in);
        int clientsCount = scanner.nextInt();

        List<Thread> threads = IntStream
                .range(1, clientsCount + 1)
                .mapToObj(x -> lookupThread(registry))
                .collect(Collectors.toList());

        threads.forEach(x -> x.start());
    }

    private static <U> Thread lookupThread(PatientRegistry registry) {
        Thread lookUpThread = new Thread(() -> {
            lookUpPatients(registry);
        });
        return lookUpThread;
    }

    private static void lookUpPatients(PatientRegistry registry) {
        int i = 100;
        List<String> toBeFound = IntStream.range(1, i).mapToObj(x -> randomPesel()).collect(Collectors.toList());
        System.out.println("Will now look up " + i + " patients by Pesel in the registry");
        long start = System.nanoTime();
        getPatientsByPesel(registry, toBeFound);
        long end = System.nanoTime();
        long elapsedNanoSeconds = end - start;
        System.out.println("done");
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

    private static void getPatientsByPesel(PatientRegistry registry, List<String> pesels) {
        for (String pesel : pesels) {
            Optional<Patient> patientByPesel = registry.getPatientByPesel(pesel);
            if (patientByPesel.isPresent()) {
                System.out.print("f"); // found
            } else {
                System.out.print("n"); // not found
            }
        }
        System.out.println();
    }
}

