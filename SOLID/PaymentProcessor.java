// violation of the Open/Closed Principle: The PaymentProcessor class is not open for extension. If we want to add a new payment method, we have to modify the existing code, which violates the principle.


public class PaymentProcessor {
    void pay(String method, double amount) {
        if (method.equals("credit_card")) {
            // Process credit card payment
        } else if (method.equals("paypal")) {
            // Process PayPal payment
        } else if (method.equals("bank_transfer")) {
            // Process bank transfer payment
        } else {
            throw new IllegalArgumentException("Unsupported payment method: " + method);
        }
    }
    
}

// Open/Closed Principle: The PaymentProcessor class is open for extension. We can add new payment methods by creating new classes that implement the PaymentMethod interface, without modifying the existing code.

interface PaymentMethod {
    void pay(double amount);
}

class CreditCardPayment implements PaymentMethod {
    public void pay(double amount) {
        // Process credit card payment
    }
}

class PayPalPayment implements PaymentMethod {
    public void pay(double amount) {
        // Process PayPal payment
    }
}
class UPIPayment implements PaymentMethod {
    public void pay(double amount) {
        // Process UPI payment
    }
}

class paymentProcessor {
    void pay(PaymentMethod method, double amount) {
        method.pay(amount);
    }
}
