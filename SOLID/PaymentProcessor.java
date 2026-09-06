// ❌ VIOLATION of the Open/Closed Principle
// The PaymentProcessor class is NOT open for extension
// Adding a new payment method requires modifying existing code
// This violates OCP: "Open for extension, Closed for modification"

class PaymentProcessorViolation {
    public void pay(String method, double amount) {
        // Every new payment method requires modifying this method
        if (method.equals("credit_card")) {
            // Process credit card payment
        } else if (method.equals("paypal")) {
            // Process PayPal payment
        } else if (method.equals("bank_transfer")) {
            // Process bank transfer payment
        } else {
            throw new IllegalArgumentException("Unsupported payment method: " + method);
        }
        // Problem: To add UPI, we must modify this class - VIOLATION!
    }
}

// ✅ OPEN/CLOSED PRINCIPLE - CORRECT APPROACH
// The class is open for extension (new payment methods) but closed for modification
// New payment methods are added by implementing the interface, not modifying existing code

// Step 1: Define the contract that all payment methods must follow
interface IPaymentMethod {
    void pay(double amount);
}

// Step 2: Implement each payment method by creating new classes
class CreditCardPayment implements IPaymentMethod {
    @Override
    public void pay(double amount) {
        // Specific implementation for credit card
        System.out.println("Processing credit card payment: $" + amount);
    }
}

class PayPalPayment implements IPaymentMethod {
    @Override
    public void pay(double amount) {
        // Specific implementation for PayPal
        System.out.println("Processing PayPal payment: $" + amount);
    }
}

class UPIPayment implements IPaymentMethod {
    @Override
    public void pay(double amount) {
        // NEW METHOD: No need to modify PaymentProcessor!
        System.out.println("Processing UPI payment: $" + amount);
    }
}

// Step 3: The PaymentProcessor uses composition with the interface
// ✅ NOW CLOSED FOR MODIFICATION - No changes needed when adding new payment methods
public class PaymentProcessor {
    private IPaymentMethod paymentMethod;

    // Constructor injection - allows flexibility
    public PaymentProcessor(IPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // This method never needs to change when adding new payment methods!
    public void processPayment(double amount) {
        paymentMethod.pay(amount);
    }
}

// Usage Example - Open for extension!
// To add a new payment method: create class, implement PaymentMethod, done!
class Main {
    public static void main(String[] args) {
        // Credit card payment
        PaymentProcessor processor1 = new PaymentProcessor(new CreditCardPayment());
        processor1.processPayment(100);

        // PayPal payment
        PaymentProcessor processor2 = new PaymentProcessor(new PayPalPayment());
        processor2.processPayment(50);

        // UPI payment - NEW! No changes to PaymentProcessor needed!
        PaymentProcessor processor3 = new PaymentProcessor(new UPIPayment());
        processor3.processPayment(75);
    }
}
