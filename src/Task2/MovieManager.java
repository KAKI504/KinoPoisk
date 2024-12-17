package Task2;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

public class MovieManager {
    private List<Movie> movies;

    public MovieManager(String jsonFilePath) {
        movies = loadMoviesFromFile(jsonFilePath);
    }

    private List<Movie> loadMoviesFromFile(String jsonFilePath) {
        List<Movie> movies = new ArrayList<>();
        File file = new File(jsonFilePath);
        if (!file.exists()) return movies;
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
        return movies.stream()
                .filter(movie -> movie.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
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

    public List<Movie> searchMoviesByDirector(String directorName) {
        return movies.stream()
                .filter(movie -> movie.getDirector().getFullName().equalsIgnoreCase(directorName))
                .collect(Collectors.toList());
    }

    public List<Movie> searchMoviesByYear(int year) {
        return movies.stream()
                .filter(movie -> movie.getYear() == year)
                .collect(Collectors.toList());
    }

    public List<String> getMoviesByActor(String actorName) {
        return movies.stream()
                .filter(movie -> movie.getCast().stream()
                        .anyMatch(cast -> cast.getFullName().equalsIgnoreCase(actorName)))
                .map(movie -> movie.getName() + " - " + movie.getCast().stream()
                        .filter(cast -> cast.getFullName().equalsIgnoreCase(actorName))
                        .map(Cast::getRole).findFirst().orElse("Без роли"))
                .collect(Collectors.toList());
    }

    public List<String> getAllActorsWithRoles() {
        return movies.stream()
                .flatMap(movie -> movie.getCast().stream())
                .distinct()
                .sorted(Comparator.comparing(Cast::getFullName))
                .map(cast -> cast.getFullName() + " - " + cast.getRole())
                .collect(Collectors.toList());
    }

    private static class MovieList {
        private List<Movie> movies;

        public List<Movie> getMovies() {
            return movies;
        }
    }
}