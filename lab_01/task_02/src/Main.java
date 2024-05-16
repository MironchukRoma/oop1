import java.util.Scanner; //Імпорт класу Scanner зі стандартної бібліотеки Java для зчитування вводу з консолі.
public class Main { //Оголошення класу Main та його методу main, який є точкою входу в програму.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Створення об'єкта Scanner для зчитування вводу з консолі.
        System.out.println("Введіть кількість секунд:"); //Виведення на екран запрошення для введення кількості секунд.
        int secondsPastMidnight = scanner.nextInt(); // Зчитування кількості секунд з консолі та збереження її у змінній secondsPastMidnight.

        int hours = secondsPastMidnight / 3600; //Обчислення годин, хвилин і секунд з введених секунд.
        int minutes = (secondsPastMidnight % 3600) / 60;
        int seconds = secondsPastMidnight % 60;

        System.out.printf("Результат виконання: %02d:%02d:%02d\n", hours, minutes, seconds); //Виведення на екран результату у форматі годин, хвилин і секунд.
    }
}