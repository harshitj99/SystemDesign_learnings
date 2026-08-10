package DesignPatterns.Creational;

public class BrokenSingleton {
    public BrokenSingleton() {
        // private constructor to prevent instantiation
    }
}

class TestBrokenSingleton {
public static void main(String[] args) {
    BrokenSingleton instance1 = new BrokenSingleton();
    BrokenSingleton instance2 = new BrokenSingleton();

    System.out.println(instance1 == instance2); // This will print false, violating the singleton pattern
}
}
