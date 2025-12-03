package work5;

import java.util.ArrayList;
import java.util.List;

/**
 * Memento: Зберігає стан персонажа (здоров'я, позицію, інвентар).
 */
public class CharacterMemento {
    private final Position position;
    private final List<String> inventory;
    private final int health;

    // Конструктор приймає дані для збереження
    public CharacterMemento(Position position, List<String> inventory, int health) {
        this.position = position;
        // Роблю копію списку, щоб зміни в грі не впливали на збережений стан
        this.inventory = new ArrayList<>(inventory);
        this.health = health;
    }

    public Position getPosition() {
        return position;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public int getHealth() {
        return health;
    }
}