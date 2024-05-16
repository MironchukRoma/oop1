import java.util.Arrays; // Імпортуємо клас Arrays для використання методу toString.

public class Main { // Початок оголошення класу Main.
    public static void main(String[] args) { // Початок оголошення методу main, який є точкою входу в програму.
        int[] input = {1, -1, 0, 4, 6, 10, 15, 25}; // Ініціалізуємо масив input з цілими числами.
        boolean[] result = getSumCheckArray(input); // Викликаємо метод getSumCheckArray для обробки масиву input.
        System.out.println(Arrays.toString(result)); // Виводимо результат у вигляді рядка.
    } // Кінець оголошення методу main.

    public static boolean[] getSumCheckArray(int[] arr) { // Початок оголошення методу getSumCheckArray.
        boolean[] result = new boolean[arr.length]; // Ініціалізуємо масив булевих значень result з такою ж довжиною, як масив arr.
        for (int i = 2; i < arr.length; i++) { // Цикл для обробки кожного елемента масиву, починаючи з третього.
            result[i] = arr[i] == arr[i - 1] + arr[i - 2]; // Перевіряємо, чи дорівнює поточний елемент сумі двох попередніх елементів.
        } // Кінець циклу.
        return result; // Повертаємо масив булевих значень result.
    } // Кінець оголошення методу getSumCheckArray.
} // Кінець оголошення класу Main.
