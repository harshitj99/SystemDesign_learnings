package DesignPatterns.Creational.Factory;


interface Notification{
    void send(String message);
}

class EmailNotification implements Notification{
    @Override
    public void send(String message){
        System.out.println(message);
    }
}

class SMSNotification implements Notification{
     @Override
    public void send(String message){
        System.out.println(message);
    }
}

class PushNotification implements Notification{
     @Override
    public void send(String message){
        System.out.println(message);
    }
}

public class NotificationsService {
    void send(String type, String message){
        if(type.equals("EMAIL")){
            EmailNotification email = new EmailNotification();
            email.send(message);
        }
        else if(type.equals("SMS")){
            SMSNotification sms = new SMSNotification();
            sms.send(message);
        }
        else if(type.equals("PUSH")){
            PushNotification push = new PushNotification();
            push.send(message);
        }
    }
}


//Whats wrong here 

//Violates Open/Closed Principle — adding a WhatsAppNotification means editing this class again, risking breaking
// the existing, already-tested EMAIL/SMS/PUSH branches.
//Object creation logic is tangled with business logic — NotificationService now needs to know the concrete class 
// name of every notification type that exists, even though its actual job is just "send a notification."