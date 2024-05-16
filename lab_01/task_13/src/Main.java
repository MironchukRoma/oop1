import java.util.Arrays; // Імпортуємо клас Arrays для використання методу toString.

public class Main { // Початок оголошення класу Main.
    public static void main(String[] args) { // Початок оголошення методу main, який є точкою входу в програму.
        int[] input = {18, 1, 3, 6, 7, -5}; // Ініціалізуємо масив input з цілими числами.
        int[] result = removeLocalMaxima(input); // Викликаємо метод removeLocalMaxima для обробки масиву input.
        System.out.println(Arrays.toString(result)); // Виводимо результат у вигляді рядка.
    } // Кінець оголошення методу main.

    public static int[] removeLocalMaxima(int[] arr) { // Початок оголошення методу removeLocalMaxima.
        int[] temp = new int[arr.length]; // Ініціалізуємо тимчасовий масив temp з такою ж довжиною, як масив arr.
        int count = 0; // Ініціалізуємо лічильник.

        for (int i = 0; i < arr.length; i++) { // Цикл для перевірки кожного елемента масиву.
            if (i > 0 && i < arr.length - 1) { // Перевіряємо, чи не перебираємо перший і останній елементи.
                if (arr[i] <= arr[i - 1] || arr[i] <= arr[i + 1]) { // Перевіряємо, чи поточний елемент не є локальним максимумом.
                    temp[count++] = arr[i]; // Додаємо поточний елемент до тимчасового масиву.
                }
            } else { // Якщо поточний елемент перший або останній, то він точно не є локальним максимумом.
                temp[count++] = arr[i]; // Додаємо поточний елемент до тимчасового масиву.
            }
        } // Кінець циклу.

        return Arrays.copyOf(temp, count); // Повертаємо новий масив без локальних максимумів.
    } // Кінець оголошення методу removeLocalMaxima.
} // Кінець оголошення класу Main.