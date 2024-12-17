import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieManager {
    private List<Movie> movies;

    public MovieManager(String jsonFilePath) {
        movies = loadMoviesFromFile(jsonFilePath);
    }

    private List<Movie> loadMoviesFromFile(String jsonFilePath) {
        List<Movie> movies = new ArrayList<>();
        File file = new File(jsonFilePath);

        if (!file.exists()) {
            System.out.println("Файл не найден: " + jsonFilePath);
            return movies;
        }

        try (Reader reader = new FileReader(jsonFilePath)) {
            Gson gson = new Gson();
            MovieList movieList = gson.fromJson(reader, MovieList.class);
            movies = movieList.getMovies();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public void printMovies() {
        if (movies.isEmpty()) {
            System.out.println("Нет доступных фильмов.");
        } else {
            movies.forEach(System.out::println);
        }
    }

    public List<Movie> searchMoviesByName(String searchText) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getName().toLowerCase().contains(searchText.toLowerCase())) {
                result.add(movie);
            }
        }
        return result;
    }

    public void sortMoviesByYearAsc() {
        movies.sort(Comparator.comparingInt(Movie::getYear));
    }

    public void sortMoviesByYearDesc() {
        movies.sort((movie1, movie2) -> Integer.compare(movie2.getYear(), movie1.getYear()));
    }

    public void sortMoviesByNameAsc() {
        movies.sort(Comparator.comparing(Movie::getName));
    }

    public void sortMoviesByNameDesc() {
        movies.sort((movie1, movie2) -> movie2.getName().compareTo(movie1.getName()));
    }

    public void sortMoviesByDirectorAsc() {
        movies.sort(Comparator.comparing(movie -> movie.getDirector().getFullName()));
    }

    private static class MovieList {
        private List<Movie> movies;

        public List<Movie> getMovies() {
            return movies;
        }
    }
}