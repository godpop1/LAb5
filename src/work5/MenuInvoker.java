package work5;

/**
 * Викликач (Invoker). Це моя кнопка меню, яка запускає призначену дію.
 */
public class MenuInvoker {
    private final String name;
    private Action action;

    public MenuInvoker(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    // Змінюю дію кнопки "на льоту"
    public void setAction(Action action) {
        this.action = action;
    }

    // Натискаю на кнопку
    public void click() {
        System.out.println("Натиснуто: " + name);
        if (action != null) {
            action.execute();
        } else {
            System.out.println("Дія не призначена.");
        }
    }
}