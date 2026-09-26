package DesignPatterns.Behavioural.State_DP;
// State interface — declares every action that might be allowed from some state

interface OrderState{
    void ship(Order order);
    void deliver(Order order);
    void cancel(Order order);
}
// Concrete states — each knows exactly what's legal FROM that state

class PendingState implements OrderState{
    public void ship(Order order){
        System.out.println("Order shipped");
        order.setState(new ShippedState());
    }

    public void deliver(Order order){
        System.out.println("cannot deliver - order hasn't shipped yet");
    }

    public void cancel(Order order){
        System.out.println("Order cancelled");
        order.setState(new CancelledState());
    }
}

class ShippedState implements OrderState{
    public void ship(Order order){
        System.out.println("Order already shipped");
    }

    public void deliver(Order order){
        System.out.println("Order Delivered");
        order.setState(new DeliveredState());
    }

    public void cancel(Order order){
        System.out.println("Order cancelled");
        order.setState(new CancelledState());
    }
}

class DeliveredState implements OrderState{
    public void ship(Order order){
        System.out.println("Order already delivered!");
    }

    public void deliver(Order order){
        System.out.println("Order already Delivered");
    }

    public void cancel(Order order){
        System.out.println("Order can't be cancelled because already delivered");
    }
}

class CancelledState implements OrderState{
    public void ship(Order order){
        System.out.println("Cannot ship - order was cancelled");
    }

    public void deliver(Order order){
        System.out.println("cannot deliver - order was cancelled");
    }

    public void cancel(Order order){
        System.out.println("Order already cancelled");
    }
}



class Order{
    private OrderState state = new PendingState();  // starts here
    void setState(OrderState state){
        this.state = state;
    }

    void ship(){state.ship(this);}
    void deliver(){state.deliver(this);}
    void cancel(){state.cancel(this);}
}
public class State {
    public static void main(String[] args) {
        Order order = new Order();
        order.ship();       // Order shipped   (Pending -> Shipped)
        order.deliver();   // Order delivered (Shipped -> Delivered)
        order.cancel();   // Cannot cancel — already delivered
    }
    
}

// Adding a RETURNED status later: you add one new ReturnedState class implementing OrderState, and only edit 
//DeliveredState.someNewReturnMethod() to transition into it — PendingState, ShippedState, and CancelledState are never touched.