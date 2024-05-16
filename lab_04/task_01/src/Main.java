// Абстрактний клас Figure, що представляє геометричну фігуру
abstract class Figure {
    // Абстрактний метод для обчислення площі фігури
    abstract double area();
}

// Клас, що представляє точку у двовимірному просторі
class Point {
    double x;
    double y;

    // Конструктор класу Point
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

// Підклас Triangle, який успадковує клас Figure
class Triangle extends Figure {
    Point a;
    Point b;
    Point c;

    // Конструктор класу Triangle
    Triangle(Point a, Point b, Point c) {
        // Перевірка, чи утворюють передані точки правильний трикутник
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Invalid triangle vertices");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Перевизначений метод для обчислення площі трикутника
    @Override
    double area() {
        return Math.abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0);
    }

    // Перевизначений метод toString() для виведення інформації про трикутник
    @Override
    public String toString() {
        return String.format("Triangle[A(%.2f,%.2f) B(%.2f,%.2f) C(%.2f,%.2f)]", a.x, a.y, b.x, b.y, c.x, c.y);
    }

    // Приватний метод для перевірки правильності трикутника за його вершинами
    private boolean isValidTriangle(Point a, Point b, Point c) {
        return (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) != 0;
    }
}

// Підклас Quadrilateral, який успадковує клас Figure
class Quadrilateral extends Figure {
    Point a;
    Point b;
    Point c;
    Point d;

    // Конструктор класу Quadrilateral
    Quadrilateral(Point a, Point b, Point c, Point d) {
        // Перевірка, чи утворюють передані точки правильний чотирикутник
        if (!isValidQuadrilateral(a, b, c, d)) {
            throw new IllegalArgumentException("Invalid quadrilateral vertices");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    // Перевизначений метод для обчислення площі чотирикутника
    @Override
    double area() {
        double s1 = Math.abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0);
        double s2 = Math.abs((a.x * (c.y - d.y) + c.x * (d.y - a.y) + d.x * (a.y - c.y)) / 2.0);
        return s1 + s2;
    }

    // Перевизначений метод toString() для виведення інформації про чотирикутник
    @Override
    public String toString() {
        return String.format("Quadrilateral[A(%.2f,%.2f) B(%.2f,%.2f) C(%.2f,%.2f) D(%.2f,%.2f)]",
                a.x, a.y, b.x, b.y, c.x, c.y, d.x, d.y);
    }

    // Приватний метод для перевірки правильності чотирикутника за його вершинами
    private boolean isValidQuadrilateral(Point a, Point b, Point c, Point d) {
        return (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) != 0 ||
                (a.x * (c.y - d.y) + c.x * (d.y - a.y) + d.x * (a.y - c.y)) != 0;
    }
}

// Підклас Circle, який успадковує клас Figure
class Circle extends Figure {
    Point center;
    double radius;

    // Конструктор класу Circle
    Circle(Point center, double radius) {
        // Перевірка на допустимість значення радіуса
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.center = center;
        this.radius = radius;
    }

    // Перевизначений метод для обчислення площі кола
    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    // Перевизначений метод toString() для виведення інформації про коло
    @Override
    public String toString() {
        return String.format("Circle[(%.2f,%.2f) Radius=%.2f]", center.x, center.y, radius);
    }
}

// Клас Main для демонстрації використання р
// Головний клас програми
public class Main {
    // Метод main, який викликається при запуску програми
    public static void main(String[] args) {

        // Створення точок для різних геометричних фігур
        Point a = new Point(0, 0);
        Point b = new Point(3, 0);
        Point c = new Point(0, 4);
        Point d = new Point(3, 4);

        // Створення об'єктів Triangle, Quadrilateral і Circle
        Triangle triangle = new Triangle(a, b, c);
        Quadrilateral quadrilateral = new Quadrilateral(a, b, c, d);
        Circle circle = new Circle(new Point(1, 1), 2);

        // Виведення площі кожної фігури
        System.out.println("Triangle area: " + triangle.area());
        System.out.println("Quadrilateral area: " + quadrilateral.area());
        System.out.println("Circle area: " + circle.area());

        // Виведення інформації про кожну фігуру
        System.out.println(triangle);
        System.out.println(quadrilateral);
        System.out.println(circle);
    }
}

