public class MonthlyReportItem {
    String item_name;
    boolean is_expense;
    int quantity, sum_of_one;

    MonthlyReportItem(String item_name, boolean is_expense, int quantity, int sum_of_one) {
        this.item_name = item_name;
        this.is_expense = is_expense;
        this.quantity = quantity;
        this.sum_of_one = sum_of_one;
    }
}
