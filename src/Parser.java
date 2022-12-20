import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Parser {

    public static MonthlyReport readMonthlyReport(String file) {
        List<String> lines = readFileContents(file);
        ArrayList<MonthlyReportItem> items = new ArrayList<>();
        System.out.println("\tФайл: " + file);
        String[] linesFile = file.split("\\.");
        int monthNumber = Integer.parseInt(linesFile[3]) % 100;
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] fields = line.split(",");
            System.out.println(Arrays.toString(fields));
            String item_name = fields[0];
            boolean is_expense = Boolean.parseBoolean(fields[1]);
            int quantity = Integer.parseInt(fields[2]);
            int sum_of_one = Integer.parseInt(fields[3]);

            MonthlyReportItem item = new MonthlyReportItem(item_name, is_expense, quantity, sum_of_one);

            items.add(item);
        }
        return new MonthlyReport(items, monthNumber);
    }

    public static YearlyReport readYearlyReport(String file) {
        List<String> lines = readFileContents(file);
        ArrayList<YearlyReportItem> items = new ArrayList<>();
        System.out.println("\tФайл: " + file);
        String[] linesFile = file.split("\\.");
        int year = Integer.parseInt(linesFile[3]);
        for (int i = 1; i < lines.size(); i ++) {
            String line = lines.get(i);
            String[] fields = line.split(",");
            System.out.println(Arrays.toString(fields));
            int month = Integer.parseInt(fields[0]);
            int amount = Integer.parseInt(fields[1]);
            boolean is_expense = Boolean.parseBoolean(fields[2]);

            YearlyReportItem item = new YearlyReportItem(month, amount, is_expense);

            items.add(item);
        }
        return new YearlyReport(items, year);
    }

    private static List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }
}
