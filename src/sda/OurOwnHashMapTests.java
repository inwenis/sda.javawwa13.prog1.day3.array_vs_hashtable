package sda;

import java.util.Map;

public class OurOwnHashMapTests {
    public static void main(String[] args) {
        Map<String, Patient> map = new OurOwnHashMap(10);

        Patient patient1 = new Patient();
        patient1.Name = "Joe Doe";
        patient1.Pesel = "80101012123";
        map.put(patient1.Pesel, patient1);

        System.out.println("expected: true actual: " + map.containsKey(patient1.Pesel));
        System.out.println("expected: false actual: " + map.containsKey("67676767676"));
        Patient patientFromMap = map.get(patient1.Pesel);
        System.out.println("expected: true actual: " + (patient1 == patientFromMap));
    }
}
