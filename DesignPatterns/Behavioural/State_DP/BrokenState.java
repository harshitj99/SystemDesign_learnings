package DesignPatterns.Behavioural.State_DP;


class Order1 {
    private String status = "PENDING";   // PENDING, SHIPPED, DELIVERED, CANCELLED

    void ship() {
        if (status.equals("PENDING")) {
            status = "SHIPPED";
            System.out.println("Order shipped");
        } else {
            System.out.println("Cannot ship — order is " + status);
        }
    }

    void deliver() {
        if (status.equals("SHIPPED")) {
            status = "DELIVERED";
            System.out.println("Order delivered");
        } else {
            System.out.println("Cannot deliver — order is " + status);
        }
    }

    void cancel() {
        if (status.equals("PENDING") || status.equals("SHIPPED")) {
            status = "CANCELLED";
            System.out.println("Order cancelled");
        } else {
            System.out.println("Cannot cancel — order is " + status);
        }
    }
}

//What's wrong here: every method needs to check the current status with if/else before deciding what's even legal. As more 
//statuses get added (RETURNED, REFUNDED), every single method grows more conditionals, and the rules for "what's allowed 
//from this status" end up scattered across every method instead of living in one place per status.
public class BrokenState {
    
}
