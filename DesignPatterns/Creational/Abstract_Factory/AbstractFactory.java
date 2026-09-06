package DesignPatterns.Creational.Abstract_Factory;

// Abstract Products
interface IButton {
    void render();
}
interface ICheckbox {
    void render();
}

// Concrete Products — Windows family
class WindowsButton implements IButton {
    public void render() { System.out.println("Rendering Windows-style button"); }
}
class WindowsCheckbox implements ICheckbox {
    public void render() { System.out.println("Rendering Windows-style checkbox"); }
}

// Concrete Products — Mac family
class MacButton implements IButton {
    public void render() { System.out.println("Rendering Mac-style button"); }
}
class MacCheckbox implements ICheckbox {
    public void render() { System.out.println("Rendering Mac-style checkbox"); }
}

// Abstract Factory — declares creation for the ENTIRE family
interface IUIFactory{
    IButton createButton();
    ICheckbox creatCheckbox();
}

// Concrete Factory — Windows
class WindowsUIFactory implements IUIFactory{
    public IButton createButton(){
        return new WindowsButton();
    }

    public ICheckbox creatCheckbox(){
        return new WindowsCheckbox();
    }
}

// Concrete Factory — Mac
class MacUIFactory implements IUIFactory{
    public IButton createButton(){
        return new MacButton();
    }

    public ICheckbox creatCheckbox(){
        return new MacCheckbox();
    }
}



public class AbstractFactory {
    
}
