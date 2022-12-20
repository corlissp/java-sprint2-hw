import java.util.ArrayList;
import java.util.List;

public class MonthlyReport {
    ArrayList<MonthlyReportItem> expenses;
    ArrayList<MonthlyReportItem> incomes;
    int monthNumber;

    MonthlyReport(List<MonthlyReportItem> items, int monthNumber) {
        this.expenses = new ArrayList<>();
        this.incomes = new ArrayList<>();
        this.monthNumber = monthNumber;
        for (MonthlyReportItem item: items) {
            if (item.is_expense)
                expenses.add(item);
            else
                incomes.add(item);
        }
    }

    public int getSumExpenses() {
        int sum = 0;
        for (MonthlyReportItem item: expenses)
            sum += (item.quantity * item.sum_of_one);
        return sum;
    }

    public int getSumIncomes() {
        int sum = 0;
        for (MonthlyReportItem item: incomes)
            sum += (item.quantity * item.sum_of_one);
        return sum;
    }

    public int getMaxSumIncomes() {
        int max = 0;
        for (MonthlyReportItem item: incomes) {
            if (max < (item.quantity * item.sum_of_one))
                max = item.quantity * item.sum_of_one;
        }
        return max;
    }

    public String getMaxSumNameIncomes() {
        int max = 0;
        String maxName = "";
        for (MonthlyReportItem item: incomes) {
            if (max < (item.quantity * item.sum_of_one)) {
                max = item.quantity * item.sum_of_one;
                maxName = item.item_name;
            }
        }
        return maxName;
    }

    public String ParseMonthNumber() {
        switch (monthNumber) {
            case 1:
                return "Январь";
            case 2:
                return "Февраль";
            case 3:
                return "Март";
            case 4:
                return "Апрель";
            case 5:
                return "Май";
            case 6:
                return "Июнь";
            case 7:
                return "Июль";
            case 8:
                return "Август";
            case 9:
                return "Сентябрь";
            case 10:
                return "Октябрь";
            case 11:
                return "Ноябрь";
            case 12:
                return "Декабрь";
        }
        return "";
    }
}
