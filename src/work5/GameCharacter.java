package work5;

import java.util.ArrayList;
import java.util.List;

/**
 * Головний персонаж. Зберігаю його стан і методи дій.
 */
public class GameCharacter {
    private final String name;
    private int health;
    private Position position;
    private List<String> inventory;

    public GameCharacter(String name, int health, Position position) {
        this.name = name;
        this.health = health;
        this.position = position;
        this.inventory = new ArrayList<>();
    }

    // --- Методи бізнес-логіки (заглушки) ---

    public void move(int x, int y) {
        this.position = new Position(x, y);
        System.out.println(name + " перемістився на позицію: " + position);
    }

    public void pickUpItem(String item) {
        inventory.add(item);
        System.out.println(name + " підібрав предмет: " + item);
    }

    public void takeDamage(int amount) {
        this.health -= amount;
        System.out.println(name + " отримав шкоду " + amount + ". Поточне здоров'я: " + health);
    }

    public void showStatus() {
        System.out.println("\n--- СТАТУС ПЕРСОНАЖА ---");
        System.out.println("Ім'я: " + name);
        System.out.println("Здоров'я: " + health);
        System.out.println("Позиція: " + position);
        System.out.println("Інвентар: " + inventory);
        System.out.println("------------------------\n");
    }

    // --- Методи Memento ---

    // Створюю знімок поточного стану
    public CharacterMemento save() {
        System.out.println(">>> Збереження гри...");
        return new CharacterMemento(this.position, this.inventory, this.health);
    }

    // Відновлюю стан зі знімка
    public void restore(CharacterMemento memento) {
        this.position = memento.getPosition();
        this.inventory = new ArrayList<>(memento.getInventory()); // Відновлюю копію
        this.health = memento.getHealth();
        System.out.println("<<< Завантаження збереженого стану завершено.");
    }
}