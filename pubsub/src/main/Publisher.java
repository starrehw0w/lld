package main;

import java.util.HashSet;

public class Publisher {

    private String name;
    private final HashSet<Topic> topics = new HashSet<>();

    public Publisher(String name) {
        this.name = name;
    }

    public void register(Topic topic) {
        topics.add(topic);
    }

    public void unregister(Topic topic) {
        topics.remove(topic);
    }

    public void publish(Topic topic, Message message) {
        if (!topics.contains(topic)) {

        }
        topic.publish(message);
    }
}
