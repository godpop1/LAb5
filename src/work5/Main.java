package work5;

/**
 * Головний клас для демонстрації роботи Memento.
 */
public class Main {
    public static void main(String[] args) {
        // 1. Створення персонажа та історії
        GameCharacter hero = new GameCharacter("Стрілок", 100, new Position(0, 0));
        GameHistory history = new GameHistory();

        hero.showStatus();

        // 2. Граємо: рух та збір предметів
        hero.move(10, 20);
        hero.pickUpItem("Аптечка");

        // Зберігаємось (Save 1)
        history.save(hero.save());

        // 3. Граємо далі: отримали шкоду, взяли зброю
        hero.takeDamage(30);
        hero.pickUpItem("AK-47");
        hero.move(50, 50);
        hero.showStatus();

        // Зберігаємось перед небезпечною дією (Save 2)
        history.save(hero.save());

        // 4. Критична помилка гравця (смертельна шкода)
        hero.takeDamage(80); // Здоров'я стало -10
        hero.showStatus();

        // 5. Відкат (Undo) до Save 2
        System.out.println("! Відкат змін (Undo) !");
        CharacterMemento memento = history.undo();
        if (memento != null) {
            hero.restore(memento);
        }
        hero.showStatus();

        // 6. Відкат (Undo) до Save 1
        System.out.println("! Відкат змін ще раз (Undo) !");
        memento = history.undo();
        if (memento != null) {
            hero.restore(memento);
        }
        hero.showStatus();
    }
}