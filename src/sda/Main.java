package sda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static sda.Utils.randomPesel;

public class Main {

    static Random random = new Random();

    public static void main(String[] args) {
        PatientRegistry registry = new PatientRegistry();
        for (int i = 0; i < 10000000; i++) {
            Patient patient = new Patient();
            patient.Name = "John Doe";
            patient.Pesel = randomPesel();
            registry.add(patient);
        }

        System.out.println("There are " + registry.getPatientsCount() + " patients in the registry.");

//        System.out.println("Gimme a Pesel");
//        Scanner scanner = new Scanner(System.in);
//        String peselToFind = scanner.nextLine();
//        long start = System.nanoTime();
//        for (Patient patient : patients) {
//            if (patient.Pesel.equals(peselToFind)) {
//                System.out.println(patient);
//                break;
//            }
//        }
//        long end = System.nanoTime();
//        long elapsed = end - start;
//        System.out.println(elapsed + "ns");
//        System.out.println(elapsed/100000 + "ms");
//        System.out.println((double)elapsed/100000000 + "s");

        List<String> toBeFound = IntStream.range(1, 100).mapToObj(x -> randomPesel()).collect(Collectors.toList());

        System.out.println("start");
        long start2 = System.nanoTime();
        get100PatientsByPesel(registry, toBeFound);
        long end2 = System.nanoTime();
        long elapsed2 = end2 - start2;
        System.out.println(elapsed2/1000000 + "ms    " + (double)elapsed2/1000000000 + "s");
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

