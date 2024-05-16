class Point {
    double x, y;  // Поля для збереження координат точки

    // Конструктор класу Point
    Point(double x, double y) {
        this.x = x;  // Ініціалізуємо поле x значенням параметра x
        this.y = y;  // Ініціалізуємо поле y значенням параметра y
    }

    // Перевизначення методу toString() для класу Point
    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";  // Повертаємо рядок з координатами точки у форматі "(x;y)"
    }
}

class Line {
    double k, b;  // Поля для збереження коефіцієнтів нахилу та зсуву лінії

    // Конструктор класу Line
    Line(double k, double b) {
        this.k = k;  // Ініціалізуємо поле k значенням параметра k
        this.b = b;  // Ініціалізуємо поле b значенням параметра b
    }

    // Метод для обчислення точки перетину ліній
    Point intersection(Line other) {
        if (this.k == other.k) {
            return null;  // Якщо лінії паралельні, повертаємо null
        }

        double x = (other.b - this.b) / (this.k - other.k);  // Обчислюємо x координату точки перетину
        double y = this.k * x + this.b;  // Обчислюємо y координату точки перетину

        return new Point(x, y);  // Повертаємо новий об'єкт класу Point з координатами точки перетину
    }
}

public class Main {
    public static void main(String[] args) {
        Line line1 = new Line(1,1);  // Створюємо першу лінію з коефіцієнтами нахилу 1 та зсувом 1
        Line line2 = new Line(-1,3);  // Створюємо другу лінію з коефіцієнтами нахилу -1 та зсувом 3

        System.out.println(line1.intersection(line2));  // Виводимо точку перетину ліній на екран
    }
}

