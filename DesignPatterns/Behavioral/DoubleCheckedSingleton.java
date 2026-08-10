package DesignPatterns.Behavioral;

public class DoubleCheckedSingleton {
    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton(){};
    public static DoubleCheckedSingleton getInstance(){
        if(instance==null){       //1st check (no lock)
            synchronized(DoubleCheckedSingleton.class){
                if(instance==null){         //2nd check (lock)
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
