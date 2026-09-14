package DesignPatterns.Behavioural.Strategy_DP;

// Imagine a PaymentProcessor that needs to support multiple ways of calculating a discount depending on customer type:

class PriceCalculator{
    double calculatePrice(double basePrice, String customerType){
        if(customerType.equals("Regular")){
            return basePrice;
        }
        else if(customerType.equals("Premium")){
            return basePrice * 0.9;  // 10% discount
        }
        else if(customerType.equals("VIP")){
            return basePrice * 0.8;  // 20% discount
        }
        return basePrice;
    }
}

// What's wrong here: this should look familiar by now — it's the same shape of problem as the original Factory example. Adding a new pricing rule 
// (say, a STUDENT discount) means editing this method again, risking the existing logic. The algorithm ("how do I calculate this price?") is hardcoded 
// as a chain of conditionals instead of being a swappable, independent thing.
public class Broken_Strategy {
    
}
