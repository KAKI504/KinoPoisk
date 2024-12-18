package Task2;

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
            System.out.println("3 - Найти фильмы по имени актера");
            System.out.println("4 - Найти фильмы по имени режиссера");
            System.out.println("5 - Найти фильмы по году выпуска");
            System.out.println("6 - Показать роли актера");
            System.out.println("7 - Показать всех актёров и их роли");
            System.out.println("0 - Выход");

            input = scanner.nextLine();

            switch (input) {
                case "1":
                    manager.printMovies();
                    break;
                case "2":
                    System.out.print("Введите название для поиска: ");
                    manager.searchMoviesByName(scanner.nextLine());
                    break;
                case "3":
                    System.out.print("Введите имя актера: ");
                    manager.searchMoviesByActor(scanner.nextLine());
                    break;
                case "4":
                    System.out.print("Введите имя режиссера: ");
                    manager.searchMoviesByDirector(scanner.nextLine());
                    break;
                case "5":
                    System.out.print("Введите год выпуска: ");
                    manager.searchMoviesByYear(scanner.nextLine());
                    break;
                case "6":
                    System.out.print("Введите имя актера: ");
                    manager.showActorRoles(scanner.nextLine());
                    break;
                case "7":
                    manager.listAllActorsAndRoles();
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