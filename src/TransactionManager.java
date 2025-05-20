import java.io.*;
import java.time.Month;
import java.util.*;

public class TransactionManager {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void loadFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            transactions.add(Transaction.fromString(line));
        }
        reader.close();
    }

    public void saveToFile(String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (Transaction t : transactions) {
            writer.write(t.toString());
            writer.newLine();
        }
        writer.close();
    }

    public void printMonthlySummary(int year, int month) {
        double incomeTotal = 0, expenseTotal = 0;

        System.out.println("Monthly Summary for " + Month.of(month) + " " + year + ":");

        for (Transaction t : transactions) {
            if (t.getDate().getYear() == year && t.getDate().getMonthValue() == month) {
                System.out.println(t);
                if (t.getType().equalsIgnoreCase("Income"))
                    incomeTotal += t.getAmount();
                else
                    expenseTotal += t.getAmount();
            }
        }

        System.out.println("Total Income: " + incomeTotal);
        System.out.println("Total Expenses: " + expenseTotal);
        System.out.println("Net Savings: " + (incomeTotal - expenseTotal));
    }
}