import java.util.ArrayList;

public class Commands {
    YearlyReport yearlyReport;
    ArrayList<MonthlyReport> monthlyReports;

    Commands() {
        monthlyReports = new ArrayList<>();
    }

    public void readAndSaveMonthlyReports() {
        for (int i = 1; i <= 3; i ++) {
            MonthlyReport report = Parser.readMonthlyReport("../resources/m.20210" + i + ".csv");
            monthlyReports.add(report);
        }
    }

    public void readAndSaveYearlyReports() {
        yearlyReport = Parser.readYearlyReport("../resources/y.2021.csv");
    }

    public void checkingReports() {
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
        for (int i = 0; i < 3; i++) {
            MonthlyReport month = monthlyReports.get(i);
            System.out.println(month.ParseMonthNumber() + ":");
            String name = month.getMaxSumNameIncomes();
            int max = month.getMaxSumIncomes();
            System.out.println(name + ", доход: " + max);
        }
    }

    public void outputYearlyReport() {
        System.out.println("Год: " + yearlyReport.year);
        yearlyReport.profitReport();
        System.out.println("Средний расход за год: " + yearlyReport.avgExpense());
        System.out.println("Средний доход за год: " + yearlyReport.avgIncome());
    }
}
