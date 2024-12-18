package Task1;

import java.util.List;

public class Movie {
    private final String name;
    private final int year;
    private final String description;
    private final Director director;
    private final List<Cast> cast;

    public Movie(String name, int year, String description, Director director, List<Cast> cast) {
        this.name = name;
        this.year = year;
        this.description = description;
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
        StringBuilder castList = new StringBuilder();
        for (Cast actor : cast) {
            castList.append(actor).append("\n");
        }
        return String.format("Название: %s\nГод: %d\nОписание: %s\nРежиссёр: %s\nАктёры:\n%s",
                name, year, description, director.getFullName(), castList);
    }
}

