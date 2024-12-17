package Task2;

public class Main {
    public static void main(String[] args) {
        String filePath = "data/movies.json";
        MovieManager manager = new MovieManager(filePath);

        System.out.println("=== Все фильмы ===");
        manager.printMovies();

        System.out.println("\n=== Фильмы по актёру ===");
        manager.getMoviesByActor("Martin Freeman").forEach(System.out::println);

        System.out.println("\n=== Фильмы по режиссёру ===");
        manager.searchMoviesByDirector("Peter Jackson").forEach(System.out::println);

        System.out.println("\n=== Фильмы по году ===");
        manager.searchMoviesByYear(2019).forEach(System.out::println);

        System.out.println("\n=== Список актёров с ролями ===");
        manager.getAllActorsWithRoles().forEach(System.out::println);
    }
}