package exam1;


import java.util.Scanner;

public class Main {

    private static int[] expenses = new int[30];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1 - Ввести расходы за определенный день");
            System.out.println("2 - Траты за месяц");
            System.out.println("3 - Самая большая сумма расхода за месяц");
            System.out.println("0 - Выход");
            System.out.print("Выберите пункт меню: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    enterExpenses(scanner);
                    break;
                case 2:
                    displayExpenses();
                    break;
                case 3:
                    displayMaxExpense();
                    break;
                case 0:
                    System.out.println("До свидания!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }
        } while (choice != 0);
    }

    public static void enterExpenses(Scanner scanner) {
        System.out.print("Введите день (от 1 до 30): ");
        int day = scanner.nextInt();
        System.out.print("Введите сумму трат за текущий день: ");
        int amount = scanner.nextInt();

        if (expenses[day - 1] != 0) {
            System.out.println("За этот день уже указана сумма: " + expenses[day - 1] + " руб.");
            System.out.print("Хотите перезаписать? (1 - Да, 0 - Нет): ");
            int overwrite = scanner.nextInt();
            if (overwrite == 1) {
                expenses[day - 1] = amount;
                System.out.println("Сумма трат успешно перезаписана.");
            }
        } else {
            expenses[day - 1] = amount;
            System.out.println("Сумма трат успешно записана.");
        }

        System.out.print("Хотите ввести трату за другой день? (1 - Да, 0 - Нет): ");
        int continueInput = scanner.nextInt();
        if (continueInput == 1) {
            enterExpenses(scanner);
        }
    }

    public static void displayExpenses() {
        System.out.println("Траты за месяц:");
        for (int i = 0; i < expenses.length; i++) {
            if (expenses[i] != 0) {
                System.out.println((i + 1) + " день - " + expenses[i] + " руб.");
            }
        }
        System.out.println();
    }

    public static void displayMaxExpense() {
        int maxExpense = 0;
        int maxExpenseDay = 0;

        for (int i = 0; i < expenses.length; i++) {
            if (expenses[i] > maxExpense) {
                maxExpense = expenses[i];
                maxExpenseDay = i + 1;
            }
        }

        if (maxExpenseDay != 0) {
            System.out.println("Самая большая сумма расхода за месяц: " + maxExpenseDay + " день - " + maxExpense + " руб.");
        } else {
            System.out.println("Не указаны траты за месяц.");
        }

        System.out.println();
    }
}

