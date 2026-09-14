package DesignPatterns.Behavioural.Observer_DP;
import java.util.List;
import java.util.ArrayList;
// Observer interface — anyone who wants to be notified implements this
interface Subscriber{
    void update(String videoTitle);
}

// Concrete observers
class EmailSubscriber implements Subscriber{
    private String email;
    EmailSubscriber(String email){
        this.email = email;
    }
    public void update(String videoTitle){
         System.out.println("Emailing " + email + ": New video - " + videoTitle);
    }
}

class PushNotificationSubscriber implements Subscriber{
    private String deviceId;
    PushNotificationSubscriber(String deviceId){
        this.deviceId = deviceId;
    }
    public void update(String videoTitle){
         System.out.println("Push to device " + deviceId + ": New video - " + videoTitle);
    }
}

// Subject — knows only about the Subscriber interface, nothing more
class YoutubeChannel{
    private String ChannelName;
    private List<Subscriber> subscribers = new ArrayList<>();
    YoutubeChannel(String ChannelName){
        this.ChannelName = ChannelName;
    }
    void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    void uploadVideo(String title){
        System.out.println(ChannelName + " uploaded: " + title);
        notifySubscribers(title);
    }

    private void notifySubscribers(String title){
        for(Subscriber subscriber: subscribers){
            subscriber.update(title);
        }
    }
}
public class Observer {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel("Tech Tutorials");
        Subscriber alice = new EmailSubscriber("alice@gmail.com");
        Subscriber bob = new PushNotificationSubscriber("device-4521");

        channel.subscribe(bob);
        channel.subscribe(alice);

        channel.uploadVideo("Observer Design Pattern");
    }
}
