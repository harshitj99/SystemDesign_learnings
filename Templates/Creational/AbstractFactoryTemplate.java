package Templates.Creational;

/*
 * Abstract Factory Pattern Assignment
 *
 * Problem:
 * A UI application needs matching families of components.
 * A Windows button should be paired with a Windows checkbox.
 * A Mac button should be paired with a Mac checkbox.
 *
 * Student task:
 * 1. Implement abstract product interfaces.
 * 2. Implement concrete product families.
 * 3. Implement factories that create a complete matching family.
 * 4. Keep Application dependent only on UIFactory, Button, and Checkbox.
 */

interface Button {
    void render();
}

interface Checkbox {
    void render();
}

class WindowsButton implements Button {
    @Override
    public void render() {
        // TODO: Render or print Windows-style button behavior.
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        // TODO: Render or print Windows-style checkbox behavior.
    }
}

class MacButton implements Button {
    @Override
    public void render() {
        // TODO: Render or print Mac-style button behavior.
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        // TODO: Render or print Mac-style checkbox behavior.
    }
}

interface UIFactory {
    Button createButton();

    Checkbox createCheckbox();
}

class WindowsUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        // TODO: Return a Windows button.
        return null;
    }

    @Override
    public Checkbox createCheckbox() {
        // TODO: Return a Windows checkbox.
        return null;
    }
}

class MacUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        // TODO: Return a Mac button.
        return null;
    }

    @Override
    public Checkbox createCheckbox() {
        // TODO: Return a Mac checkbox.
        return null;
    }
}

class Application {
    private final Button button;
    private final Checkbox checkbox;

    Application(UIFactory factory) {
        // TODO: Use the factory to create both UI components.
        // TODO: Do not use new WindowsButton(), new MacButton(), etc. in this class.
        this.button = null;
        this.checkbox = null;
    }

    void renderUI() {
        // TODO: Render both components.
    }
}

public class AbstractFactoryTemplate {
    public static void main(String[] args) {
        // TODO: Pick a factory based on an input such as "windows" or "mac".
        // TODO: Pass the chosen factory to Application.
        // TODO: Render the UI.
    }
}
