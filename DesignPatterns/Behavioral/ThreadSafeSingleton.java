package DesignPatterns.Behavioral;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private ThreadSafeSingleton() {
        // private constructor to prevent instantiation
    }

    public static synchronized ThreadSafeSingleton getInstance() {
       if(instance == null){
        instance = new ThreadSafeSingleton();
       }
       return instance;
    }
}

