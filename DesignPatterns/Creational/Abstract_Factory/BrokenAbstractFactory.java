package DesignPatterns.Creational.Abstract_Factory;

interface IButton{
    void render();
}
interface ICheckbox{
    void render();
}

class WindowsButton implements IButton {
    public void render() { System.out.println("Rendering Windows-style button"); }
}
class MacButton implements IButton {
    public void render() { System.out.println("Rendering Mac-style button"); }
}
class WindowsCheckbox implements ICheckbox {
    public void render() { System.out.println("Rendering Windows-style checkbox"); }
}
class MacCheckbox implements ICheckbox {
    public void render() { System.out.println("Rendering Mac-style checkbox"); }
}

// If you use separate factory methods for buttons and checkboxes independently, nothing stops a bug like this:
public class BrokenAbstractFactory {
    public static void main(String[] args) {
        IButton button = new WindowsButton();
        ICheckbox checkbox = new MacCheckbox();

        button.render();
        checkbox.render();
    }
}

//Each factory method only knows how to make one type of product — it has no concept of "these objects need to 
//belong to the same family." That's exactly the gap Abstract Factory closes.