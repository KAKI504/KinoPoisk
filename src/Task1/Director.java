package Task1;

public class Director {
    private String firstName;
    private String lastName;

    public Director(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
