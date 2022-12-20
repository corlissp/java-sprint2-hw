import java.util.ArrayList;
import java.util.List;

public class YearlyReport {
    ArrayList<YearlyReportItem> expenses;
    ArrayList<YearlyReportItem> incomes;
    int year;

    YearlyReport(List<YearlyReportItem> items, int year) {
        this.expenses = new ArrayList<>();
        this.incomes = new ArrayList<>();
        this.year = year;
        for (YearlyReportItem item: items)
            if (item.is_expense)
                expenses.add(item);
            else
                incomes.add(item);
    }

    public void profitReport() {
        int profit;
        for (int i = 0; i < incomes.size(); i++) {
            YearlyReportItem expense = expenses.get(i);
            YearlyReportItem income = incomes.get(i);
            System.out.print("Месяц " + income.month);
            profit = income.amount - expense.amount;
            System.out.println(",\tПрибыль: " + profit);
        }
    }

    public float avgExpense() {
        float sum = 0;
        for (YearlyReportItem expense: expenses) {
            sum += expense.amount;
        }
        return sum / expenses.size();
    }

    public float avgIncome() {
        float sum = 0;
        for (YearlyReportItem income: incomes) {
            sum += income.amount;
        }
        return sum / incomes.size();
    }
}
