package Templates.Creational;

/*
 * Factory Method Pattern Assignment
 *
 * Problem:
 * A notification service should be able to send different kinds of notifications
 * without the client directly creating Email, SMS, or Push objects.
 *
 * Student task:
 * 1. Implement each concrete notification.
 * 2. Implement each concrete creator's factory method.
 * 3. Use only NotificationCreator references in main.
 */

interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        // TODO: Print or process an email notification message.
    }
}

class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        // TODO: Print or process an SMS notification message.
    }
}

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        // TODO: Print or process a push notification message.
    }
}

abstract class NotificationCreator {
    /*
     * Factory method:
     * Subclasses decide which concrete Notification object should be created.
     */
    abstract Notification createNotification();

    /*
     * Common workflow:
     * This method should not know whether the object is Email, SMS, or Push.
     */
    void notifyUser(String message) {
        // TODO: Ask the factory method for a Notification.
        // TODO: Use that notification to send the message.
    }
}

class EmailNotificationCreator extends NotificationCreator {
    @Override
    Notification createNotification() {
        // TODO: Return the correct concrete notification object.
        return null;
    }
}

class SmsNotificationCreator extends NotificationCreator {
    @Override
    Notification createNotification() {
        // TODO: Return the correct concrete notification object.
        return null;
    }
}

class PushNotificationCreator extends NotificationCreator {
    @Override
    Notification createNotification() {
        // TODO: Return the correct concrete notification object.
        return null;
    }
}

public class FactoryMethodTemplate {
    public static void main(String[] args) {
        // TODO: Create one EmailNotificationCreator using a NotificationCreator reference.
        // TODO: Create one SmsNotificationCreator using a NotificationCreator reference.
        // TODO: Call notifyUser on both creators.
        // TODO: Add PushNotificationCreator support without changing NotificationCreator.
    }
}
