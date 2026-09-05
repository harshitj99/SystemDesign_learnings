package DesignPatterns.Creational.Singletone;

public class lazySingleton {
    private static lazySingleton instance;
    private lazySingleton() {
        // private constructor to prevent instantiation
    }

    public static lazySingleton getInstance() {
       if(instance == null){
        instance = new lazySingleton();
       }
       return instance;
    }
}

//Why it works (in single-threaded code): The constructor is private, so the only way to get an instance
//is through getInstance(), and that method only builds one instance ever, then reuses it.

//The catch: This is not thread-safe. Imagine two threads call getInstance() at almost the exact same 
// time, both see instance == null, and both proceed to create a new SimpleSingleton() — 
// now you have two instances after all, silently.

class Main{
    public static void main(String[] args) {
        lazySingleton instance1 = lazySingleton.getInstance();
        lazySingleton instance2 = lazySingleton.getInstance(); 
        System.out.println(instance1 == instance2); // This will print true, demonstrating the singleton pattern
    }
}