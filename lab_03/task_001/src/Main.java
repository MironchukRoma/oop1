import java.util.ArrayList;
import java.util.List;

class Ticket {
    private int id;
    private String name;
    private int estimate;
    private boolean completed;

    // Конструктор класу Ticket
    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        this.completed = false; // По замовчуванню завдання не виконане
    }

    // Методи доступу до полів класу Ticket
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEstimate() {
        return estimate;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Метод для відзначення завдання як виконаного
    public void complete() {
        this.completed = true;
    }
}

class UserStory extends Ticket {
    private List<UserStory> dependencies; // Залежності від інших користувальницьких історій

    // Конструктор класу UserStory
    public UserStory(int id, String name, int estimate, List<UserStory> dependencies) {
        super(id, name, estimate);
        this.dependencies = dependencies;
    }

    // Метод для отримання списку залежностей користувальницької історії
    public List<UserStory> getDependencies() {
        return new ArrayList<>(dependencies);
    }

    // Перевизначений метод toString() для класу UserStory
    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}

class Bug extends Ticket {
    private UserStory userStory; // Користувальницька історія, пов'язана з багом

    // Конструктор класу Bug
    public Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;
    }

    // Перевизначений метод toString() для класу Bug
    @Override
    public String toString() {
        return "[Bug " + getId() + "] " + userStory.getName() + ": " + getName();
    }

    // Статичний метод для створення об'єкта Bug
    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if (userStory != null && !userStory.isCompleted()) {
            return new Bug(id, name, estimate, userStory);
        } else {
            return null;
        }
    }
}

class Sprint {
    private int capacity; // Максимальна кількість балів оцінки завдань у спринті
    private int maxTickets; // Максимальна кількість завдань у спринті
    private List<Ticket> tickets; // Завдання у спринті

    // Конструктор класу Sprint
    public Sprint(int capacity, int maxTickets) {
        this.capacity = capacity;
        this.maxTickets = maxTickets;
        this.tickets = new ArrayList<>();
    }

    // Додати користувальницьку історію у спринт
    public boolean addUserStory(UserStory userStory) {
        if (userStory != null && !userStory.isCompleted() && getTotalEstimate() + userStory.getEstimate() <= capacity && tickets.size() < maxTickets) {
            tickets.add(userStory);
            return true;
        }
        return false;
    }

    // Додати баг у спринт
    public boolean addBug(Bug bug) {
        if (bug != null && !bug.isCompleted() && getTotalEstimate() + bug.getEstimate() <= capacity && tickets.size() < maxTickets) {
            tickets.add(bug);
            return true;
        }
        return false;
    }

    // Отримати список завдань у спринті
    public List<Ticket> getTickets() {
        return new ArrayList<>(tickets);
    }

    // Отримати загальну оцінку завдань у спринті
    public int getTotalEstimate() {
        int totalEstimate = 0;
        for (Ticket ticket : tickets) {
            totalEstimate += ticket.getEstimate();
        }
        return totalEstimate;
    }
}

public class Main {
    public static void main(String[] args) {
        // Створення користувальницьких історій та багу
        UserStory userStory1 = new UserStory(1, "Реалізувати функцію X", 5, new ArrayList<>());
        UserStory userStory2 = new UserStory(2, "Реалізувати функцію Y", 3, new ArrayList<>());
        Bug bug1 = Bug.createBug(1, "Виправити помилку Z", 2, userStory1);

        // Створення спринту та додавання завдань до нього
        Sprint sprint = new Sprint(10, 5);
        sprint.addUserStory(userStory1);
        sprint.addUserStory(userStory2);
        sprint.addBug(bug1);

        // Виведення інформації про завдання у спринті
        List<Ticket> sprintTickets = sprint.getTickets();
        for (Ticket ticket : sprintTickets) {
            System.out.println(ticket);
        }
        // Виведення загальної оцінки часу виконання
        System.out.println("Сума оцінок часу виконання: " + sprint.getTotalEstimate());
    }
}
