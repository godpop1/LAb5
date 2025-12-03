package work5;

import java.util.Stack;

/**
 * Caretaker: Керує історією збережень (Stack).
 */
public class GameHistory {
    private final Stack<CharacterMemento> history = new Stack<>();

    // Додаю знімок в історію
    public void save(CharacterMemento memento) {
        history.push(memento);
    }

    // Дістаю останній знімок для Undo
    public CharacterMemento undo() {
        if (history.isEmpty()) {
            System.out.println("Історія порожня, нікуди відкочуватись.");
            return null;
        }
        return history.pop();
    }
}