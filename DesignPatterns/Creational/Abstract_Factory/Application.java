package DesignPatterns.Creational.Abstract_Factory;

// Client code — notice it never mentions a concrete class:
public class Application {
    private IButton button;
    private ICheckbox checkbox;

     // client depends only on the abstract factory interface
    Application(IUIFactory factory){
        this.button = factory.createButton();
        this.checkbox = factory.creatCheckbox();
    }

    void renderUI(){
        button.render();
        checkbox.render();
    }

}

class Main{

    static String detectOS(){
        String osName = System.getProperty("os.name", "").toLowerCase(java.util.Locale.ROOT);

        if (osName.contains("mac")) return "mac";
        if (osName.contains("win")) return "windows";

        throw new UnsupportedOperationException("Unsupported operating system: " + osName);
    }

    public static void main(String[] args) {
        String os = detectOS(); // e.g. reads system property

        IUIFactory factory = os.equals("windows") ? new WindowsUIFactory() : new MacUIFactory();

        Application app = new Application(factory);
        app.renderUI();
        // Guaranteed: button and checkbox are ALWAYS from the same family
    }

}
