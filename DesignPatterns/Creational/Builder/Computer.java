package DesignPatterns.Creational.Builder;

//Broken Builder Issue: the Telescoping Constructor
public class Computer {
    Computer(String cpu){}
    Computer(String cpu, int ram){}
    Computer(String cpu, int ram, int storage){}
    Computer(String cpu, int ram, int storage, String gpu){}
    Computer(String cpu, int ram, int storage, String gpu, String monitor){}

}
// Ordering a custom PC. A PC can have a CPU, RAM, storage, GPU, and a monitor — but not every order needs all five. 
// Without a builder, you end up needing a constructor overload for every possible combination.