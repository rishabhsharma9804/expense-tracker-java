import java.time.LocalDate;
import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionManager manager = new TransactionManager();

        while (true) {
            System.out.println("\nExpense Tracker");
            System.out.println("1. Add Transaction");
            System.out.println("2. Load from file");
            System.out.println("3. Save to file");
            System.out.println("4. View Monthly Summary");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter type (Income/Expense): ");
                        String type = scanner.nextLine();

                        String categoryPrompt = type.equalsIgnoreCase("Income") ?
                            "Enter category (Salary, Business): " :
                            "Enter category (Food, Rent, Travel): ";

                        System.out.print(categoryPrompt);
                        String category = scanner.nextLine();

                        System.out.print("Enter amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();

                        Transaction t = new Transaction(LocalDate.now(), type, category, amount);
                        manager.addTransaction(t);
                        System.out.println("Transaction added.");
                        break;

                    case 2:
                        System.out.print("Enter file path to load: ");
                        String loadPath = scanner.nextLine();
                        manager.loadFromFile(loadPath);
                        System.out.println("Data loaded from file.");
                        break;

                    case 3:
                        System.out.print("Enter file path to save: ");
                        String savePath = scanner.nextLine();
                        manager.saveToFile(savePath);
                        System.out.println("Data saved to file.");
                        break;

                    case 4:
                        System.out.print("Enter year (e.g., 2025): ");
                        int year = scanner.nextInt();
                        System.out.print("Enter month (1-12): ");
                        int month = scanner.nextInt();
                        manager.printMonthlySummary(year, month);
                        break;

                    case 5:
                        System.out.println("Exiting. Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}