package sda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static sda.Utils.randomPesel;

public class Main {

    static Random random = new Random();

    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            Patient patient = new Patient();
            patient.Name = "John Doe";
            patient.Pesel = randomPesel();
            patients.add(patient);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(patients.get(patients.size() - i - 1).toHumanReadableString());
        }

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
        get100PatientsByPesel(patients, toBeFound);
        long end2 = System.nanoTime();
        long elapsed2 = end2 - start2;

        System.out.println(elapsed2/1000000 + "ms    " + (double)elapsed2/1000000000 + "s");
    }

    private static void get100PatientsByPesel(List<Patient> patients, List<String> pesels) {
        for (String pesel : pesels) {

        }
    }
}

