package main;

import java.util.HashSet;
import java.util.Set;

public class Topic {

    private String name;
    private final HashSet<Subscriber> subscribers = new HashSet<>();

    public Topic(String name) {
        this.name = name;
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publish(Message message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.consume(message);
        }
    }
}
