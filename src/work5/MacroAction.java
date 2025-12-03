package work5;

import java.util.ArrayList;
import java.util.List;

/**
 * Дозволяю виконувати кілька дій поспіль (макрос).
 */
public class MacroAction implements Action {
    private final List<Action> actions = new ArrayList<>();

    // Додаю дію до списку
    public void addAction(Action action) {
        actions.add(action);
    }

    @Override
    public void execute() {
        System.out.println("--- Початок макросу ---");
        for (Action action : actions) {
            action.execute();
        }
        System.out.println("--- Кінець макросу ---");
    }
}