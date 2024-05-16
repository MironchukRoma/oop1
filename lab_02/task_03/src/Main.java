class Point {
    double x, y; // Поля для зберігання координат точки

    // Конструктор класу Point
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Перевизначений метод toString() для класу Point
    @Override
    public String toString() {
        return "(" + x + ";" + y + ")"; // Повертає координати точки у форматі "(x;y)"
    }
}

class Triangle {
    Point a, b, c; // Три точки, які визначають трикутник

    // Конструктор класу Triangle
    Triangle(Point a, Point b, Point c) {
        // Обчислення площі трикутника
        double area = 0.5 * Math.abs((a.x - c.x) * (b.y - a.y) - (a.x - b.x) * (c.y - a.y));
        // Перевірка на виродженість трикутника (точки колінеарні)
        if (area == 0) {
            throw new IllegalArgumentException("Points are collinear. Triangle is degenerate.");
        }
        // Ініціалізація полів класу з переданими точками
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Метод для обчислення площі трикутника
    double area() {
        return 0.5 * Math.abs((a.x - c.x) * (b.y - a.y) - (a.x - b.x) * (c.y - a.y));
    }

    // Метод для обчислення центроїду трикутника
    Point centroid() {
        return new Point((a.x + b.x + c.x) / 3, (a.y + b.y + c.y) / 3);
    }
}

public class Main {
    public static void main(String[] args) {
        // Створення трикутника з заданими точками
        Triangle triangle = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 1));
        // Виведення площі трикутника
        System.out.println("Area: " + triangle.area());
        // Виведення центроїду трикутника
        System.out.println("Centroid: " + triangle.centroid());
    }
}