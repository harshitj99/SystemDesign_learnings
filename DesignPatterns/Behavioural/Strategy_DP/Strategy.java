package DesignPatterns.Behavioural.Strategy_DP;


//Strategy Pattern: Defines a family of algorithms, encapsulates each one in its own class, and makes them interchangeable at runtime. 
//The class that uses the algorithm (the "context") doesn't need to know which specific algorithm it's running — it just calls a common interface.


//Strategy Interface
interface DiscountStrategy{
    double applyDiscount(double basePice);
}

// Concrete strategies
class  RegularCustomerDiscount implements DiscountStrategy{

    @Override
    public double applyDiscount(double basePice) {
        return basePice; // no discount
    }
}

class  PremiumCustomerDiscount implements DiscountStrategy{

    @Override
    public double applyDiscount(double basePice) {
        return basePice * 0.9;
    }
}

class  VIPCustomerDiscount implements DiscountStrategy{

    @Override
    public double applyDiscount(double basePice) {
        return basePice * 0.8;
    }
}

//Adding a new Discount - Student Discount
class StudentDiscount implements DiscountStrategy {
    public double applyDiscount(double basePrice) {
        return basePrice * 0.85;   // 15% off
    }
}

// Context — holds a reference to a strategy, delegates to it
class PriceCalculator{
    private DiscountStrategy strategy;

    PriceCalculator(DiscountStrategy strategy){
        this.strategy = strategy;
    }

    void setStrategy(DiscountStrategy strategy){
        this.strategy = strategy;
    }

    double calculatePrice(double basePrice){
        return  this.strategy.applyDiscount(basePrice);
    }
}
public class Strategy {

    public static void main(String[] args) {
        PriceCalculator pc = new PriceCalculator(new RegularCustomerDiscount());
        System.out.println(pc.calculatePrice(1000));

        pc.setStrategy(new VIPCustomerDiscount());
        System.out.println(pc.calculatePrice(1000));
    }
    
}
