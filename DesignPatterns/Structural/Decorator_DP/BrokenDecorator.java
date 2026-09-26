package DesignPatterns.Structural.Decorator_DP;


// The problem: extending behavior via inheritance gets combinatorially messy

// Imagine a coffee shop app that needs to price different coffee combinations — a plain coffee, coffee with milk, coffee with 
//milk and sugar, coffee with whipped cream, coffee with milk and whipped cream and caramel...

// The naive approach — a subclass per combination:

class TestCoffee {
    double cost() { return 2.0; }
}

class CoffeeWithMilk extends TestCoffee {
    double cost() { return super.cost() + 0.5; }
}

class CoffeeWithMilkAndSugar extends TestCoffee {
    double cost() { return super.cost() + 0.5 + 0.2; }
}

class CoffeeWithMilkAndSugarAndWhippedCream extends TestCoffee {
    double cost() { return super.cost() + 0.5 + 0.2 + 0.7; }
}
// ... this explodes combinatorially with every new topping
public class BrokenDecorator {
    
}
