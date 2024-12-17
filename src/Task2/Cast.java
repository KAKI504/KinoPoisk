package Task2;

public class Cast {
    private String fullName;
    private String role;

    public Cast(String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cast cast = (Cast) obj;
        return fullName.equals(cast.fullName);
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }
}