class Point {
    double x, y; // Поля для зберігання координат точки

    // Конструктор класу Point
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Segment {
    Point start_point, end_point; // Початкова та кінцева точки відрізка

    // Конструктор класу Segment
    public Segment(Point start_point, Point end_point) {
        this.start_point = start_point;
        this.end_point = end_point;
        if (start_point.x == end_point.x && start_point.y == end_point.y) { // Перевірка на виродженість відрізка
            throw new IllegalArgumentException("Відрізок є виродженим (початкова та кінцева точки співпадають)");
        }
    }

    // Метод для обчислення довжини відрізка
    public double length() {
        return Math.sqrt(Math.pow(end_point.x - start_point.x, 2) + Math.pow(end_point.y - start_point.y, 2));
    }

    // Метод для знаходження середньої точки відрізка
    public Point middle() {
        double mid_x = (start_point.x + end_point.x) / 2;
        double mid_y = (start_point.y + end_point.y) / 2;
        return new Point(mid_x, mid_y);
    }

    // Метод для знаходження точки перетину відрізків
    public Point intersection(Segment another) {
        double x1 = start_point.x, y1 = start_point.y;
        double x2 = end_point.x, y2 = end_point.y;
        double x3 = another.start_point.x, y3 = another.start_point.y;
        double x4 = another.end_point.x, y4 = another.end_point.y;

        double det = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4); //обчислення визначника

        if (det == 0) {
            return null; // Якщо відрізки паралельні, повертаємо null
        }

        double intersection_x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / det; //обчислення координат
        double intersection_y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / det;

        // Перевірка чи точка перетину знаходиться на обох відрізках
        if ((Math.min(x1, x2) <= intersection_x && intersection_x <= Math.max(x1, x2)) &&
                (Math.min(y1, y2) <= intersection_y && intersection_y <= Math.max(y1, y2)) &&
                (Math.min(x3, x4) <= intersection_x && intersection_x <= Math.max(x3, x4)) &&
                (Math.min(y3, y4) <= intersection_y && intersection_y <= Math.max(y3, y4))) {
            return new Point(intersection_x, intersection_y);
        } else {
            return null; // Якщо точка перетину знаходиться за межами відрізків, повертаємо null
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Point start_point1 = new Point(1, 1);
        Point end_point1 = new Point(4, 5);
        Segment segment1 = new Segment(start_point1, end_point1);

        Point start_point2 = new Point(2, 3);
        Point end_point2 = new Point(5, 2);
        Segment segment2 = new Segment(start_point2, end_point2);

        // Виведення інформації про відрізки та їх взаємодію
        System.out.println("Довжина відрізка: " + segment1.length());
        System.out.println("Середня точка відрізка: (" + segment1.middle().x + ", " + segment1.middle().y + ")");
        System.out.println("Точка перетину відрізків: " + segment1.intersection(segment2));
    }
}
