package work5;

/**
 * Головний клас для демонстрації роботи обох завдань (Memento та Command).
 */
public class Main {
    public static void main(String[] args) {

        // ==========================================
        // ЗАВДАННЯ 1 (Варіант 6 - Memento)
        // ==========================================
        System.out.println("==========================================");
        System.out.println("ЗАВДАННЯ 1: ПАТЕРН MEMENTO (Ігровий персонаж)");
        System.out.println("==========================================");

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


        // ==========================================
        // ЗАВДАННЯ 2 (Варіант 4 - Command)
        // ==========================================
        System.out.println("\n\n==========================================");
        System.out.println("ЗАВДАННЯ 2: ПАТЕРН COMMAND (Меню та кнопки)");
        System.out.println("==========================================");

        // 1. Створюю самі дії (Receiver логіка всередині дій)
        Action save = new SaveFileAction();
        Action open = new OpenFileAction();
        Action copy = new CopyAction();
        Action paste = new PasteAction();

        // 2. Створюю кнопки та призначаю їм дії
        MenuInvoker btnSave = new MenuInvoker("Кнопка 'Зберегти'", save);
        MenuInvoker btnOpen = new MenuInvoker("Кнопка 'Відкрити'", open);

        // 3. Тестую прості натискання
        btnOpen.click();
        btnSave.click();

        // 4. Динамічно змінюю дію кнопки
        System.out.println("\n> Змінюю призначення кнопки 'Зберегти' на 'Копіювати'...");
        btnSave.setAction(copy);
        btnSave.click();

        // 5. Створюю макрос (Копіювати -> Вставити -> Зберегти)
        System.out.println("\n> Запускаю макрос...");
        MacroAction macro = new MacroAction();
        macro.addAction(copy);
        macro.addAction(paste);
        macro.addAction(save);

        MenuInvoker btnMacro = new MenuInvoker("Кнопка 'Макрос'", macro);
        btnMacro.click();
    }
}