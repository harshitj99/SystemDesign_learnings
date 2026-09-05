package DesignPatterns.Creational.Singletone;

public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){
        System.out.println("EagerSingleton Instance is created");
    }
    public static EagerSingleton getInstance(){
        return instance;
    }

    void doSomething(){
        System.out.println("Doing Something");
    }
}


/*
How it works: The instance field is created immediately when the class is loaded by the JVM — not when
getInstance() is first called. Java guarantees that static field initializers run exactly once, 
at class-loading time, before any other thread can touch the class. */

// Issue: the point is, it's created whether or not you ever actually call getInstance() in that particular run.

//This is the exact tradeoff called out earlier: Eager Singleton is thread-safe and simple, 
// but not lazy — it sacrifices "create only when needed" for simplicity.