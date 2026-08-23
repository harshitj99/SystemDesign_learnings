package DesignPatterns.Creational.Abstract_Factory;

interface Button{
    void render();
}
interface Checkbox{
    void render();
}

class WindowsButton implements Button {
    public void render() { System.out.println("Rendering Windows-style button"); }
}
class MacButton implements Button {
    public void render() { System.out.println("Rendering Mac-style button"); }
}
class WindowsCheckbox implements Checkbox {
    public void render() { System.out.println("Rendering Windows-style checkbox"); }
}
class MacCheckbox implements Checkbox {
    public void render() { System.out.println("Rendering Mac-style checkbox"); }
}

// If you use separate factory methods for buttons and checkboxes independently, nothing stops a bug like this:
public class BrokenAbstractFactory {
    public static void main(String[] args) {
        Button button = new WindowsButton();
        Checkbox checkbox = new MacCheckbox();

        button.render();
        checkbox.render();
    }
}

//Each factory method only knows how to make one type of product — it has no concept of "these objects need to 
//belong to the same family." That's exactly the gap Abstract Factory closes.