package DesignPatterns.Creational.Abstract_Factory;

// Abstract Products
interface Button {
    void render();
}
interface Checkbox {
    void render();
}

// Concrete Products — Windows family
class WindowsButton implements Button {
    public void render() { System.out.println("Rendering Windows-style button"); }
}
class WindowsCheckbox implements Checkbox {
    public void render() { System.out.println("Rendering Windows-style checkbox"); }
}

// Concrete Products — Mac family
class MacButton implements Button {
    public void render() { System.out.println("Rendering Mac-style button"); }
}
class MacCheckbox implements Checkbox {
    public void render() { System.out.println("Rendering Mac-style checkbox"); }
}

// Abstract Factory — declares creation for the ENTIRE family
interface UIFactory{
    Button createButton();
    Checkbox creatCheckbox();
}

// Concrete Factory — Windows
class WindowsUIFactory implements UIFactory{
    public Button createButton(){
        return new WindowsButton();
    }

    public Checkbox creatCheckbox(){
        return new WindowsCheckbox();
    }
}

// Concrete Factory — Mac
class MacUIFactory implements UIFactory{
    public Button createButton(){
        return new MacButton();
    }

    public Checkbox creatCheckbox(){
        return new MacCheckbox();
    }
}



public class AbstractFactory {
    
}
