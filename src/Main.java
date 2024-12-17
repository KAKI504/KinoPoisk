
public class Main {
    public static void main(String[] args) {
        String filePath = "data/movies.json";

        MovieManager manager = new MovieManager(filePath);

        System.out.println("=== Все фильмы ===");
        manager.printMovies();

        System.out.println("\n=== Фильмы, содержащие 'Hobbit' в названии ===");
        manager.searchMoviesByName("Hobbit").forEach(System.out::println);

        manager.sortMoviesByYearAsc();
        System.out.println("\n=== Фильмы, отсортированные по году (возрастание) ===");
        manager.printMovies();

        manager.sortMoviesByYearDesc();
        System.out.println("\n=== Фильмы, отсортированные по году (убывание) ===");
        manager.printMovies();

        manager.sortMoviesByNameAsc();
        System.out.println("\n=== Фильмы, отсортированные по названию (возрастание) ===");
        manager.printMovies();

        manager.sortMoviesByNameDesc();
        System.out.println("\n=== Фильмы, отсортированные по названию (убывание) ===");
        manager.printMovies();

        manager.sortMoviesByDirectorAsc();
        System.out.println("\n=== Фильмы, отсортированные по режиссёру (возрастание) ===");
        manager.printMovies();
    }
}