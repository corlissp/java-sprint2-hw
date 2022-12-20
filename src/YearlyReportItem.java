public class YearlyReportItem {
    int month;
    int amount;
    boolean is_expense;

    YearlyReportItem(int month, int amount, boolean is_expense) {
        this.month = month;
        this.amount = amount;
        this.is_expense = is_expense;
    }
}
