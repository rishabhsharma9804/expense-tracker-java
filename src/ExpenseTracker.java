import java.time.LocalDate;
import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TransactionManager manager = new TransactionManager();

        while (true) {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Monthly Summary");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double incomeAmount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter category (e.g., Salary, Business): ");
                    String incomeCat = sc.nextLine();
                    manager.addTransaction(new Transaction(LocalDate.now(), "Income", incomeCat, incomeAmount));
                    System.out.println("Income added.");
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    double expAmount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter category (e.g., Food, Rent, Travel): ");
                    String expCat = sc.nextLine();
                    manager.addTransaction(new Transaction(LocalDate.now(), "Expense", expCat, expAmount));
                    System.out.println("Expense added.");
                    break;
                case 3:
                    System.out.print("Enter month (1–12): ");
                    int month = sc.nextInt();
                    manager.showMonthlySummary(month);
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
