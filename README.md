# expense-tracker-java
# 💸 Expense Tracker Java Application

A simple and efficient command-line Expense Tracker written in Java. This application allows users to:

- ✅ Add incomes and expenses
- ✅ Categorize each transaction (e.g., Food, Rent, Travel, Salary, Business)
- ✅ View monthly summaries by category
- ✅ Load and save transactions from/to a file

---

## 📁 Project Structure

ExpenseTracker/
├── src/
│ ├── Transaction.java
│ ├── TransactionManager.java
│ └── ExpenseTracker.java
├── data/
│ └── transactions.txt
└── README.md

---

## 🚀 Features

- **Add Income & Expense:** Add new transactions with amount, category, and current date.
- **Categorization:** Define categories like Salary, Business, Food, Rent, Travel, etc.
- **Monthly Summary:** View categorized summary of income and expenses by selected month.
- **File Persistence:** All transactions are stored in `data/transactions.txt` for persistence.
- **Read from File:** The system loads transactions from file on startup.

---

## 🛠️ Getting Started

### ✅ Prerequisites
- Java JDK 8 or higher
- Command-line terminal or VS Code with Java extension

### 📥 Clone the Repository
```bash
git clone https://github.com/yourusername/expense-tracker-java.git
cd expense-tracker-java
