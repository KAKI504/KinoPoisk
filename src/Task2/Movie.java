package Task2;
import java.util.List;

public class Movie {
    private final String name;
    private final int year;
    private final Director director;
    private final List<Cast> cast;

    public Movie(String name, int year, Director director, List<Cast> cast) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.cast = cast;
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

    public List<Cast> getCast() {
        return cast;
    }

    @Override
    public String toString() {
        return String.format("Название: %-35s Год: %-5d Режиссёр: %-25s", name, year, director.getFullName());
    }
}