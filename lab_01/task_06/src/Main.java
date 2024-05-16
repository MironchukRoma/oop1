import java.util.Scanner; //Імпорт класу Scanner зі стандартної бібліотеки Java для зчитування вводу з консолі.

public class Main { //Оголошення класу Main та його методу main, який є точкою входу в програму.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Створення об'єкта Scanner для зчитування вводу з консолі.
        System.out.println("Введіть загальну суму рахунку:");
        double totalBill = scanner.nextDouble();
        System.out.println("Введіть кількість друзів:");
        int numFriends = scanner.nextInt();

        if (totalBill < 0) {
            System.out.println("Сума рахунку не може бути від'ємною");
            return;
        }

        if (numFriends <= 0) {
            System.out.println("Кількість друзів повинна бути більшою за 0");
            return;
        }

        double totalPayment = totalBill + totalBill * 0.1; // Обчислення загальної суми платежу з урахуванням 10% чайових.
        double paymentPerPerson = totalPayment / numFriends; // Обчислення розміру частини оплати для кожного друга.

        System.out.println("Розмір частини оплати: " + paymentPerPerson);
    }
}