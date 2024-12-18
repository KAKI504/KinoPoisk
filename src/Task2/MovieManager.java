package Task2;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

public class MovieManager {
    private final List<Movie> movies;

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
        movies.forEach(System.out::println);
    }

    public void searchMoviesByName(String name) {
        movies.stream()
                .filter(m -> m.getName().toLowerCase().contains(name.toLowerCase()))
                .forEach(System.out::println);
    }

    public void searchMoviesByActor(String actorName) {
        movies.stream()
                .filter(movie -> movie.getCast().stream()
                        .anyMatch(cast -> cast.getFullName().equalsIgnoreCase(actorName)))
                .forEach(System.out::println);
    }

    public void searchMoviesByDirector(String directorName) {
        movies.stream()
                .filter(movie -> movie.getDirector().getFullName().equalsIgnoreCase(directorName))
                .forEach(System.out::println);
    }

    public void searchMoviesByYear(String year) {
        movies.stream()
                .filter(movie -> String.valueOf(movie.getYear()).equals(year))
                .forEach(System.out::println);
    }

    public void showActorRoles(String actorName) {
        movies.stream()
                .flatMap(movie -> movie.getCast().stream()
                        .filter(cast -> cast.getFullName().equalsIgnoreCase(actorName))
                        .map(cast -> String.format("Фильм: %s, Роль: %s", movie.getName(), cast.getRole())))
                .forEach(System.out::println);
    }

    public void listAllActorsAndRoles() {
        Set<String> actors = new TreeSet<>();
        movies.forEach(movie -> movie.getCast()
                .forEach(cast -> actors.add(cast.getFullName() + " - " + cast.getRole())));

        actors.forEach(System.out::println);
    }

    private static class MovieList {
        private List<Movie> movies;

        public List<Movie> getMovies() {
            return movies;
        }
    }
}