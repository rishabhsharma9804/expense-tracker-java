import java.io.*;
import java.time.Month;
import java.util.*;

public class TransactionManager {
    private List<Transaction> transactions = new ArrayList<>();
    private final String filePath = "data/transactions.txt";

    public TransactionManager() {
        loadFromFile();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
        saveToFile();
    }

    public void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                transactions.add(Transaction.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Transaction t : transactions) {
                bw.write(t.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public void showMonthlySummary(int month) {
        double totalIncome = 0;
        double totalExpense = 0;
        Map<String, Double> categoryTotals = new HashMap<>();

        for (Transaction t : transactions) {
            if (t.getDate().getMonthValue() == month) {
                if (t.getType().equalsIgnoreCase("Income")) {
                    totalIncome += t.getAmount();
                } else {
                    totalExpense += t.getAmount();
                }

                categoryTotals.put(t.getCategory(),
                    categoryTotals.getOrDefault(t.getCategory(), 0.0) + t.getAmount());
            }
        }

        System.out.println("\n--- Monthly Summary for " + Month.of(month) + " ---");
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expense: " + totalExpense);
        System.out.println("By Category:");
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
