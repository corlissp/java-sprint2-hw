import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Commands {
    YearlyReport yearlyReport;
    ArrayList<MonthlyReport> monthlyReports;

    Commands() {
        monthlyReports = new ArrayList<>();
    }

    public void readAndSaveMonthlyReports() {
        Path path = Paths.get("resources");
        Path absPath = path.toAbsolutePath();
        for (int i = 1; i <= 3; i ++) {
            MonthlyReport report = Parser.readMonthlyReport(absPath + "\\m.20210" + i + ".csv");
            monthlyReports.add(report);
        }
    }

    public void readAndSaveYearlyReports() {
        Path path = Paths.get("resources");
        Path absPath = path.toAbsolutePath();
        yearlyReport = Parser.readYearlyReport(absPath + "\\y.2021.csv");
    }

    public void checkingReports() {
        if (!checkErrorMonth() || !checkErrorYear()) {
            return;
        }
        boolean errors = false;
        for (int i = 0; i < monthlyReports.size(); i++) {
            MonthlyReport month = monthlyReports.get(i);
            int sumExpense = month.getSumExpenses();
            int sumIncome = month.getSumIncomes();
            if (yearlyReport.expenses.get(i).amount != sumExpense) {
                errors = true;
                System.out.println("Несовпали траты в " + yearlyReport.expenses.get(i).month + " месяце");
            }
            if (yearlyReport.incomes.get(i).amount != sumIncome) {
                errors = true;
                System.out.println("Несовпали доходы в " + yearlyReport.incomes.get(i).month + " месяце");
            }
        }
        if (!errors)
            System.out.println("Сверка прошла успешно!");
    }

    public void outputMonthlyReports() {
        if (!checkErrorMonth()) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            MonthlyReport month = monthlyReports.get(i);
            System.out.println(month.ParseMonthNumber() + ":");
            String name = month.getMaxSumNameIncomes();
            int max = month.getMaxSumIncomes();
            System.out.println(name + ", доход: " + max);
        }
    }

    public void outputYearlyReport() {
        if (!checkErrorYear()) {
            return;
        }
        System.out.println("Год: " + yearlyReport.year);
        yearlyReport.profitReport();
        System.out.println("Средний расход за год: " + yearlyReport.avgExpense());
        System.out.println("Средний доход за год: " + yearlyReport.avgIncome());
    }

    public boolean checkErrorYear() {
        if (yearlyReport == null) {
            System.out.println("Данные не считаны!\nНеобходимо считать данные и повторить попытку.");
            return false;
        }
        return true;
    }

    public boolean checkErrorMonth() {
        if (monthlyReports.size() == 0) {
            System.out.println("Данные не считаны!\nНеобходимо считать данные и повторить попытку.");
            return false;
        }
            return true;
    }
}
