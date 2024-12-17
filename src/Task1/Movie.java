package Task1;

public class Movie {
    private final String name;
    private final int year;
    private final Director director;

    public Movie(String name, int year, Director director) {
        this.name = name;
        this.year = year;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public Director getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return String.format("Название: %-35s Год: %-5d Режиссёр: %-25s", name, year, director.getFullName());
    }
}
