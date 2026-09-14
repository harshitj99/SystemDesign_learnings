package DesignPatterns.Behavioural.Observer_DP;

import java.util.ArrayList;
import java.util.List;

class EmailService {
    void sendEmail(List<String> emails, String title) {
        for (String email : emails) {
            System.out.println("Sending email to " + email + " about " + title);
        }
    }
}

class PushNotificationService {
    void sendPush(List<String> subscriberIds, String title) {
        for (String id : subscriberIds) {
            System.out.println("Sending push to " + id + " about " + title);
        }
    }
}

class SmsService {
    void sendSMS(List<String> phoneNumbers, String title) {
        for (String number : phoneNumbers) {
            System.out.println("Sending SMS to " + number + " about " + title);
        }
    }
}

class AnalyticsService {
    void logUpload(String title) {
        System.out.println("Analytics: video uploaded -> " + title);
    }
}

class YouTubeChannel {
    private final List<String> subscriberEmails = new ArrayList<>();
    private final List<String> subscriberIds = new ArrayList<>();
    private final List<String> phoneNumbers = new ArrayList<>();
    private final EmailService emailService = new EmailService();
    private final PushNotificationService pushNotificationService = new PushNotificationService();
    private final SmsService smsService = new SmsService();
    private final AnalyticsService analyticsService = new AnalyticsService();

    void addSubscriberEmail(String email) {
        subscriberEmails.add(email);
    }

    void addSubscriberId(String id) {
        subscriberIds.add(id);
    }

    void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    void uploadVideo(String title) {
        System.out.println("New video uploaded: " + title);
        // Now manually notify every single subscriber type, one by one
        emailService.sendEmail(subscriberEmails, title);
        pushNotificationService.sendPush(subscriberIds, title);
        smsService.sendSMS(phoneNumbers, title);
        analyticsService.logUpload(title);
        // every time a NEW way to notify people is added, this method must be edited
    }
}

//YouTubeChannel's core job is "manage videos," but it's been forced to know about email systems, push services,
//  SMS gateways, and analytics — none of which are really its responsibility. Adding a new notification channel
// (say, Discord webhooks) means editing this method again. This class has become tightly coupled to every single
// thing that cares about its state changing.

public class Broken_Observer {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();
        channel.addSubscriberEmail("alice@example.com");
        channel.addSubscriberId("user-101");
        channel.addPhoneNumber("+1234567890");

        channel.uploadVideo("Java Design Patterns");
    }
}
