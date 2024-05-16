import java.util.Arrays; // Імпортуємо клас Arrays для використання методу toString.

public class Main { // Початок оголошення класу Main.
    public static void main(String[] args) { // Початок оголошення методу main, який є точкою входу в програму.
        int[] array = {1, 3, 2, 7, 4}; // Ініціалізуємо масив array з цілими числами.
        cycleSwap(array); // Викликаємо метод cycleSwap для циклічного зсуву масиву на одну позицію вправо.
        System.out.println(Arrays.toString(array)); // Виводимо результат у вигляді рядка.

        int[] array2 = {1, 3, 2, 7, 4}; // Ініціалізуємо другий масив array2 з цілими числами.
        cycleSwap(array2, 3); // Викликаємо метод cycleSwap для циклічного зсуву масиву на три позиції вправо.
        System.out.println(Arrays.toString(array2)); // Виводимо результат у вигляді рядка.
    } // Кінець оголошення методу main.

    public static void cycleSwap(int[] array) { // Початок оголошення методу cycleSwap без параметрів.
        int last = array[array.length - 1]; // Зберігаємо значення останнього елемента масиву.
        System.arraycopy(array, 0, array, 1, array.length - 1); // Копіюємо всі елементи масиву вправо на одну позицію.
        array[0] = last; // Першому елементу присвоюємо значення останнього елемента, збереженого раніше.
    } // Кінець оголошення методу cycleSwap без параметрів.

    public static void cycleSwap(int[] array, int shift) { // Початок оголошення методу cycleSwap з одним параметром.
        for (int i = 0; i < shift; i++) { // Цикл для виконання циклічного зсуву задану кількість разів.
            cycleSwap(array); // Викликаємо метод cycleSwap для циклічного зсуву масиву на одну позицію вправо.
        } // Кінець циклу.
    } // Кінець оголошення методу cycleSwap з одним параметром.
} // Кінець оголошення класу Main.