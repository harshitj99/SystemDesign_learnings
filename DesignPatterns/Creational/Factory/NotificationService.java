package DesignPatterns.Creational.Factory;

// Product interface
interface INotification{
    void send(String message);
}

// Concrete Products
class EmailNotification implements INotification{
    @Override
    public void send(String message){
        System.out.println("Sending EMAIL: " + message);
    }
}

class SMSNotification implements INotification{
     @Override
    public void send(String message){
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotification implements INotification{
     @Override
    public void send(String message){
        System.out.println("Sending Push: " + message);
    }
}

// Creator (abstract) — declares the factory method
abstract class NotificationCreator {
    // the factory method — subclasses decide what gets created
    abstract INotification createNotification();
// shared logic that uses the created product — lives in ONE place
    void notify(String message){
        INotification notification = createNotification();
        notification.send(message);
    }
}

class EmailNotificationCreator extends NotificationCreator{
    INotification createNotification(){
        return new EmailNotification();
    }
}

class SMSNotificationCreator extends NotificationCreator{
    INotification createNotification(){
        return new SMSNotification();
    }
}

class PushNotificationCreator extends NotificationCreator{
    INotification createNotification(){
        return new PushNotification();
    }
}

public class NotificationService {

    public static void main(String[] args) {
        NotificationCreator email = new EmailNotificationCreator();
        email.notify("Your order has been shipped");

        NotificationCreator sms = new SMSNotificationCreator();
        sms.notify("Your OTP is 4178");


    }
    
}
