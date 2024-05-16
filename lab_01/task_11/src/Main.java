import java.util.Scanner; // Імпортуємо клас Scanner для зчитування введення з консолі.

public class Main { // Початок оголошення класу Main.
    public static void main(String[] args) { // Початок оголошення методу main, який є точкою входу в програму.
        int[] array = {1, 2, 3, 4, 5}; // Ініціалізуємо масив з числами.
        int sum = sum(array); // Викликаємо метод sum для обчислення суми парних чисел в масиві.
        System.out.println("Сума парних чисел: " + sum); // Виводимо суму парних чисел на екран.
    } // Кінець оголошення методу main.

    public static int sum(int[] array) { // Початок оголошення методу sum, який обчислює суму парних чисел у масиві.
        int sum = 0; // Ініціалізуємо змінну для збереження суми парних чисел.
        for (int i = 0; i < array.length; i++) { // Цикл для перевірки кожного елемента масиву.
            if (array[i] % 2 == 0) { // Перевіряємо, чи є поточний елемент парним числом.
                sum += array[i]; // Додаємо парне число до суми.
            }
        }
        return sum; // Повертаємо суму парних чисел.
    } // Кінець оголошення методу sum.
} // Кінець оголошення класу Main.