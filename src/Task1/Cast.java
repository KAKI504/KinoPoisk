package Task1;

public class Cast {
    private final String fullName;
    private final String role;

    public Cast(String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("    %s - %s", fullName, role);
    }
}