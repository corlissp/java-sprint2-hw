import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        Commands command = new Commands();
        byte userInput = scanner.nextByte();
        printGran();
        while (userInput != 0) {
            if (userInput == 1) {
                command.readAndSaveMonthlyReports();
            } else if (userInput == 2) {
                command.readAndSaveYearlyReports();
            } else if (userInput == 3) {
                command.checkingReports();
            } else if (userInput == 4) {
                command.outputMonthlyReports();
            } else if (userInput == 5) {
                command.outputYearlyReport();
            } else if (userInput == 0) {
                System.out.println("Выход из приложения...");
                break;
            } else {
                System.out.println("Неверная команда!");
            }
            printMenu();
            userInput = scanner.nextByte();
            printGran();
        }
    }

    public static void printMenu() {
        printGran();
        System.out.println("\tМеню");
        System.out.println("1. Считать месячные отчёты.");
        System.out.println("2. Считать годовой отчёт.");
        System.out.println("3. Сверить отчёты.");
        System.out.println("4. Вывести информацию о всех месячных отчётах.");
        System.out.println("5. Вывести информацию о годовом отчёте.");
        System.out.println("0. Выйти из приложения.");
        System.out.print("Ввод: ");
    }

    public static void printGran() {
        System.out.println("===================================================");
    }
}

