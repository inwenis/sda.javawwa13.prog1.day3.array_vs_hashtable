package sda;

public class Patient {
    public String Name;
    public String Pesel;

    public String toHumanReadableString() {
        return "{ " + Name + ", " + Pesel + "}";
    }
}
