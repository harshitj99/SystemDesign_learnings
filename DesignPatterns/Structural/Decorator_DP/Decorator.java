package DesignPatterns.Structural.Decorator_DP;

// Component interface — both the base object and every decorator implement this
interface Coffee{
    double cost();
    String description();
}

// Concrete component — the "core" object being decorated

class SimpleCoffee implements Coffee{
    public double cost(){ return 2.0;}
    public String description(){return "Coffee";}
}

// Base decorator — wraps a Coffee, delegates by default

abstract class CoffeeDecorator implements Coffee {
    protected Coffee wrapped;
    CoffeeDecorator(Coffee wrapped){
        this.wrapped = wrapped;
    }

    public double cost(){return  wrapped.cost();}
    public String description(){ return wrapped.description();}
    
}

// Concrete decorators — each adds ONE feature, then defers to what it wraps

class MilkDecorator extends CoffeeDecorator{
    MilkDecorator(Coffee wrapped){super(wrapped);}

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }
    @Override
    public String description() {
       
        return super.description() + " + Milk";
    }
}

class SugarDecorator extends CoffeeDecorator{
    SugarDecorator(Coffee wrapped){super(wrapped);}

    @Override
    public double cost() {
        return super.cost() + 0.2;
    }
    @Override
    public String description() {
       
        return super.description() + " + Sugar";
    }
}

class WhippedCreamDecorator extends CoffeeDecorator{
    WhippedCreamDecorator(Coffee wrapped){super(wrapped);}

    @Override
    public double cost() {
        return super.cost() + 0.7;
    }
    @Override
    public String description() {
       
        return super.description() + " + Whipped Cream";
    }
}
public class Decorator {
    public static void main(String[] args) {
        Coffee order = new SimpleCoffee();
    System.out.println(order.description() + " = $" + order.cost());
    // Coffee = $2.0

    order = new MilkDecorator(order);
    System.out.println(order.description() + " = $" + order.cost());
    // Coffee + Milk = $2.5

    order = new SugarDecorator(order);
    order = new WhippedCreamDecorator(order);
    System.out.println(order.description() + " = $" + order.cost());
    // Coffee + Milk + Sugar + Whipped Cream = $3.4
    }
}
