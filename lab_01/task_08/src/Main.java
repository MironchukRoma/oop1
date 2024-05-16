import java.util.Scanner; // Імпорт класу Scanner зі стандартної бібліотеки Java для зчитування вводу з консолі.

public class Main { // Оголошення класу Main та його методу main, який є точкою входу в програму.
    public static void main(String[] args) {
        System.out.println("Введення даних: :"); // Виведення на екран запрошення для введення даних.
        Scanner scanner = new Scanner(System.in); // Створення об'єкта Scanner для зчитування вводу з консолі.

        int sum = 0; // Ініціалізація змінної sum для обчислення суми введених чисел.
        int count = 0; // Ініціалізація змінної count для обчислення кількості введених чисел.
        int input; // Оголошення змінної input для зберігання введеного числа.

        while ((input = scanner.nextInt()) != 0) { // Цикл для введення чисел з консолі, що продовжується до введення нуля.
            sum += input; // Додавання введеного числа до суми.
            count++; // Збільшення лічильника чисел на одиницю.
        }

        double average = (double) sum / count; // Обчислення середнього значення введених чисел.
        System.out.println("Середнє значення: " + average); // Виведення середнього значення на екран.
    }
}