package DesignPatterns.Creational;

//The goal is to get laziness back — "only create it when someone actually asks for it" — without losing 
//thread safety and without paying the performance cost of synchronized on every call (like ThreadSafeSingleton does)
public class BillPughSingleton {
    private BillPughSingleton(){
        System.out.println("BillPughSingleton instance created");
    }

    private static class Holder {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return Holder.INSTANCE;
    }
    void doSomething(){
        System.out.println("Doing Something");
    }
}

/*
The outer class BillPughSingleton gets loaded whenever your program first touches it (e.g. calling getInstance())
— but at that point, the JVM only loads BillPughSingleton itself. The inner class Holder is a completely separate
class as far as the JVM's class loader is concerned, and it is not loaded until the very first line inside 
getInstance() — Holder.INSTANCE — actually references it. */