package Task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "data/movies.json";
        MovieManager manager = new MovieManager(filePath);
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1 - Показать все фильмы");
            System.out.println("2 - Искать фильм по названию");
            System.out.println("3 - Сортировать по году (возрастание)");
            System.out.println("4 - Сортировать по году (убывание)");
            System.out.println("5 - Сортировать по названию (возрастание)");
            System.out.println("6 - Сортировать по названию (убывание)");
            System.out.println("7 - Сортировать по режиссёру");
            System.out.println("0 - Выход");

            input = scanner.nextLine();

            switch (input) {
                case "1":
                    manager.printMovies();
                    break;
                case "2":
                    System.out.print("Введите название для поиска: ");
                    String searchText = scanner.nextLine();
                    manager.searchMoviesByName(searchText);
                    break;
                case "3":
                    manager.sortMoviesByYearAsc();
                    manager.printMovies();
                    break;
                case "4":
                    manager.sortMoviesByYearDesc();
                    manager.printMovies();
                    break;
                case "5":
                    manager.sortMoviesByNameAsc();
                    manager.printMovies();
                    break;
                case "6":
                    manager.sortMoviesByNameDesc();
                    manager.printMovies();
                    break;
                case "7":
                    manager.sortMoviesByDirectorAsc();
                    manager.printMovies();
                    break;
                case "0":
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный ввод. Повторите попытку.");
            }
        }
    }
}