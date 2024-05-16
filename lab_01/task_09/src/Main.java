import java.util.Scanner; // Імпорт класу Scanner зі стандартної бібліотеки Java для зчитування вводу з консолі.

public class Main { // Оголошення класу Main та його методу main, який є точкою входу в програму.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Створення об'єкта Scanner для зчитування вводу з консолі.
        System.out.println("Введення даних: "); // Виведення на екран запрошення для введення даних.

        double a = scanner.nextDouble(); // Зчитування коефіцієнта 'a' з консолі.
        double b = scanner.nextDouble(); // Зчитування коефіцієнта 'b' з консолі.
        double c = scanner.nextDouble(); // Зчитування коефіцієнта 'c' з консолі.

        double discriminant = b * b - 4 * a * c; // Обчислення дискримінанту.

        if (discriminant > 0) { // Перевірка, чи дискримінант більший за нуль.
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a); // Обчислення першого кореня.
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a); // Обчислення другого кореня.
            System.out.println("Результат: " + root1 + " " + root2); // Виведення коренів на екран.
        } else if (discriminant == 0) { // Перевірка, чи дискримінант дорівнює нулю.
            double root = -b / (2 * a); // Обчислення кореня.
            System.out.println("Результат: " + root); // Виведення кореня на екран.
        } else { // У всіх інших випадках (коли дискримінант менший за нуль).
            System.out.println("Результат: no roots"); // Виведення повідомлення про відсутність коренів на екран.
        }
    }
}