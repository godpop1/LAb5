package work5;

// --- Реалізації конкретних команд ---

class SaveFileAction implements Action {
    @Override
    public void execute() {
        System.out.println(">> [SAVE] Я зберігаю файл на диск.");
    }
}

class OpenFileAction implements Action {
    @Override
    public void execute() {
        System.out.println(">> [OPEN] Я відкриваю файл для редагування.");
    }
}

class CopyAction implements Action {
    @Override
    public void execute() {
        System.out.println(">> [COPY] Я копіюю виділені дані.");
    }
}

class PasteAction implements Action {
    @Override
    public void execute() {
        System.out.println(">> [PASTE] Я вставляю дані з буфера.");
    }
}